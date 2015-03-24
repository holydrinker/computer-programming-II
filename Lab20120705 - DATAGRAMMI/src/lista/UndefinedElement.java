package lista;

public class UndefinedElement extends RuntimeException {

	public UndefinedElement() {
		super("Cella vuota");
	}
	
	public UndefinedElement(String msg) {
		super(msg);
	}
	
}
