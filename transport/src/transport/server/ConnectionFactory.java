package transport.server;

import java.sql.*;
import java.util.logging.*;
import transport.logic.*;
import java.util.ArrayList;
import java.sql.Connection;

public class ConnectionFactory {
	private static ArrayList connections = new ArrayList();
	private static boolean init = false;
	private static Logger logger = Logger.getLogger(
		"transport.server.ConnectionFactory");
	static String URL_PROPERTY = "transport.url";
	static String USER_PROPERTY = "transport.user";
	static String PASSWD_PROPERTY = "transport.passwd";
/**
	 * FIXME: should read from a config file of sorts.
	 */

	private static void initFactory() {
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		init = true;
	}

	public static synchronized void closeConnection(Connection conn) {
		connections.add(conn);
	}

/**
	 * FIXME: Rule-based and not fixed.
	 */

	private static boolean validate(Connection conn) {
		try {
			conn.getMetaData();
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public static synchronized Connection getConnection() throws SQLException {
		if (!init) {
			initFactory();
		}

		/*String afslURL = System.getProperty(URL_PROPERTY);
						 String afslUser = System.getProperty(USER_PROPERTY);
			 String afslPassWord = System.getProperty(PASSWD_PROPERTY);*/

		if (connections.size() == 0) {
			return DriverManager.getConnection(
				"jdbc:postgresql://localhost/transport", "ola", "passwd");
		} else {
			Connection conn = (Connection) connections.get(0);
			connections.remove(0);

			if (!validate(conn)) {
				conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost/transport", "ola", "passwd");
			}

			return conn;
		}
	}
}
