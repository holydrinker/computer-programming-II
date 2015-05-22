package rivista;

public class EccezioneVolumePubblicato extends RuntimeException {

	EccezioneVolumePubblicato() {
		super();
	}
	
	EccezioneVolumePubblicato(String msg) {
		super(msg);
	}
	
}
