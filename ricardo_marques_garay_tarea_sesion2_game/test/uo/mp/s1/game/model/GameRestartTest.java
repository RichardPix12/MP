package uo.mp.s1.game.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameRestartTest {
	/**
	 * Test para comprobar el funcionamiento del método que pone todo el tablero
	 * con ceros excepto una casilla que la pone con un 2. 
	 */
	@Test
	public void testRestart() {
		//Caso 1:Creas un tablero.
		Game2048 game1=new Game2048();
		game1.setBoard(GameCodeForTest.FULL);
		game1.restart();
		int contador0=0;
		int contador2=0;
		for(int i=0;i<game1.getBoard().length;i++){
			for(int j=0;j<game1.getBoard()[i].length;j++) {
				if(game1.getBoard()[i][j]==0)
					contador0++;
		        if(game1.getBoard()[i][j]==2)
		        	contador2++;
			}
		}
		assertEquals(1,contador2);
		assertEquals((game1.getBoard().length*game1.getBoard().length)-1,contador0);	
	}
	

}
