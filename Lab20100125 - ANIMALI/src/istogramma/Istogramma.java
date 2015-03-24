package istogramma;

import java.util.HashMap;

import animali.Animale;
import animali.Cane;
import animali.Gatto;
import animali.Leone;
import animali.Scorpione;
import animali.Tucano;
import serie.Serie;

public class Istogramma {

	private HashMap<Class, Integer> istogramma = new HashMap<Class, Integer>();
	
	public Istogramma(Serie<Animale> serie) {
		//Inizializzo l'istogramma. Ovviamente in fase di creazione ci sono 0 animali per specie.
		Class caneClass = new Cane().getClass();
		Class gattoClass = new Gatto().getClass();
		Class leoneClass = new Leone().getClass();
		Class tucanoClass = new Tucano().getClass();
		Class scorpioneClass = new Scorpione().getClass();
		istogramma.put(caneClass , 0);
		istogramma.put(gattoClass , 0);
		istogramma.put(leoneClass , 0);
		istogramma.put(tucanoClass , 0);
		istogramma.put(scorpioneClass , 0);
		
		/*
		 * Estraggo dalla serie un animale alla volta, vedo a che classe appartiene, ed aggiorno il valore associato alla classe
		 */
		for(Animale a : serie){
			if(a instanceof Cane){
				int caneCount = istogramma.get(caneClass);
				istogramma.remove(caneClass);
				istogramma.put(caneClass, caneCount+1);
			}else if(a instanceof Gatto){
				int gattoCount = istogramma.get(gattoClass);
				istogramma.remove(gattoClass);
				istogramma.put(gattoClass, gattoCount+1);
			}else if(a instanceof Leone){
				int leoneCount = istogramma.get(leoneClass);
				istogramma.remove(leoneClass);
				istogramma.put(leoneClass, leoneCount+1);
			}else if(a instanceof Tucano){
				int tucanoCount = istogramma.get(tucanoClass);
				istogramma.remove(tucanoClass);
				istogramma.put(tucanoClass, tucanoCount+1);
			}else if(a instanceof Scorpione){
				int scorpioneCount = istogramma.get(scorpioneClass);
				istogramma.remove(scorpioneClass);
				istogramma.put(scorpioneClass, scorpioneCount+1);
			}
		}
	}
	
	public void print(){
		for(Class c : istogramma.keySet()){
			int n = istogramma.get(c);
			while(n != 0){
				System.out.print("* ");
				n--;
			}
			String name = c.toString().replaceAll("class animali.", "");
			System.out.println(name);
		}
	}
}
