package circlist;

public class EccezioneStrutturaVuota extends RuntimeException {

	public EccezioneStrutturaVuota() {
		super();
	}
	
	public EccezioneStrutturaVuota(String msg) {
		super(msg);
	}
	
}
