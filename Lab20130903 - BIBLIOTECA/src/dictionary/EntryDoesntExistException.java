package dictionary;

public class EntryDoesntExistException extends RuntimeException {

	public EntryDoesntExistException() {
		super();
	}
	
	public EntryDoesntExistException(String msg) {
		super(msg);
	}
	
}
