
public class Persona {
	private String nomeCognome;
	
	public Persona(String nomeCognome) {
		this.nomeCognome = nomeCognome;
	}
	
	public String getNomeCognome(){
		return this.nomeCognome;
	}
	
	@Override
	public boolean equals(Object obj) {
		Persona other = (Persona) obj;
		return this.nomeCognome.equals(other.getNomeCognome());
	}
}
