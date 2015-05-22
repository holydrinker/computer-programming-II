package dictionary;

public class KeyAlreadyExistsException extends RuntimeException {

	public KeyAlreadyExistsException() {
		super();
	}
	
	public KeyAlreadyExistsException(String msg) {
		super(msg);
	}
	
}
