package bussola;

import circlist.CircList;
import circlist.ListCircDC;

public class Bussola {
	CircList<Cardinale> bussola;
	
	public Bussola() {
		bussola = new ListCircDC<Cardinale>();
		bussola.addCircList(Cardinale.nord);
		bussola.addCircList(Cardinale.nordEst);
		bussola.addCircList(Cardinale.est);
		bussola.addCircList(Cardinale.sudEst);
		bussola.addCircList(Cardinale.sud);
		bussola.addCircList(Cardinale.sudOvest);
		bussola.addCircList(Cardinale.ovest);
		bussola.addCircList(Cardinale.nordOvest);
	}
	
	public void ruotaA(){
		bussola.ruotaAvanti();
	}
	
	public void ruotaI(){
		bussola.ruotaIndietro();
	}
	
	public Cardinale direzione(){
		return bussola.value();
	}
}
