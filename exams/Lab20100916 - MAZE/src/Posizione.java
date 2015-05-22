
public class Posizione {
	int row;
	int col;
	
	public Posizione(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	@Override
	public String toString() {
		return ("(" + row + "," + col + ")");
	}
}
