import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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

	/**
	 * @param args
	 */
	private static BaggingToolDatabase db = null;
	public static void main(String[] args) {
		
		BaggingToolDatabase db = new BaggingToolDatabase();
		db.resetDatabase();
		//testYaf();
		
		testSoftflowd();
		//testNetmate();
		//testTranalyzer();
	}

	public static void testYaf() {
		// YAF TESTS
		BaggingToolDatabase db = new BaggingToolDatabase();
		File f = new File(
				"C:/Users/Eduardo/Documents/NIMS/Flow samples/Alexa3-YAFDemo.txt");
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
		
		YafBagging yafBag = new YafBagging();
		db.performQueries(yafBag.getBaggingQuery());

	}

	public static void testNetmate() {
		// NETMATE TESTS
		BaggingToolDatabase db = new BaggingToolDatabase();
		File f = new File(
		 "C:/Users/Eduardo/Documents/NIMS/Flow samples/Alexa-NetmateDemo.txt");

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
		NetmateBagging netBag = new NetmateBagging();
		db.performQueries(netBag.getBaggingQuery());
	}
	public static void testSoftflowd() {

		BaggingToolDatabase db = new BaggingToolDatabase();
		File f = new File(
		 "C:/Users/Eduardo/Documents/NIMS/Flow samples/Alexa-softflowdDemo.txt");

				//"/home/eduardo/Desktop/NIMS/NewBaggingTool/FlowSamples/Alexa-softflowd.txt");

		SoftflowdOutput softOut = new SoftflowdOutput();
		ArrayList<Flow> rawData = softOut.getRawDataFromFile(f);

		softOut.setOutputFlowsFromRawData(rawData);
		//softOut.printOutFlows();

		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		//softOut.setOutputName(softOut.getClass().toString()
				//+ dateFormat.format(cal.getTime()).toString());
		db.saveOutputToDatabase(softOut);
		SoftflowdBagging softBag = new SoftflowdBagging();
		db.performQueries(softBag.getBaggingQuery());
	}
	
	public static void testTranalyzer() {
		
		BaggingToolDatabase db = new BaggingToolDatabase();
		File f = new File(
		 "C:/Users/Eduardo/Documents/NIMS/Flow samples/tranalyzer_demo.txt");

				//"/home/eduardo/Desktop/NIMS/NewBaggingTool/FlowSamples/Alexa_Tranalzer.txt");

		TranalyzerOutput tranOut = new TranalyzerOutput();
		ArrayList<Flow> rawData = tranOut.getRawDataFromFile(f);

		tranOut.setOutputFlowsFromRawData(rawData);
		//tranOut.printOutFlows();

		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		//softOut.setOutputName(softOut.getClass().toString()
			//	+ dateFormat.format(cal.getTime()).toString());
		db.saveOutputToDatabase(tranOut);
		TranalyzerBagging tBag = new TranalyzerBagging();
		db.performQueries(tBag.getBaggingQuery());
	}
	
}

/*
 * TODO: 
 * ASSUMED tranalyzer: Overall ipTTLChg = total = sum.
 * median of MedianIat = std of medianIAT right now
 * 
 * transformed dates to miliseconds
 * 
 * add a class label after bagging (we are assuming that every file will have
 * only ONE label)
 * look groupby, outfile mysql and
 */

