package dictionary;

public class EntryDoesntExistsException extends RuntimeException {

	EntryDoesntExistsException() {
		super();
	}
	
	EntryDoesntExistsException(String msg) {
		super(msg);
	}
	
}
