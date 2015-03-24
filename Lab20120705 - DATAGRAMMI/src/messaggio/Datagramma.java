package messaggio;
import java.net.InetAddress;


public class Datagramma {
	InetAddress sorgente;
	InetAddress destinazione;
	int identificativo;
	String dati;
	boolean ultimo;
	
	public Datagramma(int identificativo, String dati) {
		this.identificativo = identificativo;
		this.dati = dati;
		this.ultimo = false;
	}
}
