package uo.mp.s3.dome.service.medialibrary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo270160.mp.s3.dome.model.Cd;
import uo270160.mp.s3.dome.service.MediaLibrary;

public class NumberOfItemsOwned {

	private Cd cd1;
	private Cd cd2;
	@Before
	public void setUp() {
		cd1 = new Cd("Canguro","Wos",9,50);
		cd2 = new Cd("Primavera", "Vivaldi",4,40);
	}
	
	//caso1: coleccion vacia
	//caso2: coleccion con todos los elementos con propietario
	//caso3: colecccion con todos los elementos no en propiedad
	
	/**
	 * GIVEN un medialibrary vacio
	 * WHEN buscamos el numero de items con dueño
	 * THEN nos devuelve 0
	 */
	@Test
	public void testEmpty() {
		MediaLibrary ml = new MediaLibrary();
		assertEquals(0,ml.numberOfItemsOwned());
	}

}
