package uo.mp.s1.game.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class GameWithoutParamsTest {

	@Test
	public void testGameWithOutParams() {
	//caso 1 con un tablero normal
			Game2048 game1= new Game2048();
			assertEquals(3,game1.getBoard().length);
			assertEquals(3,game1.getBoard()[0].length);
	}
}
		