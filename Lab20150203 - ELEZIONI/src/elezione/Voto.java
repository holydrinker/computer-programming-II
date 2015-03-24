package elezione;


public class Voto {
	Scheda scheda;
	ListaElettorale listaVotata;
	
	public Voto(ListaElettorale s) {
		this.listaVotata = s;
		
		if(s==null)
			scheda = Scheda.nulla;
		else
			scheda = Scheda.valida;
	}
	
	public Voto() {
		scheda = Scheda.bianca;
	}
	
	boolean nullo(){
		return scheda == Scheda.nulla;
	}
	
	boolean bianca(){
		return scheda == Scheda.bianca;
	}
	
	ListaElettorale voto(){
		if(scheda == Scheda.valida)
			return this.listaVotata;
		return null;
	}
}
