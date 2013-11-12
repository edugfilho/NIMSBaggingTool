import java.io.File;
import java.util.ArrayList;

import format.NetmateOutput;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File(
				"/home/eduardo/Desktop/NIMS/NewBaggingTool/FlowSamples/Alexa-Netmate.txt");
		//Field[] fields = FeaturesConsts.class.getFields();
		NetmateOutput netOut = new NetmateOutput();
		ArrayList<ArrayList<String>> rawData = netOut.getRawDataFromFile(f, ",");

		for (ArrayList<String> arrayList : rawData) {
			for (String string : arrayList) {
				System.out.println(string);
			}
		}
		

	}

}
/*
 * Tranalyzer's duration
 * check ip address if it doesn't have (softflowd and yaf spec) get rid of it
 * softflowd "M" (mega) features YAF check ip addr (if it has endtime it's ok)
 * YAF: idle (or active when no duration ) means no backwards data YAF: (icmp)
 * [x:y] = port numbers YAF: flows that doesn't have endtime: endtime = 0,
 * duration = 0 Remove ipv6
 */
