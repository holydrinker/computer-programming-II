package graduatoria;

public class RateNotValidException extends RuntimeException {
	
	public RateNotValidException(){}
	
	public RateNotValidException(String msg){
		super(msg);
	}
}
