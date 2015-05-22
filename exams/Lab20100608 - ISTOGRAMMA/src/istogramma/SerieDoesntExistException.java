package istogramma;

public class SerieDoesntExistException extends RuntimeException {

	public SerieDoesntExistException() {
		super();
	}
	
	public SerieDoesntExistException(String msg) {
		super(msg);
	}
}
