package indexedList;

public class ItemAlreadyPresent extends RuntimeException {

	public ItemAlreadyPresent() {
		super();
	}
	
	public ItemAlreadyPresent(String msg) {
		super(msg);
	}
	
}
