import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import database.BaggingToolDatabase;
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
		//db.prepareAndExecuteQueries();
		//testNetmate();
		//testYaf();
		//testSoftflowd();
		//testTranalyzer();

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
	
	public static void testTranalyzer() {
		// NETMATE TESTS
		BaggingToolDatabase db = new BaggingToolDatabase();
		File f = new File(
		 "C:/Users/Eduardo/Documents/NIMS/Flow samples/tranalyzer_demo");

				//"/home/eduardo/Desktop/NIMS/NewBaggingTool/FlowSamples/Alexa_Tranalzer.txt");

		TranalyzerOutput tranOut = new TranalyzerOutput();
		ArrayList<Flow> rawData = tranOut.getRawDataFromFile(f);

		tranOut.setOutputFlowsFromRawData(rawData);
		tranOut.printOutFlows();

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
 * transform dates to miliseconds
 * 
 * add a class label after bagging (we are assuming that every file will have
 * only ONE label)
 * 
 * Insert Start and End time as date into the DB!
 * 
 * Queries must take into consideration valid features!

 * Tranalyzer's duration 
 * 
 ***softflowd "M" (mega) features
 * 
 * YAF check ip addr (if it has endtime it's ok)
 * 
 * 
 * 
 ***YAF: flows that doesn't have endtime: endtime = 0, duration = 0
 * 
 ***Remove ipv6
 * 
 * 
 * 
 ***include all features in the database
 * 
 * look groupby, outfile mysql and
 */

