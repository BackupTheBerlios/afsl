package transport.server;

import java.sql.*;
import java.util.logging.*;

public class ConnectionFactory {
	private static boolean init=false;
	private static Logger logger=Logger.getLogger(
		"transport.server.ConnectionFactory");

	/**
	 * FIXME: should read from a config file of sorts.
	 */

	private static void initFactory() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		init=true;
	}

	/**
	 * FIXME: Rule-based and not fixed.
	 */

	public static Connection getConnection() throws SQLException {
		if (!init) {
			initFactory();
		}

		return DriverManager.getConnection("jdbc:postgresql://10.0.0.6/transport","ola","passwd");
	}
}
