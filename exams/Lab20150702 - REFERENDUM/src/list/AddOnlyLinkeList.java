package list;

import java.util.Iterator;

public class AddOnlyLinkeList<S> implements AddOnlyList<S> {
	private Record head = null;
	private int n = 0;
	
	@Override
	public void add(S e) {
		if(head == null)
			head = new Record(e);
		else{
			Record tmp = head;
			while(tmp.next != null)
				tmp = tmp.next;
			tmp.next = new Record(e);
		}
		n++;
	}

	@Override
	public int size() {
		return n;
	}
	
	@Override
	public Iterator<S> iterator() {
		return new Iterator<S>(){
			private int i = 0;
			private Record ref = head;
			
			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public S next() {
				Record r = ref;
				ref = ref.next;
				i++;
				return r.e;
			}
		};
	}
	
	private class Record{
		S e;
		Record next;
		
		public Record(S e) {
			this.e = e;
		}
	}
}
