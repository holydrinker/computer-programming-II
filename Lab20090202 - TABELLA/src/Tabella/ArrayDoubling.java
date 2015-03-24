package Tabella;

public class ArrayDoubling implements Tabella {

	private Entry[] S = new Entry[1];
	private int n = 0;
	private static final String MSG_KEY_EXISTS = "La chiave è già presente nella tabella";
	private static final String MSG_KEY_DOESNT_EXISTS = "La chiave non è presente nella tabella";
	private static final String MSG_EMPTY = "La struttura dati è vuota";
	
	
	@Override
	public void insert(Object e, Comparable k) {
		
		Entry nuovo = new Entry(k,e);
		
		if(n == 0){
			S[0] = nuovo;
			n++;
			return;
		}
		
		if(n == S.length){
			
			Entry tmp[] = new Entry[S.length * 2];
			
			for(int i = 0; i < n; i++){
				
				if(S[i].chiave.compareTo(k) == 0)
					throw new EccezioneChiavePresente(MSG_KEY_EXISTS);
				else
					tmp[i] = S[i];
				
			}
			
			S = tmp;
			
		}
		
		S[n] = nuovo;
		n++;
		
	}

	@Override
	public void delete(Comparable k) {
		
		int i = 0;
		boolean trovato = false;
		
		while ( !trovato && i < n){
			
			if(S[i].chiave.compareTo(k) == 0)
				trovato = true;
			else
				i++;
			
		}

		if(!trovato)
			throw new EccezioneChiaveInesistente(MSG_KEY_DOESNT_EXISTS);
		
		for(int j = i + 1; j < n; j++)
			S[j - 1] = S[j];
		
		n--;
		
		if(n == S.length / 4){
			
			Entry tmp[] = new Entry[S.length / 2];
			
			for(int idx = 0; idx < n; idx++)
				tmp[idx] = S[idx];
			
			S = tmp;
			
		}
		
	}

	@Override
	public Object search(Comparable k) {
		
		if(n == 0)
			throw new EccezioneStrutturaVuota(MSG_EMPTY);
		
		int i = 0;
		boolean trovato = false;
		
		while(i < n && !trovato){
			
			if(S[i].chiave.compareTo(k) == 0)
				trovato = true;
			else
				i++;
			
		}
		
		if(!trovato)
			throw new EccezioneChiaveInesistente(MSG_KEY_DOESNT_EXISTS);
		
		return S[i].elem;
		
	}

	@Override
	public String toString() {
		
		String s = "";
		
		if(n == 0)
			s = "(Vuoto)";
		
		else{
			
			for(int i = 0; i < n; i++)
				s += S[i].chiave.toString() + " - " + S[i].elem + "\n";
			
		}
		
		return s;
	}
	
	private class Entry{
		
		Comparable chiave;
		Object elem;
		
		public Entry(Comparable chiave, Object elem) {
			this.chiave = chiave;
			this.elem = elem;
		}
		
	}
	
}
