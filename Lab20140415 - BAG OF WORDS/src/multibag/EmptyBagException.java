package multibag;

public class EmptyBagException extends RuntimeException {

	public EmptyBagException() {
		super();
	}
	
	public EmptyBagException(String msg) {
		super(msg);
	}
	
}
