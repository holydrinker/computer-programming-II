import circlist.CircList;
import circlist.ListaCircDL;


public class Scheduler {

	public static void main(String[] args) {
		CircList<Processo> processi = new ListaCircDL<Processo>();
		int NUM_PROC = 9;
		final int TIME_SLICES = 100;
		
		for(int i = 0; i < NUM_PROC; i++){
			Processo p = new Processo();
			processi.addCircList(p);
			
			for(Object obj : processi){
				Processo proc = (Processo) obj;
				System.out.print("(" + proc.getID() + " , " + proc.getDurata() + ") ");
			}
			System.out.println("");
			
			if(p.exectute(TIME_SLICES))
				processi.delCircList();
			processi.ruota();
		}
		
		while(processi.isEmpty()){
			Processo p = processi.value();
			if(p.exectute(TIME_SLICES))
				processi.delCircList();
			
			System.out.print("(" + p.getID() + " , " + p.getDurata() + ") ");
			System.out.println("");
			
			processi.ruota();
		}
	}
	
}
