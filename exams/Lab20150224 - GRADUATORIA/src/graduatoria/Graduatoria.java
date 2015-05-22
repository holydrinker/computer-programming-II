package graduatoria;

import java.util.Iterator;

import list.*;

public class Graduatoria implements Iterable {
	private ListaOrdinata graduatoria;
	
	public Graduatoria() {
		graduatoria = new WOListLinked();
	}
	
	public void aggG(float punteggio, Progetto progetto){
		graduatoria.insert(new Record(progetto, punteggio));
	}
	
	public float primoV(){
		for(Object o : graduatoria)
			return ((Record)o).punteggio;
		return 0f;
	}
	
	public Progetto primoP(){
		for(Object o : graduatoria)
			return ((Record)o).progetto;
		return null;
	}
	
	public void restoG(){
		ListaOrdinata tmp = new WOListLinked();
		int i = 0;
		for(Object o : graduatoria){
			if(i != 0)
				tmp.insert(((Record)o));
			i++;
		}
		graduatoria = tmp;
	}
	
	public int dim(){
		return graduatoria.numElementi();
	}
	
	public boolean ËVuota(){
		return graduatoria.numElementi() == 0;
	}
	
	public float media(){
		float sum = 0f;
		for(Object prog : graduatoria)
			sum += (float)((Record)prog).punteggio;
		return ((float)(sum / (float)graduatoria.numElementi()));
	}
	
	public boolean contenuta(Graduatoria g2){
		int count = 0;
		boolean found = false;
		for(Object p1 : graduatoria){
			for(Object p2 : g2)
				if(((Record)p1).compareTo((Record)p2) == 0){
					found = true;
					break;
				}
			if(found)
				count++;
		}
		if(count == graduatoria.numElementi())
			return true;
		else
			return false;
		
		/*
		 * METODO ALTERNATIVO
		 * 
		for(Object p1 : graduatoria){
			int count = g2.dim();
			for(Object p2 : g2.graduatoria){
				Record r1 = (Record) p1;
				Record r2 = (Record) p2;
				if(r1.compareTo(r2)!=0)
					count--;
			}
			if(count == 0)
				return false;
		}
		return true;
		*/
	}

	@Override
	public Iterator iterator() {
		return graduatoria.iterator();
	}
}
