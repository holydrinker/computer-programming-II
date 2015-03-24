package elezioni;

public class ListDoesntExistException extends RuntimeException {

	public ListDoesntExistException() {
		super();
	}
	
	public ListDoesntExistException(String msg) {
		super(msg);
	}
	
}
