package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.collections.impl.LinkedList;
import uo.mp.collections.setting.Settings;

public class HashCodeTests {
	
	private List list;
	@SuppressWarnings("unused")
	private List other;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
		other = Settings.factory.newList();
	}

	/**
	 * GIVEN Dos listas vacías de tipo ArrayList son iguales
	 * WHEN se ejecuta el método
	 * THEN devuelve true
	 */
	@Test
	public void EmptyArrayListTest() {
		List l2 = new ArrayList();
		assertTrue(list.equals(l2));
	}

	/**
	 * GIVEN Dos listas vacías de tipo LinkedList son iguales
	 * WHEN se ejecuta el método
	 * THEN devuelve true
	 */
	@Test
	public void EmptyLinkedListTest() {
		List l2 = new LinkedList();
		assertTrue(list.equals(l2));
	}
	
	/**
	 * GIVEN Dos listas vacías una de tipo ArrayList y otra de tipo LinekList son iguales
	 * WHEN se ejecuta el método
	 * THEN devuelve true
	 */
	@Test
	public void EmptyBothListTest() {
		List l2 = new LinkedList();
		assertTrue(list.equals(l2));
	}
	
	/**
	 * GIVEN Dos lista de tipo ArrayList con los mismos elementos en la misma posición son iguales
	 * WHEN se ejecuta el método
	 * THEN devuelve true
	 */
	@Test
	public void EmptyArrayListWithElementsTest() {
		List l2 = new ArrayList();
		list.add("A");
		l2.add("A");
		assertTrue(list.equals(l2));
	}

	/**
	 * GIVEN Dos lista de tipo LinkedList con los mismos elementos en la misma posición son iguales
	 * WHEN se ejecuta el método
	 * THEN devuelve true
	 */
	@Test
	public void EmptyLinkedListWithElementsTest() {
		List l2 = new LinkedList();
		list.add("A");
		l2.add("A");
		assertTrue(list.equals(l2));
	}
	
	/**
	 * GIVEN Dos listas de ambos tipos con los mismsos elementos en la misa posición son iguales
	 * WHEN se ejecuta el método
	 * THEN devuelve true
	 */
	@Test
	public void EmptyBothListWithElementsTest() {
		List l2 = new LinkedList();
		list.add("A");
		l2.add("A");
		assertTrue(list.equals(l2));
	}
	
	/**
	 * GIVEN un objeto ArrayList
	 * WHEN se llama al método con elementos iguales en distintas posiciones
	 * THEN devuelve false
	 */
	@Test
	public void twoArrayListInDiferentPositions() {
		List l1 = new ArrayList();
		List l2 = new ArrayList();
		l1.add("A");l1.add("B");l1.add("C");
		l2.add("B");l2.add("C");l2.add("A");
		assertEquals(false, l1.equals(l2));
		
	}
	
	/**
	 * GIVEN un objeto LinkedList
	 * WHEN se llama al método con elementos iguales en distintas posiciones
	 * THEN devuelve false
	 */
	@Test
	public void twoLinkedListInDiferentPositions() {
		List l1 = new LinkedList();
		List l2 = new LinkedList();
		l1.add("A");l1.add("B");l1.add("C");
		l2.add("B");l2.add("C");l2.add("A");
		assertEquals(false, l1.equals(l2));
		
	}
	
	/**
	 * GIVEN un objeto LinkedList y uno ArrayList
	 * WHEN se llama al método con elementos iguales en distintas posiciones
	 * THEN devuelve false
	 */
	@Test
	public void twoListInDiferentPositions() {
		List l1 = new LinkedList();
		List l2 = new ArrayList();
		l1.add("A");l1.add("B");l1.add("C");
		l2.add("B");l2.add("C");l2.add("A");
		assertEquals(false, l1.equals(l2));
		
	}
	
	/**
	 * GIVEN un objeto ArrayList
	 * WHEN se llama al método con elementos diferentes
	 * THEN devuelve false
	 */
	@Test
	public void twoArrayListWithDiferentElements() {
		List l1 = new ArrayList();
		List l2 = new ArrayList();
		l1.add("A");l1.add("B");l1.add("C");
		l2.add("D");l2.add("E");l2.add("F");
		assertEquals(false, l1.equals(l2));
		
	}
	
	/**
	 * GIVEN un objeto ArrayList y otro LinkedList
	 * WHEN se llama al método con elementos diferentes
	 * THEN devuelve false
	 */
	@Test
	public void twoLinkedListWithDiferentElements() {
		List l1 = new LinkedList();
		List l2 = new LinkedList();
		l1.add("A");l1.add("B");l1.add("C");
		l2.add("D");l2.add("E");l2.add("F");
		assertEquals(false, l1.equals(l2));
		
	}

	/**
	 * GIVEN un objeto ArrayList y otro LinkedList
	 * WHEN se llama al método con elementos diferentes
	 * THEN devuelve false
	 */
	@Test
	public void twoListtWithDiferentElements() {
		List l1 = new ArrayList();
		List l2 = new LinkedList();
		l1.add("A");l1.add("B");l1.add("C");
		l2.add("D");l2.add("E");l2.add("F");
		assertEquals(false, l1.equals(l2));
	}

}
