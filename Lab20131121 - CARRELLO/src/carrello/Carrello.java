package carrello;

import java.util.Iterator;

import dictionary.Dictionary;
import dictionary.EmptyStructureException;
import dictionary.EntryDoesntExistException;
import dictionary.LinkedDict;


public class Carrello implements Iterable<Articolo> {
	protected Dictionary<Integer> cart;
	
	public Carrello() {
		cart = new LinkedDict<Integer>();
	}
	
	public void aggiungiArticolo(Articolo a){
		int qta = 0;
		
		try {
			qta = cart.search(a);
			cart.delete(a);
			
		} catch (EntryDoesntExistException e) {
			qta = 0;
		} catch (EmptyStructureException e) {
			qta = 0;
		} 
		
		cart.insert(a, qta+1);	
	}
	
	public void togliArticolo(Articolo a){
		int qta;
		
		try {
			qta = cart.search(a);
			
		} catch (EmptyStructureException e) {
			throw new EmptyCartException(e.getMessage());
		}
		
		cart.delete(a);
		
		if(qta>1)
			cart.insert(a, qta-1);	
	}
	
	public int quantit‡(Articolo a){
		int qta;
		
		try {
			qta = cart.search(a);
			
		} catch (EmptyStructureException e) {
			throw new EmptyCartException(e.getMessage());
		} catch (EntryDoesntExistException e) {
			throw new ArticleNotInCartException(e.getMessage());
		}
		
		return qta;
	}
	
	public boolean ËVuoto(){
		
		try {
			cart.delete(new Articolo("",""));
			
		} catch (EmptyStructureException e) {
			return true;
		}
		
		return false;
	}
	
	public boolean appartiene(Articolo a){
		int qta;
		
		try {
			qta = cart.search(a);
		} catch (EntryDoesntExistException e) {
			qta = 0;
		} catch (EmptyStructureException e) {
			throw new EmptyCartException(e.getMessage());
		}
		
		return qta != 0;
	}
	
	public int numArticoliDistinti(){		
		int num = 0;
		for(Object o : cart)
			num = num+1;
		
		if(num == 0)
			throw new EmptyCartException();
		return num;
	}
	
	@Override
	public Iterator<Articolo> iterator() {
		return (Iterator)cart.iterator();
	}
}
