import list.AddOnlyList;
import list.VectorList;
import dictionary.Dictionary;
import dictionary.EmptyStructureException;
import dictionary.EntryAlreadyExists;
import dictionary.EntryDoesntExistException;


public abstract class BibliotecaAbs {
	protected Dictionary<String,Record> volumi;
	
	public boolean bibliotecaVuota(){
		
		try {
			volumi.delete("");
		} catch (Exception e) {
			return true;
		}
		
		return false;
	}
	
	public void addVol(String posizione, Record recordVolume){
		
		try {
			volumi.insert(posizione, recordVolume);
		} catch (EntryAlreadyExists e) {
			throw new PositionAlreadyFull(e.getMessage());
		}
	}
	
	public Volume volume(String posizione){
		Record vol;
		
		try {
			vol = (Record)volumi.search(posizione);
		} catch (EntryDoesntExistException e) {
			throw new EmptyStructureException(e.getMessage());
		} catch (EmptyStructureException e) {
			throw new EmptyLibraryException(e.getMessage());
		}
		
		return vol.getVolume();
	}
	
	public void prestito(String posizione){
		Record vol;
		
		try {
			vol = (Record)volumi.search(posizione);
		} catch (EntryDoesntExistException e) {
			throw new EmptyStructureException(e.getMessage());
		} catch (EmptyStructureException e) {
			throw new EmptyLibraryException(e.getMessage());
		}
		
		if(vol.getPrestato())
			throw new VolumAlreadyLent();
		vol.setPrestato(true);
	}
	
	public void restituzione(String posizione){
		Record vol;
		
		try {
			vol = (Record)volumi.search(posizione);
		} catch (EntryDoesntExistException e) {
			throw new EmptyStructureException(e.getMessage());
		} catch (EmptyStructureException e) {
			throw new EmptyLibraryException(e.getMessage());
		}
		
		if(!vol.getPrestato())
			throw new VolumAlreadyReturned();
		vol.setPrestato(false);
	}
	
	public boolean prestato(String posizione){
		Record vol;
		
		try {
			vol = (Record)volumi.search(posizione);
		} catch (EntryDoesntExistException e) {
			throw new EmptyStructureException(e.getMessage());
		} catch (EmptyStructureException e) {
			throw new EmptyLibraryException(e.getMessage());
		}
		
		return vol.getPrestato();
	}
	
	public AddOnlyList<String> posizione(Volume volume){
		AddOnlyList<String> list = new VectorList<String>();
		
		for(Object o : volumi){
			String pos = o.toString();
			Volume v = volumi.search(pos).getVolume();
			
			if(v.equals(volume))
				list.add(pos);
		}
		return list;
	}
}
