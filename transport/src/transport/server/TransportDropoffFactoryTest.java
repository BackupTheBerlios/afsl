/*
 * TransportDropoffFactoryTest.java
 * JUnit based test
 *
 * Created on June 17, 2004, 4:19 PM
 */

package transport.server;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import junit.framework.*;
import transport.logic.*;

/**
 *
 * @author ola
 */
public class TransportDropoffFactoryTest extends TestCase {
	
	public TransportDropoffFactoryTest(java.lang.String testName) {
		super(testName);
	}
	
	public static Test suite() {
		TestSuite suite = new TestSuite(TransportDropoffFactoryTest.class);
		return suite;
	}
	
	/**
	 * Test of getDropoffs method, of class transport.server.TransportDropoffFactory.
	 */
	public void testGetDropoffs() {
		System.out.println("testGetDropoffs");
		
		// TODO add your test code below by replacing the default call to fail.
		fail("The test case is empty.");
	}
	
	// TODO add test methods here, they have to start with 'test' name.
	// for example:
	// public void testHello() {}
	
	
}
