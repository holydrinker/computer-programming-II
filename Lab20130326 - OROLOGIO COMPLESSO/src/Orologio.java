import queue.CircQueue;
import queue.CircQueueArray;


public class Orologio<S> {
	protected CircQueue<S> queue;
	
	public Orologio(int numFrazioni) {
		this.queue = new CircQueueArray<S>(numFrazioni);
	}
	
	@Override
	public boolean equals(Object obj) {
		Orologio<S> other = (Orologio<S>) obj;
		return queue.equals(other.queue);
	}
	
}
