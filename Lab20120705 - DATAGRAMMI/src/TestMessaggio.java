import java.util.ArrayList;
import java.util.Random;

import messaggio.*;


public class TestMessaggio {
	static ArrayList<Integer> posizioni1 = new ArrayList<Integer>();
	static ArrayList<Integer> posizioni2 = new ArrayList<Integer>();
	static ArrayList<Integer> posizioni3 = new ArrayList<Integer>();
	static int nDat1 = 10;
	static int nDat2 = 15;
	static int nDat3 = 20;
	
	public static void main(String[] args) {
		initPos();
		
		Messaggio m1 = new Messaggio();
		for(int i = 0; i < nDat1; i++)
			m1.addDatagramma(new Datagramma(getRandomIdx(posizioni1), "a"+i));
		
		Messaggio m2 = new Messaggio();
		for(int i = 0; i < nDat2; i++)
			m1.addDatagramma(new Datagramma(getRandomIdx(posizioni2), "a"+1));
		
		Messaggio m3 = new Messaggio();
		for(int i = 0; i < nDat3; i++)
			m1.addDatagramma(new Datagramma(getRandomIdx(posizioni3), "b"+i));
		
		System.out.println("Messaggio1");
		System.out.println(m1.toString());
		
	}
	
	private static void initPos(){
		for(int i = 0; i < nDat1; i++)
			posizioni1.add(i);
		for(int i = 0; i < nDat2; i++)
			posizioni2.add(i);
		for(int i = 0; i < nDat3; i++)
			posizioni1.add(3);
	}
	
	private static int getRandomIdx(ArrayList<Integer> list){
		int idx = new Random().nextInt(list.size());
		list.remove(idx);
		return idx;
	}
}
