package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import util.Util;
import format.FlowOutput;
import format.FlowOutput.Flow;
import format.NetmateOutput;
import format.YafOutput;

public class BaggingToolDatabase {
	private static final String url = "jdbc:mysql://localhost:3306/baggingtool";
	private static final String user = "nims";
	private static final String password = "nimslabpass";
	private Connection con = null;

	private void connect() throws SQLException {

		con = DriverManager.getConnection(url, user, password);

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
				 + output.getOutputName()+"'");
				String recentOutputId = "";
				 
				  if(rs.next()){ 
					  recentOutputId = rs.getString(1);
					  System.out.println("ok, netmate: " + recentOutputId); 
				  }
				 

				for (Flow flow : output.getOutputFlows()) {
					String insertFlows = "INSERT INTO flows (";
					
					for (Entry<String, Integer> entry : Util
							.entriesSortedByValues(output.getFeaturesPresent())) {

						if (entry.getValue() != FlowOutput.FALSE) {
							insertFlows += entry.getKey() + ", ";
						}
					}
					insertFlows += "Output_id)";
							
					insertFlows += " VALUES (";

					for (String string : flow) {
						insertFlows += "'" + string + "', ";
					}
					insertFlows += "'"+recentOutputId+"')";
					st.executeUpdate(insertFlows);
					//System.out.println(insertFlows);
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
}
