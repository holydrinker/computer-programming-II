

import java.util.Random;

public class Process {

	String path;
	int ID;
	private final int MAX_ID_VALUE = 1000;
	
	public Process(String path) {
		this.path = path;
		this.ID = getID();
	}
	
	public int getID(){
		return new Random().nextInt(MAX_ID_VALUE);
	}
	
	public String getPath(){
		return this.path;
	}
	
	public String toString(){
		String s = "";
		s += "Path: " + this.path;
		s += " ID: " + this.ID;
		return s;
	}
}
