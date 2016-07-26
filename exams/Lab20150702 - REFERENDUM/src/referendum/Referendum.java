package referendum;

import dictionary.ArrayDoubling;
import dictionary.Dictionary;
import dictionary.KeyAlreadyExists;
import list.*;

public class Referendum {
	protected Dictionary<Voto> referendum;
	protected AddOnlyList<Cittadino> cittadini;
	protected boolean aperto;

	public Referendum() {
		this.referendum = new ArrayDoubling<Voto>();
		this.cittadini = new AddOnlyLinkeList<Cittadino>();
	}

	public void addCittadino(Cittadino c) {
		cittadini.add(c);
	}

	public AddOnlyList<Cittadino> registrati() {
		return cittadini;
	}

	public void apriReferendum() {
		aperto = true;
	}

	public void vota(Cittadino c, Voto v) {
		if (!aperto)
			throw new ReferendumChiuso();

		boolean found = false;
		for (Cittadino cittadino : cittadini) {
			if (c.compareTo(cittadino) == 0) {
				found = true;
				break;
			}
		}
		if (!found)
			throw new NonRegistrato("Il cittadino con ID: " + c.getId() + " non è registrato e non può votare");

		try {
			referendum.insert(v, c);
		} catch (KeyAlreadyExists e) {
			throw new GiaVotato();
		}
	}

	public void chiudiRefendum() {
		aperto = false;
	}

	public AddOnlyList<Cittadino> votanti() {
		AddOnlyList<Cittadino> list = new AddOnlyLinkeList<Cittadino>();
		for (Object obj : referendum)
			list.add((Cittadino) obj);
		return list;
	}

	public int votiSi() {
		int res = 0;
		for (Comparable cittadino : referendum) {
			Voto v = referendum.search(cittadino);
			if (v == Voto.si)
				res++;
		}
		return res;
	}

	public int votiNo() {
		int res = 0;
		for (Comparable cittadino : referendum) {
			Voto v = referendum.search(cittadino);
			if (v == Voto.no)
				res++;
		}
		return res;
	}

	public int schedeNulle() {
		int res = 0;
		for (Comparable cittadino : referendum) {
			Voto v = referendum.search(cittadino);
			if (v == Voto.nulla)
				res++;
		}
		return res;
	}

	public int schedeBianche() {
		int res = 0;
		for (Comparable cittadino : referendum) {
			Voto v = referendum.search(cittadino);
			if (v == Voto.bianca)
				res++;
		}
		return res;
	}
}
