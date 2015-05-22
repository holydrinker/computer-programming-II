package biblioteca;
import java.util.ArrayList;

import dictionary.Dictionary;
import dictionary.EmptyStructuresException;
import dictionary.EntryAlreadyExistsException;
import dictionary.EntryDoesntExistException;
import dictionary.HashDivisione;
import dictionary.TabellaHashLL;


public class Biblioteca {
	protected Dictionary<Volume> volumi = new TabellaHashLL<Volume>(13, new HashDivisione());
	
	public int volumi(){
		int count = 0;
		for(Object obj : volumi)
			count++;
		return count;
	}
	
	public void registra(String codice, String titolo, String autore, int anno){
		Volume v = new Volume(titolo, autore, anno, false);
		
		try {
			volumi.insert(v, codice);
		} catch (EntryAlreadyExistsException e) {
			throw new VolumePresenteException(e.getMessage());
		}
	}
	
	public String titolo(String codice){
		String titolo = "";
		
		try {
			titolo = volumi.search(codice).getTitolo();
		} catch (EntryDoesntExistException e) {
			throw new VolumeAssenteException(e.getMessage());
		} catch (EmptyStructuresException e) {
			throw new BibliotecaVuotaException(e.getMessage());
		}
		return titolo;
	}
	
	public String autore(String codice){
		String autore = "";
		
		try {
			autore = volumi.search(codice).getAutore();
		} catch (EntryDoesntExistException e) {
			throw new VolumeAssenteException(e.getMessage());
		} catch (EmptyStructuresException e) {
			throw new BibliotecaVuotaException(e.getMessage());
		}
		return autore;
	}
	
	public int anno(String codice){
		int anno = -1;
		
		try {
			anno = volumi.search(codice).getAnno();
		} catch (EntryDoesntExistException e) {
			throw new VolumeAssenteException(e.getMessage());
		} catch (EmptyStructuresException e) {
			throw new BibliotecaVuotaException(e.getMessage());
		}
		return anno;
	}
	
	public ArrayList<String> codice(String titolo, String autore, int anno){
		ArrayList<String> lista = new ArrayList<String>();
		int i = 0;
		
		for(Object obj : volumi){
			String codice = obj.toString();
			Volume v = volumi.search(codice);
			if(titolo.equals(v.getTitolo()) && autore.equals(v.getAutore()) && anno == v.getAnno())
				lista.add(codice);
		}
		return lista;
	}
	
	public void prestito(String codice){
		
		try {
			Volume v = volumi.search(codice);
			v.setPrestato(true);
		} catch (EntryDoesntExistException e) {
			throw new VolumeAssenteException(e.getMessage());
		} catch (EmptyStructuresException e) {
			throw new BibliotecaVuotaException(e.getMessage());
		}
	}
	
	public boolean prestato(String codice){
		
		try {
			Volume v = volumi.search(codice);
			return v.getPrestato();
		} catch (EntryDoesntExistException e) {
			throw new VolumeAssenteException(e.getMessage());
		} catch (EmptyStructuresException e) {
			throw new BibliotecaVuotaException(e.getMessage());
		}
	}
	
	public int copie(String titolo, String autore, int anno){
		ArrayList<String> listaCodici = codice(titolo, autore, anno);
		return listaCodici.size();
	}
	
	@Override
	public String toString() {
		String s = "";
		
		for(Object cod : volumi){
			String codice = cod.toString();
			Volume v = volumi.search(codice);
			String stato = "disponibile";
			if(v.getPrestato())
				stato = "prestato";
			
			s += codice + " " + v.getTitolo() + " " + v.getAutore() + " " + v.getAnno() + " " + stato + "\n"; 
		}
		return s;
	}
}
