/*
 * ArtistFactoryTest.java
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
public class ArtistFactoryTest extends TestCase {
	ArtistFactory af=new ArtistFactory();
	
	public ArtistFactoryTest(java.lang.String testName) {
		super(testName);
	}
	
	public static Test suite() {
		TestSuite suite = new TestSuite(ArtistFactoryTest.class);
		return suite;
	}
	
	/**
	 * Test of getArtistsForTransport method, of class transport.server.ArtistFactory.
	 */
	public void testGetArtistsForTransport() {
		System.out.println("testGetArtistsForTransport");
	
		// TODO add your test code below by replacing the default call to fail.
		
	}
	
	/**
	 * Test of getArtist method, of class transport.server.ArtistFactory.
	 */
	public void testGetArtist() {
		System.out.println("testGetArtist");
		
		// TODO add your test code below by replacing the default call to fail.
		
		Artist a=af.getArtist(1);
		
		System.out.println(a);
	}
	
	/**
	 * Test of getAllArtists method, of class transport.server.ArtistFactory.
	 */
	public void testGetAllArtists() {
		System.out.println("testGetAllArtists");
		
		// TODO add your test code below by replacing the default call to fail.
		Artist a[]=af.getAllArtists();

		for (int i=0;i<a.length;i++) {
			System.out.println(a);
		}
	}
	
	/**
	 * Test of newArtist method, of class transport.server.ArtistFactory.
	 */
	public void testNewArtist() {
		System.out.println("testNewArtist");
		
		// TODO add your test code below by replacing the default call to fail.
		/*
		Artist a=new Artist(0,"Moofoo","Boofoo",);
		af.newArtist(a);
		Artist b=af.getArtist();
		*/
	}
	
	/**
	 * Test of updateArtist method, of class transport.server.ArtistFactory.
	 */
	public void testUpdateArtist() {
		System.out.println("testUpdateArtist");
		
		// TODO add your test code below by replacing the default call to fail.
		fail("The test case is empty.");
	}
	
	// TODO add test methods here, they have to start with 'test' name.
	// for example:
	// public void testHello() {}
	
	
}
