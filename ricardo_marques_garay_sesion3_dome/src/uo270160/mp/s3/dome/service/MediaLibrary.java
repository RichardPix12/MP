package uo270160.mp.s3.dome.service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo270160.mp.s3.dome.model.Item;

/**
 * @author UO270160
 *
 */

public class MediaLibrary {

	private List<Item> items;

	public MediaLibrary() {
		items = new ArrayList<Item>();
	}

	/**
	 * @param theItem de tipo Item
	 */
	public void add(Item theItem) {
		checkParameter(theItem == null, "Item no válido, se esperaba Item y " + "apareció Null");

		items.add(theItem);
	}

	/** Metodo que calcula el numero de items que tienen dueño
	 * @return numero de elementos con propietario
	 */
	public int numberOfItemsOwned() {
		int contador = 0;
		for (Item it : items) {
			if (it.getOwn() == true) {
				contador++;

			}
		}
		return contador;

	}
	
	public void list(PrintStream out) {
		for (Item it : items) {
			it.print(out);
		}
	}

	protected void checkParameter(boolean condition, String str) {
		if (condition) {
			throw new IllegalArgumentException(str);
		}

	}

	
}
