package serie;

public class EmptySerieException extends RuntimeException {

	public EmptySerieException() {
		super();
	}
	
	public EmptySerieException(String msg) {
		super(msg);
	}
}
