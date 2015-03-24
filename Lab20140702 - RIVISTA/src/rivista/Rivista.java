package rivista;

import dizionario.Dictionary;
import dizionario.KeyAlreadyExistsException;
import dizionario.KeyDoesntExistException;
import dizionario.EmptyStructureException;
import dizionario.LinkedDict;

public class Rivista {
	protected Dictionary<String,Articolo> articoli;
	protected Dictionary<Integer,Boolean> volumi;
	
	public Rivista() {
		articoli = new LinkedDict<String, Articolo>();
		volumi = new LinkedDict<Integer, Boolean>();
	}
	
	public boolean rivistaNuova(){
		for(int vol : volumi)
			if(volumi.search(vol))
				return true;
			
		return false;
	}
	 
	public void addArt(String titoloArticolo, int volume){
		try{
			volumi.search(volume);
		}catch(KeyDoesntExistException e){
			volumi.insert(volume, false);
		}catch(EmptyStructureException e){
			volumi.insert(volume, false);
		}
			
		Articolo nuovoArticolo = new Articolo();
		nuovoArticolo.setVolume(volume);
		try {
			articoli.insert(titoloArticolo, nuovoArticolo);
		} catch (KeyAlreadyExistsException e) {
			throw new EccezioneArticoloDuplicato("L'articolo che si sta cercando di inserire è già presente in questo volume: " + volume);
		}
	}
	
	public void addAut(String titolo, String nuovoAutore){
		try {
			Articolo tmp = articoli.search(titolo);
			tmp.addAutore(nuovoAutore);
			articoli.delete(titolo);
			articoli.insert(titolo, tmp);
		} catch (KeyDoesntExistException e) {
			throw new EccezioneArticoloInesistente("Non esiste alcun articolo corrispondente al titolo cercato.");
		} catch (EmptyStructureException e) {
			throw new EccezioneRivistaVuota("Non è ancora presente alcun articolo");
		}
	}

	public void pubblicaVol(int volumePub){
		try {
			boolean result = volumi.search(volumePub);
			if(result)
				throw new EccezioneVolumePubblicato("Il volume è già stato pubblicato in precedenza");
			else{
				volumi.delete(volumePub);
				volumi.insert(volumePub, !result);
			}
		} catch (KeyDoesntExistException e) {
			throw new EccezioneVolumeInesistente("Il volume che si sta cercando di pubblicare non esiste");
		}	
	}
	
	public boolean pubblicato(int volume){
		boolean result = false;
		try {			
			result = volumi.search(volume);
		} catch (KeyDoesntExistException e) {
			throw new EccezioneVolumeInesistente("Non esiste alcun volume corrispondente a quello che si sta cercando");
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		String stampa = "";
		
		for(String titolo : articoli){
			Articolo a = articoli.search(titolo);
			stampa += "Autori: " + a.autoriToString() + "\n";
			stampa += "Titolo: " + titolo + "\n";
			stampa += "Volume: " + a.getVolume() + "\n \n";
		}
		
		return stampa;
	}
}
