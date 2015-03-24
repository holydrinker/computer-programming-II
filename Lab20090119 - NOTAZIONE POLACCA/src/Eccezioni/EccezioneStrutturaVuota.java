package Eccezioni;

public class EccezioneStrutturaVuota extends RuntimeException {

	public EccezioneStrutturaVuota() {}
	
	public EccezioneStrutturaVuota(String msg) {
		super(msg);
	}
	
}
