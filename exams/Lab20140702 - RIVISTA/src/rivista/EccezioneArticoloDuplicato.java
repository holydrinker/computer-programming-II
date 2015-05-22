package rivista;

public class EccezioneArticoloDuplicato extends RuntimeException {

	EccezioneArticoloDuplicato() {
		super();
	}
	
	EccezioneArticoloDuplicato(String msg) {
		super(msg);
	}
	
}
