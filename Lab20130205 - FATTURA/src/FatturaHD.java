import pila.PilaHD;


public class FatturaHD extends Fattura {

	public FatturaHD(Persona venditore, Persona compratore, String dataEmissione) {
		super(venditore, compratore, dataEmissione);
		super.beni = new PilaHD<Bene>();
	}

}
