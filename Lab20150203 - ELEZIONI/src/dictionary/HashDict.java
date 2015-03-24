package dictionary;

import java.util.Iterator;
import java.util.LinkedList;

public class HashDict<S> implements Dictionary<S> {
	LinkedList<Pair<S>>[] s;
	private int n = 0;
	
	public HashDict(int n) {
		s = new LinkedList[n];
		
		for(int i = 0; i < s.length; i++)
			s[i] = new LinkedList<Pair<S>>();
	}
	
	@Override
	public void insert(S e, Comparable k) {
		int pos = h(k);
		
		for(Object obj : s[pos]){
			Pair<S> pair = (Pair<S>) obj;
			if(pair.key.equals(k))
				throw new KeyAlreadyExistsException(ExceptionMessages.MSG_DUPLICATE);
		}
		s[pos].add(new Pair<S>(e,k));
		n++;
	}

	@Override
	public void delete(Comparable k) {
		if(n==0)
			throw new EmptyStructureException(ExceptionMessages.MSG_EMPTY);
		
		int pos = h(k);
		boolean found = false;
		int i;
		
		for(i = 0; i < s[pos].size(); i++){
			Pair<S> pair = s[pos].get(i);
			if(pair.key.equals(k)){
				found = true;
				break;
			}
		}
		if(!found)
			throw new KeyDoesntExistException(ExceptionMessages.MSG_NOTIN);
		s[pos].remove(i);
		n--;
	}

	@Override
	public S search(Comparable k) {
		if(n==0)
			throw new EmptyStructureException(ExceptionMessages.MSG_EMPTY);
		
		int pos = h(k);
		for(Object obj : s[pos]){
			Pair<S> pair = (Pair<S>) obj;
			if(pair.key.equals(k))
				return pair.item;
		}
		throw new KeyDoesntExistException(ExceptionMessages.MSG_NOTIN);
	}

	@Override
	public Iterator iterator() {
		return new Iterator<Comparable>(){
			int i = 0;
			Pair<S> pair;
			Iterator<Pair<S>> it = null;
			
			@Override
			public boolean hasNext() {
				if(it == null)
					it = s[0].iterator();
				
				while(!it.hasNext()){
					if(++i < s.length)
						it = s[i].iterator();
					else
						return false;
				}
				
				pair = it.next();
				return true;
			}

			@Override
			public Comparable next() {
				return pair.key;
			}};
	}
	
	@Override
	public String toString() {
		String s = "";
		for(S pair : this)
			s += pair.toString() + " ";
		return s;
	}
	
	/*
	 * Funzione Hash
	 */
	private int h(Comparable k){
		return Math.abs(k.hashCode() % s.length);
	}
	
	/*
	 * Inner class
	 */
	private class Pair<S>{
		S item;
		Comparable key;
		
		public Pair(S item, Comparable k) {
			this.item = item;
			this.key = k;
		}
	}
	
	/*
	 * Testing my hash table
	 
	public static void main(String[] args) {
		Dictionary<String> d = new HashDict<String>(5);
		d.insert("item1", "key1");
		d.insert("item2", "key2");
		d.insert("item3", "key3");
		d.insert("item4", "key4");
		d.insert("item5", "key5");
		d.insert("item3", "key6");
		d.insert("item4", "key7");
		d.insert("item5", "key8");
		
		d.delete("key2");
		System.out.println(d.toString());
	}
	*/
}
