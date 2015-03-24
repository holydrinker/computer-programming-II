package carrello;

import java.util.Iterator;

public class Carrello<S> implements AddOnlyList<S> {
	private Record<S> dummy = new Record<S>(null);
	private Record<S> first;
	private static int FORWARD = -1;
	private static int BACKWARD = -2;
	private int direction = FORWARD;
	
	class Record<S>{
		S item;
		Record<S> prev;
		Record<S> next;
		
		public Record(S item) {
			this.item = item;
			prev = null;
			next = null;
		}
	}

	@Override
	public void add(S e) {
		Record<S> last = new Record<S>(e);
		
		if(dummy.next == null){
			last.prev = dummy;
			last.next = dummy;
			dummy.prev = last;
			dummy.next = last;
		} else {
			last.prev = dummy.prev;
			last.next = dummy;
			dummy.prev.next = last;
			dummy.prev = last;
		}
	}

	@Override
	public void forward() {
		direction = FORWARD;
		first = dummy.next;
	}

	@Override
	public void backward() {
		direction = BACKWARD;
		first = dummy.prev;
	}
	
	@Override
	public Iterator<S> iterator() {
		return new Iterator<S>(){

			@Override
			public boolean hasNext() {
				return first != dummy;
			}

			@Override
			public S next() {
				S item = first.item;
				if(direction == FORWARD)
					first = first.next;
				else if(direction == BACKWARD)
					first = first.prev;
				return item;
			}
		};
	}
}
