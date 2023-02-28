package uo.mp.s3.dome.model.cd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo270160.mp.s3.dome.model.Cd;
import uo270160.mp.s3.dome.model.Item;


public class SetOwnTest {
	private Item aCD;
	private String theTitle;
	private String theArtist;
	private int theTime;
	private int theTracks;
	
	
	@Before
	public void setUp() {
		theTitle = "Come Together";
		theArtist = "Beatles";
		theTime = 70;
		theTracks = 4;
		aCD = new Cd(theTitle, theArtist, theTracks, theTime);
	}

	/**
	 * GIVEN:	cd con valor true para propietario
	 * WHEN:	se invoca setOwn con true
	 * THEN:	el cd permanece con true en propietario
	 * 
	 */
	@Test
	public void testSetOwnTrueTrue() {
		aCD.setOwn(true);
		aCD.setOwn(true);
		assertEquals(true, aCD.getOwn());
	}

	/**
	 * GIVEN:	cd con valor true para propietario
	 * WHEN:	se invoca setOwn con false
	 * THEN:	el cd cambia a false en propietario
	 * 
	 */
	@Test
	public void testSetOwnTrueFalse() {
		aCD.setOwn(true);
		aCD.setOwn(false);
		assertEquals(false, aCD.getOwn());
	}

	/**
	 * GIVEN:	cd con valor false para propietario
	 * WHEN:	se invoca setOwn con false
	 * THEN:	el dvd permanece con false en propietario
	 * 
	 */
	@Test
	public void testSetOwnFalseFalse() {
		aCD.setOwn(false);
		aCD.setOwn(false);
		assertEquals(false, aCD.getOwn());
	}
	/**
	 * GIVEN:	cd con valor false para propietario
	 * WHEN:	se invoca setOwn con true
	 * THEN:	el dvd cambia a true en propietario
	 * 
	 */
	@Test
	public void testSetOwnFalseTrue() {
		aCD.setOwn(false);
		aCD.setOwn(true);
		assertEquals(true, aCD.getOwn());
	}
}
