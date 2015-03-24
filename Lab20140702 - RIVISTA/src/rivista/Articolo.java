package rivista;

import list.AddOnlyList;
import list.VectorList;

public class Articolo {
	private AddOnlyList<String> autori;
	private int volume;
	
	public Articolo() {
		autori = new VectorList<String>();
	}
	
	public void addAutore(String autore){
		autori.add(autore);
	}
	
	public String autoriToString(){
		return autori.toString();	
	}
	
	public int getVolume(){
		return this.volume;
	}
	
	public void setVolume(int volume){
		this.volume = volume;
	}
}
