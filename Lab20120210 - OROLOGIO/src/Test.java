
public class Test {

	public static void main(String[] args) {

		OrologioDaPolso o1 = new OrologioDaPolso();
		OrologioDaPolso o2 = new OrologioDaPolso();
		System.out.println("Confroto uguaglianza prima che il primo orologio inizi a ruotare: " + o1.equals(o2) + "\n");
		o1.start();
		System.out.println("\nConfroto uguaglianza dopo la rotazione: " + o1.equals(o2));
	}

}
