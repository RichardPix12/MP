package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class RemoveObjectTests {
	
	private List list;
	private Object a;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
		a = new Object();
	}
	
	/**
	 * Given: una lista con un elemento
	 * When: elimina el objeto
	 * Then: devuelve true
	 */
	@Test
	public void test() {
		list.add(a);
		list.remove(a);
		assertTrue( list.size() == 0 );
		assertTrue(list.remove(a));
	}
	
	/**
	 * Given: una lista con varios elementos
	 * When: elimina el objeto
	 * Then: devuelve true
	 */
	@Test
	public void test2() {
		list.add(a);
		list.remove(a);
		assertTrue(list.remove(a));
		assertFalse(list.contains(a));
	}
	
	/**
	 * Given: una lista vacia
	 * When: elimina un objeto que no esta dentro
	 * Then: devuelve false
	 */
	@Test
	public void test3() {
		assertTrue( list.size() == 0 );
		list.remove(a);
		assertFalse(list.remove(a));
	}
	
	/**
	 * Given: una lista con varios elementos
	 * When: elimina un objeto que no esta dentro
	 * Then: devuelve false
	 */
	@Test
	public void test4() {
		int b=list.size();
		list.remove(a);
		assertFalse(list.remove(a));
		assertEquals(b,list.size());
	}
	
	/**
	 * Given: una lista con varios elementos repetidos
	 * When: elimina un objeto 
	 * Then: devuelve true
	 */
	@Test
	public void test5() {
		assertTrue(list.size()>0);
		list.add(a);list.add(a);list.add(a);
		int b=list.size();
		list.remove(a);
		assertTrue(list.remove(a));
		assertEquals(b-1,list.size());
	}
	
	/**
	 * Given: una lista con varios elementos
	 * When: elimina un objeto null
	 * Then: devuelve una excepcion
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void test6() {
		assertTrue(list.size()>0);
		list.remove(null);
	}
	

}
