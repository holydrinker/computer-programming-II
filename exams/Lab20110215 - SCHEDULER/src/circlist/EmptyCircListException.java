package circlist;

public class EmptyCircListException extends RuntimeException {

	public EmptyCircListException() {
		super();
	}
	
	public EmptyCircListException(String msg) {
		super(msg);
	}
}
