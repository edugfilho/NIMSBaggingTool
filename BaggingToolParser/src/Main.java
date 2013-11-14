import java.io.File;
import java.util.ArrayList;

import format.FlowOutput.Flow;
import format.NetmateOutput;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File(
				"C:/Users/Eduardo/Documents/NIMS/Flow samples/Alexa-Netmate.txt");
		//Field[] fields = FeaturesConsts.class.getFields();
		NetmateOutput netOut = new NetmateOutput();
		ArrayList<Flow> rawData = netOut.getRawDataFromFile(f, ",");

		/*for (ArrayList<String> arrayList : rawData) {
			System.out.println("");
			for (String string : arrayList) {
				System.out.print(string+" ");
			}
		}*/
		netOut.setOutputFlowsFromRawData(rawData);
		for (Flow flow : netOut.getOutputFlows()) {
			System.out.println("");
			for (String string : flow) {
				System.out.print(string+" ");
			}
		}

	}

}
/*TODO: get desired fields and mount queries to database with netmate 
 * Tranalyzer's duration
 * check ip address if it doesn't have (softflowd and yaf spec) get rid of it
 * softflowd "M" (mega) features YAF check ip addr (if it has endtime it's ok)
 * YAF: idle (or active when no duration ) means no backwards data YAF: (icmp)
 * [x:y] = port numbers YAF: flows that doesn't have endtime: endtime = 0,
 * duration = 0 Remove ipv6
 */

