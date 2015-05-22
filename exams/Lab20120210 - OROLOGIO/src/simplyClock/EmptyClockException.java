package simplyClock;

public class EmptyClockException extends RuntimeException {

	public EmptyClockException() {
		super();
	}
	
	public EmptyClockException(String msg) {
		super(msg);
	}
	
}
