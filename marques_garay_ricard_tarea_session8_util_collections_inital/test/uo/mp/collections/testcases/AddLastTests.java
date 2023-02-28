package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class AddLastTests {
	
	private List list;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}
	
	/**
	 * GIVEN Una lista vacia
	 * WHEN  se a�ade un objeto en la posicion 0
	 * THEN  se a�ade correctamente este objeto
	 */
	@Test
	public void testEmptyList() {
		String str = "Hola";
		list.add(0,str);
		assertEquals(1,list.size());
		assertTrue(str.equals(list.get(0)));
	}
	
	/**
	 * GIVEN Una lista con un objeto
	 * WHEN  se a�ade un objeto en la posicion 0
	 * THEN  se a�ade correctamente este objeto
	 */
	@Test
	public void testZeroPos() {
		String str = "Hola";
		Integer number = 5;
		
		list.add(0,str);
		list.add(0,number);
		
		assertEquals(2,list.size());
		assertTrue(number.equals(list.get(0)));
		assertTrue(str.equals(list.get(1)));
	}
	
	/**
	 * GIVEN Una lista con varios objetod
	 * WHEN  se a�ade un objeto en una posicion intermedia
	 * THEN  se a�ade correctamente este objeto moviendo los
	 * 		 objetos siguientes a la derecha
	 */
	@Test
	public void testMiddlePos() {
		String str = "Hola";
		Integer number = 5;
		Integer x = 10;
		
		list.add(str);
		list.add(number);
		list.add(1,x);
		
		assertEquals(3,list.size());
		assertTrue(number.equals(list.get(0)));
		assertTrue(x.equals(list.get(1)));
		assertTrue(str.equals(list.get(2)));
	}
	
	/**
	 * GIVEN Una lista con objetos
	 * WHEN  se a�ade un objeto en la �ltima posici�n
	 * THEN  se a�ade este objeto al final de la lista
	 */
	@Test
	public void testAddLastPos() {
		String str = "Hola";
		Integer number = 13;
		Integer x = 5;
		
		list.add(0,str);
		list.add(1,number);
		list.add(1,x);
		
		assertEquals(3,list.size());
		assertTrue(str.equals(list.get(0)));
		assertTrue(x.equals(list.get(1)));
		assertTrue(number.equals(list.get(2)));
	}
	
	/**
	 * GIVEN Una lista con objetos
	 * WHEN  se a�ade un objeto en la �ltima posici�n
	 * THEN  se a�ade este objeto al final de la lista
	 */
	@Test
	public void testAddAfterLastPos() {
		String str = "Hola";
		Integer number = 13;
		
		list.add(0,str);
		list.add(1,number);
		
		assertEquals(2,list.size());
		assertTrue(str.equals(list.get(0)));
		assertTrue(number.equals(list.get(1)));
	}
	
	/**
	 * GIVEN Una lista con objetos
	 * WHEN  se a�ade un objeto en una posicion negativa
	 * THEN  se a�ade este objeto al final de la lista
	 */
	@Test
	public void testAddNegativePos() {
		String str = "Hola";
		Integer number = 13;
		
		list.add(0,str);
		try {
		list.add(-1,number);
		fail("Deber�a haber saltado una excepci�n");
		}catch(IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		assertEquals(2,list.size());
		assertTrue(str.equals(list.get(0)));
	}
	
	/**
	 * Caso 7
	 * GIVEN posici�n > size()
	 * WHEN se invoca al m�todo
	 * THEN se lanza una excepci�n del tipo IndexOutOfBoundsException
	 */
	@Test
	public void testPositionAboveSize() {
		try {
			list.add(list.size() + 1, "A");
			fail("Deber�a haber saltado una excepci�n");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Indice fuera de l�mites");
		}
	}
	
	/**
	 * Caso 8
	 * GIVEN null como par�metro
	 * WHEN se invoca al m�todo
	 * THEN se lanza una excepci�n del tipo  IllegalArgumentException
	 */
	@Test
	public void testNull() {
		try {
			list.add(null);
			fail("Deber�a haber saltado una excepci�n");
		} catch (IllegalArgumentException e) {
			System.out.println("Null como par�metro");
		}
	}
	

}
