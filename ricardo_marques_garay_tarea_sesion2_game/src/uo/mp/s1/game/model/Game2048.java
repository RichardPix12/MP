package uo.mp.s1.game.model;

import java.util.Random;

/**
 * <p>
 * Título: Clase Game2048
 * </p>
 * <p>
 * Descripción: A partir de un array bidimensional de números y a través de
 * diferentes operaciones se simula un juego llamado "2048"
 * </p>
 * <p>
 * Copyright: Copyright (c) 2020
 * </p>
 * <p>
 * Empresa: Escuela de Ingeniería Informática - Uiversidad de Oviedo
 * </p>
 * 
 * @author Ricardo Marqués Garay
 * @version 2.0
 */
public class Game2048 {
	
	//Constantes de la clase
	public static final int DIMENSIONS = 3;
	public static final int RESTART = 0;
	public static final int COMPLETE = 9;
	public static final int EMPTY = 0;
	//Atributos de la clase
	private int [][] board;
			
	

	/**
	 * Constructor sin parámetros con tablero por defecto de 3*3 Inicialmente todas
	 * las posiciones con valor 0
	 */
	public Game2048() {
			board = new int[DIMENSIONS][DIMENSIONS];
			
			print();
	}

	/**
	 * 
	 * @param número de filas y de columnas (matriz cuadrada)
	 *  entre minimo y máximo
	 */
	public Game2048(int dimension) {
		this();
		if(dimension >=1 && dimension <=3)
		    board = new int[dimension][dimension];
	}

	/**
	 * Devuelve una copia de la matriz para poder usarla en las pruebas
	 * @return
	 */
	protected int[][] getBoard() {
		int [][]aux = board;
		return aux;
		
	}
	
	
	/**
	 * Reinicia todas las posiciones a 0 y llama a next para que incluya un
	 * 2 en una posición aleatoria
	 */
	public void restart() {
		for (int i=0;i<board.length;i++) {
			for(int j=0; j<board[i].length;j++) {
				board[i][j]=0;
				
			}
		}
		next();
	}	
	/**
	 * Añade un nuevo número 2 en posición aleatoria vacía (valor 0)
	 * y pinta el tablero
	 * 
	 */
	public void next() {
		Random r=new Random();		
		
		int i = r.nextInt(board.length);
		int j = r.nextInt(board.length);
		while(board[i][j] != 0) {
			i = r.nextInt(board.length);
			j = r.nextInt(board.length);
		}
		if(board[i][j]== 0){
			board[i][j]=2;
		}
	}
	
	/**
	 * Comprueba si el tablero está lleno. Esto ocurre cuando todas las celdas o
	 * posiciones del tablero tienen un número distinto de cero
	 * 
	 * @return true si el tablero está lleno
	 */
	public boolean isBoardFull() {
		for (int i=0;i<board.length;i++) {
			for(int j=0; j<board[i].length;j++) {
				if(board[i][j]==EMPTY) {
					return false;}
				
				}
		}
		return true;
	}
					
				
	

	/**
	 * Compacta el tablero a la derecha compactando todas las filas
	 */
	public void compactRight() {
			int valor=0;
			for(int i=0; i<getBoard().length;i++)
				for(int j=0;j<getBoard()[i].length;j++)
					if(board[i][getBoard()[i].length-1-j]!=0){
						valor=board[i][getBoard()[i].length-1-j];
						board[i][getBoard()[i].length-1-j]=0;
						for(int jb=0;jb<getBoard()[i].length;jb++)
							if(board[i][getBoard()[i].length-1-jb]==0){
								board[i][getBoard()[i].length-1-jb]=valor;
								break;
							}	
					}
			print();
		}
	


	/**
	 * Compacta el tablero a la derecha compactando todas las filas
	 */
	public void compactLeft() {
		int valor=0;
		for(int i=0; i<getBoard().length;i++)
			for(int j=0;j<getBoard()[i].length;j++)
				if(board[i][j]!=0){
					valor=board[i][j];
					board[i][j]=0;
					for(int jb=0;jb<getBoard()[i].length;jb++)
						if(board[i][jb]==0){
							board[i][jb]=valor;
							break;
						}	
				}
		print();
	}
	
	/**
	 * compacta toda la matriz hacia arriba
	 */
	public void compactUp() {
		int valor=0;
		for(int i=0; i<getBoard().length;i++)
			for(int j=0;j<getBoard()[i].length;j++)
				if(board[i][j]!=0){
					valor=board[i][j];
					board[i][j]=0;
					for(int ib=0;ib<getBoard().length;ib++)
						if(board[ib][j]==0){
							board[ib][j]=valor;
							break;
						}
				}
		print();
	}
	
	/**
	 * compacta toda la matriz hacia abajo
	 */
	public void compactDown() {
		int valor=0;
		for(int i=0; i<getBoard().length;i++)
			for(int j=0;j<getBoard()[i].length;j++)
				if(board[getBoard().length-1-i][j]!=0){
					valor=board[getBoard().length-1-i][j];
					board[getBoard().length-1-i][j]=0;
					for(int ib=0;ib<getBoard().length;ib++)
						if(board[getBoard().length-1-ib][j]==0){
							board[getBoard().length-1-ib][j]=valor;
							break;
						}
				}
		print();
		
	}
	
	/**
	 * Inicializa el tablero con la matriz pasada como parámetro
	 */
	protected void setBoard(int[][] matrix) {
		this.board=matrix;
		
	}
	/**
	 * Metodo que muestra el tablero por pantalla
	 */
	public void print() {
		for(int i=0;i<board.length;i++)
        {
            for(int j=0;j < board[i].length; j++)
                if(j<(board[i].length-1))
                   System.out.print(String.format("%1d"+" ",board[i][j]));
                else if(j==board[i].length-1)  
                        System.out.println(board[i][j]+" ");
        }     
		
	}
	
	/** Método que compacta a la derecha los números de cada fila 
	 * y a continuación suma de dos en dos los números consecutivos iguales dejando el resultado en la casilla derecha,
	 *  repitiendo el proceso mientras sea posible
	 * 
	 */
//	public void moveRight() {
//		compactRight();
//		for(int i=0;i<board.length;i++) {
//			for(int j= board[i].length;j<EMPTY;j--) {
//				if(board[i][j]!=0 ) { 
//					for(int k= board[i].length;j<EMPTY;j--)
//				}
//	}
//	}
//	
	
}
