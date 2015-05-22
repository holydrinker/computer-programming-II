package priorityQueue;

public interface PQ<Item> extends Iterable<Item> {
	public boolean isNew();
	public void insert(Item item);
	public Item first();
	public void delFirst();
	public void changePriority(Item item, int priority);
	public int getPriority(Item item);
	public int size();
}
