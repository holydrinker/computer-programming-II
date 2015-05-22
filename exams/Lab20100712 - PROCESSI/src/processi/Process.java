package processi;
import java.util.Random;


public class Process {
	public final int UNRUNNABLE = -1;
	public final int RUNNABLE = -2;
	public final int STOP = -3;
	private int id;
	private int priority;
	private String path;
	private int stato;
	
	public Process(String path, int priority) {
		this.id = new Random().nextInt(10000);
		this.stato = UNRUNNABLE;
		this.path = path;
		this.priority = priority;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getPath(){
		return this.path;
	}
	
	public void setPriority(int priority){
		this.priority = priority;
	}
	
	public int getPriority(){
		return this.priority;
	}
	
	public void setState(){
		if(stato == UNRUNNABLE || stato == STOP)
			stato = RUNNABLE;
		else{
			int n = new Random().nextInt(2);
			if(n==0)
				stato = UNRUNNABLE;
			else 
				stato = STOP;
		}
	}
	
	public int getState(){
		return this.stato;
	}
	
	@Override
	public String toString() {
		return "(" + this.path + "-" +this.priority + ")";
	}
}
