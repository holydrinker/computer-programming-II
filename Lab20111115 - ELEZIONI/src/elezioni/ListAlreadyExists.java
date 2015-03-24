package elezioni;

public class ListAlreadyExists extends RuntimeException {

	public ListAlreadyExists() {
		super();
	}
	
	public ListAlreadyExists(String msg) {
		super(msg);
	}
	
}
