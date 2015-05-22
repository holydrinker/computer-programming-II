import java.util.ArrayList;


public class MatriceSparsaD<T> extends MatriceSparsa<T> {

	public MatriceSparsaD(int nRow, int nCol, T defValue) {
		super(nRow, nCol, defValue);
	}

	public int similarita(int idxTesto1, int idxTesto2){
		if(idxTesto1 > super.numeroRighe() || idxTesto2 > super.numeroRighe())
			throw new IndexOutOfBoundsException();
		
		int similarity = 0;
		ArrayList<Record<T>> testo1 = super.valori[idxTesto1];
		ArrayList<Record<T>> testo2 = super.valori[idxTesto2];
		
		for(int i = 0; i < super.numeroColonne(); i++){
			T v1 = testo1.get(i).valore;
			T v2 = testo2.get(i).valore;
			
			if(v1.equals(v2) && !v1.equals(super.defValue))
				similarity++;
		}
		return similarity;	
	}
}