package instituto;

public class NoResultSetException extends Exception {

	private static final long serialVersionUID = -2913624470336393083L;
	public NoResultSetException(String string) {
		super(string);
	}
	@Override 
	public String getMessage() {
		return "Executed query returned no data";
		
	}
	public NoResultSetException() {
		super();
	}

}
