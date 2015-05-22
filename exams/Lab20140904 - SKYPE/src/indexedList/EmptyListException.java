package indexedList;

public class EmptyListException extends RuntimeException {

	public EmptyListException() {
		super();
	}
	
	public EmptyListException(String msg) {
		super(msg);
	}
	
}
