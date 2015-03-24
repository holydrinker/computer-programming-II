
import java.util.ArrayList;

import javax.swing.plaf.BorderUIResource.EmptyBorderUIResource;

import dictionary.Dictionary;
import dictionary.EmptyDictionaryException;
import dictionary.EntryAlreadyExists;
import dictionary.EntryDoesntExist;
import dictionary.HashDivisione;
import dictionary.TabellaHashLL;


public class Biblioteca {
	protected Dictionary<Volume> volumi;
	private int dimArray = 13;
	
	public Biblioteca() {
		volumi = new TabellaHashLL<Volume>(dimArray, new HashDivisione());
	}
	
	public int volumi(){
		int n = 0;
		for(Object obj : volumi)
			n++;
		return n;
	}
	
	public void registra(String codice, String titolo, String autore, int anno){
		Volume nuovoVolume = new Volume(titolo, autore, anno);
		
		try {
			volumi.insert(nuovoVolume, codice);
		} catch (EntryAlreadyExists e) {
			throw new VolumeDuplicatoException(e.getMessage());
		}
	}
	
	public String titolo(String codice){
		try {
			Volume v = volumi.search(codice);
			return v.getTitolo();
		} catch (EmptyDictionaryException e) {
			throw new BibliotecaVuotaException(e.getMessage());
		} catch (EntryDoesntExist e) {
			throw new VolumeInesistenteException(e.getMessage());
		}
	}
	
	public String autore(String codice){
		try {
			Volume v = volumi.search(codice);
			return v.getAutore();
		} catch (EmptyDictionaryException e) {
			throw new BibliotecaVuotaException(e.getMessage());
		} catch (EntryDoesntExist e) {
			throw new VolumeInesistenteException(e.getMessage());
		}
	}
	
	public int anno(String codice){
		try {
			Volume v = volumi.search(codice);
			return v.getAnno();
		} catch (EmptyDictionaryException e) {
			throw new BibliotecaVuotaException(e.getMessage());
		} catch (EntryDoesntExist e) {
			throw new VolumeInesistenteException(e.getMessage());
		}
	}
	
	public ArrayList<String> codice(String titolo, String autore, int anno){
		ArrayList<String> list = new ArrayList<String>();
		
		for(Object obj : volumi){
			String key = ((Comparable) obj).toString();
			Volume v = volumi.search(key);
			
			if(v.getTitolo().equals(titolo))
				if(v.getAutore().equals(autore))
					if(v.getAnno() == anno)
						list.add(key);
		}
		return list;
	}
	
	public void prestito(String codice){
		try {
			Volume v = volumi.search(codice);
			v.setStato(true);
		} catch (EmptyDictionaryException e) {
			throw new BibliotecaVuotaException(e.getMessage());
		} catch (EntryDoesntExist e) {
			throw new VolumeInesistenteException(e.getMessage());
		}
	}
	
	public boolean prestato(String codice){
		try {
			Volume v = volumi.search(codice);
			return v.getStato();
		} catch (EmptyDictionaryException e) {
			throw new BibliotecaVuotaException(e.getMessage());
		} catch (EntryDoesntExist e) {
			throw new VolumeInesistenteException(e.getMessage());
		}
	}
	
	public int copie(String titolo, String autore, int anno){
		int n = 0;
		
		for(Object obj : volumi){
			String codice = ((Comparable)obj).toString();
			Volume v = volumi.search(codice);
			if(v.getTitolo().equals(titolo))
				if(v.getAutore().equals(autore))
					if(v.getAnno() == anno)
						n++;
		}
		return n;
	}
}
