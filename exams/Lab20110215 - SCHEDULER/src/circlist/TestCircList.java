package circlist;

public class TestCircList {


	public static void main(String[] args) {
		CircList<String> list = new ListaCircDL<String>();
		list.addCircList("alpha");
		list.addCircList("beta");
		list.addCircList("gamma");
		list.addCircList("delta");
		list.addCircList("epsilon");
		
		list.setDir(Direzione.forward);
		for(String x : list)
			System.out.print(x + " ");
		System.out.println("");
		
		list.setDir(Direzione.backward);
		list.ruota();
		list.setDir(Direzione.forward);
		for(String x : list)
			System.out.print(x + " ");
		System.out.println("");
	
		list.setDir(Direzione.forward);
		list.ruota();
		for(String x : list)
			System.out.print(x + " ");
		System.out.println("");
		
		for(int i = 0; i < list.numItem(); i++){
			String s = list.value();
			if(s.charAt(0) == 'd'){
				list.delCircList();
				break;
			}
			else
				list.ruota();
		}
		
		for(String x : list)
			System.out.print(x + " ");
	}

	
}
