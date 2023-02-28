package uo.mp.s1.game.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameNextTest {
	/**
	 * Test para comprobar el funcionamiento del método que añade un número 2 
	 * en una posición aleatoria con valor 0.
	 */
	@Test
	public void testNext() {
		//Caso 1:Hay huecos posibles.
		Game2048 game1=new Game2048(); 
		int[][] matrix={{0,0,0},{0,0,0},{0,0,0}};
		game1.setBoard(matrix);
		int contadorDeCeros1=0;
		int contadorDeCeros2=0;
		for(int i=0;i<game1.getBoard().length;i++)
			for(int j=0;j<game1.getBoard()[i].length;j++)
				if(game1.getBoard()[i][j]==0)
					contadorDeCeros1=contadorDeCeros1+1;
		game1.next();
		for(int i=0;i<game1.getBoard().length;i++)
			for(int j=0;j<game1.getBoard()[i].length;j++)
				if(game1.getBoard()[i][j]==0)
					contadorDeCeros2=contadorDeCeros2+1;
		assertEquals(contadorDeCeros1-1,contadorDeCeros2);		
	}
	
}
