package rivista;

public class EccezioneVolumeInesistente extends RuntimeException {

	EccezioneVolumeInesistente() {
		super();
	}
	
	EccezioneVolumeInesistente(String msg) {
		super(msg);
	}
	
}
