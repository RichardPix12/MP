package uo.mp.s3.dome.model.cd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo270160.mp.s3.dome.model.Cd;


public class ConstructorTest {
	 
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
	}

	/**
	 * GIVEN:
	 * WHEN: Se crea con parámetros válidos
	 * THEN: se crea y los valores se asignan a los atributos
	 */
	@Test
	public void testValidParamsConstructor() {
		Cd cd =  new Cd(theTitle, theArtist, theTracks, theTime);

		assertEquals("Come Together", cd.getTitle());
		assertEquals("Beatles", cd.getArtist());
		assertEquals(70, cd.getPlayingTime());
		assertEquals(4, cd.getNumberOfTracks());
		assertEquals(false, cd.getOwn());
		assertEquals("No comment", cd.getComment());
	}

	/**
	 * Constructor with invalid title
	 */

	/**
	 * Constructor with invalid artist
	 */

	/**
	 * Constructor with invalid palyingTime
	 */

	/**
	 * Constructor with invalid number of tracks
	 */ 

	
}
