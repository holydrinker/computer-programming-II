import java.util.HashMap;

import articoli.*;
import list.Carrello;

public class MarketBasketAnalysis {
	HashMap<Class, Integer> qTotArticolo = new HashMap<Class,Integer>();
	
	public MarketBasketAnalysis() {
		qTotArticolo.put(Articolo.class, 0);
		qTotArticolo.put(Alimenti.class, 0);
		qTotArticolo.put(Casalinghi.class, 0);
		qTotArticolo.put(Cereali.class, 0);
		qTotArticolo.put(Dentifricio.class, 0);
		qTotArticolo.put(Igene.class, 0);
		qTotArticolo.put(Piatti.class, 0);
		qTotArticolo.put(Sapone.class, 0);
		qTotArticolo.put(Spaghetti.class, 0);
		qTotArticolo.put(Tovagliolini.class, 0);
		qTotArticolo.put(Burro.class, 0);
		qTotArticolo.put(Pane.class, 0);
	}
	
	public void add(Carrello<Item> trolley){
	
		for(Object item : trolley){
			
			Articolo articolo = ((Item)item).getArticolo();
			int qtaAgg = ((Item)item).getQuantita(); 
			
			/*
			 * Aggiorno il totale degli articoli
			 */
			int qtaArt = qTotArticolo.get(Articolo.class);
			qTotArticolo.remove(Articolo.class);
			qTotArticolo.put(Articolo.class, qtaArt + qtaAgg);
			
			/*
			 * Contrllo per ogni sottocategoria di articolo a chi appartiene, e aggiorno i contatori
			 */
			if ( articolo instanceof Alimenti ){
				int qtaAli = qTotArticolo.get(Alimenti.class);
				qTotArticolo.remove(Alimenti.class);
				qTotArticolo.put(Alimenti.class, qtaAli + qtaAgg);
			} else if (articolo instanceof Igene ) {
				int qtaIge = qTotArticolo.get(Igene.class);
				qTotArticolo.remove(Igene.class);
				qTotArticolo.put(Igene.class, qtaIge + qtaAgg);
			} else if (articolo instanceof Casalinghi ) {
				int qtaCas = qTotArticolo.get(Casalinghi.class);
				qTotArticolo.remove(Casalinghi.class);
				qTotArticolo.put(Casalinghi.class, qtaCas + qtaAgg);
			}
			
			/*
			 * Controllo infinite per l'appartenenza alla classe foglia
			 */
			Class foglia = articolo.getClass();
			int qtaFog = qTotArticolo.get(foglia);
			qTotArticolo.remove(foglia);
			qTotArticolo.put(foglia, qtaFog + qtaAgg);
		}	
		
	}

	@Override
	public String toString() {
		String s = "";
		
		for(Class c : qTotArticolo.keySet()){
			String nomeClasse = c.getName();
			nomeClasse = nomeClasse.substring(9, nomeClasse.length());
			int qta = qTotArticolo.get(c);
			s += nomeClasse + " " + qta + "\n"; 
		}
		return s;
	}	
}
