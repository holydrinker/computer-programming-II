package pila;

public interface Pila<T> extends Iterable<T> {

	public boolean isEmpty();
	public void push(T e);
	public void pop();
	public T top();
	
	
}
