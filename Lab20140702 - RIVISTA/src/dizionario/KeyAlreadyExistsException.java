package dizionario;

public class KeyAlreadyExistsException extends RuntimeException {

	KeyAlreadyExistsException() {
		super();
	}
	
	KeyAlreadyExistsException(String msg){
		super(msg);
	}
	
}
