/*
 * ArtistFactoryTest.java
 * JUnit based test
 *
 * Created on June 17, 2004, 4:19 PM
 */

package transport.server;

import junit.framework.*;
import transport.logic.*;

/**
 *
 * @author ola
 */

public class ArtistFactoryTest extends TestCase {
	ArtistFactory af=new ArtistFactory();
	PlaceFactory pf=new PlaceFactory();

	public ArtistFactoryTest(java.lang.String testName) {
		super(testName);
	}

	public static Test suite() {
		TestSuite suite=new TestSuite(ArtistFactoryTest.class);
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

		for (int i=0; i < a.length; i++) {
			System.out.println(a);
		}
	}

	/**
	 * Test of newArtist method, of class transport.server.ArtistFactory.
	 */
	/*
	  public void testNewArtist() {
	 System.out.println("testNewArtist");

	 Artist a=new Artist();

	 a.setName("Nishrakt");
	 a.setContactName("Forslay");
	 a.setTelephoneNumber("123-456-7890");
	 a.setArrivalTime(new java.util.Date("2004-07-15 12:34"));
	 a.setArrival(pf.getPlace(1));
	 a.setDepartureTime(new java.util.Date("2004-07-17 23:12"));
	 a.setDeparture(pf.getPlace(2));
	 a.setNoOfArtists(2);
	 a.setNoOfCrew(4);
	 a.setNoOfGuests(7);
	 a.setExtraInfo("Meep!");
	 af.newArtist(a);

	 Artist b=af.getArtist(a.getId());

	 // check that a=b
	 if (!a.equals(b)) {
	  System.err.println(a);
	  System.err.println(b);
	  fail("testNewArtist: artist mismatch.");
	 }
	  }
	 */

	/**
	 * Test of updateArtist method, of class transport.server.ArtistFactory.
	 */
	/*
	  public void testUpdateArtist() {
	 System.out.println("testUpdateArtist");

	 Artist a=new Artist(0,"Farclas","Wayborne");

	 a=af.newArtist(a);

	 Artist b=a.clone();

	 b.setName("Nishrakt");
	 b.setContactName("Forslay");
	 b.setTelephoneNumber("123-456-7890");
	 b.setArrivalTime(new Date("2004-07-15 12:34"));
	 b.setArrival(pf.getPlace(1));
	 b.setDepartureTime(new Date("2004-07-17 23:12"));
	 b.setDeparture(pf.getPlace(2));
	 b.setNoOfArtists(2);
	 b.setNoOfCrew(4);
	 b.setNoOfGuests(7);
	 b.setExtraInfo("Meep!");

	 af.updateArtist(a);
	 a=af.getArtist(a.getId());

	 if (!a.equals(b)) {
	  System.err.println(a);
	  System.err.println(b);
	  fail("testNewArtist: artist mismatch.");
	 }

	  }
	 */

	// TODO add test methods here, they have to start with 'test' name.
	// for example:
	// public void testHello() {}

}
