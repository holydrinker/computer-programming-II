package circlist;

public class CannotSetDirectionException extends RuntimeException {

	public CannotSetDirectionException() {
		super();
	}
	
	public CannotSetDirectionException(String msg) {
		super(msg);
	}
}
