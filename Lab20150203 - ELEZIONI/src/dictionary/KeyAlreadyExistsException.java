package dictionary;

public class KeyAlreadyExistsException extends RuntimeException {
	public KeyAlreadyExistsException(String msg) {
		super(msg);
	}
	
	public KeyAlreadyExistsException() {
		
	}
}
