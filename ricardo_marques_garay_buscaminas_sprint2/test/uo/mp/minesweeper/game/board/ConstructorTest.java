package uo.mp.minesweeper.game.board;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.minesweeper.game.Board;

public class ConstructorTest {

	/**
	 * GIVEN un constructor del objeto
	 * WHEN comprobar que el objeto creado tiene la dimension y minas 
	 * pasadas por parámetro
	 *  THEN devuelve la dimesion y las minas del tablero
	 */
	@Test
	public void testConstructor() {
		Board bd1 = new Board(9, 9, 12);
 		assertEquals (9,bd1.getMinesLeft());
		
		
	}

}
