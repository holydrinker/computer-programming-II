package list;
import java.util.Iterator;


public class LinkedList<S> implements AddOnlyList<S> {
	private Record<S> head = null;
	private Record<S> end = null;
	
	class Record<S>{
		S value;
		Record<S> next;
		
		public Record(S value) {
			this.value = value;
			next = null;
		}
	}
	
	@Override
	public void add(S e) {
		Record<S> item = new Record<S>(e);
		
		if(head == null){
			head = item;
			end = item;
		} else {
			end.next = item;
			end = item;
		}		

	}
	
	@Override
	public Iterator<S> iterator() {
		return new Iterator<S>(){
			private Record<S> tmp = head;
			
			@Override
			public boolean hasNext() {
				return tmp != null;
			}

			@Override
			public S next() {
				S value = tmp.value;
				tmp = tmp.next;
				return value;
			}
		};
	}
	
}
