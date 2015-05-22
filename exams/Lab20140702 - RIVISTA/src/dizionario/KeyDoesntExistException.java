package dizionario;

public class KeyDoesntExistException extends RuntimeException {

	KeyDoesntExistException() {
		super();
	}
	
	KeyDoesntExistException(String msg) {
		super(msg);
	}
	
}
