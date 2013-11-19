import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import database.BaggingToolDatabase;
import format.FlowOutput.Flow;
import format.NetmateOutput;
import format.YafOutput;

public class Main {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		BaggingToolDatabase db = new BaggingToolDatabase();
		//testNetmate();
		testYaf();

	}

	public static void testYaf() {
		// YAF TESTS

		File f = new File(
				"C:/Users/Eduardo/Documents/NIMS/Flow samples/Alexa3-YAF.txt");
		//"/home/eduardo/NIMS/NewBaggingTool/FlowSamples/Alexa3-Yaf.txt");
		YafOutput yafOut = new YafOutput();
		ArrayList<Flow> rawData = yafOut.getRawDataFromFile(f);

		yafOut.setOutputFlowsFromRawData(rawData);
		yafOut.printOutFlows();

	}

	public static void testNetmate() {
		// NETMATE TESTS

		File f = new File(
		 "C:/Users/Eduardo/Documents/NIMS/Flow samples/Alexa-Netmate.txt");

			//	"/home/eduardo/Desktop/NIMS/NewBaggingTool/FlowSamples/Alexa-Netmate.txt");

		NetmateOutput netOut = new NetmateOutput();
		ArrayList<Flow> rawData = netOut.getRawDataFromFile(f);

		netOut.setOutputFlowsFromRawData(rawData);
		netOut.printOutFlows();
		/*
		 * DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
		 * Calendar cal = Calendar.getInstance();
		 * netOut.setOutputName(netOut.getClass().toString() +
		 * dateFormat.format(cal.getTime()).toString()); upstream
		 * db.saveOutputToDatabase(netOut);
		 */

		// db.saveOutputToDatabase(netOut);
		// db.prepareAndExecuteQueries();
	}
}

/*TODO: add new fields to database, organize checklists!
 * TODO: why isn't the output coming out completely? something with the printer
 * Tranalyzer's duration check ip address if it doesn't have (softflowd and yaf
 * spec) get rid of it. softflowd "M" (mega) features YAF check ip addr (if it
 * has endtime it's ok) YAF: idle (or active when no duration ) means no
 * backwards data YAF: (icmp) [x:y] = port numbers YAF: flows that doesn't have
 * endtime: endtime = 0, duration = 0 Remove ipv6 add a class label after
 * bagging (we are assuming that every file will have only ONE label)
 * 
 * include all features in the database
 * 
 * look groupby, outfile mysql and
 */

