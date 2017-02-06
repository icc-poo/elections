package electionsTest;

import elections.*;


public class MainTestListeElectorale {
	public static void main(String[] args){
		
		ListeElectorale liste1 = new ListeElectorale(1, "A", 20000, 10, false);
		
		System.out.println("Liste #1 : " +liste1);
		
		liste1.setSieges(2);
		System.out.println("Liste #1 : " +liste1);
		
		liste1.setNom("");
		
		
		
	}

}
