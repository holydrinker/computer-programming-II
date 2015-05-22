package orologio;
import queue.CircQueue;
import queue.CircQueueArray;
import queue.EmptyQueueException;
import queue.FullQueueException;


public class Orologio<S> {
	protected CircQueue<S> queue;
	
	public Orologio(int numFrazioni) {
		this.queue = new CircQueueArray<S>(numFrazioni);
	}
	
	public void add(S nuovo){
		try {
			queue.add(nuovo);
		} catch (FullQueueException e) {
			throw new FullClockException(e.getMessage());
		}	
	}
	
	public S value(){
		try {
			return queue.value();
		} catch (EmptyQueueException e) {
			throw new EmptyClockException(e.getMessage());
		}
	}
	
	public boolean isFull(){
		if(this.queue.isEmpty())
			return false;
		
		int count = 0;
		for(S obj : this.queue)
			count++;
		return count == this.queue.size();
	}
	
	public void rotateF(){
		try {
			queue.rotateF();
		} catch (EmptyQueueException e) {
			throw new EmptyClockException(e.getMessage());
		}
	}
	
	public int size(){
		return queue.size();
	}
	
	public void stop(){
		queue.stop();
	}
	
	public void restart(){
		queue.restart();
	}
	
	public boolean equals(Orologio<S> clock) {
		return queue.equals(clock.queue);
	}
}
