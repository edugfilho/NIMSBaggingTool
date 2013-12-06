package database;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import util.Util;
import bagging.feature.FeaturesConsts;
import format.FlowOutput;
import format.FlowOutput.Flow;
import format.NetmateOutput;
import format.SoftflowdOutput;
import format.TranalyzerOutput;
import format.YafOutput;

public class BaggingToolDatabase {
	private static final String url = "jdbc:mysql://localhost:3306/baggingtool";
	private static final String user = "root";
	private static final String password = "root";
	private static final String VARCHAR_SIZE = "200";
	private Connection con = null;

	private void connect() throws SQLException {

		con = DriverManager.getConnection(url, user, password);

	}

	public void resetDatabase() {
		Statement st = null;

		// ResultSet rs = null;
		try {
			connect();

			st = con.createStatement();

			String statement = "DROP TABLE IF EXISTS flows";
			st.executeUpdate(statement);

			statement = "DROP TABLE IF EXISTS output";
			st.executeUpdate(statement);

			statement = "CREATE TABLE IF NOT EXISTS output ( OutputName varchar(100) NOT NULL, ToolName varchar(100) NOT NULL, output_id bigint(20) NOT NULL AUTO_INCREMENT, PRIMARY KEY (output_id)) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8";
			st.executeUpdate(statement);

			statement = "CREATE TABLE flows ("
					+ mountFlowTableCreationStatement();
			st.executeUpdate(statement);

			String lastPart = "ALTER TABLE flows ADD CONSTRAINT flows_ibfk_1 FOREIGN KEY (Output_Id) REFERENCES output (output_id) ON DELETE CASCADE";
			st.executeUpdate(lastPart);
			// ON DELETE CASCADE ON UPDATE RESTRICT
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private String getFieldType(String fieldName) {
		
		TranalyzerOutput tranOut = new TranalyzerOutput();
		NetmateOutput netOut = new NetmateOutput();
		SoftflowdOutput softOut = new SoftflowdOutput();
		YafOutput yafOut = new YafOutput();

		HashSet<String> allFeaturesUsed = new HashSet<String>();
		allFeaturesUsed.addAll(tranOut.getFeaturesUsed());
		allFeaturesUsed.addAll(netOut.getFeaturesUsed());
		allFeaturesUsed.addAll(softOut.getFeaturesUsed());
		allFeaturesUsed.addAll(yafOut.getFeaturesUsed());
		
		if(allFeaturesUsed.contains(fieldName)){
			return "double";
		}else return "varchar("+VARCHAR_SIZE+")";
	}

	public String mountFlowTableCreationStatement() {
		Field[] fields = FeaturesConsts.class.getFields();
		String result = "FlowId bigint(20) NOT NULL AUTO_INCREMENT, Output_Id bigint(20) NOT NULL";
		for (Field field : fields) {
			String s = null;
			try {
				s = (String) field.get(new Object());
				String type = getFieldType(s);
				String mod;
				if (s.contentEquals(FeaturesConsts.flowSrcIpAddr)
						|| s.contentEquals(FeaturesConsts.flowDstIpAddr)
						|| s.contentEquals(FeaturesConsts.flowSrcPort)
						|| s.contentEquals(FeaturesConsts.flowDstPort)
						|| s.contentEquals(FeaturesConsts.flowProtocol)) {
					mod = " NOT NULL";
					type = "varchar("+VARCHAR_SIZE+")";
				} else {
					mod = " default NULL";
				}

				s = ", " + s + " "+ type + mod;

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			result = result + s;

		}
		return result
				+ ", PRIMARY KEY (FlowId), KEY Output_Id (Output_Id)) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ";
	}

	public String getAllValidFeatures(FlowOutput output, int numFeatures) {
		String insertFlows = "";
		int index = 0;
		for (Entry<String, Integer> entry : Util.entriesSortedByValues(output
				.getFeaturesPresent())) {

			// To be inserted, a feature must exist in an output
			if (entry.getValue() != FlowOutput.FALSE && index < numFeatures) {
				insertFlows += entry.getKey() + ", ";
				index++;
			}

		}
		insertFlows += "Output_id)";
		return insertFlows;
	}

	public void saveOutputToDatabase(FlowOutput output) {

		Statement st = null;
		ResultSet rs = null;
		String insertOutput = "INSERT INTO output (OutputName, ToolName) VALUES ( '"
				+ output.getOutputName() + "'";

		try {
			connect();
			if (output.getClass() == NetmateOutput.class) {
				insertOutput = insertOutput + ", 'Netmate')";
			}
			if (output.getClass() == YafOutput.class) {
				insertOutput = insertOutput + ", 'YAF')";
			}
			if (output.getClass() == TranalyzerOutput.class) {
				insertOutput = insertOutput + ", 'Tranalyzer')";
			}
			if (output.getClass() == SoftflowdOutput.class) {
				insertOutput = insertOutput + ", 'Softflowd')";
			}

			st = con.createStatement();
			st.executeUpdate(insertOutput);
			rs = st.executeQuery("SELECT output_id from output WHERE OutputName LIKE '"
					+ output.getOutputName() + "'");
			String recentOutputId = "";

			if (rs.next()) {
				recentOutputId = rs.getString(1);
				// System.out.println("ok, netmate: " + recentOutputId);
			}

			for (Flow flow : output.getOutputFlows()) {
				String insertFlows1 = "INSERT INTO flows ("
						+ getAllValidFeatures(output, flow.size())
						+ " VALUES (";
				String insertFlows2 = "";
				for (String string : flow) {
					insertFlows2 += "'" + string + "', ";
				}
				insertFlows2 += "'" + recentOutputId + "')";
				st.executeUpdate(insertFlows1 + insertFlows2);
				// System.out.println(insertFlows);
			}

			// st = con.createStatement();
			// rs = st.executeQuery("SELECT * from names");
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(BaggingToolDatabase.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}

		finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(BaggingToolDatabase.class
						.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}

	}

	public String performQueries(String query) {
		Statement st = null;
		ResultSet rs = null;
		String result = "";

		try {
			connect();
			st = con.createStatement();
			rs = st.executeQuery(query);
			int columns = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columns; i++) {
					result += rs.getString(i) + ", ";
				}
				result += "\n";

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	public void prepareAndExecuteQueries() {
		//TranalyzerBagging tBag = new TranalyzerBagging();
		NetmateBagging netBag = new NetmateBagging();

		//performQueries(tBag.getBaggingQuery());
		performQueries(netBag.getBaggingQuery());


	}

	public void printToFile(String content, String fname) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(
					"C:/Users/Eduardo/Documents/NIMS/baggingTool/Output"
							+ fname, "UTF-8");// "/home/eduardo/NIMSBaggingTool/output"
			// + fname, "UTF-8");
			writer.println(content);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
