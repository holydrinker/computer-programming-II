package elezioni;

public class EmptyListsException extends RuntimeException {

	public EmptyListsException() {
		super();
	}
	
	public EmptyListsException(String msg) {
		super(msg);
	}
}
