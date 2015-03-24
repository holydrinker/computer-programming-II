import java.util.Random;

import priorityQueue.PQ;
import priorityQueue.PQA;


public class Test {

	static PQ<Process> stopped = new PQA<Process>();
	static PQ<Process> runnable = new PQA<Process>();
	static PQ<Process> unrunnable = new PQA<Process>();
	
	public static void main(String[] args) {
		
		int PROCESS_INSTANCE = 17;
		int MAX_PRIORITY = 101;
		
		for(int i = 0; i < PROCESS_INSTANCE; i++){
			int randomPriority = new Random().nextInt(MAX_PRIORITY);
			unrunnable.insert(new Process(generateRandomPath()), randomPriority);
		}

		int UPDATE_QUEUES = 20;
		for(int j = 0; j < UPDATE_QUEUES; j++){
			PQ<Process> randomQueue = getRandomQueue();
			changeStatePriority();
		}
		
		//OUTPUT
		System.out.println("STOPPED");
		for(Object p : stopped)
			System.out.println(((Process)p).toString());
		System.out.println("\n \n");
		
		System.out.println("RUNNABLE");
		for(Object p : runnable)
			System.out.println(((Process)p).toString());
		System.out.println("\n \n");
		
		System.out.println("UNRUNNABLE");
		for(Object p : unrunnable)
			System.out.println(((Process)p).toString());
		System.out.println("\n \n");
			
	}

	private static String generateRandomPath(){
		
		final int maxLengthPath = 7;
		final int lengthPath = new Random().nextInt(maxLengthPath + 5);
		final String matrix = "abcdefghilmnopqrstuvz123456789";
		String path = "System/Process/";
		
		for(int i = 0; i < lengthPath; i++)
			path += matrix.charAt(new Random().nextInt(matrix.length()));
		
		return path;
	}
	
	private static PQ<Process> getRandomQueue(){
		int idx = new Random().nextInt(3);
		
		if(idx == 0)
			return unrunnable;
		else if(idx == 1)
			return stopped;
		else
			return runnable;
	}
	
	private static void changeStatePriority(){
		
		PQ<Process> queue = getRandomQueue();
		if(queue.isNew())
			return;
			
		Process process = queue.first();
		int priority = queue.getPriority(process);
			
		if(queue == unrunnable)
			runnable.insert(process, eventuallyChangePriority(priority));
		else if(queue == stopped)
			runnable.insert(process, eventuallyChangePriority(priority));
		else{
			int selectState = new Random().nextInt(2);
			if(selectState == 0)
				unrunnable.insert(process, eventuallyChangePriority(priority));
			else
				stopped.insert(process, eventuallyChangePriority(priority));
		}
		queue.delFirst();
		
	}
	
	private static int eventuallyChangePriority(int priority){
		final int MAX_PRIORITY_RANGE = 101;
		final int PERC = 100;
		int probability = new Random().nextInt(PERC);
		
		if(probability < 10){
			priority = new Random().nextInt(MAX_PRIORITY_RANGE);
		}
		
		return priority;
	}
}
