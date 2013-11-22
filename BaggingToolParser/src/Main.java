import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import database.BaggingToolDatabase;
import format.FlowOutput.Flow;
import format.NetmateOutput;
import format.SoftflowdOutput;
import format.YafOutput;

public class Main {

	/**
	 * @param args
	 */
	private static BaggingToolDatabase db = null;
	public static void main(String[] args) {
		
		BaggingToolDatabase db = new BaggingToolDatabase();
		//db.prepareAndExecuteQueries();
		//testNetmate();
		//testYaf();
		testSoftflowd();

	}

	public static void testYaf() {
		// YAF TESTS
		BaggingToolDatabase db = new BaggingToolDatabase();
		File f = new File(
				"C:/Users/Eduardo/Documents/NIMS/Flow samples/Alexa3-YAF.txt");
		 //"/home/eduardo/NIMS/NewBaggingTool/FlowSamples/Alexa3-Yaf.txt");
		YafOutput yafOut = new YafOutput();
		ArrayList<Flow> rawData = yafOut.getRawDataFromFile(f);

		yafOut.setOutputFlowsFromRawData(rawData);
		//yafOut.printOutFlows();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		yafOut.setOutputName(yafOut.getClass().toString()
				+ dateFormat.format(cal.getTime()).toString());
		db.saveOutputToDatabase(yafOut);

		//db.saveOutputToDatabase(yafOut);

	}

	public static void testNetmate() {
		// NETMATE TESTS
		BaggingToolDatabase db = new BaggingToolDatabase();
		File f = new File(
		 "C:/Users/Eduardo/Documents/NIMS/Flow samples/Alexa-Netmate.txt");

				//"/home/eduardo/Desktop/NIMS/NewBaggingTool/FlowSamples/Alexa-Netmate.txt");

		NetmateOutput netOut = new NetmateOutput();
		ArrayList<Flow> rawData = netOut.getRawDataFromFile(f);

		netOut.setOutputFlowsFromRawData(rawData);
		//netOut.printOutFlows();

		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		netOut.setOutputName(netOut.getClass().toString()
				+ dateFormat.format(cal.getTime()).toString());
		db.saveOutputToDatabase(netOut);
		//db.prepareAndExecuteQueries();
	}
	public static void testSoftflowd() {
		// NETMATE TESTS
		BaggingToolDatabase db = new BaggingToolDatabase();
		File f = new File(
		 "C:/Users/Eduardo/Documents/NIMS/Flow samples/Alexa-softflowd.txt");

				//"/home/eduardo/Desktop/NIMS/NewBaggingTool/FlowSamples/Alexa-softflowd.txt");

		SoftflowdOutput softOut = new SoftflowdOutput();
		ArrayList<Flow> rawData = softOut.getRawDataFromFile(f);

		softOut.setOutputFlowsFromRawData(rawData);
		softOut.printOutFlows();

		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		//softOut.setOutputName(softOut.getClass().toString()
			//	+ dateFormat.format(cal.getTime()).toString());
		//db.saveOutputToDatabase(softOut);
		//db.prepareAndExecuteQueries();
	}
	
}

/*
 * TODO: 
 * Softflowd InDstMac, OutDstMac, InSrcMac, OutSrcMac. What to do?
 * 
 * Insert Start and End time as date into the DB!
 * 
 * Queries must take into consideration valid features!
 * 
 * 
 * 
 * 
 * Tranalyzer's duration check ip address if it doesn't have (softflowd and yaf
 * spec) get rid of it.
 * 
 * softflowd "M" (mega) features
 * 
 * YAF check ip addr (if it has endtime it's ok)
 * 
 * YAF: idle (or active when no duration ) means no backwards data
 * 
 * YAF: (icmp) [x:y] = port numbers
 * 
 ***YAF: flows that doesn't have endtime: endtime = 0, duration = 0
 * 
 ***Remove ipv6
 * 
 * add a class label after bagging (we are assuming that every file will have
 * only ONE label)
 * 
 ***include all features in the database
 * 
 * look groupby, outfile mysql and
 */

