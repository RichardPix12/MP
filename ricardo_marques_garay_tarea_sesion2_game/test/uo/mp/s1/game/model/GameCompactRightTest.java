package uo.mp.s1.game.model;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class GameCompactRightTest {
	/**
	 * Test para comprobar el funcionamiento del método que hace que los números
	 * se desplacen hacia la derecha.
	 */
	@Test
	public void testCompactRigth() {
		//Caso 1:Números a la izquierda y a la derecha ceros.
		Game2048 game1=new Game2048(); 
		game1.setBoard(GameCodeForTest.SEMIFULL12);
		game1.compactRight();
		assertArrayEquals(GameCodeForTest.SEMIFULL1_RIGHTCOMPACTED,game1.getBoard());
		
		//Caso 2:Números a la derecha.
		Game2048 game2=new Game2048(); 
		game2.setBoard(GameCodeForTest.SEMIFULL13);
		game2.compactRight();
		assertArrayEquals(GameCodeForTest.SEMIFULL13,game2.getBoard());
		
		//Caso 3:Números en el centro y a la derecha ceros.
		Game2048 game3=new Game2048(); 
		game3.setBoard(GameCodeForTest.SEMIFULL11);
		game3.compactRight();
		assertArrayEquals(GameCodeForTest.SEMIFULL1_RIGHTCOMPACTED,game3.getBoard());
		
		//Caso 4:Números en cualquier sitio y a la derecha números.
		int[][] matrix4a={{2,0,2},{4,4,0},{0,8,8}};
		int[][] matrix4b={{0,2,2},{0,4,4},{0,8,8}};
		Game2048 game4=new Game2048(); 
		game4.setBoard(matrix4a);
		game4.compactRight();
		assertArrayEquals(matrix4b,game4.getBoard());
	}
}
