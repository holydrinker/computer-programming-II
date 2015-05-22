
import list.AddOnlyList;

public abstract class SessioneAbs {
	protected AddOnlyList<Prodotto> prodotti = null;
	
	protected void aggiungiProdotto(Prodotto prodotto){
		prodotti.add(prodotto);
	}
}
