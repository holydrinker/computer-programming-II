
public class Bene {
	private String name;
	private int quantita;
	private float importo;
	
	public Bene(String name, int quantita, float importo) {
		this.name = name;
		this.quantita = quantita;
		this.importo = importo;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getQuantita(){
		return this.quantita;
	}
	
	public float getImporto(){
		return this.importo;
	}
	
	@Override
	public boolean equals(Object obj) {
		Bene other = (Bene) obj;
		
		if(this.name.equals(other.getName()))
			if(this.quantita == other.getQuantita())
				if(this.importo == other.getImporto())
					return true;
		return false;
	}
}
