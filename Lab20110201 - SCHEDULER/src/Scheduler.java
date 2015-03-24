import java.util.Random;

import circlist.CircList;
import circlist.EmptyCircListException;
import circlist.ListaCircCollegata;

public class Scheduler {
	static CircList<Processo> list;
	
	public Scheduler() {
		list = new ListaCircCollegata<Processo>();
	}
	
	void addProcess(){
		int durata = new Random().nextInt(751) + 50;
		list.addCircList(new Processo(durata));
	}
	
	void executeProcess(int TIME_SLICES){
		Processo p = list.value();
		p.durata -= TIME_SLICES;
		if(p.durata <= 0){
			list.delCircList();
			System.out.println("Processo " + p.getID() + " completato");
		}
	}
	
	public static void main(String[] args) {
		int ITERATIONS = 9;
		final int TIME_SLICES = 100;
		int i = 0;
		Scheduler scheduler = new Scheduler();
		
		for(i = 0; i < ITERATIONS; i++){
			System.out.println("Iterata " + (i+1));
			for(Object processo : list)
				System.out.print(((Processo)processo).toString());
			System.out.println("");
			
			scheduler.addProcess();
			scheduler.executeProcess(TIME_SLICES);
			list.ruotaAvanti();		
		}
		
		while(!list.isEmpty()){
			System.out.println("Iterata " + (i++));
			for(Object processo : list)
				System.out.print(((Processo)processo).toString());
			System.out.println("");
			
			scheduler.executeProcess(TIME_SLICES);
			try {
				list.ruotaAvanti();
			} catch (EmptyCircListException e) {
				
			}
		}
	}
}
