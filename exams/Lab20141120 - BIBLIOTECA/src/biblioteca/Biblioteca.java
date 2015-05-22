package biblioteca;

import dictionary.ArrayDict;

public class Biblioteca<K> extends BibliotecaAbs<K> {
	public Biblioteca() {
		super.volumi = new ArrayDict<String, Record>();
	}
}
