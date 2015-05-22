package list;

import java.util.Iterator;

public class ListDoubling<T> implements List<T> {

	Object[] list = new Object[1];
	int n = 0;
	
	@Override
	public boolean isEmpty() {
		
		return n == 0;
		
	}

	@Override
	public T readList(Position p) {
		
		if(!checkPosition(p))
			throw new IndexOutOfBoundsException(List.MSG_POS_NOT_VALID + ((Index)p).index);
		
		return (T) list[((Index) p).index];
	
	}

	@Override
	public void writeList(T elem, Position p) {
		
		if(!checkPosition(p))
			throw new IndexOutOfBoundsException(List.MSG_POS_NOT_VALID + ((Index)p).index);

		list[((Index) p).index] = elem;
		
	}

	@Override
	public Position firstList() {
		
		return new Index();
		
	}

	@Override
	public boolean endList(Position p) {
		
		return ((Index)p).index == n;
		
	}

	@Override
	public Position succList(Position p) {
		
		if(endList(p) || !checkPosition(p))
			throw new IndexOutOfBoundsException(List.MSG_POS_NOT_VALID + ((Index)p).index);
		
		Index pos = new Index();
		pos.index = ((Index)p).index + 1;
		return pos;
		
	}

	@Override
	public Position predList(Position p) {
		
		if(firstList() == p || !checkPosition(p))
			throw new IndexOutOfBoundsException(List.MSG_POS_NOT_VALID + ((Index)p).index);
		
		Index pos = new Index();
		pos.index = ((Index)p).index - 1;
		return pos;
		
	}

	@Override
	public void insList(T elem, Position p) {
		
		if(!checkPosition(p))
			throw new IndexOutOfBoundsException();
		
		int pos = ((Index)p).index;
		
		for(int i = pos + 1; i <= n; i++)
			list[i] = list[i-1];
		
		list[pos] = elem;
		n++;
		
		if(n == list.length){
			
			Object[] tmp = new Object[list.length * 2];
			Position idx = firstList();
			
			while(!endList(idx)){
				
				tmp[((Index)idx).index] = list[((Index)idx).index];
				idx = succList(idx);
				
			}

			list = tmp;
			
		}

	}

	@Override
	public void cancList(Position p) {
		
		if(!checkPosition(p) || endList(p))
			throw new IndexOutOfBoundsException(MSG_POS_NOT_VALID + ((Index)p).index);
		
		int pos = ((Index)p).index;
		
		for(int i = pos; i < n - 1; i++)
			list[i] = list[i+1];
		
		n--;

	}

	protected boolean checkPosition(Position p){
		
		Index pos = ((Index)p);
		
		if(pos.index < 0 || pos.index > n)
			return false;
		else
			return true;
		
	}
	
	@Override
	public Iterator<T> iterator() {
		
		return new ListDoublingIterator<T>(this);
		
	}
	
	@Override
	public String toString() {
		
		String result = "";
		
		for(int i = 0; i < n; i++){
			
			if(list[i] == null)
				result += "null ";
			else
				result += list[i] + " "; 
			
		}
		
		return result;
		
	}
	
	public static void main(String[] args){
		
		List<Integer> list = new ListDoubling<Integer>();
		Position pos = new Index();
		
		((Index)pos).index = 0;
		list.insList(0, pos);
		
		((Index)pos).index = 1;
		list.insList(1, pos);
		
		((Index)pos).index = 2;
		list.insList(2, pos);
	
		((Index)pos).index = 3;
		list.insList(3, pos);
		
		((Index)pos).index = 4;
		list.insList(4, pos);
		
		System.out.println("Struttura:");
		
		for(Integer x : list){
			
			System.out.print(x + " ");
			
		}
		
	}

	
	
}
