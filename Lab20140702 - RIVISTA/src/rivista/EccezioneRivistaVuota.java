package rivista;

class EccezioneRivistaVuota extends RuntimeException {

	EccezioneRivistaVuota() {
		super();
	}
	
	EccezioneRivistaVuota(String msg) {
		super(msg);
	}
	
}
