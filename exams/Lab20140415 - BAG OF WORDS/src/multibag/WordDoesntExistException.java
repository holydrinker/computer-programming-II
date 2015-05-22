package multibag;

public class WordDoesntExistException extends RuntimeException {

	public WordDoesntExistException() {
		super();
	}
	
	public WordDoesntExistException(String msg) {
		super(msg);
	}
	
}
