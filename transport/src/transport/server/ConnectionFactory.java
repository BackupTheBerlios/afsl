package transport.server;

import java.sql.*;
import transport.logic.*;

public class ConnectionFactory {
	private static boolean init=false;

	/**
	 * FIXME: should read from a config file of sorts.
	 */
	
	private static void initFactory() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
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

		return DriverManager.getConnection("jdbc:postgresql://localhost/transport","ola","passwd");
	}
}
