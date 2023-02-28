package uo.mp.collections.testcases;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class ContainsTests {
	
	private List list;
	private int n1;
	private int n2;
	private int n3;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
		n1=55;
		n2=10;
		n3=20;
		
	}

	/**
	 * Given: una lista vacia
	 * When: se invoca contains
	 * Then: devuelve false
	 */
	@Test
	public void testContainsWithEmptyList() {
		assertTrue(list.isEmpty());
		assertTrue(!list.contains(n2));
	}
	
	/**
	 * Given: una lista con varios elementos
	 * When: se invoca contains con un elemento que no esta en la lista
	 * Then: devuelve false
	 */
	@Test
	public void testContainsWithoutElement() {
		list.add(n1);
		list.add(n3);
		assertTrue(!list.contains(n2));
	}
	
	/**
	 * Given:una lista con un elemento
	 * When:se invoca contains y contiene el elemento
	 * Then: devuelve true
	 */
	@Test
	public void testContainsWithElementContained() {
		list.add(n1);
		assertTrue(list.contains(n1));
	}
	
	/**
	 * Given: una lista con varios elementos
	 * When: se invoca contains y contiene al elemento
	 * Then: devuelve true
	 */
	@Test
	public void testContainsWithElementsContained() {
		list.add(n1);
		list.add(n2);
		assertTrue(list.contains(n1));
	}
	
	/**
	 * Given: una lista vacia
	 * When: se invoca contains y no contiene null
	 * Then: devuelve false
	 */
	@Test
	public void testContainsWithoutNullContained() {
		assertTrue(list.isEmpty());
		assertTrue(!list.contains(null));
	}
	
	/**
	 * Given: una lista con elementos
	 * When: se invoca contains y no contiene null
	 * Then: devuelve false
	 */
	@Test
	public void testContainsWithElementsAndNullContained() {
		list.add(n1);
		list.add(n2);
		assertTrue(list.contains(n1));
		assertTrue(list.contains(n2));
		assertTrue(!list.contains(null));
	}

}
