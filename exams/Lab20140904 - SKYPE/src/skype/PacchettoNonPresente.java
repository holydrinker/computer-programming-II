package skype;

public class PacchettoNonPresente extends RuntimeException {

	public PacchettoNonPresente() {
		super();
	}
	
	public PacchettoNonPresente(String msg) {
		super(msg);
	}
}
