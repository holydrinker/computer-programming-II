package dictionary;

public class EntryDoesntExist extends RuntimeException {

	public EntryDoesntExist() {
		super();
	}
	
	public EntryDoesntExist(String msg) {
		super(msg);
	}
	
}
