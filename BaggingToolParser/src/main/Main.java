package main;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import util.BaggingToolUtil;

import com.beust.jcommander.JCommander;

import database.BaggingToolDatabase;
import database.NetmateBagging;
import database.SoftflowdBagging;
import database.TranalyzerBagging;
import database.YafBagging;
import format.FlowOutput.Flow;
import format.NetmateOutput;
import format.SoftflowdOutput;
import format.TranalyzerOutput;
import format.YafOutput;

public class Main {



	private static BaggingToolDatabase db = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Parameters param = new Parameters();
		new JCommander(param, args);
		 
		//param.

		//BaggingToolDatabase db = new BaggingToolDatabase();
		// db.resetDatabase();
		// testYaf();
		// testSoftflowd();
		// testNetmate();
		//testTranalyzer();
		
		
	}
	
	public void doMain(){
		
	}

	public static void testYaf() {
		// YAF TESTS
		File file = new File(BaggingToolUtil.getPath("OUTPUT_FOLDER")
				+ "outYaf.txt");

		file.delete();
		BaggingToolDatabase db = new BaggingToolDatabase();
		File f = new File(BaggingToolUtil.getPath("YAF_FLOWS"));
		YafOutput yafOut = new YafOutput();
		ArrayList<Flow> rawData = yafOut.getRawDataFromFile(f);

		yafOut.setOutputFlowsFromRawData(rawData);

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		yafOut.setOutputName(yafOut.getClass().getSimpleName()
				+ dateFormat.format(cal.getTime()).toString());
		db.saveOutputToDatabase(yafOut);

		yafOut.printOutFlows(BaggingToolUtil.getPath("OUTPUT_FOLDER") + "flow_"
				+ yafOut.getOutputName() + ".txt");

		YafBagging yafBag = new YafBagging(yafOut.getOutputName());
		db.performQueries(yafBag.getBaggingQuery());

	}

	public static void testNetmate() {
		// NETMATE TESTS
		File file = new File(BaggingToolUtil.getPath("OUTPUT_FOLDER")
				+ "outNetmate.txt");

		file.delete();
		BaggingToolDatabase db = new BaggingToolDatabase();
		File f = new File(
				"C:/Users/Eduardo/Documents/NIMS/Flow samples/Alexa-NetmateDemo.txt");

		// "/home/eduardo/NIMS/NewBaggingTool/FlowSamples/Alexa-NetmateDemo.txt");

		NetmateOutput netOut = new NetmateOutput();
		ArrayList<Flow> rawData = netOut.getRawDataFromFile(f);

		netOut.setOutputFlowsFromRawData(rawData);

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		netOut.setOutputName(netOut.getClass().getSimpleName()
				+ dateFormat.format(cal.getTime()).toString());

		netOut.printOutFlows(BaggingToolUtil.getPath("OUTPUT_FOLDER") + "flow_"
				+ netOut.getOutputName() + ".txt");

		db.saveOutputToDatabase(netOut);
		NetmateBagging netBag = new NetmateBagging(netOut.getOutputName());
		db.performQueries(netBag.getBaggingQuery());
	}

	public static void testSoftflowd() {
		File file = new File(BaggingToolUtil.getPath("OUTPUT_FOLDER")
				+ "outSoftflowd.txt");

		file.delete();
		BaggingToolDatabase db = new BaggingToolDatabase();
		File f = new File(BaggingToolUtil.getPath("SOFTFLOWD_FLOWS"));

		SoftflowdOutput softOut = new SoftflowdOutput();
		ArrayList<Flow> rawData = softOut.getRawDataFromFile(f);

		softOut.setOutputFlowsFromRawData(rawData);

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		softOut.setOutputName(softOut.getClass().getSimpleName()
				+ dateFormat.format(cal.getTime()).toString());

		softOut.printOutFlows(BaggingToolUtil.getPath("OUTPUT_FOLDER")
				+ "flow_" + softOut.getOutputName() + ".txt");

		db.saveOutputToDatabase(softOut);
		SoftflowdBagging softBag = new SoftflowdBagging(softOut.getOutputName());
		db.performQueries(softBag.getBaggingQuery());
	}

	public static void testTranalyzer() {
		File file = new File(BaggingToolUtil.getPath("OUTPUT_FOLDER")
				+ "outTranalyzer.txt");

		file.delete();
		BaggingToolDatabase db = new BaggingToolDatabase();
		File f = new File(BaggingToolUtil.getPath("TRANALYZER_FLOWS"));

		TranalyzerOutput tranOut = new TranalyzerOutput();
		ArrayList<Flow> rawData = tranOut.getRawDataFromFile(f);

		tranOut.setOutputFlowsFromRawData(rawData);

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		tranOut.setOutputName(tranOut.getClass().getSimpleName()
				+ dateFormat.format(cal.getTime()).toString());

		tranOut.printOutFlows(BaggingToolUtil.getPath("OUTPUT_FOLDER")
				+ "flow_" + tranOut.getOutputName() + ".txt");

		db.saveOutputToDatabase(tranOut);
		TranalyzerBagging tBag = new TranalyzerBagging(tranOut.getOutputName());
		db.performQueries(tBag.getBaggingQuery());

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

