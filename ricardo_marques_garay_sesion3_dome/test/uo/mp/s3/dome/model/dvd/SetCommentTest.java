package uo.mp.s3.dome.model.dvd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo270160.mp.s3.dome.model.Dvd;

public class SetCommentTest {
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
	 * GIVEN: 	dvd con comentario vacío
	 * WHEN: 	invoca setComment cadena no vacía como comentario
	 * THEN:	se cambia el comentario a la cadena
	 */
	@Test
	public void testSetComment() {
		aDVD.setComment("Excellent");

		assertEquals("Excellent", aDVD.getComment());
	}
	
	/**
	 * GIVEN: 	dvd con comentario no vacío
	 * WHEN: 	invoca setComment con null
	 * THEN:	permanece el comentario que había
	 */
	@Test
	public void testSetInvalidComment() {
		aDVD.setComment("Excellent");
		aDVD.setComment(null);

		assertEquals("Excellent", aDVD.getComment());
	}

}