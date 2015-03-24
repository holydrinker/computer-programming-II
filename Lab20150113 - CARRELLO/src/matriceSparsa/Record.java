package matriceSparsa;

class Record<E> {
	E valore;
	int colonna;
	
	public Record(E valore, int colonna) {
		this.valore = valore;
		this.colonna = colonna;
	}
}
