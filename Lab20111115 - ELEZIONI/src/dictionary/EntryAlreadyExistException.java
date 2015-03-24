package dictionary;

public class EntryAlreadyExistException extends RuntimeException {

	public EntryAlreadyExistException() {
		super();
	}
	
	public EntryAlreadyExistException(String msg) {
		super(msg);
	}
}
