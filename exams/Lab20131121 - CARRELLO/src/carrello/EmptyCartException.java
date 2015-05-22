package carrello;

public class EmptyCartException extends RuntimeException {

	public EmptyCartException() {
		super();
	}
	
	public EmptyCartException(String msg) {
		super(msg);
	}
	
}
