/*
 * TransportSuite.java
 * JUnit based test
 *
 * Created on June 17, 2004, 4:19 PM
 */

package transport;

import junit.framework.*;

/**
 *
 * @author ola
 */
public class TransportSuite extends TestCase {
	
	public TransportSuite(java.lang.String testName) {
		super(testName);
	}
	
	/**
	 * suite method automatically generated by JUnit module
	 */
	public static Test suite() {
		TestSuite suite = new TestSuite("TransportSuite");
		suite.addTest(transport.logic.LogicSuite.suite());
		suite.addTest(transport.server.ServerSuite.suite());
		return suite;
	}
	
	// TODO add test methods here, they have to start with 'test' name.
	// for example:
	// public void testHello() {}
	
	
}
