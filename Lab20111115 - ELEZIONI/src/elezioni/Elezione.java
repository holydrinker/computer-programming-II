package elezioni;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dictionary.Dictionary;
import dictionary.EmptyStructureException;
import dictionary.EntryAlreadyExistException;
import dictionary.EntryDoesntExistException;
import dictionary.LinkedDict;


public class Elezione {
	protected Dictionary<Integer> listeElettorali;
	protected int numVotanti;
	protected int numNulle = 0;
	protected int numBianche = 0;
	
	public Elezione(int numVotanti) {
		this.listeElettorali = new LinkedDict<Integer>();
		this.numVotanti = numVotanti;
	}
	
	public void aggiungiLista(ListaElettorale nuovaLista){
		try {
			listeElettorali.insert(0, nuovaLista);
		} catch (EntryAlreadyExistException e) {
			throw new ListAlreadyExists(e.getMessage());
		}
	}
	
	public void scrutinaVoto(Voto voto){
		if (voto.tipoVoto == TipoVoto.schedaNulla)
			this.numNulle++;
		else if (voto.tipoVoto == TipoVoto.schedaBianca)
			this.numBianche++;
		
		else{
			if(voto.tipoVoto != TipoVoto.schedaValida)
				return;
			ListaElettorale lista = voto.s;
			if(lista == null)
				return;
			
			try{
				int votiLista = listeElettorali.search(lista);
				listeElettorali.delete(lista);;
				listeElettorali.insert(votiLista+1, lista);
			} catch (EntryDoesntExistException e) {
				throw new ListDoesntExistException(e.getMessage());
			} catch (EmptyStructureException e) {
				throw new EmptyListsException(e.getMessage());
			} 
		}
	}
	
	public int numVoti(ListaElettorale lista){
		try{
			return listeElettorali.search(lista);
		} catch (EntryDoesntExistException e) {
			throw new ListDoesntExistException(e.getMessage());
		} catch (EmptyStructureException e) {
			throw new EmptyListsException(e.getMessage());
		} 
	}
	
	public int nulle(){
		return this.numNulle;
	}
	
	public int bianche(){
		return this.numBianche;
	}
	
	public List<String> elencoOrdinato(){
		ArrayList<ListaElettorale> liste = new ArrayList<ListaElettorale>();
		ArrayList<Integer> nVoti = new ArrayList<Integer>();
		
		for(Object obj : this.listeElettorali){
			ListaElettorale lista = (ListaElettorale) obj;
			int votiLista = this.listeElettorali.search(lista);
			liste.add(lista);
			nVoti.add(votiLista);
		}
		
		ListaElettorale[] listeArray = new ListaElettorale[liste.size()];
		for(int i = 0; i < liste.size(); i++)
			listeArray[i] = liste.get(i);
		
		int[] votiArray = new int[nVoti.size()];
		for(int i = 0; i < nVoti.size(); i++)
			votiArray[i] = nVoti.get(i);
		
		doubleSelectionSort(listeArray,votiArray);
		
		ArrayList<String> esiti = new ArrayList<String>();
		for(int i = 0; i < listeArray.length; i++)
			esiti.add(listeArray[i] + ": " + votiArray[i]);
		return esiti;
	}
	
	private void doubleSelectionSort(ListaElettorale[] listeArray, int[] votiArray){
		
		for(int i = 0; i < votiArray.length; i++){
			int min = i;
			
			for(int j = i; j < votiArray.length; j++){
				if(votiArray[j] < votiArray[i])
					min = j;
			}
			int tmpVoti = votiArray[i];
			votiArray[i] = votiArray[min];
			votiArray[min] = tmpVoti;
			
			ListaElettorale tmpListe = listeArray[i];
			listeArray[i] = listeArray[min];
			listeArray[min] = tmpListe;
		}
		
	}
	
	public int getNumVotanti(){
		return this.numVotanti;
	}
	
}
