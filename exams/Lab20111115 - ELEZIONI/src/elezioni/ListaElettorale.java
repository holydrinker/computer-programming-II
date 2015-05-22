package elezioni;
import java.util.List;


public class ListaElettorale implements Comparable {
	private String nomeLista;
	private List<String> listaCandidati;
	
	public ListaElettorale(String nomeLista) {
		this.nomeLista = nomeLista;
	}

	@Override
	public int compareTo(Object o) {
		ListaElettorale lista = (ListaElettorale) o;
		return this.nomeLista.compareTo(lista.nomeLista);
	}
	
	@Override
	public String toString() {
		return this.nomeLista.toUpperCase();
	}
	
}
