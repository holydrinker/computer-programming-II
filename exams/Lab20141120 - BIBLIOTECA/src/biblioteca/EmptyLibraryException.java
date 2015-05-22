package biblioteca;

public class EmptyLibraryException extends RuntimeException {

	public EmptyLibraryException(String msg) {
		super(msg);
	}
	
	public EmptyLibraryException() {
		
	}
	
}
