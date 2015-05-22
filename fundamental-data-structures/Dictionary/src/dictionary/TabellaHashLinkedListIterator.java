package dictionary;

import java.util.Iterator;

public class TabellaHashLinkedListIterator<T> implements Iterator<T> {

	private StrutturaCollegata<T> S[];
	private int dimArray;
	private int i = 0;
	private StrutturaCollegataIterator<T> scIter;
	
	public TabellaHashLinkedListIterator(TabellaHashLinkedList<T> dizionario) {
		
		this.S = dizionario.S;
		this.dimArray = S.length;
		posizionaCursore();
		
	}
	
	@Override
	public boolean hasNext() {
		
		checkArray();
		return i < dimArray;
		
	}

	@Override
	public T next() {

		return (T)scIter.next();
		
	}

	private void posizionaCursore(){
		
		/*
		 * Posiziono la i sulla prossima cella dell'array che non sia NULL
		 */
		
		boolean iPosizionato = false;
		
		while(!iPosizionato && i < dimArray){
			
			if(S[i] == null || S[i].list == null){
				
				i++;
				
			}
			
			else{
				
				iPosizionato = true;
				scIter = new StrutturaCollegataIterator<T>(S[i]);
				
			}
			
		}
		
	}
	
	private void checkArray(){
		
		/*
		 * Controllo se abbiamo finito di iterare sulla struttura collegata di una cella dell'array.
		 * Se abbiamo finito incrementiamo la i, assicurandoci che adesso la i
		 * non faccia riferiemtno alla posizione di una cella NULL
		 */
		
		if(!scIter.hasNext()){
			
			i++;
			posizionaCursore();
			
		}
		
	}
	
}
