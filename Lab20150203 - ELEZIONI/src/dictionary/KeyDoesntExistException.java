package dictionary;

public class KeyDoesntExistException extends RuntimeException {
	public KeyDoesntExistException(String msg) {
		super(msg);
	}
	
	public KeyDoesntExistException() {
		
	}
}
