package frazioni;

public class Event {
	private String nomeEvento;
	
	public Event(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	
	@Override
	public String toString() {
		return this.nomeEvento.toString();
	}
}
