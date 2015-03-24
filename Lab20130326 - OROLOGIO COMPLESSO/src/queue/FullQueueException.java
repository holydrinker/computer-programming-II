package queue;

public class FullQueueException extends RuntimeException {

	public FullQueueException() {
		super();
	}
	
	public FullQueueException(String msg) {
		super(msg);
	}
	
}
