package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class SetTests {
	
	private List list;
	private Object element;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
		element=2;
	}
	
	/**
	 * GIVEN una lista con un elemento
	 * THEN cambiamos el valor del elemento
	 * WHEN devuelve el elemento
	 */
	@Test
	(expected=IndexOutOfBoundsException.class)
	public void testPos0() {
		list.add(1);
		assertEquals(element,list.set(0, element));
		
	}
	/**
	 * GIVEN una lista con varios elementos
	 * THEN cambiamos el valor de una posicion n
	 * WHEN devuelve el elemento
	 */
	@Test
	public void testPosN() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		list.set(3, element);
		
		assertEquals(element,list.set(3, element));
	}
	/**
	 * GIVEN una lista vacia
	 * THEN cambiamos el valor de la posicion 0
	 * WHEN devuelve IndexOutOfBoundsException
	 */
	@Test
	(expected=IndexOutOfBoundsException.class)
	public void testEmptyList() {
		list.set(0,element);
		
	}
	/**
	 * GIVEN una lista vacia
	 * THEN cambiamos el valor de la posicion -1
	 * WHEN devuelve IndexOutOfBoundsException
	 */
	@Test
	(expected=IndexOutOfBoundsException.class)
	public void testPosNegative() {
		list.set(-1,element);
		
	}
	/**
	 * GIVEN una lista vacia
	 * THEN cambiamos el valor de la posicion size()
	 * WHEN devuelve IndexOutOfBoundsException
	 */
	@Test
	(expected=IndexOutOfBoundsException.class)
	public void testEmptySize() {
		list.set(list.size(),element);
		
	}
	
	/**
	 * GIVEN una lista no vacia
	 * THEN cambiamos el valor de la posicion -1
	 * WHEN devuelve IndexOutOfBoundsException
	 */
	@Test
	(expected=IndexOutOfBoundsException.class)
	public void testPosNegativeWithElements() {
		list.add(1);
		list.add(2);
		list.add(3);
		
		list.set(-1,element);
		
	}
	/**
	 * GIVEN una lista no vacia
	 * THEN cambiamos el valor de la posicion size()
	 * WHEN devuelve IndexOutOfBoundsException
	 */
	@Test
	(expected=IndexOutOfBoundsException.class)
	public void testEmptySizeWithElements() {
		list.add(1);
		list.add(2);
		list.add(3);
		
		list.set(list.size(),element);
		
	}

}
