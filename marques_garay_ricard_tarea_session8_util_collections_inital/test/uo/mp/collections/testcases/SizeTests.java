package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class SizeTests {
	
	private List list;
	
	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}
	
	/**
	 * GIVEN un lista vacia de tamaño 0
	 * WHEN utilizamos el metodo sieze
	 * THEN devuelve 0
	 */	
	@Test
	public void testSize0() {
	
		assertEquals(0,list.size());
	}
	
	/**
	 * 
	 * GIVEN un lista con elemento de tamaño 1
	 * WHEN utilizamos el metodo sieze
	 * THEN devuelve 1
	 */	
	@Test
	public void testSizeOneAndElement() {
		Object ob1 = new String("1");
		list.add(ob1);
		assertEquals(1,list.size());
	}
	
	/**
	 * GIVEN un lista con varios elementos
	 * WHEN utilizamos el metodo sieze
	 * THEN devuelve el tamaño correcto
	 */	
	@Test
	public void testSizeAndElement() {
		Object ob1 = new String("1");
		Object ob2 = new String("2");
		Object ob3 = new String("3");
		list.add(ob1);
		list.add(ob2);
		list.add(ob3);
		assertEquals(3,list.size());
	}
	 
	/**
	 * 
	 * GIVEN un lista con elementos
	 * WHEN utilizamos el metodo size despues de añadir un elemento
	 * THEN devuelve 1, de la resta, entre el tamaño final menos el de antes de añadir
	 */	
	@Test
	public void testSizeAdd() {
		int parte1 = list.size();
		Object ob1 = new String("1");
		list.add(ob1);
		int parte2 = list.size();
		assertEquals(1,(parte2 - parte1));
	}
	
	/**
	 * 
	 * GIVEN un lista con elementos
	 * WHEN utilizamos el metodo size despues de borrar un elemento
	 * THEN devuelve 1 de la resta entre el tamaño inicial menos el final
	 */	
	@Test
	public void testSizeRemove() {
		
		Object ob1 = new String("1");
		list.add(ob1);
		int parte1 = list.size();
		list.remove(0);
		int parte2 = list.size();
		assertEquals(1,(parte1-parte2));
	}

}
