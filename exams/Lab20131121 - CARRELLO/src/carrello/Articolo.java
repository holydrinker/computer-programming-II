package carrello;

public class Articolo implements Comparable {
	String name;
	String measure;
	
	public Articolo(String name, String measure) {
		this.name = name;
		this.measure = measure;
	}
	
	@Override
	public String toString() {
		return this.name + " " + this.measure;
	}

	@Override
	public int compareTo(Object o) {
		String s1 = this.toString().toLowerCase();
		String s2 =  o.toString().toLowerCase();
		return s1.compareTo(s2);
	}
}
