package database;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import util.Util;
import bagging.feature.FeaturesConsts;
import format.FlowOutput;
import format.FlowOutput.Flow;
import format.NetmateOutput;
import format.YafOutput;

public class BaggingToolDatabase {
	private static final String url = "jdbc:mysql://localhost:3306/baggingtool";
	private static final String user = "root";
	private static final String password = "root";
	private Connection con = null;

	private void connect() throws SQLException {

		con = DriverManager.getConnection(url, user, password);

	}

	public String getAllValidFeatures(FlowOutput output) {
		String insertFlows = "";
		for (Entry<String, Integer> entry : Util.entriesSortedByValues(output
				.getFeaturesPresent())) {

			if (entry.getValue() != FlowOutput.FALSE) {
				insertFlows += entry.getKey() + ", ";
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

				st = con.createStatement();
				st.executeUpdate(insertOutput);
				rs = st.executeQuery("SELECT output_id from output WHERE OutputName LIKE '"
						+ output.getOutputName() + "'");
				String recentOutputId = "";

				if (rs.next()) {
					recentOutputId = rs.getString(1);
					System.out.println("ok, netmate: " + recentOutputId);
				}

				String insertFlows1 = "INSERT INTO flows ("
						+ getAllValidFeatures(output) + " VALUES (";

				for (Flow flow : output.getOutputFlows()) {
					String insertFlows2 = "";
					for (String string : flow) {
						insertFlows2 += "'" + string + "', ";
					}
					insertFlows2 += "'" + recentOutputId + "')";
					st.executeUpdate(insertFlows1 + insertFlows2);
					// System.out.println(insertFlows);
				}

			}
			if (output.getClass() == YafOutput.class) {
				System.out.println("eeh yaf!");
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
		String result = null;

		try {
			connect();
			st = con.createStatement();
			rs = st.executeQuery(query);
			int columns = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columns; i++) {
					result += rs.getString(i) + ", ";
				}
				System.out.println();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public void prepareAndExecuteQueries() {
		String query1 = "SELECT * FROM flows ORDER BY "
				+ FeaturesConsts.flowSrcIpAddr;
		String query2 = "SELECT * FROM flows ORDER BY "
				+ FeaturesConsts.flowSrcPort;
		String query3 = "SELECT * FROM flows ORDER BY "
				+ FeaturesConsts.flowSrcPort + ", "
				+ FeaturesConsts.flowSrcIpAddr;

		printToFile(performQueries(query1), "query1");

		printToFile(performQueries(query2), "query2");

		printToFile(performQueries(query3), "query3");
	}

	public void printToFile(String content, String fname) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("/home/eduardo/NIMSBaggingTool/output"
					+ fname, "UTF-8");
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
