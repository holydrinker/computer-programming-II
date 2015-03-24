package skype;

public class Pacchetto {
	Utente mittente;
	Utente destinatario;
	int identificativo;
	String dati;
	boolean ultimo;
	
	public Pacchetto(int identificativo, String dati, boolean ultimo) {
		this.identificativo = identificativo;
		this.dati = dati;
		this.ultimo = ultimo;
	}
}
