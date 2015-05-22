import java.util.Iterator;

public class TabellaHashLL<T> implements Dictionary<T> {
	private StrutturaCollegata<T>[] S;
	private Hash fHash;
	
	public TabellaHashLL(int n, Hash fHash) {
		this.S = new StrutturaCollegata[n];
		this.fHash = fHash;
	}
	
	@Override
	public void insert(T e, Comparable k) {
		int pos = fHash.h(S.length, k);
		if(S[pos] == null)
			S[pos] = new StrutturaCollegata<T>();
		S[pos].insert(e, k);
	}

	@Override
	public void delete(Comparable k) {
		int pos = fHash.h(S.length, k);
		S[pos].delete(k);
		if(S[pos].getNumElem() == 0)
			S[pos] = null;
	}

	@Override
	public T search(Comparable k) {
		int pos = fHash.h(S.length, k);
		return S[pos].search(k);
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			T value;
			int i = initCursore();
			Iterator<T> it = S[i].iterator();
			
			@Override
			public boolean hasNext() {
				if(!it.hasNext()){
					i = posizionaCursore(i);
					if(i == S.length)
						return false;
					it = S[i].iterator();
				} 
				
				value = it.next();
				return true;
			}

			@Override
			public T next() {
				return value;
			}
			
			private int posizionaCursore(int j){
				for(int i = j+1; i < S.length; i++)
					if(S[i] != null)
						return i;
				return S.length;
			}
			
			private int initCursore(){
				for(int i = 0; i < S.length; i++)
					if(S[i] != null)
						return i;
				return S.length;
			}
		};
	}

	public static void main(String[] args){
		Dictionary<Integer> d = new TabellaHashLL<Integer>(5,new HashDivisione());
		d.insert(1, "A1");
		d.insert(2, "A2");
		d.insert(3, "A3");
		d.insert(4, "A4");
		d.insert(5, "A5");
		d.insert(6, "A6");
		d.insert(7, "A7");
		
		for(Integer x : d){
			System.out.print(x + " ");
		}
	}
	
	
}
