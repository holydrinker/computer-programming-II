package priorityQueue;



import java.util.LinkedList;

import processi.Process;


public class CodaLL<Item> extends PQL<Item> {

	public CodaLL() {
		super.coda = new LinkedList<Item>();
	}
	
	public static void main(String[] args) {
		PQL<Process> processi = new CodaLL<Process>();
		Process p4 = new Process("Peppo", 12);
		Process p1 = new Process("Marco", 3);
		Process p2 = new Process("Checco", 5);
		Process p3 = new Process("Papà", 6);
		
		processi.insert(p4);
		processi.insert(p1);
		processi.insert(p3);
		processi.insert(p2);
		processi.changePriority(p4, 1);
		
		processi.delFirst();
		for(Object o : processi.coda){
			System.out.println(((Process)o).toString());
		}
	}
}
