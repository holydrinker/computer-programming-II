package biblioteca;

import list.AddOnlyList;

public class Volume {
	public String titolo;
	public String casaEditrice;
	public int annoPubblicazione;
	public AddOnlyList<String> listaAutori;
	
	public Volume(String titolo, String casaEditrice, int annoPubblicazione, AddOnlyList<String> listaAutori) {
		this.titolo = titolo;
		this.casaEditrice = casaEditrice;
		this.annoPubblicazione = annoPubblicazione;
		this.listaAutori = listaAutori;
	}
	
	@Override
	public boolean equals(Object obj) {
		Volume other = (Volume) obj;
		
		if(this.titolo.equalsIgnoreCase(other.titolo))
			if(this.casaEditrice.equals(other.casaEditrice))
				if(this.annoPubblicazione == other.annoPubblicazione)
					if(this.listaAutori.equals(other.listaAutori))
						return true;
		return false;
	}
}
