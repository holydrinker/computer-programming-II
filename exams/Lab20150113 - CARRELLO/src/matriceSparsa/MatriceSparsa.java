package matriceSparsa;
import java.util.ArrayList;
import java.util.Iterator;


public class MatriceSparsa<T> implements Iterable<T> {
	protected ArrayList<Record<T>>[] valori;
	protected int nRow;
	protected int nCol;
	protected T defValue;
	
	public MatriceSparsa(int nRow, int nCol, T defValue) {
		this.nRow = nRow;
		this.nCol = nCol;
		this.defValue = defValue;
		
		valori = new ArrayList[nRow];
		for(int i = 0; i < valori.length; i++)
			valori[i] = new ArrayList<Record<T>>();
		
	}
	
	public void cambiaValore(int riga, int colonna, T valore){
		ArrayList<Record<T>> carrello = valori[riga];
		for(Record<T> item : carrello)
			if(item.colonna == colonna)
				throw new ItemAlreadyPresentExcetpion(ExceptionMsg.DUPLICATE + valore.toString());
		carrello.add(new Record<T>(valore,colonna));
	}
	
	public T valore(int riga, int colonna){
		ArrayList<Record<T>> carrello = valori[riga];
		for(Record<T> item : carrello)
			if(item.colonna == colonna)
				return item.valore;
		return defValue;
	}
	
	public int numeroRighe(){
		return this.nRow;
	}
	
	public int numeroColonne(){
		return this.nCol;
	}
	
	public int numValoriSignificativi(){
		int count = 0;
		for(int i = 0; i < valori.length; i++){
			ArrayList<Record<T>> carrello = valori[i];
			count += carrello.size(); //in ogni carrello ci sono soltanto valori significativi
		}
		return count;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			int rowScan = 0;
			int colScan = 0;
			
			@Override
			public boolean hasNext() {
				return rowScan < nRow;
			}

			@Override
			public T next() {
				T value = valore(rowScan, colScan);
				
				if(++colScan == nCol){
					colScan = 0;
					rowScan++;
				}
				return value;
			}
		};
	}

	@Override
	public String toString() {
		String matrix = "	     pane    burro         marmellata       biscotti        patatine       aranciata        cioccolata      prosciutto     formaggio   \n";
		int colScan = 0;
		int rowScan = 0;
		matrix += "carrello"+(rowScan+1)+"->   ";
		
		for(Object obj : this){
			T value = (T) obj;
			matrix += value.toString() + "	        ";
			if(++colScan == this.numeroColonne()){
				colScan = 0;
				if(++rowScan < this.numeroRighe())
				matrix += "\ncarrello"+(rowScan+1)+ "->   ";
			}
		}
		return matrix;
	}
}
