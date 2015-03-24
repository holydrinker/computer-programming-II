package list;

import java.util.Iterator;

public class Carrello<S> implements AddOnlyList<S> {
	
	private Record<S> dummy = new Record<S>(null);
	private static final int FORWARD = -1;
	private static final int BACKWARD = -2;
	//I seguenti due campi servono all'iteratore
	private Record<S> tmp;
	private int state = FORWARD;
	
	class Record<S>{
		S value;
		Record<S> prev;
		Record<S> next;
		
		public Record(S value) {
			this.value = value;
			prev = null;
			next = null;
		}
	}
	
	@Override
	public void add(S e) {
		Record<S> last = new Record<S>(e);
		
		if(dummy.next == null){
			dummy.next = last;
			dummy.prev = last;
			last.prev = dummy;
			last.next = dummy;
			//per evitare di avere un null pointer nell'iteratore
			tmp = dummy.next;
		} else {
			last.prev = dummy.prev;
			last.next = dummy;
			dummy.prev.next = last;
			dummy.prev = last;
		}
	}

	@Override
	public void forward() {
		this.state = FORWARD;
		tmp = dummy.next;
	}

	@Override
	public void backward() {
		this.state = BACKWARD;
		tmp = dummy.prev;
	}

	@Override
	public Iterator<S> iterator() {
		return new Iterator<S>(){
			
			@Override
			public boolean hasNext() {
				return tmp != dummy;
			}

			@Override
			public S next() {
				S value = tmp.value;
				if(state == FORWARD)
					tmp = tmp.next;
				else 
					tmp = tmp.prev;
				return value;
			}
		};
	}
}
