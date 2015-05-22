package list;

public interface List<T> extends Iterable<T> {

	static final String MSG_POS_NOT_VALID = "Invalid position. ";
	static final String MSG_EMPTY = "Empty List. ";
	
	public boolean isEmpty();
	public T readList(Position p);
	public void writeList(T elem, Position p);
	public Position firstList();
	public boolean endList(Position p);
	public Position succList(Position p);
	public Position predList(Position p);
	public void insList(T elem, Position p);
	public void cancList(Position p);
	
}
