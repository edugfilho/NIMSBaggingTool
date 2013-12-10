package main;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;

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

public class Main {

	private static BaggingToolDatabase db = null;
	private static int inputLevel;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Parameters param = new Parameters();
		new JCommander(param, args);
		initLevel(param);
		String filePath;
		if(param.startFromPcap){
			filePath = phaseOne(param.filePath);
			inputLevel = 2;
		}else{
			filePath = param.filePath;
		}
		
		
		// param.

		// BaggingToolDatabase db = new BaggingToolDatabase();
		// db.resetDatabase();
		//testYaf();
		//testSoftflowd();
		//testNetmate();
		//testTranalyzer();

	}

	/**
	 * Initializes the initial level of the file to be processed
	 * @param p
	 */
	private static void initLevel(Parameters p) throws ParameterException{
		if(p.startFromPcap && p.fileProcessed){
			throw new ParameterException("File cannot be a .pcap processed!");
		}
		inputLevel = 1;
		if(!p.startFromPcap){
			inputLevel++;
		}
		if(p.fileProcessed){
			inputLevel++;
		}
	}
	/**
	 * phaseOne is responsible for calling a flow tool to process a .pcap file
	 * and output a flow file.
	 */
	public static String phaseOne(String inputFilePath) {
		return null; //the path of the output file saved by 
	}

	/**
	 * phaseTwo uses a flow file to process it and outputs another flow file,
	 * ready to phase 3.
	 */
	public static void phaseTwo(FlowOutput output, File f) {
		ArrayList<Flow> rawData = output.getRawDataFromFile(f, inputLevel);

		output.setOutputFlowsFromRawData(rawData, inputLevel);

		output.setOutputName(output.getClass().getSimpleName()
				+ BaggingToolUtil.getTimeStamp());

		output.printOutFlows(BaggingToolUtil.getPath("OUTPUT_FOLDER") + "flow_"
				+ output.getOutputName() + ".txt");
	}

	/**
	 * phaseThree inserts a processed flow file into a database and groups them.
	 */
	public static void phaseThree(FlowOutput output, OutputBagging outBagging) {

		db = new BaggingToolDatabase();
		db.saveOutputToDatabase(output);
		db.performQueries(outBagging.getBaggingQuery());
	}

	public static void testYaf() {

		File f = new File(BaggingToolUtil.getPath("YAF_FLOWS"));
		YafOutput yafOut = new YafOutput();

		phaseTwo(yafOut, f);

		YafBagging yafBag = new YafBagging(yafOut.getOutputName());
		phaseThree(yafOut, yafBag);

	}

	public static void testNetmate() {

		File f = new File(BaggingToolUtil.getPath("NETMATE_FLOWS"));
		NetmateOutput netOut = new NetmateOutput();
		phaseTwo(netOut, f);

		NetmateBagging netBag = new NetmateBagging(netOut.getOutputName());
		phaseThree(netOut, netBag);

	}

	public static void testSoftflowd() {

		File f = new File(BaggingToolUtil.getPath("SOFTFLOWD_FLOWS"));

		SoftflowdOutput softOut = new SoftflowdOutput();
		phaseTwo(softOut, f);

		SoftflowdBagging softBag = new SoftflowdBagging(softOut.getOutputName());
		phaseThree(softOut, softBag);

	}

	public static void testTranalyzer() {

		File f = new File(BaggingToolUtil.getPath("TRANALYZER_FLOWS"));

		TranalyzerOutput tranOut = new TranalyzerOutput();
		phaseTwo(tranOut, f);

		TranalyzerBagging tBag = new TranalyzerBagging(tranOut.getOutputName());
		phaseThree(tranOut, tBag);

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
 * remove database info from code and put it in a separate file
 * 
 * transformed dates to milliseconds (add to report) add to the report what tags
 * we added to the outputs so they can work on this tool
 * 
 * store flow generator tools' exe path so we can run it from a pcap file
 * 
 * 
 * 
 * add a class label after bagging (we are assuming that every file will have
 * only ONE label) look groupby, outfile mysql and
 */

