import pila.EmptyStructureException;
import pila.Pila;

public abstract class Fattura {
	protected Pila<Bene> beni;
	protected Persona venditore;
	protected Persona compratore;
	protected String dataEmissione;
	
	public Fattura(Persona venditore, Persona compratore, String dataEmissione) {
		this.venditore = venditore;
		this.compratore = compratore;
		this.dataEmissione = dataEmissione;
	}
	
	public void aggiungiBene(String nome, int quantita, float importo){
		Bene nuovoBene = new Bene(nome, quantita, importo);
		beni.push(nuovoBene);
	}
	
	public String ultimoBene(){
		Bene ultimoBene;
		
		try {
			ultimoBene = beni.top();
		} catch (FatturaVuotaException e) {
			throw new EmptyStructureException(e.getMessage());
		}
		
		return ultimoBene.getName();
	}

	public int quantitaUltimoBene(){
		Bene ultimoBene;
		
		try {
			ultimoBene = beni.top();
		} catch (FatturaVuotaException e) {
			throw new EmptyStructureException(e.getMessage());
		}
		
		return ultimoBene.getQuantita();
	}
	
	public float importoUltimoBene(){
		Bene ultimoBene;
		
		try {
			ultimoBene = beni.top();
		} catch (FatturaVuotaException e) {
			throw new EmptyStructureException(e.getMessage());
		}
		
		return ultimoBene.getImporto();
	}
	
	public void rimuoviUltimoBene(){
		try {
			beni.pop();
		} catch (FatturaVuotaException e) {
			throw new EmptyStructureException(e.getMessage());
		}
	}
	
	public float totaleImport(){
		float totale = 0f;
		
		try {
			for(Object obj : beni){
				Bene bene = (Bene) obj;
				totale += (float)bene.getImporto();
			}
		} catch (FatturaVuotaException e) {
			throw new EmptyStructureException(e.getMessage());
		}
		
		return totale;
	}
	
	public int numeroBeniFatturati(){
		int count = 0;
		
		try {
			for(Object obj : beni)
				count++;
		} catch (FatturaVuotaException e) {
			return 0;
		}
		
		return count;
	}
	
	public boolean uguali(Fattura fattura){
		
		if(this.beni.isEmpty() && fattura.beni.isEmpty())
			return true;
		
		if(this.venditore.equals(fattura.venditore))
			if(this.compratore.equals(fattura.compratore))
				if(this.dataEmissione.equals(fattura.dataEmissione)){
				
					for(Object obj : this.beni){
						Bene bene = (Bene) obj;
						if(bene.equals(fattura.beni.top())){
							fattura.beni.pop();
						}
						else
							return false;
					}
				}
		
		if(fattura.beni.isEmpty())
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		String s = "Compratore: " + compratore.getNomeCognome() + "\n";
		s += "Venditore: " + venditore.getNomeCognome() + "\n";
		s += "Data Emissione: " + dataEmissione + "\n" + "LISTA: \n";
		
		for(Object obj : beni){
			Bene bene = (Bene) obj;
			s += bene.getName() + " ";
			s += "x " + bene.getQuantita() + " = ";
			s += bene.getImporto() + "€\n";
		}
		s += "\n";
		return s;
	}
}
