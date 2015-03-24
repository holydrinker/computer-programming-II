package Ditta;

public class InfoFornitore extends InfoDitta {

	public tipoFornitore tipo;
	
	public InfoFornitore(String sede, tipoFornitore tipo) {
		
		super(sede);
		this.tipo = tipo;
		
	}
	
}
