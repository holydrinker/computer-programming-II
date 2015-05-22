import java.util.HashMap;

import articoli.*;
import carrello.Carrello;


public class MarketBasketAnalysis {
	HashMap<Class,Integer> qTotArticoli = new HashMap<Class,Integer>();
	
	public MarketBasketAnalysis() {
		qTotArticoli.put(Articoli.class, 0);
		qTotArticoli.put(Alimenti.class, 0);
		qTotArticoli.put(Pane.class, 0);
		qTotArticoli.put(Burro.class, 0);
		qTotArticoli.put(Cereali.class, 0);
		qTotArticoli.put(Spaghetti.class, 0);
		qTotArticoli.put(Igene.class, 0);
		qTotArticoli.put(Sapone.class, 0);
		qTotArticoli.put(Dentifricio.class, 0);
		qTotArticoli.put(Casalinghi.class, 0);
		qTotArticoli.put(Tovagliolini.class, 0);
		qTotArticoli.put(Piatti.class, 0);
	}
	
	void add(Carrello<Item> trolley){
		for(Object obj : trolley){
			Item item = (Item) obj;
			Articoli articolo = item.getArticolo();
			int qtaArticolo = item.getQuantita();
			
			//--Update totale
			int qtaTot = qTotArticoli.get(Articoli.class);
			qTotArticoli.remove(Articoli.class);
			qTotArticoli.put(Articoli.class, qtaTot + qtaArticolo);
			
			//--Update categoria
			if(articolo instanceof Alimenti){
				int qtaAlimenti = qTotArticoli.get(Alimenti.class);
				qTotArticoli.remove(Alimenti.class);
				qTotArticoli.put(Alimenti.class, qtaAlimenti + qtaArticolo);
			} else if(articolo instanceof Igene ){
				int qtaIgene = qTotArticoli.get(Igene.class);
				qTotArticoli.remove(Igene.class);
				qTotArticoli.put(Igene.class, qtaIgene + qtaArticolo);
			} else if(articolo instanceof Casalinghi){
				int qtaCasa= qTotArticoli.get(Casalinghi.class);
				qTotArticoli.remove(Casalinghi.class);
				qTotArticoli.put(Casalinghi.class, qtaCasa + qtaArticolo);
			}
			
			//--Update articolo
			Class classeArticolo = articolo.getClass();
			int qtaPrecArt = qTotArticoli.get(classeArticolo);
			qTotArticoli.remove(classeArticolo);
			qTotArticoli.put(classeArticolo, qtaPrecArt + qtaArticolo);
		}	
	}
	
	@Override
	public String toString() {
		String s = "";
		for(Class classe : qTotArticoli.keySet()){
			int qta = qTotArticoli.get(classe);
			s += classe.toString().substring(15) + " " + qta + "\n";
		}
		return s;
	}
}
