package transport.server;

import java.sql.*;
import java.util.logging.*;
import transport.logic.*;

public class ConnectionFactory {
	private static boolean init=false;
	private static Logger logger=Logger.getLogger("transport.server.ConnectionFactory");
        static String URL_PROPERTY = "transport.url";
        static String USER_PROPERTY = "transport.user";
        static  String PASSWD_PROPERTY = "transport.passwd";
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

                /*String afslURL = System.getProperty(URL_PROPERTY);

                String afslUser = System.getProperty(USER_PROPERTY);

                String afslPassWord = System.getProperty(PASSWD_PROPERTY);*/

		return DriverManager.getConnection("jdbc:postgresql://localhost/transport","sessan","utfors22");
	}
}