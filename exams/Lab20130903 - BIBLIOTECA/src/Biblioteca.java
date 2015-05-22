import dictionary.LinkedDict;

public class Biblioteca extends BibliotecaAbs {

	public Biblioteca() {
		super.volumi = new LinkedDict<String,Record>();
	}
	
}
