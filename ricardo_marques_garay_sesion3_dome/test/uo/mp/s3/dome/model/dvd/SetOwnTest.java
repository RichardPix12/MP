package uo.mp.s3.dome.model.dvd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo270160.mp.s3.dome.model.Dvd;

public class SetOwnTest {
	private Dvd aDVD;
	private String theTitle;
	private String theDirector;
	private int theTime;
	
	
	@Before
	public void setUp() {
		theTitle = "La guerra de las Galaxias";
		theDirector = "George Lucas";
		theTime = 125;
		aDVD = new Dvd(theTitle, theDirector, theTime);
	}
	
	/**
	 * GIVEN:	dvd con valor true para propietario
	 * WHEN:	se invoca setOwn con true
	 * THEN:	el dvd permanece con true en propietario
	 * 
	 */
	@Test
	public void testSetOwnTrueTrue() {
		aDVD.setOwn(true);
		aDVD.setOwn(true);
		assertEquals(true, aDVD.getOwn());
	}

	/**
	 * GIVEN:	dvd con valor true para propietario
	 * WHEN:	se invoca setOwn con false
	 * THEN:	el dvd cambia a false en propietario
	 * 
	 */
	@Test
	public void testSetOwnTrueFalse() {
		aDVD.setOwn(true);
		aDVD.setOwn(false);
		assertEquals(false, aDVD.getOwn());
	}

	/**
	 * GIVEN:	dvd con valor false para propietario
	 * WHEN:	se invoca setOwn con false
	 * THEN:	el dvd permanece con false en propietario
	 * 
	 */
	@Test
	public void testSetOwnFalseFalse() {
		aDVD.setOwn(false);
		aDVD.setOwn(false);
		assertEquals(false, aDVD.getOwn());
	}
	/**
	 * GIVEN:	dvd con valor false para propietario
	 * WHEN:	se invoca setOwn con true
	 * THEN:	el dvd cambia a true en propietario
	 * 
	 */
	@Test
	public void testSetOwnFalseTrue() {
		aDVD.setOwn(false);
		aDVD.setOwn(true);
		assertEquals(true, aDVD.getOwn());
	}
	

}