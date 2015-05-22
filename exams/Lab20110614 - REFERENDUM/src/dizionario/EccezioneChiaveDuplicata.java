package dizionario;

public class EccezioneChiaveDuplicata extends RuntimeException {

	public EccezioneChiaveDuplicata() {
		super();
	}
	
	public EccezioneChiaveDuplicata(String msg) {
		super(msg);
	}
	
}
