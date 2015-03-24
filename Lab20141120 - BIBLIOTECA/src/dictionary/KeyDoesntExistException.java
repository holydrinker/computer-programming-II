package dictionary;

public class KeyDoesntExistException extends RuntimeException {

	public KeyDoesntExistException() {
		super();
	}
	
	public KeyDoesntExistException(String msg) {
		super(msg);
	}
	
}
