package Ditta;

import Tabella.ArrayDoubling;
import Tabella.EccezioneChiaveInesistente;
import Tabella.EccezioneChiavePresente;
import Tabella.EccezioneStrutturaVuota;
import Tabella.Tabella;

public class GestioneDitte {

	static Tabella t = new ArrayDoubling();
	
	public static void main(String[] args) {
			
		inizializza();
			
		tipoDitta tipo;
		InfoDitta info;
		
		//---Cliente1
		try{
			
			info = (InfoDitta)t.search("Cliente1");
			tipo = ricerca(info);
			System.out.println(tipo.toString());
				
			if(tipo != tipoDitta.undefined)
				t.delete("Cliente1");
			
		} catch (EccezioneStrutturaVuota e) {
			
			System.out.println(e.getMessage());
			
		} catch (EccezioneChiaveInesistente e) {
			
			System.out.println(e.getMessage());
			
		}
		
		//---Cliente1 Undefined
		try{
			
			info = (InfoDitta)t.search("Cliente1");
			tipo = ricerca(info);
			System.out.println(tipo.toString());
				
			if(tipo != tipoDitta.undefined)
				t.delete("Cliente1");
			
		} catch (EccezioneStrutturaVuota e) {
			
			System.out.println(e.getMessage());
			
		} catch (EccezioneChiaveInesistente e) {
			
			System.out.println(tipoDitta.undefined);
			
		}
		
		//---Fornitore1
			try{
					
				info = (InfoDitta)t.search("Fornitore1");
				tipo = ricerca(info);
				System.out.println(tipo.toString());
						
				if(tipo != tipoDitta.undefined)
					t.delete("Fornitore1");
					
			} catch (EccezioneStrutturaVuota e) {
					
				System.out.println(e.getMessage());
					
			} catch (EccezioneChiaveInesistente e) {
					
				System.out.println(tipoDitta.undefined);
				
			}
			
		//---Fornitore1 Undefined
			try{
				
				info = (InfoDitta)t.search("Fornitore1");
				tipo = ricerca(info);
				System.out.println(tipo.toString());
						
				if(tipo != tipoDitta.undefined)
					t.delete("Fornitore1");
					
			} catch (EccezioneStrutturaVuota e) {
					
				System.out.println(e.getMessage());
					
			} catch (EccezioneChiaveInesistente e) {
					
				System.out.println(tipoDitta.undefined);
				
			}
		
	}

	static tipoDitta ricerca(InfoDitta ditta){
		
		if ( ditta instanceof InfoCliente )
			return tipoDitta.cliente;
		else if (ditta instanceof InfoFornitore )
			return tipoDitta.fornitore;
		else
			return tipoDitta.undefined;
		
	}
	
	private static void inizializza(){
		
		try{
			t.insert(new InfoCliente("Bari", 1992), "Cliente1");
		}catch (EccezioneChiavePresente e){
			System.out.println(e.getMessage());
		}
		
		try{
			t.insert(new InfoFornitore("Roma", tipoFornitore.primario), "Fornitore1");
		}catch (EccezioneChiavePresente e){
			System.out.println(e.getMessage());
		}
		
		try{
			t.insert(new InfoCliente("Milano", 1992), "Cliente2");
		}catch (EccezioneChiavePresente e){
			System.out.println(e.getMessage());
		}
		
		try{
			t.insert(new InfoFornitore("Bolzano", tipoFornitore.secondario), "Fornitore2");
		}catch (EccezioneChiavePresente e){
			System.out.println(e.getMessage());
		}
		
	}
	
}
