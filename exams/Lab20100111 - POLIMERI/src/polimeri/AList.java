package polimeri;

import monomeri.Monomero;

public class AList implements ListaSemplice {

	private Object[] list = new Object[1];
	int n = 0;
	int count = 0;
	
	@Override
	public void add(Object o) {
		
		if(n == list.length){
			
			Object[] tmp = new Object[list.length * 2];
			for(int i = 0; i < list.length; i++)
				tmp[i] = list[i];
			list = tmp;
			
		}
			
		list[n] = o;
		n++;
		
	}

	@Override
	public void reset() {
		
		count = 0;

	}

	@Override
	public Object next() {
		
		return list[count - 1];
		
	}

	@Override
	public boolean hasNext() {
		
		int tmp = count;
		count++;
		return tmp < n;
		
	}
	
	@Override
	public String toString() {
		
		String res = "";
		Monomero monomero;
		
		while(hasNext()){
			monomero = (Monomero)next();
			res += monomero.getSymbol();
		}
	
		return res;
	}

}
