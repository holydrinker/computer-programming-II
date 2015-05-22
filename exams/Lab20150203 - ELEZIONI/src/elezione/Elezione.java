package elezione;

import java.util.ArrayList;
import java.util.List;

import dictionary.*;

//lol
public class Elezione {
	protected Dictionary<Integer> listeElettorali;
	private int numSchedeNulle = 0;
	private int numSchedeBianche = 0;
	private static final int DIM = 5;
	
	public Elezione() {
		listeElettorali = new HashDict<Integer>(DIM);
	}
	
	public void aggiungiLista(ListaElettorale lista){
		try {
			listeElettorali.insert(0, lista);
		} catch (KeyAlreadyExistsException e) {
			throw new ListaElettoraleDuplicataException(e.getMessage());
		}
	}
	
	public void scrutinaVoto(Voto voto){
		if(voto.bianca())
			numSchedeBianche++;
		else if (voto.nullo())
			numSchedeNulle++;
		else{
			ListaElettorale lista = voto.listaVotata;
			try {
				int votiLista = listeElettorali.search(lista);
				listeElettorali.delete(lista);
				listeElettorali.insert(votiLista+1, lista);
			} catch (KeyDoesntExistException e) {
				throw new ListaElettoraleNonPresente(e.getMessage());
			} catch (EmptyStructureException e) {
				throw new ListeVuoteException(e.getMessage());
			}
		}
	}
	
	public int numeroVoti(ListaElettorale lista){
		int votiLista;
		try {
			votiLista = listeElettorali.search(lista);
		} catch (KeyDoesntExistException e) {
			throw new ListaElettoraleNonPresente(e.getMessage());
		} catch (EmptyStructureException e) {
			throw new ListeVuoteException(e.getMessage());
		}
		
		return votiLista;
	}
	
	public int nulle(){
		return this.numSchedeNulle;
	}
	
	public int bianche(){
		return this.numSchedeBianche;
	}
	
	public List<ListaElettorale> elencoOrdinato(){
		List<ListaElettorale> elencoOrdinato = new ArrayList<ListaElettorale>();
		
		for(Object obj : listeElettorali){
			ListaElettorale lista = (ListaElettorale) obj;
			int numVoti = listeElettorali.search(lista);
			boolean inserito = false;
			
			if(elencoOrdinato.isEmpty())
				elencoOrdinato.add(lista);
			else{
				for(int i = 0; i < elencoOrdinato.size(); i++){
					int tmpVoti = listeElettorali.search(elencoOrdinato.get(i));
					if(numVoti <= tmpVoti){
						elencoOrdinato.add(i, lista);
						inserito = true;
						break;
					}
				}
				if(!inserito)
					elencoOrdinato.add(lista);
			}
		}
		return elencoOrdinato;
	}	
}
