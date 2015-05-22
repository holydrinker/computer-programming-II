
public class Autore {
	private String nome;
	private String cognome;
	private String affiliazione;
	
	public Autore(String nome, String cognome, String affiliazione) {
		this.nome = nome;
		this.cognome = cognome;
		this.affiliazione = affiliazione;
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + " Cognome: " + cognome + " Affiliazione: " + affiliazione;
	}
}
