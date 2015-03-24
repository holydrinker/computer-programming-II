import java.util.Random;
import priorityQueue.CodaLL;
import priorityQueue.PQL;
import processi.Process;

public class Test {
	public static final int UNRUNNABLE = -1;
	public static final int RUNNABLE = -2;
	public static final int STOP = -3;
	
	public static void main(String[] args) {
		PQL<Process> unrunnable = new CodaLL<Process>();
		PQL<Process> runnable = new CodaLL<Process>();
		PQL<Process> stop = new CodaLL<Process>();
		
		int INSTANCES = 15;
		for(int i = 0; i < INSTANCES; i++){
			Process p = new Process("Documenti/Esami/Luglio2012/Processi/"+generateFileName(), new Random().nextInt(101));
			System.out.println("Nuovo inserimento in unrunnable: " + p.toString());
			unrunnable.insert(p);
		}
	
		int unrunnableSize = unrunnable.size();
		for(int i = 0; i < unrunnableSize; i++){
			Process p = (Process) unrunnable.first();
			p.setState();
			System.out.println("Nuovo inserimento in runnable: " + p);
			runnable.insert(p);
			unrunnable.delFirst();
		}
		
		int runnableSize = runnable.size();
		for(int i = 0; i < runnableSize; i++){
			Process p = (Process) runnable.first();
			p.setState();
			if(p.getState() == UNRUNNABLE){
				System.out.println("Nuovo inserimento in unrunnable: " + p.toString());
				unrunnable.insert(p);
			} else if (p.getState() == STOP) {
				System.out.println("Nuovo inserimento in stop: " + p.toString());
				stop.insert(p);
			}
			runnable.delFirst();
		}
		
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("UNRUNNABLE completo");
		for(Object o : unrunnable)
			System.out.println(((Process)o).toString());
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("RUNNABLE svuotato");
		for(Object o : runnable)
			System.out.println(((Process)o).toString());
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("STOP completo");
		for(Object o : stop)
			System.out.println(((Process)o).toString());
		System.out.println("------------------------------------------------------------------------------------");
	}
	
	private static String generateFileName(){
		String matrix = "abcdefghilmnopqrstuvz";
		String s = "";
		for(int i = 0; i < 5; i++)
			s += matrix.charAt(new Random().nextInt(matrix.length()));
		return s;
	}
}
