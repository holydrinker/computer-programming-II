package dictionary;

public class EntryAlreadyExists extends RuntimeException {

	public EntryAlreadyExists() {
		super();
	}
	
	public EntryAlreadyExists(String msg) {
		super(msg);
	}
	
}
