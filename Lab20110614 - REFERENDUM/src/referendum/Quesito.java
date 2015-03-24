package referendum;

import java.util.ArrayList;

public class Quesito<T> implements AddOnlyQueue<T> {

	public String quesito;
	private ArrayList<T> list = new ArrayList<T>();
	
	public Quesito(String quesito) {
		
		this.quesito = quesito;
		
	}
	
	@Override
	public void add(T elem) {
		
		list.add(elem);

	}

	@Override
	public T getElement(int i) {
		
		return (T)list.get(i);
		
	}

	@Override
	public int numberElements() {
		
		return list.size();
		
	}

}
