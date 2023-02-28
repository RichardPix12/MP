package uo.mp.exceptions.newsstand;

@SuppressWarnings("serial")
public class NewStandException extends Exception {
	
	public NewStandException(String fileName) {
		super("El nombre del fichero " + fileName + "no existe");
		// TODO Auto-generated constructor stub
	}
	

	public NewStandException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewStandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NewStandException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}


	public NewStandException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
