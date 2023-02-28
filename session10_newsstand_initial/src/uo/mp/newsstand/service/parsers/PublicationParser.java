package uo.mp.newsstand.service.parsers;

import java.util.ArrayList;
import java.util.List;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.NewsPaper;
import uo.mp.newsstand.domain.Publication;
import uo.mp.util.Logger;
import uo.mp.util.checks.ArgumentChecks;
import uo.mp.util.exceptions.LineFormatException;



public class PublicationParser {
	
	private int lineNumber = 1;

	public List<Publication> parse(List<String> lines )  {
		ArgumentChecks.isNotNull(lines);
		List<Publication> res = new ArrayList<>();

		for (String line : lines) {
			try {
				Publication p = paseLine(line);
				res.add(p);
			} catch (LineFormatException e) {
				Logger.log(e.toString());
			}
			lineNumber++;
		}

		return res;
	}

	private Publication paseLine(String line) throws LineFormatException {
		// lanzar excepcion si la línea está vacia
		
		String[] parts = line.split("\t");
		String type = parts[0];

		if (type.equals("newspaper")) {
			return parseNewspaper(parts);
		} else if (type.equals("magazine")) {
			return parseMagazine(parts);
		}
		//lanzar una excepcion si el tipo no es válido
		throw new LineFormatException(lineNumber,"el tipo " + type + " es desconocido");
	}

	private Publication parseMagazine(String[] parts) throws LineFormatException {
		checkLength(parts, 5);
		int i = 1;
		String name = parts[i++];
		int stock = toInteger(parts[i++]);
		int sales = toInteger(parts[i++]);
		int regularity = toInteger(parts[i++]);

		return new Magazine(name, stock, sales, regularity);
	}

	private Publication parseNewspaper(String[] parts) throws LineFormatException {
		checkLength(parts, 4);
		int i = 1;
		String name = parts[i++];
		int stock = toInteger(parts[i++]);
		int sales = toInteger(parts[i++]);

		return new NewsPaper(name, stock, sales);
	}

	private void checkLength(String[] parts, int expected) throws LineFormatException {
		if(parts.length != expected) {
			throw new LineFormatException(lineNumber, "Número de campos incorrecto");
		}
		
	}

	private int toInteger(String value) throws LineFormatException{
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new LineFormatException(lineNumber,e.getMessage());
		}
	}
}
