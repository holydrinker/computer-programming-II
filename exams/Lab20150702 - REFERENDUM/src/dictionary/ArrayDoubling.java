package dictionary;

import java.util.Arrays;
import java.util.Iterator;

import javax.management.openmbean.KeyAlreadyExistsException;

public class ArrayDoubling<S> implements Dictionary<S> {
	private Pair<S> array[] = new Pair[1];
	private int n = 0;

	private class Pair<S> {
		S item;
		Comparable key;

		public Pair(S item, Comparable key) {
			this.item = item;
			this.key = key;
		}
	}

	@Override
	public void insert(S e, Comparable k) {
		int i = 0;
		while (i < n) {
			if (array[i].key.compareTo(k) == 0)
				throw new KeyAlreadyExists();
			i++;
		}

		if (n < array.length) {
			array[n] = new Pair(e, k);
		} else {
			Pair tmp[] = new Pair[n * 2];
			System.arraycopy(array, 0, tmp, 0, n);
			tmp[n] = new Pair(e, k);
			array = tmp;
		}

		n++;
	}

	@Override
	public void delete(Comparable k) {
		int i = 0;
		boolean found = false;
		while (i < n && !found) {
			if (array[i].key.compareTo(k) == 0)
				found = true;
			else
				i++;
		}
		if(!found)
			throw new KeyNotFound();
		
		System.arraycopy(array, i+1, array, i, n-(i+1));
		n--;

		if(n == array.length / 4){
			Pair tmp [] = new Pair [array.length / 2];
			System.arraycopy(array, 0, tmp, 0, n);
			array = tmp;
		}
	}

	@Override
	public S search(Comparable k) {
		int i = 0;
		boolean found = false;
		while (i < n && !found) {
			if (array[i].key.compareTo(k) == 0)
				found = true;
			else
				i++;
		}
		if(!found)
			throw new KeyNotFound();
		
		return array[i].item;
	}

	@Override
	public Iterator<Comparable> iterator() {
		return new Iterator<Comparable>() {
			private int i = 0;
			
			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public Comparable next() {
				return array[i++].key;
			}
		};
	}

}
