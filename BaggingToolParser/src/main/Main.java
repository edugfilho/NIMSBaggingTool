package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import util.BaggingToolUtil;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import database.BaggingToolDatabase;
import database.NetmateBagging;
import database.OutputBagging;
import database.SoftflowdBagging;
import database.TranalyzerBagging;
import database.YafBagging;
import format.FlowOutput;
import format.FlowOutput.Flow;
import format.NetmateOutput;
import format.SoftflowdOutput;
import format.TranalyzerOutput;
import format.YafOutput;

/**
 * This work was done at the NIMS - Network Information Management and Security
 * group, at Dalhousie University, Halifax, NS, Canada, under the supervision of
 * Dr. Nur Zincir-Heywood. This tool was initially intended to transform
 * different types of flow output, generated by tools like Netmate, Softflowd,
 * Yaf and Tranalyzer, into a unified file type, and then have the flows in this
 * file processed to come out with a group of flows, called bagged flows. Later
 * on, the ability to make calls to some of those 4 tools, in case they are
 * installed in the system, was added, making it possible to work with the .pcap
 * files all the way to the bagged flows' files.
 * <p>
 * Although I had little time to develop it, a considerable effort was put in
 * the coding in order to make it easy to add compatibility with tools other
 * than the ones already mentioned. Any thoughts, suggestions:
 * edugomfilho@gmail.com
 * 
 * @author Eduardo
 * 
 */
public class Main {

