package serie;

class Elemento<T> implements Posizione {

	T elemento;
	Elemento<T> precedente;
	Elemento<T> successivo;

	Elemento(T elemento) {
		
		this.elemento = elemento;
		precedente = successivo = null;
		
	}
	
}
