package dictionary;

public class EntryAlreadyExistsException extends RuntimeException {

	EntryAlreadyExistsException() {
		super();
	}
	
	EntryAlreadyExistsException(String msg) {
		super(msg);
	}
	
}
