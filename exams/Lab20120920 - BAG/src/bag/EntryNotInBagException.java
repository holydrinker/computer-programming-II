package bag;

public class EntryNotInBagException extends RuntimeException {

	public EntryNotInBagException() {
		super();
	}
	
	public EntryNotInBagException(String msg) {
		super(msg);
	}
}
