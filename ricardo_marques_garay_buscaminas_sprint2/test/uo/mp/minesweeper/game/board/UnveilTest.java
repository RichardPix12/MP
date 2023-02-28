package uo.mp.minesweeper.game.board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.game.Square;
import uo.mp.minesweeper.game.State;

public class UnveilTest {
	
	public Square[][] square1;
	public Square[][] square2;
	public Square[][] square3;

	public Board bd1;
	public Board bd2;
	public Board bd3;
	
	@Before
	public void setUp() {


		square1 = new Square[3][3];		
		square2 = new Square[3][3];
		square3 = new Square[3][3];

	}

	/**
	 * GIVEN un tablero completamente cubierto
	 * WHEN se pasa el método unveil
	 * THEN devuelve el tablero desmarcado
	 */
	@Test
	public void testUnveilCoveredBoard() {
		for (int i=0; i<square1.length; i++) {
			for(int j=0; j<square1[i].length; j++) {
				square1[i][j] = new Square(State.CLOSED,Square.EMPTY_SQUARE);
			}
		}
			bd1 = new Board(2,square1);
			bd1.unveil();
			for (int i=0; i<square1.length; i++) {
				for(int j=0; j<square1[i].length; j++) {
					assertEquals(State.OPEN,square1[i][j].getState());
				}
			}
	}
			
		
	

	
	/**
	 * GIVEN un tablero con alguna bandera
	 * WHEN se pasa el método unveil
	 * THEN devuelve el tablero desmarcado
	 */
	@Test
	public void testUnveilBoardWithSomeFlags() {
		for (int i=0; i<square2.length; i++) {
			for(int j=0; j<square2[i].length; j++) {
				square2[i][j] = new Square(State.CLOSED,Square.EMPTY_SQUARE);
			}
		}
			square2[1][1] = new Square(State.FLAGGED, Square.EMPTY_SQUARE);
			square2[2][1] = new Square(State.FLAGGED, Square.EMPTY_SQUARE);
			bd2 = new Board(2,square2);
			bd2.unveil();
			for (int i=0; i<square2.length; i++) {
				for(int j=0; j<square2[i].length; j++) {
					assertEquals(State.OPEN,square2[i][j].getState());
				}
			}
	}
	
	/**
	 * GIVEN un tablero con alguna bandera ya descubierta
	 * WHEN se pasa el método unveil
	 * THEN devuelve el tablero desmarcado
	 */
	@Test
	public void testUnveilUncoveredBoardWithFlags() {
		for (int i=0; i<square3.length; i++) {
			for(int j=0; j<square3[i].length; j++) {
				square3[i][j] = new Square(State.CLOSED,Square.EMPTY_SQUARE);
			}
		}
			square3[1][1] = new Square(State.OPEN, Square.EMPTY_SQUARE);
			square3[2][1] = new Square(State.OPEN, Square.EMPTY_SQUARE);
			bd3 = new Board(2,square3);
			bd3.unveil();
			for (int i=0; i<square3.length; i++) {
				for(int j=0; j<square3[i].length; j++) {
					assertEquals(State.OPEN,square3[i][j].getState());
				}
			}
	}
}
