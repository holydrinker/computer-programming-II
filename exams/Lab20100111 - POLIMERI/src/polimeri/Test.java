package polimeri;

import java.io.*;

public class Test {

	public static void main(String[] args) {		
		
		DNA dna = new DNA("TAAAGGGCTACAT");
		Proteina proteina = new Proteina("ACDEAACCDEDDA");
		
		String printDNA = "DNA: " + dna.toString();
		String printProteina = "Proteina: " + proteina.toString();
		
		try {
			
			FileOutputStream output = new FileOutputStream("output.txt");
			PrintStream bufferWriter = new PrintStream(output);
			
			bufferWriter.println(printDNA);
			bufferWriter.println(printProteina);
			
			bufferWriter.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

}
