package uo270160.mp.s2.analyzer.model.wordanalyzer;

import static org.junit.Assert.*;

import org.junit.Test;

import uo270160.mp.s2.analyzer.model.WordAnalyzer;

public class FirstMultipleCharacterTest {
	//caso 1: palabra con caracteres repetidos no consecutivos
	//caso 2: palabra con caracteres repetidos consecutivos al principio
	//caso 3: palabra con caracteres repetidos consecutivos a la mitad
	//caso 4: palabra con caracteres repetidos consecutivos al final
	//caso 5: palabra sin caracteres repetidos
	//caso 6: palabra vacia
	
	
	/**
	 * GIVEN un objeto analizador con palabra vacia
	 * WHEN se comprueba los caracteres repetidos
	 * THEN devuelve 0
	 */
	
	
	@Test
	public void testEmptyWord() {
		WordAnalyzer wa = new WordAnalyzer("");
		assertEquals(0, wa.firstMultipleCharacter());
	}

}
