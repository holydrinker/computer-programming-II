package messaggio;
import lista.IndexedList;
import lista.ListaIndicizzata;
import lista.NotEmptyCellException;


public class Messaggio {
	private ListaIndicizzata<Datagramma> messaggio = new IndexedList<Datagramma>();
	private int ultimo = -1;
	
	public void addDatagramma(Datagramma datagramma){
		
		try {
			messaggio.addElement(datagramma, datagramma.identificativo);
		} catch (NotEmptyCellException e) {
			throw new FullPositionException(e.getMessage());
		}
	}

	public boolean completo(){
		
		int[] fullCellIdx = new int[messaggio.numberElements()];
		int i = 0;
		
		for(Object obj : messaggio){
			Datagramma datagramma = (Datagramma) obj;
			fullCellIdx[i] = datagramma.identificativo;
			i++;
		}
		
		int j = 0;
		boolean completo = true;
		while(j < fullCellIdx.length-1 && completo){
			if(!(fullCellIdx[j] == fullCellIdx[j++]))
				completo = false;
			else
				j++;
		}
		return completo;
	}
	
	@Override
	public String toString() {
		String s = "";
		
		for(Object obj : messaggio){
			Datagramma datagramma = (Datagramma) obj;
			s += datagramma.dati + " ";
		}
		return s;
	}
	
	public boolean confronta(Messaggio other){
		
		if(!this.completo() || !other.completo())
			return false;
		
		return messaggio.toString().equals(other.toString());

	}
}
