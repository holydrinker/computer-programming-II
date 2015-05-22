import java.util.ArrayList;
import java.util.Iterator;


public class MatriceSparsa<T> implements Iterable<T> {
	/*
	 * In questo vettore di arrayList ogni arrayList rappresenta una riga, e contiene al suo interno i record
	 * che rappresentano i valori e le colonne dei termini presenti in un testo
	 */
	protected ArrayList<Record<T>>[] valori;
	private int nRow;
	private int nCol;
	protected T defValue;
	
	class Record<T>{
		T valore;
		int colonna;
		
		public Record(T valore, int colonna) {
			this.valore = valore;
			this.colonna = colonna;
		}
	}
	
	public MatriceSparsa(int nRow, int nCol, T defValue) {
		this.nRow = nRow;
		this.nCol = nCol;
		this.defValue = defValue;
		valori = new ArrayList[nRow];
		
		for(int i = 0; i < valori.length; i++){
			ArrayList<Record<T>> tmpList = new ArrayList<Record<T>>();
			valori[i] = tmpList;
			
			for(int j = 0; j < nCol; j++)
				tmpList.add(new Record(defValue,nCol));
		}	
	}
	
	public void cambiaValore(int raw, int col, T value){
		if(raw > nRow || col > nCol)
			throw new IndexOutOfBoundsException();
		
		ArrayList<Record<T>> testo = valori[raw];
		testo.set(col, new Record(value,col));
	}
	
	public T valore(int raw, int col){
		if(raw > nRow || col > nCol)
			throw new IndexOutOfBoundsException();
		
		ArrayList<Record<T>> testo = valori[raw];
		Record<T> record = testo.get(col);
		return record.valore;
	}
	
	public int numeroRighe(){
		return this.nRow;
	}
	
	public int numeroColonne(){
		return this.nCol;
	}
	
	public int numValoriSignificativi(){
		int n = 0;
		
		for(T v : this)
			if(!v.equals(defValue))
				n++;
		
		return n;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			int i = 0;
			ArrayList<Record<T>> tmpList = valori[i];
			Record<T> tmpValue = tmpList.get(0);
			Iterator listIterator = tmpList.iterator();
					
			@Override
			public boolean hasNext() {
				return i < valori.length;
			}

			@Override
			public T next() {
				if(!listIterator.hasNext()){
					tmpList = valori[i++];
					listIterator = tmpList.iterator();
				}
				
				tmpValue = (Record<T>)listIterator.next();
				return tmpValue.valore;
			}
		};
	}
	
	@Override
	public String toString() {
		String s = "";
		
		for(int j = 0; j < valori.length; j++){
			for(int i = 0; i < valori[j].size(); i++)
				s += valori[j].get(i).valore.toString() + " ";
			s += "\n";
		}
		return s;	
	}
	
	public static void main(String[] args){
		//OK tranne iteratore
		MatriceSparsa<Integer> matrix = new MatriceSparsa<Integer>(4, 5, 0);
		matrix.cambiaValore(0, 0, 1);
		matrix.cambiaValore(1, 0, 1);
		matrix.cambiaValore(2, 0, 1);
		matrix.cambiaValore(3, 0, 1);
		System.out.println(matrix.toString());
		
		/*for(Object o : matrix){
			boolean b = (boolean) o;
			System.out.println(b);
		}*/
	}
}