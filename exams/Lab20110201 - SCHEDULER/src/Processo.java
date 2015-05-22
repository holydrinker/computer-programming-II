
public class Processo {
	private static int genId = 1;
	private int id;
	int durata;
	
	public Processo(int durata) {
		this.id = genId++;
		this.durata = durata;
	}
	
	public int getID(){
		return this.id;
	}
	
	@Override
	public String toString() {
		return "(" + id + ", " + durata + ") ";
	}
}
