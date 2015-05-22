package graduatoria;

public class Record implements Comparable {
	public Progetto progetto;
	public float punteggio;
	private static final float MIN_RATE = 0f;
	private static final float MAX_RATE = 15f;
	
	public Record(Progetto progetto, float punteggio) {
		if(!checkRate(punteggio))
			throw new RateNotValidException();
		this.progetto = progetto;
		this.punteggio = punteggio;
	}
	
	private boolean checkRate(float punteggio){
		return (punteggio >= MIN_RATE && punteggio <= MAX_RATE);
	}
	@Override
	public int compareTo(Object arg0) {
		Record r = (Record) arg0;
		if(this.punteggio < r.punteggio)
			return -1;
		else if (this.punteggio > r.punteggio)
			return +1;
		else
			return 0;
	}
}
