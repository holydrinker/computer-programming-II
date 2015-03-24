package rivista;

class EccezioneArticoloInesistente extends RuntimeException {

	EccezioneArticoloInesistente() {
		super();
	}
	
	EccezioneArticoloInesistente(String msg) {
		super(msg);
	}
	
}
