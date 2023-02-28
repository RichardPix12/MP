package uo.mp.s1.game.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameWithParamsTest {
	
	@Test
	public void testWithParams() {
	//Caso 1:Creamos un tablero con dimensi�n dentro de los l�mites.
	Game2048 game1=new Game2048(3);
	assertEquals(3,game1.getBoard().length);
	assertEquals(3,game1.getBoard()[0].length);
	
	//Caso 2:Creamos un tablero con dimensi�n superior al l�mite superior.
	Game2048 game2=new Game2048(12);
	assertEquals(3,game2.getBoard().length);
	assertEquals(3,game2.getBoard()[0].length);
	
	//Caso 3:Creamos un tablero con dimensi�n inferior al l�mite inferior.
	Game2048 game3=new Game2048(0);
	assertEquals(3,game3.getBoard().length);
	assertEquals(3,game3.getBoard()[0].length);
	}
	

}
