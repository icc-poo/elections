package istia.st.elections.tests;

import org.junit.Test;

import istia.st.elections.ListeElectorale;
import istia.st.elections.ElectionsException;
import istia.st.elections.ListeElectorale;

public class MainTest1ListeElectorale {
	@Test
	public void main() {
		// création d'une liste électorale
		ListeElectorale listeElectorale1 = new ListeElectorale(1, "A", 32000,0,false);

		// affichage identité liste
		System.out.println("listeElectorale1=" + listeElectorale1);
		
		// modification du nombre de sièges
		listeElectorale1.setSieges(2);
		
		// affichage identité liste 1
		System.out.println("listeElectorale1="+ listeElectorale1);
		
		// une nouvelle liste électorale
		ListeElectorale listeElectorale2 = listeElectorale1;
		
		// affichage identité liste 2
		System.out.println("listeElectorale2=" + listeElectorale2);
		
		// modification du nombre de sièges
		listeElectorale2.setSieges(3);
		
		// affichage identité des 2 listes
		System.out.println("listeElectorale2=" + listeElectorale2);
		System.out.println("listeElectorale1=" + listeElectorale1);
		
		// test exception
		try {
			listeElectorale2.setSieges(-3);
		} catch(ElectionsException ex) {
			System.err.println("L'exception suivante s'est produite : ["
				+ ex.toString() + "]");
		}
	}
}
