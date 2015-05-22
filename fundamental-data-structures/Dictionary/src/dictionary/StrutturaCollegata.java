package dictionary;

import java.util.Iterator;

import dictionary.Record;

public class StrutturaCollegata<T> implements Dizionario<T> {

	/*
	 * Ricordiamo che questa è una struttura dati circolare doppiamente collegata.
	 * Una operazione di inserimento comporta l'inserimento dell'elemento collocandosi nella posizione seguente a LIST,
	 * e non in coda, come intuitivamente potrebbe venire da pensare.
	 */
	
	Record<T> list = null;
	int n = 0;
	
	@Override
	public void insert(Comparable key, T elem) {
		
		/*
		 * Verifichiamo che non ci sia un duplicato della chiave
		 */
		boolean duplicato = false;
		int i = 0;
		Record<T> tmp = list;
		
		while(i < n && !duplicato){
			
			if(tmp.chiave.equals(key))
				duplicato = true;
			
			else{
				tmp = tmp.next;
				i++;
			}
			
		}
		
		if(duplicato)
			throw new EccezioneChiavePresente(Dizionario.MSG_KEY_EXISTS);
		
		/*
		 * Se non c'è il duplicato, e quindi se non è stata sollevata l'eccezione, inserisco il nuovo elemento
		 */
		Record<T> nuovo = new Record<T>(key, elem);
		
		if(list == null){
			
			list = nuovo;
			list.prev = list;
			list.next = list;
			
		}
	
		else{
			
			nuovo.next = list.next;
			nuovo.prev = list;
			list.next.prev = nuovo;
			list.next = nuovo;
			
		}
		
		n++;
		
	}

	@Override
	public void delete(Comparable key) {
		
		if(list == null)
			throw new EccezioneDizionarioVuoto(Dizionario.MSG_EMPTY);
		
		else if(list.chiave.compareTo(key) == 0){
			
			/*
			 * Se l'elemento punta a se stesso, vuol dire che è rimasto l'unico elemento della struttura.
			 */
			if(list.chiave.equals(list.next.chiave))
				list = list.next = list.prev = null;
			
			else{
				list.prev.next = list.next;
				list.next.prev = list.prev;
				list = list.next;
			}
			
		}
		
		else{
			
			boolean trovato = false;
			Record<T> tmp = list.next;
			
			while(!trovato && !tmp.chiave.equals(list.chiave)){
				
				if(tmp.chiave.equals(key)){
					
					trovato = true;
					tmp.prev.next = tmp.next;
					tmp.next.prev = tmp.prev;
					
				}
				
				else
					tmp = tmp.next;
			
			}
			
			if(!trovato)
				throw new EccezioneChiaveInesistente(Dizionario.MSG_KEY_DOESNT_EXISTS);
			
		}
		
		n--;
		
	}

	@Override
	public T search(Comparable key) {
		
		if(n == 0)
			throw new EccezioneDizionarioVuoto(Dizionario.MSG_EMPTY);
		
		int i = 0;
		boolean trovato = false;
		Record<T> current = list;
		
		while(i < n && !trovato){
			
			if( key.equals(current.chiave))
				trovato = true;
			
			else{
				current = current.next;
				i++;
			}
			
		}
		
		if(!trovato)
			throw new EccezioneChiaveInesistente(Dizionario.MSG_KEY_DOESNT_EXISTS);
		
		return current.elem;
		
	}

	@Override
	public Iterator<T> iterator() {
		
		return new StrutturaCollegataIterator<T>(this);
		
	}
	
}
