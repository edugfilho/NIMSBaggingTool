import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import format.FlowOutput.Flow;
import format.NetmateOutput;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		File f = new File(
				"C:/Users/Eduardo/Documents/NIMS/Flow samples/Alexa-Netmate.txt");
		NetmateOutput netOut = new NetmateOutput();
		ArrayList<Flow> rawData = netOut.getRawDataFromFile(f, ",");

		netOut.setOutputFlowsFromRawData(rawData);
		for (Flow flow : netOut.getOutputFlows()) {
			System.out.println("");
			for (String string : flow) {
				System.out.print(string + " ");
			}
		}*/

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/test";
		String user = "nims";
		String password = "nimslabpass";

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * from names");
			

			while (rs.next()) {
				System.out.println(rs.getString(2));
			}
			int a = st.executeUpdate("SET PASSWORD FOR 'root'@'localhost' = PASSWORD('root')");
			int b = st.executeUpdate("GRANT ALL ON * TO 'root'@'localhost'");
			System.out.println(a);
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Main.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
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
				Logger lgr = Logger.getLogger(Main.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
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

