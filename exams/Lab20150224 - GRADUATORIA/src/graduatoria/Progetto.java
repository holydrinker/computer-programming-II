package graduatoria;

public class Progetto {
	private String nome;
	private int codice;
	private static int codeGen = 0;
	
	public Progetto(String nome) {
		this.nome = nome;
		this.codice = codeGen++;
	}
	
	int codice(){
		return this.codice;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
}
