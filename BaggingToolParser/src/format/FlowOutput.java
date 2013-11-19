package format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import bagging.feature.FeaturesConsts;

public abstract class FlowOutput {

	/*
	 * featuresPresent maps a feature name and the position from where to get
	 * the feature value inside a flow (positions are separated by a given
	 * separator, different in each output).
	 * 
	 * featuresUsed contains the name of the features that are going to be used
	 * in the bagging process.
	 * 
	 * If a feature is inside "featuresPresent" but not in "featuresUses", it
	 * means that that feature is part of an output but is not considered in the
	 * bagging process.
	 */
	protected HashMap<String, Integer> featuresPresent;
	protected ArrayList<String> featuresUsed;
	public static Integer FALSE = Integer.MIN_VALUE;

	private ArrayList<Flow> outputFlows;
	// TODO: Name must be always different between outputs
	private String outputName;

	public FlowOutput() {
		featuresPresent = new HashMap<String, Integer>();
		featuresUsed = new ArrayList<String>();

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

	/*
	 * This method sets usedFeatures with the features contained in the actual
	 * state of presentFeatures
	 */
	public void setUsedFeaturesWithCurrentPresentFeatures() {
		for (Map.Entry<String, Integer> entry : featuresPresent.entrySet()) {
			featuresUsed.add(entry.getKey());
		}
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

		// RawIndex means the position of a given feature inside a flow.
		int rawIndex = 0;

		// FeatIndex is the position of a flow inside the outputFlows
		// int featIndex = 0;
		for (Flow rawFlow : rawData) {
			Flow tempFlow = new Flow();
			rawIndex = 0;

			if (processRawFlow(rawFlow)) {

				// At this point, rawFlow has modified pre-processed values. It
				// only needs to be out of undesired feature values, the ones
				// not
				// specified for the output in question.
				for (String featValue : rawFlow) {

					if (featuresPresent.containsValue(rawIndex)) {
						tempFlow.add(featValue);

						// outputFlows.get(featIndex).add(featValue);
					}
					rawIndex++;
				}
				outputFlows.add(tempFlow);
				// featIndex++;
			}

		}
	}

	/* Do not ever call this function over a non-raw flow. I'm counting on it. */
	public Boolean processRawFlow(Flow f) {
		// Boolean flowOk = Boolean.TRUE;

		// The number of entries in featurePresent matches the size of the flow
		// "f". Because of that, we can iterate over the "featuresPresent" and
		// increment "index" for "f" after each iteration on "featuresPresent".
		int index = 0;
		for (Map.Entry<String, Integer> entry : featuresPresent.entrySet()) {

			/*
			 * Make sure I'm only processing valid fields. featuresPresent is
			 * not ordered but it doesn't matter since we get the index inside
			 * the flow by entry.getValue().
			 */

			if (entry.getValue() != FALSE && entry.getValue() < f.size()) {
				
				//Removes all non-visible characters from field value (YAF has some nasty tab)
				String processedFeatValue = preProcessField(entry.getKey().replaceAll("\\s+",""), f);
				index = entry.getValue();
				if (processedFeatValue == null) {
					return Boolean.FALSE;
				} else {
					f.set(index, processedFeatValue);
				}
			}
			
		}

		return Boolean.TRUE;
	}

	public abstract String preProcessField(String fieldName, Flow f);

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

	public void printOutFlows() {
		for (Flow flow : outputFlows) {
			System.out.println("");
			for (String string : flow) {
				System.out.print(string + "\t");
			}

		}
	}
}
