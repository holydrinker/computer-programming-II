package elezione;

import java.util.List;


public class ListaElettorale implements Comparable {
	private String nomeLista;
	private List<String> nomiCandidati;
	
	public ListaElettorale(String nomeLista) {
		this.nomeLista = nomeLista;
	}

	public String getNomeLista(){
		return this.nomeLista;
	}
	
	@Override
	public int compareTo(Object otherList) {
		ListaElettorale lista = (ListaElettorale) otherList;
		int compare = this.nomeLista.compareTo(lista.getNomeLista());
		
		if(compare < 0)
			return -1;
		else if(compare > 0)
			return 1;
		else
			return 0;
	}
	
	public void print(){
		System.out.println(this.nomeLista.toUpperCase());
	}
}
