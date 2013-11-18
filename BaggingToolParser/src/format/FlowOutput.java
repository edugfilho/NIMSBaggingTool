package format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import bagging.feature.FeaturesConsts;

public abstract class FlowOutput {
	protected HashMap<String, Integer> featuresPresent;
	public static String TRUE = "true";
	public static Integer FALSE = -1;

	private ArrayList<Flow> outputFlows;
	//TODO: Name must be always different between outputs
	private String outputName;

	public FlowOutput() {
		featuresPresent = new HashMap<String, Integer>();

		Field[] fields = FeaturesConsts.class.getFields();
		for (Field field : fields) {
			String s = null;
			try {
				s = (String) field.get(new Object());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

			featuresPresent.put(s, FALSE);
		}
		outputFlows = new ArrayList<Flow>();
	}

	public HashMap<String, Integer> getFeaturesPresent() {
		return featuresPresent;
	}

	public void setFeaturesPresent(HashMap<String, Integer> featuresPresent) {
		this.featuresPresent = featuresPresent;
	}

	public ArrayList<Flow> getRawDataFromFile(File file) {
		String splitToken = getSeparator();
		ArrayList<Flow> data = new ArrayList<Flow>();
		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				data.add(i, new Flow());
				StringTokenizer st = new StringTokenizer(line, splitToken);
				int j = 0;
				while (st.hasMoreElements()) {
					data.get(i).add(j, st.nextElement().toString());
					j++;
				}
				i++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	public void setOutputFlowsFromRawData(ArrayList<Flow> rawData) {
		int rawIndex = 0;
		int featIndex = 0;
		for (Flow flow : rawData) {
			outputFlows.add(featIndex, new Flow());
			// System.out.println("outputflows size:" + outputFlows.size());
			rawIndex = 0;
			for (String featValue : flow) {
				if (featuresPresent.containsValue(rawIndex)) {
					outputFlows.get(featIndex).add(featValue);
				}
				rawIndex++;
			}
			featIndex++;
		}
	}

	public abstract String preProcessField(String fieldName);

	public class Flow extends ArrayList<String> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	}

	public ArrayList<Flow> getOutputFlows() {
		return outputFlows;
	}

	public void setOutputFlows(ArrayList<Flow> outputFlows) {
		this.outputFlows = outputFlows;
	}

	public String getOutputName() {
		return outputName;
	}

	public void setOutputName(String outputName) {
		this.outputName = outputName;
	}
	
	public abstract String getSeparator();
	
	public void printOutFlows(){
		for (Flow flow : outputFlows) {
			System.out.println("");
			for (String string : flow) {
				System.out.print(string+"\t");
			}
		}
	}
}
