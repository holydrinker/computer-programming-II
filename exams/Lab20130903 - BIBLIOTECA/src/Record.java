
public class Record {
	private Volume volume;
	private boolean prestato;
	
	public Record(Volume volume) {
		this.volume = volume;
		this.prestato = false;
	}
	
	public Volume getVolume(){
		return this.volume;
	}
	
	public boolean getPrestato(){
		return this.prestato;
	}
	
	public void setPrestato(boolean pubblicato){
		this.prestato = pubblicato;
	}
}
