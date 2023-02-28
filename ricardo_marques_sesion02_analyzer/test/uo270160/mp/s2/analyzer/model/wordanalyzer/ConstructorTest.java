package uo270160.mp.s2.analyzer.model.wordanalyzer;

import org.junit.Test;

import uo270160.mp.s2.analyzer.model.WordAnalyzer;

public class ConstructorTest {

	/**
	 * GIVEN analizador
	 * WHEN  se crea con la palabra vacia
	 * THEN lanza una IllegalArgumentException
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testWordNull() {
		new WordAnalyzer(null) ; 
		//Forma de comprobarlo si en try-catch
	}

}
