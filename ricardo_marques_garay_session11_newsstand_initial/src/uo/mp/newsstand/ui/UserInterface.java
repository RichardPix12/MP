package uo.mp.newsstand.ui;



import java.io.FileNotFoundException;

import uo.mp.collections.List;
import uo.mp.exceptions.newsstand.AlreadyExistException;
import uo.mp.exceptions.newsstand.NewStandException;
import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.service.NewsStand;
import uo.mp.sort.Collections;
import uo.mp.util.Console;
import uo.mp.util.Logger;
import uo.mp.util.comparators.BySoldComparator;
import uo.mp.util.exceptions.DoesNoExistException;
import uo.mp.util.exceptions.InvalidFileNameException;

/**
 * It is in charge of interacting with the user:
 * 	- Shows the menu of options
 *  - Process the option chosen by the user
 *  	- For that it asks the user the necessary data to fulfill the request
 *  	- Shows the result of the request
 *  - In case of error shows an explaining message
 *  
 *  Note: This is the unique class allowed to show information to the user
 */
public class UserInterface {
	private static final int EXIT = 0;

	private Menu menu = new Menu();
	private NewsStand newsStand = new NewsStand();
	
	public void show()  {
		int option = EXIT;
		do {
			menu.show();
			option = menu.readOption();
			try {
				processOption(option);
			} catch (RuntimeException e) {
				handleFatalEror(e);
				return;
			} catch (Exception e) {
				handleUserEror(e);
			}
		} while (option != EXIT);
	}

	private void handleUserEror(Exception e) {
		String msg ="Ha ocurrido un error al ejecutar la opción\n";
		msg+= e.getMessage();
		msg+= "Por favor, intente corregirlo y vuelva a intentarlo";
		Console.println(msg);
		
	}

	private void handleFatalEror(RuntimeException e) {		
		String msg ="Ha ocurrido un error al ejecutar la opción, que"
				+ " impide seguir ejecutandola\n";
		msg+= e.getMessage();
		msg+= "Por favor, contacte con el técnico";
		Console.println(msg);
		Logger.log(e);
	}

	private void processOption(int option) throws NewStandException, FileNotFoundException {
		switch( option ) {
			case EXIT: return;
			case 1: loadFile(); break;
			case 2: showPublications(); break;				
			case 3: addPublication(); break;
			case 4: removePublication(); break;				
			case 5: createOrders(); break; 				
			case 6: saveOrdersToFile(); break;
			case 7: importFromZip(); break;
			case 8: exportToZip(); break;
			case 9: sortByName(); break;
			case 10: sortBySold(); break;
		}
	}

	private void sortBySold() {
		List<Publication> publications = newsStand.getPublications();
		Collections.sort(publications, new BySoldComparator);
		listPublications(publications);
		
	}

	private void sortByName() {
		List <Publication> publications = newsStand.getPublications();
		Collections.sort(publications);
		listPublications(publications);
	}

	private void loadFile() throws AlreadyExistException, InvalidFileNameException, FileNotFoundException {
		String fileName = Console.readString("File name?");
		newsStand.loadFile( fileName );
	}
	
	private void addPublication() throws AlreadyExistException {
		Publication p = new PublicationForm().askForPublication();
		newsStand.addPublication( p );
	}

	private void removePublication() throws DoesNoExistException {
		String name = Console.readString("publication name?");
		newsStand.removePublication( name );
	}
	
	private void showPublications() {
		List<Publication> publications = newsStand.getPublications();
		listPublications( publications );
	}

	private void createOrders() {
		
		newsStand.createOrders();
	}

	private void listPublications(List<Publication> publications) {
		Console.println("\nList of publications");
		Console.println("------------------");
		for (Publication p: publications) {
			System.out.println( p );
		}
	
		Console.println("------------------");
   }	
	
	private void saveOrdersToFile() {
		String fileName = Console.readString("output file name?");
		newsStand.saveOrdersToFile( fileName );
	}
	
	private void importFromZip() throws InvalidFileNameException, FileNotFoundException {
		String fileName = Console.readString("input zip file name?");
		newsStand.importPublicationsFromZipFile( fileName );
	}
	
	private void exportToZip() {
		String fileName = Console.readString("output file name?");
		newsStand.exportPublicationsToZipFile( fileName );
	}

}
