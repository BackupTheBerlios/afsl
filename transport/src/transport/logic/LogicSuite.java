/*
 * LogicSuite.java
 * JUnit based test
 *
 * Created on June 17, 2004, 4:19 PM
 */

package transport.logic;

import junit.framework.*;

/**
 *
 * @author ola
 */
public class LogicSuite extends TestCase {
	
	public LogicSuite(java.lang.String testName) {
		super(testName);
	}
	
	/**
	 * suite method automatically generated by JUnit module
	 */
	public static Test suite() {
		TestSuite suite = new TestSuite("LogicSuite");
		suite.addTest(transport.logic.ArtistTest.suite());
		suite.addTest(transport.logic.CarTest.suite());
		suite.addTest(transport.logic.FunctionaryTest.suite());
		suite.addTest(transport.logic.MobilePhoneTest.suite());
		suite.addTest(transport.logic.PlaceTest.suite());
		suite.addTest(transport.logic.RoleTest.suite());
		suite.addTest(transport.logic.TransportTest.suite());
		suite.addTest(transport.logic.TransportDropoffTest.suite());
		return suite;
	}
	
	// TODO add test methods here, they have to start with 'test' name.
	// for example:
	// public void testHello() {}
	
	
}