package frazioni;

public class Frazione {
	private String nome;
	private Event e;
	
	public Frazione(String nome, Event e) {
		this.nome = nome;
		this.e = e;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public Event getEvent(){
		return this.e;
	}
	
	public void setEvent(Event e){
		this.e = e;
	}
	
	@Override
	public boolean equals(Object obj) {
		Frazione f = (Frazione) obj;
		return this.nome.equals(f.nome);
	}
}
