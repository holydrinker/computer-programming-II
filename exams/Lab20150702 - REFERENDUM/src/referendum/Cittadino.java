package referendum;

public class Cittadino implements Comparable {
	private static int idGen = 0;
	private String nome;
	private String cognome;
	private int id;
	
	public Cittadino(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		this.id = idGen++;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getCognome(){
		return this.cognome;
	}
	
	public int getId(){
		return this.id;
	}
	
	@Override
	public int compareTo(Object arg0) {
		Cittadino other = (Cittadino) arg0;
		if(this.getId() < other.getId())
			return -1;
		else if(this.getId() > other.getId())
			return +1;
		else
			return 0;
	}
}
