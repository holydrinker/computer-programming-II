package dictionary;

public class EntryAlreadyExistsException extends RuntimeException {

	public EntryAlreadyExistsException() {
		super();
	}
	
	public EntryAlreadyExistsException(String msg) {
		super(msg);
	}
	
}
