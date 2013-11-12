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
	}

	public HashMap<String, Integer> getFeaturesPresent() {
		return featuresPresent;
	}

	public void setFeaturesPresent(HashMap<String, Integer> featuresPresent) {
		this.featuresPresent = featuresPresent;
	}


	public ArrayList<ArrayList<String>> getRawDataFromFile(File file,
			String splitToken) {
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				data.add(i, new ArrayList<String>());
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

	public abstract String preProcessField(String fieldName);

	public abstract String setFieldValueFromFile(ArrayList<ArrayList<String>> rawData);

}