	private static BaggingToolDatabase db = null;
	private static int inputLevel;
	private static Parameters param;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		param = new Parameters();
		new JCommander(param, args);
		initLevel();
		String filePath;
		if (param.startFromPcap) {
			filePath = phaseOne(param.filePath, param);
			inputLevel = 2;
		} else {
			filePath = param.filePath;
		}
		File f = new File(filePath);
		if (param.useNetmate) {
			testNetmate(f);
		}
		if (param.useSoftflowd) {
			testSoftflowd(f);
		}
		if (param.useTranalyzer) {
			testTranalyzer(f);
		}
		if (param.useYaf) {
			testYaf(f);
		}
		if (param.resetDb) {
			db = new BaggingToolDatabase();
			db.resetDatabase();
			return;
		}

	}

	/**
	 * Calls whichever flow tool that was specificed in phase 1 to process a .pcap file and produce a flow file.
	 * @param cmd The tool's executable path.
	 * @return The path of the output flow file 
	 */
	private static String execFlowTool(String cmd) {
		Process tr;
		Process nfcapd = null;
		Process nfdump = null;
		String wholeCmd = cmd;
		String outName = BaggingToolUtil.getPath("OUTPUT_FOLDER") + "rawFlow_";
		if (param.useNetmate) {
			outName += "netmate_" + BaggingToolUtil.getTimeStamp();
			
			// Sets the output path and name to the netmate configuration file
			setNetmateOutput(outName);
			wholeCmd += " -r " + param.netmateConf + " -f " + param.filePath;
		}

		if (param.useSoftflowd) {
			try {

				String addr = NetworkInterface.getByName("eth1")
						.getInterfaceAddresses().get(1).getAddress()
						.getHostAddress();

				outName += "softflowd_" + BaggingToolUtil.getTimeStamp();
				String nfcapdExec = "res/runSoftflowd.sh " + addr + " "
						+ BaggingToolUtil.getPath("OUTPUT_FOLDER") + " "
						+ param.filePath + " " + findNfcapdFile() + " "
						+ outName; // "nfcapd -p 5748 -b " + addr
				nfcapd = Runtime.getRuntime().exec(nfcapdExec);

				BufferedReader rd = new BufferedReader(new InputStreamReader(
						nfcapd.getInputStream()));
				String s = rd.readLine();
				while (s != null) {
					System.out.println(s);
					s = rd.readLine();
				}
				// nfcapd.waitFor();
				wholeCmd += " -v 9 -r " + param.filePath + " -n " + addr
						+ ":5748";
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (param.useTranalyzer) {
			outName += "tranalyzer";
			wholeCmd += " -r " + param.filePath + " -w " + outName;
		}
		if (param.useYaf) {
			outName += "yaf";
			wholeCmd += " -i " + param.filePath + " -o " + outName;
		}
		try {
			if (!param.useSoftflowd) {
				tr = Runtime.getRuntime().exec(wholeCmd);
				tr.waitFor();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return outName;

	}

	/**
	 * Searches for the last modified "nfcapd" file into the folder. This is a file that Softflowd creates as temporary and
	 * needs to be processed. We need the most recently created one in order to make sure that we are working with the one that 
	 * was made using the .pcap file that the user specified.
	 * 
	 * @param folderPath The folder where the file is
	 *
	 * @return the most recent nfcapd file
	 * @see File
	 */
	/*
	 * TODO it doesn't work!
	 */
	private static File findNfcapdFile() {
		File f = new File(BaggingToolUtil.getPath("OUTPUT_FOLDER"));
		File candidate = null;
		for (File file : f.listFiles()) {
			if (file.getName().contains("nfcapd")) {
				if (candidate == null
						|| file.lastModified() > candidate.lastModified()) {
					candidate = file;
				}
			}
		}
		return candidate;
	}

	/**
	 * Initializes the level of the file to be processed according to
	 * the parameters passed by the user.
	 * <p>
	 * Level 1: Will start from a .pcap (which contain packets) file;
	 * <p>
	 * Level 2: Will start from a flow file (file type varies with the flow
	 * generator used (Netmate, Yaf, etc...))
	 * <p>
	 * Level 3: Will start from the processed flow file (generated from the
	 * second level)
	 * 
	 * @see Parameters 
	 */
	private static void initLevel() throws ParameterException {
		if (param.startFromPcap && param.fileProcessed) {
			throw new ParameterException("File cannot be a .pcap processed!");
		}
		inputLevel = 1;
		if (!param.startFromPcap) {
			inputLevel++;
		}
		if (param.fileProcessed) {
			inputLevel++;
		}
	}

	/**
	 * In phase 1 it is assumed that a .pcap file is available. The specified tool is called (Netmate, Yaf, etc) to 
	 * generate a flow file from the .pcap one.
	 * <p>
	 * Executes a flow tool to process a .pcap file
	 * and output a flow file.
	 * 
	 * @param inputFilePath path of the input .pcap file
	 * @param param parameters specified by the user
	 * 
	 * @return The path of the output flow file
	 */
	public static String phaseOne(String inputFilePath, Parameters param) {

		if (param.useNetmate) {
			return execFlowTool(BaggingToolUtil.getPath("NETMATE_EXE"));
		}
		if (param.useSoftflowd) {
			return execFlowTool(BaggingToolUtil.getPath("SOFTFLOWD_EXE"));
		}
		if (param.useTranalyzer) {
			return execFlowTool(BaggingToolUtil.getPath("TRANALYZER_EXE"));
		}
		if (param.useYaf) {
			return execFlowTool(BaggingToolUtil.getPath("YAF_EXE"));
		}
		return null;
	}

	/**
	 * In phase 2, it is assumed that a flow file is available, regardless of the format.
	 * Produces a formatted flow file from a common flow file. 
	 * <p> 
	 * Outputs a ready-to-bag, formatted flow file from a common flow file (e.g. Netmate output)
	 * 
	 * @param output Data to receive the output.
	 * @param f The flow file to be processed
	 * @see FlowOutput
	 */
	public static void phaseTwo(FlowOutput output, File f) {
		output.setOutputLabel(param.flowLabel);
		ArrayList<Flow> rawData = output.getRawDataFromFile(f, inputLevel);

		output.setOutputFlowsFromRawData(rawData, inputLevel);

		output.setOutputName(output.getClass().getSimpleName()
				+ BaggingToolUtil.getTimeStamp());

		output.printOutFlows(BaggingToolUtil.getPath("OUTPUT_FOLDER") + "flow_"
				+ output.getOutputName() + ".txt");
	}

	/**
	 * In phase 3 it is assumed that a formatted set of flows is available.
	 * Inserts the formatted flows set into the database and perform queries over it to generate the grouped flows file
	 * 
	 * @param output Data containing the formatted set of flows
	 * @param outBagging Data containing the query to be performed
	 */
	public static void phaseThree(FlowOutput output, OutputBagging outBagging) {

		db = new BaggingToolDatabase();
		db.saveOutputToDatabase(output);
		db.performQueries(outBagging.getBaggingQuery());
	}
	
	/**
	 * Executes phase 2 and 3 from a Yaf output file
	 * @param f The Yaf output file
	 */

	public static void testYaf(File f) {

		// File f = new File(BaggingToolUtil.getPath("YAF_FLOWS"));
		YafOutput yafOut = new YafOutput();

		phaseTwo(yafOut, f);

		YafBagging yafBag = new YafBagging(yafOut.getOutputName());
		phaseThree(yafOut, yafBag);

	}

	/**
	 * Executes phase 2 and 3 from a Netmate output file
	 * @param f The Netmate output file
	 */
	public static void testNetmate(File f) {

		// File f = new File(BaggingToolUtil.getPath("NETMATE_FLOWS"));
		NetmateOutput netOut = new NetmateOutput();
		phaseTwo(netOut, f);

		NetmateBagging netBag = new NetmateBagging(netOut.getOutputName());
		phaseThree(netOut, netBag);

	}
	
	/**
	 * Executes phase 2 and 3 from a Softflowd output file
	 * @param f The Softflowd output file
	 */
	public static void testSoftflowd(File f) {

		// File f = new File(BaggingToolUtil.getPath("SOFTFLOWD_FLOWS"));

		SoftflowdOutput softOut = new SoftflowdOutput();
		phaseTwo(softOut, f);

		SoftflowdBagging softBag = new SoftflowdBagging(softOut.getOutputName());
		phaseThree(softOut, softBag);

	}

	/**
	 * Executes phase 2 and 3 from a Tranalyzer output file
	 * @param f The Tranalyzer output file
	 */
	public static void testTranalyzer(File f) {

		// File f = new File(BaggingToolUtil.getPath("TRANALYZER_FLOWS"));

		TranalyzerOutput tranOut = new TranalyzerOutput();
		phaseTwo(tranOut, f);

		TranalyzerBagging tBag = new TranalyzerBagging(tranOut.getOutputName());
		phaseThree(tranOut, tBag);

	}

	/**
	 * Changes the output path for Netmate output file inside the Netmate configurations file. This is required
	 * in order to output different file names each time.
	 * 
	 * @param outPath The complete path of Netmate's output file to insert into the configurations file.
	 */
	private static void setNetmateOutput(String outPath) {
		File netConf = new File(param.netmateConf);
		BufferedReader br;

		List<String> lines;

		try {
			lines = FileUtils.readLines(netConf);

			int i = 0;
			for (String string : lines) {
				if (string.contains("Filename")) {
					break;
				}
				i++;
			}
			lines.set(i, "      <PREF NAME=\"Filename\">" + outPath + "</PREF>");
			FileUtils.writeLines(netConf, lines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static BaggingToolDatabase getDb() {
		return db;
	}

	public static void setDb(BaggingToolDatabase db) {
		Main.db = db;
	}

}

/*
 * TODO: have the processed flows output median of MedianIat = mean of medianIAT
 * right now
 * 
 * Have labels in the flows and output
 * 
 * Netmate make sure the exe files have permission to be executed
 * 
 * remove database info from code and put it in a separate file
 * 
 * transformed dates to milliseconds (add to report) add to the report what tags
 * we added to the outputs so they can work on this tool *
 */

