package uo.mp.newsstand.service;

import java.io.FileNotFoundException;


import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.collections.impl.LinkedList;
import uo.mp.exceptions.newsstand.AlreadyExistException;
import uo.mp.newsstand.domain.Order;
import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.service.parsers.PublicationParser;
import uo.mp.newsstand.service.serializers.OrderSerializer;
import uo.mp.newsstand.service.serializers.PublicationSerializer;
import uo.mp.util.Logger;
import uo.mp.util.checks.ArgumentChecks;
import uo.mp.util.exceptions.DoesNoExistException;
import uo.mp.util.exceptions.InvalidFileNameException;
import uo.mp.util.file.FileUtil;
import uo.mp.util.file.ZipFileUtil;

public class NewsStand {

	private List<Publication> publications =new LinkedList<Publication>();

	private List<Order> orders =  new LinkedList<Order>();

	/**
	 * Loads all the products contained in the file desined by its name.
	 * None publication can be repeated regarding its name. If a publication
	 * is with a repeated name is already registered it will be ignored 
	 * and a message sent to log.
	 * 
	 * @param inFileName, the name of the file
	 * @throws AlreadyExistException 
	 * @throws InvalidFileNameException 
	 * @throws FileNotFoundException 
	 * @throws NewsStandException, if the file name is invalid
	 */
	public void loadFile(String inFileName) throws AlreadyExistException,
													InvalidFileNameException,
														FileNotFoundException {
		checkName(inFileName);
		List<String> lines = new FileUtil().readLines(inFileName);
		List<Publication> filePublications = new PublicationParser().parse(lines);
		addPublications(filePublications);
	}

	private void checkName(String inFileName) throws InvalidFileNameException {
		if(inFileName.trim().length() == 0 ||inFileName.length() < 5) {
			throw new InvalidFileNameException(inFileName);
		}
		
	}

	/**
	 * Add all the publications contained on the list passed as argument.
	 * None publication can be repeated regarding its name. If a publication
	 * is with a repeated name is already registered it will be ignored 
	 * and a message sent to log.
	 * 
	 * @param newProducts, the list with the new publications

	 */
	private void addPublications(List<Publication> filePublications)  {
		for (Publication p : filePublications) {
			try {
				addPublication(p);
			} catch (AlreadyExistException e) {
				Logger.log(e);
			}
		}
	}

	/**
	 * Add the publication if it is name is not already registered
	 * @param p, the product to be added
	 * @throws AlreadyExistException cuando la publicación está repetida
	 */
	public void addPublication(Publication p) throws AlreadyExistException {
		ArgumentChecks.isNotNull(p);
		if(searchByName(p.getName()) != -1) {
			throw new AlreadyExistException(p.getName());
		}
		publications.add(p);
	}

	/**
	 * Removes the product whose indicated by its name
	 * 
	 * @param name of the publication to be removed
	 * @throws DoesNoExistException the products dont exist
	 */
	public void removePublication(String name) throws DoesNoExistException {
		int pos = searchByName(name);
		if(pos == -1) {
			throw new DoesNoExistException(name);
		}
		publications.remove(pos);
	}

	private int searchByName(String name) {
		for (int i = 0; i < publications.size(); i++) {
			Publication p = publications.get(i);
			if ((p.getName().equals(name)) /* compare both names */ )
				return i;
		}
		return -1;
	}

	/**
	 * @return a list which a copy of the internal list of publications
	 */
	public List<Publication> getPublications() {
		// Returns a list, copy of our own list to not break the encapsulation
		// A copy constructor needed in out lists
	return publications;
	}

	/**
	 * Generates a list of orders. One for every product with stock under limits
	 */
	public void createOrders() {
	 orders.clear();
	 for(Publication p: publications) {
		 if(p.getStock()<10) {
			 orders.add(p.order());
		 }
		 
	 }
	}

	/**
	 * @return a list which a copy of the internal list of orders
	 */
	public List<Order> getOrders() {
		// Returns a list, copy of our own list to not break the encapsulation
		// A copy constructor needed in out lists
		return new ArrayList<>(orders);
	}

	/**
	 * Save all orders to a file with the given format
	 * 
	 * @param fileName
	 * @throws NewsStandException in case
	 * 		- the file name is invalid
	 */
	public void saveOrdersToFile(String fileName) {
		OrderSerializer serializer = new OrderSerializer();
		List<String> lines = serializer.serialize(orders);
		new FileUtil().writeLines(fileName, lines);
	}

	/**
	 * Imports all the publications from the zip file and removes all the 
	 * previous ones.
	 * 
	 * @param fileName
	 * @throws InvalidFileNameException 
	 * @throws FileNotFoundException 
	 */
	public void importPublicationsFromZipFile(String fileName) throws InvalidFileNameException, FileNotFoundException{
		checkName(fileName);
		List<String> lines = new ZipFileUtil().readLines(fileName);
		List<Publication> filePublications = new PublicationParser().parse(lines);
		addPublications(filePublications);
	}

	/**
	 * Saves all the publications to a zip file. The file produced can be read
	 * by the method @see importPublicationsFromZipFile
	 * 
	 * @param fileName
	 */
	public void exportPublicationsToZipFile(String fileName) {
		PublicationSerializer serializer = new PublicationSerializer();
		List<String> lines = serializer.serialize(publications);
		new ZipFileUtil().writeLines(fileName, lines);
	}

}
