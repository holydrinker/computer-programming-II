package dictionary;

public class EmptyStructureException extends RuntimeException {

	public EmptyStructureException() {
		super();
	}
	
	public EmptyStructureException(String msg) {
		super(msg);
	}
}
