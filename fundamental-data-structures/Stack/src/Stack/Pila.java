package Stack;

public interface Pila<T> extends Iterable<T> {

	static final String MSG_EMPTY = "Empty Stack.";
	
	public boolean isEmpty();
	public void push(T e);
	public Object top();
	public void pop();
	
}
