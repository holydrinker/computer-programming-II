
import rivista.Rivista;


public class Test {
	public static void main(String[] args) {
		Rivista rivista = new Rivista();
		
		String titolo1 = "A relational perspective on spatial data mining";
		rivista.addArt(titolo1 , 1);
		rivista.addAut(titolo1, "Donato Malerba");
		
		String titolo2 = "Multi-label large margin hierarchical perceptron";
		rivista.addArt(titolo2, 1);
		rivista.addAut(titolo2, "Clay Woolam");
		rivista.addAut(titolo2, "Latifur Khan");
		
		String titolo3 = "Privacy preserving record linkage approaches";
		rivista.addArt(titolo3, 2);
		rivista.addAut(titolo3, "Vassilios S. Verykios");
		rivista.addAut(titolo3, "Alexandros Karakasidis");
		rivista.addAut(titolo3, "Vassilios K. Mitrogiannis");
		
		String titolo4 = "On the selection of k efficient paths by clustering techniques";
		rivista.addArt(titolo4, 3);
		rivista.addAut(titolo4, "Massimiliano Caramia");
		rivista.addAut(titolo4, "Stefano Giordani");
		
		rivista.pubblicaVol(1);
		rivista.pubblicaVol(2);
		rivista.pubblicaVol(3);
		
		System.out.println("RIVISTA");
		System.out.println(rivista.toString());
	}
}
