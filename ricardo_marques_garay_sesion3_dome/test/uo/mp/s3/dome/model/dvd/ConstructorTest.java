package uo.mp.s3.dome.model.dvd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo270160.mp.s3.dome.model.Dvd;

public class ConstructorTest {

	private Dvd aDvd;
	private String theTitle;
	private String theDirector;
	private int theTime;
	
	
	
	@Before
	public void setUp() {
		theTitle = "La guerra de las Galaxias";
		theDirector = "George Lucas";
		theTime = 125;		
	}
		
	/**
	 * GIVEN:
	 * WHEN: Se crea con parámetros válidos
	 * THEN: se crea y los valores se asignan a los atributos
	 */
	@Test
	public void testValidParamsConstructor() {
		aDvd = new Dvd(theTitle, theDirector, theTime);

		assertEquals(theTitle, aDvd.getTitle());
		assertEquals(theDirector, aDvd.getDirector());
		assertEquals(theTime, aDvd.getPlayingTime());
		assertEquals(false, aDvd.getOwn());
		assertEquals("No comment", aDvd.getComment());
	}

	/**
	 * Constructor with invalid title
	 */

	/**
	 * Constructor with invalid director
	 */

	/**
	 * Constructor with invalid palyingTime
	 */

}
