package uo.mp.util.exceptions;

@SuppressWarnings("serial")
public class LineFormatException extends Exception{
	private int lineNumber;
	
	public LineFormatException(int lineNumber, String msg) {
		super(msg);
		this.lineNumber = lineNumber;
	}
	
	
	

	@Override
	public String toString() {
		return getMessage()+ "en linea" + lineNumber;
	}




	public LineFormatException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LineFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public LineFormatException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public LineFormatException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public LineFormatException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
