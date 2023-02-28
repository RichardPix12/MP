package uo.mp.collections.testcases;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class IsEmptyTests {
	
	private List list;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}

	/**
	 * GIVEN: lista nueva
	 * WHEN: se llama a isEmpty()
	 * THEN: devuelve true
	 */
	@Test
	public void testNewEmptyList() {
		assertTrue(list.isEmpty());
	}

	/**
	 * GIVEN: lista con un elemento
	 * WHEN: se llama a clear()
	 * THEN: queda vacía e isEmpty() devuelve true
	 */
	@Test
	public void testClearList() {
		list.add(new Integer(2));
		assertFalse(list.isEmpty());
		list.clear();
		assertTrue(list.isEmpty());
	}
	
	/**
	 * GIVEN: lista con un elemento
	 * WHEN: se llama isEmpty()
	 * THEN: devuelve false
	 */
	@Test
	public void testOneElementList() {
		list.add(new Integer(2));
		assertFalse(list.isEmpty());
	}
	
	/**
	 * GIVEN: lista con varios elementos
	 * WHEN: se llama a isEmpty()
	 * THEN: devuelve false
	 */
	@Test
	public void testMoreElementsList() {
		list.add(new Integer(2));
		list.add(new Integer(3));
		list.add(new Integer(4));
		assertFalse(list.isEmpty());
	}
}