package uo.mp.newsstand.ui;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.NewsPaper;
import uo.mp.newsstand.domain.Publication;
import uo.mp.util.Console;

/**
 * Asks the user all the data for a new publication.
 * 
 */
public class PublicationForm {

	/**
	 * @return The new Publication object created. It will be be of any 
	 * of the child types of Publication.
	 */
	public Publication askForPublication() {
		String type = Console.readString("Type of publication? (n | m)");
		type = type.toLowerCase();
		switch (type) {
			case "n": return askForNewsPaper();
			case "m": return askForMagazine();
			default:  return null;
		}

	}

	private Publication askForMagazine() {
		String name = Console.readString("name?");
		int stock = Console.readInteger("stock?");
		int sales = Console.readInteger("sales?");
		int regularity = Console.readInteger("regularity?");

		return new Magazine(name, stock, sales, regularity);
	}

	private Publication askForNewsPaper() {
		String name = Console.readString("name?");
		int stock = Console.readInteger("stock?");
		int sales = Console.readInteger("sales?");

		return new NewsPaper(name, stock, sales);
	}

}
