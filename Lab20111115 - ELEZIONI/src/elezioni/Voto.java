package elezioni;

public class Voto {
	TipoVoto tipoVoto;
	ListaElettorale s = null;
	
	public Voto(ListaElettorale s) {
		if(s == null)
			this.tipoVoto = TipoVoto.schedaNulla;
		else{
			this.tipoVoto = TipoVoto.schedaValida;
				this.s = s;
		}
	}
	
	public Voto() {
		tipoVoto = TipoVoto.schedaBianca;
	}

	public boolean nullo(){
		return (this.tipoVoto == TipoVoto.schedaNulla);
	}
	
	public boolean bianca(){
		return this.tipoVoto == TipoVoto.schedaBianca;
	}
	
	public ListaElettorale voto(){
		if(this.tipoVoto == TipoVoto.schedaValida)
			return this.s;
		else
			return null;
	}
}
