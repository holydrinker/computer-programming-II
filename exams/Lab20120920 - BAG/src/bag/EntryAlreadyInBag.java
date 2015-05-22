package bag;

public class EntryAlreadyInBag extends RuntimeException {

	public EntryAlreadyInBag() {
		super();
	}
	
	public EntryAlreadyInBag(String msg) {
		super(msg);
	}
	
}
