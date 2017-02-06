package istia.st.elections.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import istia.st.elections.ElectionsException;
import istia.st.elections.ListeElectorale;

public class JUnitTest1ListeElectorale {

	@Test
	public void t1() {
		//création de la liste électorale
		ListeElectorale liste = new ListeElectorale(1, "a", 32000, 0, false);
		
		// vérifications
		assertEquals("a", liste.getNom());
		assertEquals(32000, liste.getVoix());
		assertEquals(false, liste.isElimine());
		assertEquals(0, liste.getSieges());
		
		//vérification validité id 
		boolean erreur = false;
		
		try {
			liste.setId(-4);
		} catch(ElectionsException e) {
			erreur = true;
		}
		
		assertTrue(erreur);
		
		//verification validité nom
		erreur = false;
		
		try {
				liste.setNom("");
		} catch(ElectionsException e){
			erreur=true;
		}

		assertTrue(erreur);

		//vérification validité voix
		erreur = false;
		
		try {
			liste.setVoix(-4);
		} catch (ElectionsException e) {
			erreur = true;
		}
		
		assertTrue(erreur);
		
		//vérification validité sieges
		erreur = false;
		
		try {
			liste.setSieges(-4);
		} catch (ElectionsException e) {
			erreur = true;
		}

		assertTrue(erreur);
	}

}
