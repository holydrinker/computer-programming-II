package skype;
import indexedList.IndexedLL;
import indexedList.IndexedList;
import indexedList.ItemAlreadyPresent;
import indexedList.ItemNotPresents;


public class Skype implements Comparable {
	 private IndexedList<Pacchetto> comunicazione = new IndexedLL<Pacchetto>(); 
	 
	 public void addPacchetto(Pacchetto p){
		 try {
			 comunicazione.addItem(p, p.identificativo);
		} catch (ItemAlreadyPresent e) {
			throw new PacchettoGiaInviato(e.getMessage() + " ID: " + p.identificativo);
		}
	 }
	 
	public boolean complete(){
		Pacchetto p0 = null;
		try {
			p0 = comunicazione.getItem(0);
		} catch (ItemNotPresents e) {
			throw new PacchettoNonPresente(e.getMessage());
		}
		int prevID = p0.identificativo;
		
		Pacchetto p = null;
		for(Object obj : comunicazione){
			 p = (Pacchetto) obj;
			 int tmpID = p.identificativo;
			 
			 if(tmpID != p0.identificativo){
				 if(tmpID != prevID+1)
					 return false;
				 else
					 prevID = tmpID;
			 }
		 }
		return p.ultimo == true; 
	 }
	 
	@Override
	public String toString() {
		String s = "";
		for(Object obj : comunicazione){
			Pacchetto p = (Pacchetto) obj;
			s += p.dati + " ";
		}
		return s;
	}
	
	@Override
	public int compareTo(Object arg0) {
		Skype messaggio = (Skype) arg0;
		if(!this.complete() || !messaggio.complete())
			throw new MessaggiNonConfrontabili("Impossibile confrontare i due messaggi. Uno dei due non è completo.");
		return this.toString().compareTo(messaggio.toString());
	}

}
