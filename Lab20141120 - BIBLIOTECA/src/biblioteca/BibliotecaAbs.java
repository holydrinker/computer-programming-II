package biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import dictionary.Dictionary;
import dictionary.EmptyStructureException;
import dictionary.KeyAlreadyExistsException;
import dictionary.KeyDoesntExistException;

public abstract class BibliotecaAbs<K> implements Iterable<K> {

	protected Dictionary<String, Record> volumi;
	
	public boolean bibliotecaVuota(){
		try {
			volumi.delete("");
		} catch (EmptyStructureException e) {
			return true;
		}
		return false;
	}
	
	public void addVol(Volume volume){
		try {
			volumi.insert(getPos() , new Record(volume));
		} catch (KeyAlreadyExistsException e) {
			throw new VolAlreadyExistsException(e.getMessage());
		}
	}
	
	public Volume volume(String posizione){
		Record r;
		try {
			r = volumi.search(posizione);
		} catch (KeyDoesntExistException e) {
			throw new VolumeDoesnExistException(e.getMessage());
		} catch (EmptyStructureException e) {
			throw new EmptyLibraryException(e.getMessage());
		}
		return r.volume;
	}
	
	public void prestito(String posizione){
		Record vol;
		
		try {
			vol = volumi.search(posizione);
		} catch (KeyDoesntExistException e) {
			throw new VolumeDoesnExistException(e.getMessage());
		} catch (EmptyStructureException e) {
			throw new EmptyLibraryException(e.getMessage());
		}
		
		vol.prestato = true;	
	}
	
	public void restituzione(String posizione){
		Record vol;
		
		try {
			vol = volumi.search(posizione);
		} catch (KeyDoesntExistException e) {
			throw new VolumeDoesnExistException(e.getMessage());
		} catch (EmptyStructureException e) {
			throw new EmptyLibraryException(e.getMessage());
		}
		
		vol.prestato = false;
	}
	
	public boolean prestato(String posizione){
		Record vol;
		
		try {
			vol = volumi.search(posizione);
		} catch (KeyDoesntExistException e) {
			throw new VolumeDoesnExistException(e.getMessage());
		} catch (EmptyStructureException e) {
			throw new EmptyLibraryException(e.getMessage());
		}
		
		return vol.prestato;
	}
	
	public ArrayList<String> posizioni(Volume v){
		ArrayList<String> list = new ArrayList<String>();
		
		for(String pos : volumi){
			Record vol = volumi.search(pos);
			if(vol.volume.equals(v))	
				list.add(pos);
		}
		
		return list;
	}
	
	private String getPos(){
		String pos = "ARMADIO - SCAFFALE - ";
		int prog = new Random().nextInt(1000);
		pos += prog;
		
		return pos;
	}
	
	@Override
	public Iterator<K> iterator() {
		return (Iterator<K>)this.volumi.iterator();
	}
}
