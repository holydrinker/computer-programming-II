package dictionary;

public class EmptyStructureException extends RuntimeException {

	EmptyStructureException() {
		super();
	}
	
	EmptyStructureException(String msg) {
		super(msg);
	}
	
}
