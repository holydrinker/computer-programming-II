package istogramma;
import java.util.Comparator;
import java.util.Iterator;

import serie.Serie;
import dictionary.ArrayOrdinato;
import dictionary.Dictionary;
import dictionary.EmptyStructureException;
import dictionary.EntryAlreadyExists;
import dictionary.EntryDoesntExist;


public class Istogramma<T> implements Iterable<T> {
	protected Dictionary<Serie<T>> istogr;
	
	public Istogramma() {
		istogr = new ArrayOrdinato<Serie<T>>();
	}
	
	public void aggiungiSerie(String nomeSerie){
		try {
			istogr.insert(new Serie<T>(), nomeSerie);
			
		} catch (EntryAlreadyExists e) {
			throw new SerieAlreadyExistsException(e.getMessage());
		}
	}
	
	public void aggiungiValore(String nomeSerie, T valore){
		try {
			Serie<T> serie = (Serie<T>)istogr.search(nomeSerie);
			istogr.delete(nomeSerie);
			serie.add(valore);
			istogr.insert(serie, nomeSerie);
			
		} catch (EmptyStructureException e) {
			throw new EmptyIstogrammaException(e.getMessage());
		} catch (EntryDoesntExist e) {
			throw new SerieDoesntExistException(e.getMessage());
		}
	}
	
	public int lunghezzaSerie(String nomeSerie){
		try {
			Serie<T> serie = istogr.search(nomeSerie);
			return serie.numberElements();
			
		} catch (EmptyStructureException e) {
			throw new EmptyIstogrammaException(e.getMessage());
		} catch (EntryDoesntExist e) {
			throw new SerieDoesntExistException(e.getMessage());
		}
	}
	
	public T valore(String nomeSerie, int pos){
		try {
			Serie<T> serie = istogr.search(nomeSerie);
			return serie.getElement(pos);
			
		} catch (EmptyStructureException e) {
			throw new EmptyIstogrammaException(e.getMessage());
		} catch (EntryDoesntExist e) {
			throw new SerieDoesntExistException(e.getMessage());
		}
	}
	
	public T massimo(String nomeSerie, Comparator comparator){
		try {
			Serie<T> serie = istogr.search(nomeSerie);
			return serie.getMaximum(comparator);
			
		} catch (EmptyStructureException e) {
			throw new EmptyIstogrammaException(e.getMessage());
		} catch (EntryDoesntExist e) {
			throw new SerieDoesntExistException(e.getMessage());
		}
	}
	
	public boolean crescente(String nomeSerie, Comparator comparator){
		try {
			Serie<T> serie = istogr.search(nomeSerie);
			return serie.growing(comparator);
			
		} catch (EmptyStructureException e) {
			throw new EmptyIstogrammaException(e.getMessage());
		} catch (EntryDoesntExist e) {
			throw new SerieDoesntExistException(e.getMessage());
		}
	}

	@Override
	public Iterator<T> iterator() {
		return (Iterator<T>) this.istogr.iterator();
	}
}
