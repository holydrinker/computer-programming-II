import java.util.Random;

public class Processo {
	private static int idGen = 0;
	private int id;
	private int durata;
	
	public Processo() {
		this.id = this.idGen++;
		this.durata = new Random().nextInt(751) + 50;
	}
	
	public boolean exectute(int time_slice){
		durata -= time_slice;
		return durata <= 0;
	}
	
	public int getID(){
		return this.id;
	}
	
	public int getDurata(){
		return this.durata;
	}
}
