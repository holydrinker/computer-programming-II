package priorityQueue;
import java.util.Iterator;
import java.util.List;

import processi.Process;

public abstract class PQL<Item> implements PQ<Item> {
	protected List<Item> coda;
	
	@Override
	public boolean isNew() {
		return coda.size() == 0;
	}

	@Override
	public void insert(Item item) {
		Process p = ((Process)item);
		Process tmp;
		boolean found = false;
		int i = 0;
		while(!found && i < coda.size()){
			tmp = (Process) coda.get(i);
			if(p.getPriority() < tmp.getPriority())
				found = true;
			else
				i++;
		}
		coda.add(i, item);
	}

	@Override
	public Item first() {
		if(isNew())
			throw new EmptyListException(ExceptionMessages.EMPTY);
		return coda.get(0);
	}

	@Override
	public void delFirst() {
		if(isNew())
			throw new EmptyListException(ExceptionMessages.EMPTY);
		coda.remove(0);
	}

	@Override
	public void changePriority(Item item, int priority) {
		if(isNew())
			throw new EmptyListException(ExceptionMessages.EMPTY);
		
		Process p1 = (Process) item;
		boolean found = false;
		int i = 0;
		Process p2 = null;
		while(!found && i<coda.size()){
			p2 = (Process) coda.get(i);
			if(p1.getId() == p2.getId())
				found = true;
			else
				i++;
		}
		if(!found)
			throw new EntryDoesntExistException(ExceptionMessages.NOT_IN + p1.getId());
		
		p2.setPriority(priority);
		coda.remove(i);
		insert((Item)p2);
	}

	@Override
	public int getPriority(Item item) {
		if(isNew())
			throw new EmptyListException(ExceptionMessages.EMPTY);
		
		Process p = (Process) item;
		Process tmp = null;
		boolean found = false;
		int i = 0;
		while(!found && i < coda.size()){
			tmp = (Process) coda.get(i);
			if(p.getId() == tmp.getId())
				found = true;
			else
				i++;
		}
		if(!found)
			throw new EntryDoesntExistException(ExceptionMessages.NOT_IN + p.getId());
		return tmp.getPriority();
	}

	@Override
	public int size() {
		return coda.size();
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>(){
			int i = 0;
			
			@Override
			public boolean hasNext() {
				return i < coda.size();
			}

			@Override
			public Item next() {
				return coda.get(i++);
			}
		};
	}

}
