import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map.Entry;

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

		
		//YAF TESTS
		File f = new File(
				"C:/Users/Eduardo/Documents/NIMS/Flow samples/Alexa3-YAF.txt");
		YafOutput yafOut = new YafOutput();
		ArrayList<Flow> rawData = yafOut.getRawDataFromFile(f);

		yafOut.setOutputFlowsFromRawData(rawData);
		yafOut.printOutFlows();
		
		
		
		//NETMATE TESTS
		/*File f = new File(
				"C:/Users/Eduardo/Documents/NIMS/Flow samples/Alexa-Netmate.txt");
		NetmateOutput netOut = new NetmateOutput();
		ArrayList<Flow> rawData = netOut.getRawDataFromFile(f);

		netOut.setOutputFlowsFromRawData(rawData);

		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		netOut.setOutputName(netOut.getClass().toString()
				+ dateFormat.format(cal.getTime()).toString());
		db.saveOutputToDatabase(netOut);*/
		
		/*
		 * for (Flow flow : netOut.getOutputFlows()) { System.out.println("");
		 * for (String string : flow) { System.out.print(string + " "); } }
		 */

	}

}
/*
 * TODO: get desired fields and mount queries to database with netmate
 * Tranalyzer's duration check ip address if it doesn't have (softflowd and yaf
 * spec) get rid of it softflowd "M" (mega) features YAF check ip addr (if it
 * has endtime it's ok) YAF: idle (or active when no duration ) means no
 * backwards data YAF: (icmp) [x:y] = port numbers YAF: flows that doesn't have
 * endtime: endtime = 0, duration = 0 Remove ipv6
 */

