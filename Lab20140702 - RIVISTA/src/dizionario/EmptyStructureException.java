package dizionario;

public class EmptyStructureException extends RuntimeException {

	EmptyStructureException() {
		super();
	}
	
	EmptyStructureException(String msg) {
		super(msg);
	}
	
}
