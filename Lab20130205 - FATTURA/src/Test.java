
public class Test {

	public static void main(String[] args) {
		
		Persona vendFatt1 = new Persona("Giuseppe Lorusso");
		Persona comprFatt1 = new Persona("Donato Malerba");
		String dataFatt1 = "26/01/2015";
		Fattura fattura1 = new FatturaHD(vendFatt1, comprFatt1, dataFatt1);
		fattura1.aggiungiBene("Birra Peroni", 3, 1.80f);
		fattura1.aggiungiBene("Pizza Margherita", 1, 3f);
		fattura1.aggiungiBene("Kinder Pinguì", 2, 8.0f);
		
		Persona vendFatt2 = new Persona("Giuseppe Lorusso");
		Persona comprFatt2 = new Persona("Donato Malerba");
		String dataFatt2 = "26/01/2015";
		Fattura fattura2 = new FatturaHD(vendFatt2, comprFatt2, dataFatt2);
		fattura2.aggiungiBene("Birra Peroni", 3, 1.80f);
		fattura2.aggiungiBene("Pizza Margherita", 1, 3f);
		fattura2.aggiungiBene("Kinder Pinguì", 2, 8.0f);
		
		Persona vendFatt3 = new Persona("Donato Malerba");
		Persona comprFatt3 = new Persona("Giuseppe Lorusso");
		String dataFatt3 = "26/01/2015";
		Fattura fattura3 = new FatturaHD(vendFatt3, comprFatt3, dataFatt3);
		fattura3.aggiungiBene("Birra Peroni", 3, 1.80f);
		fattura3.aggiungiBene("Pizza Margherita", 1, 3f);
		fattura3.aggiungiBene("Kinder Pinguì", 2, 8.0f);
		
		System.out.println("FATTURA 1");
		System.out.println(fattura1.toString());
		
		System.out.println("FATTURA 2");
		System.out.println(fattura2.toString());
		
		System.out.println("FATTURA 3");
		System.out.println(fattura3.toString());
		System.out.println("Confronto di uguaglianza fra fattura1 e fattura2: " + fattura1.uguali(fattura2));
		System.out.println("Confronto di uguaglianza fra fattura2 e fattura3: " + fattura2.uguali(fattura3));
	}
}
