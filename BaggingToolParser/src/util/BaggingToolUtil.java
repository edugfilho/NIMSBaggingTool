package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BaggingToolUtil {
	public static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> entriesSortedByValues(
			Map<K, V> map) {
		SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(
				new Comparator<Map.Entry<K, V>>() {
					@Override
					public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
						int res = e1.getValue().compareTo(e2.getValue());
						return res != 0 ? res : 1; // Special fix to preserve
													// items with equal values
					}
				});
		sortedEntries.addAll(map.entrySet());
		return sortedEntries;
	}
	
	public static String getTimeStamp(){
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime()).toString();
	}

	public static String getPath(String what) {
		File fPath = new File("res/filePath");

		try {
			BufferedReader br;
			br = new BufferedReader(new FileReader(fPath));
			String line = null;

			while ((line = br.readLine()) != null) {
				if (line.contains(what)) {
					StringTokenizer st = new StringTokenizer(line, "=");
					st.nextElement();
					br.close();
					if (st.hasMoreElements()) {
						return st.nextElement().toString();
					}else return null;
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
