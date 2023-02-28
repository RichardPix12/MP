package uo.mp.s1.game.model;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;


public class GameCompactLeftTest {
	/**
	 * Test para comprobar el funcionamiento del método que hace que los números
	 * se desplacen hacia la izquierda.
	 */
	@Test
	public void testCompactLeft() {
		//Caso 1:Números a la derecha y a la izquierda ceros.
		Game2048 game1=new Game2048(); 
		game1.setBoard(GameCodeForTest.SEMIFULL13);
		game1.compactLeft();
		assertArrayEquals(GameCodeForTest.SEMIFULL1_LEFTCOMPACTED,game1.getBoard());
		
		//Caso 2:Números a la izquierda.
		Game2048 game2=new Game2048(); 
		game2.setBoard(GameCodeForTest.SEMIFULL12);
		game2.compactLeft();
		assertArrayEquals(GameCodeForTest.SEMIFULL12,game2.getBoard());
		
		//Caso 3:Números en el centro y a la izquierda ceros.
		Game2048 game3=new Game2048(); 
		game3.setBoard(GameCodeForTest.SEMIFULL11);
		game3.compactLeft();
		assertArrayEquals(GameCodeForTest.SEMIFULL1_LEFTCOMPACTED,game3.getBoard());
		
		//Caso 4:Números en cualquier sitio y a la izquierda números.
		int[][] matrix4a={{2,0,2},{4,4,0},{0,8,8}};
		int[][] matrix4b={{2,2,0},{4,4,0},{8,8,0}};
		Game2048 game4=new Game2048(); 
		game4.setBoard(matrix4a);
		game4.compactLeft();
		assertArrayEquals(matrix4b,game4.getBoard());
	}
	
}
