package lista;

public class NotEmptyCellException extends RuntimeException {

	public NotEmptyCellException() {
		super("Cella non vuota");
	}
	
	public NotEmptyCellException(String msg) {
		super(msg);
	}
}
