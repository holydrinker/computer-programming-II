import frazioni.Event;
import frazioni.Minuto;
import frazioni.Ora;
import simplyClock.Orologio;

public class OrologioDaPolso {
	Orologio<Ora> ore;
	Orologio<Minuto> minuti;
	private static Event nullEvent = new Event("");
	
	public OrologioDaPolso() {
		//--Inizializzazione
		inizializzaOre();
		inizializzaMinuti();
		
		//--Stampa
		System.out.println("ORE");
		for(Object o : ore){
			Ora ora = (Ora) o;
			System.out.print(ora.getNome() + " ");
		}
		System.out.println("\nMINUTI");
		for(Object m : minuti){
			Minuto minuto = (Minuto) m;
			System.out.print(minuto.getNome() + " ");
		}
		
		System.out.println("\n");
	}
	
	public void start(){
		Ora oraCorrente = ore.value();		
		Minuto minutoCorrente = minuti.value();
		
		while(!(oraCorrente.getNome().equals("23") && minutoCorrente.getNome().equals("59"))){
			String nomeEvento = minutoCorrente.getEvent().toString();
			
			if(!(nomeEvento.equals("")))
				System.out.println(	oraCorrente.getNome() + ":" 
									+ minutoCorrente.getNome() + " " 
									+ minutoCorrente.getEvent().toString());
			
			//--rotazione orologio
			if(minutoCorrente.getNome().equals("59")){
				ore.rotateF();
				oraCorrente = ore.value();
			}
			minuti.rotateF();
			minutoCorrente = minuti.value();
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		OrologioDaPolso o = (OrologioDaPolso) obj;
		if(this.ore.equals(o.ore))
			if(this.minuti.equals(o.minuti))
				return true;
		return false;
	}
	
	private void inizializzaOre(){
		ore = new Orologio<Ora>();
		
		int NUM_ORE = 24;
		for(int i = NUM_ORE - 1; i >= 0; i--)
			ore.add(new Ora(i+"", null));
	}
	
	private void inizializzaMinuti(){
		minuti = new Orologio<Minuto>();
		
		int NUM_MINUTI = 60;
		for(int i = NUM_MINUTI - 1; i >= 0; i--){
			Event e = null;
			
			if(i == 0)
				e = new Event("Bip Bip");
			else if(i == 30)
				e = new Event("Bip");
			else 
				e = nullEvent;
			minuti.add(new Minuto(i+"", e));
		}
	}
}
