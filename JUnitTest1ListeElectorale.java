package projet;


 import org.junit.Assert;
 import projet.ElectionsException;
 import projet.ListeElectorale;




import org.junit.Test;

public class JUnitTest1ListeElectorale {

	@Test
	 public void t1() {
	 // création liste électorale
	ListeElectorale liste = new ListeElectorale(1, "a", 32000, 0, false);
	 // vérifications
	 Assert.assertEquals("a", liste.getNom());
	 Assert.assertEquals(32000, liste.getVoix());
	 Assert.assertEquals(false, liste.isElimine());
	 Assert.assertEquals(0, liste.getSieges());
	 // vérification validité id
	 boolean erreur = false;
	 try {
	 liste.setId(-4);
	 } catch (ElectionsException e) {
	 erreur = true;
	 }
	 Assert.assertEquals(true, erreur);
	 // vérification validité nom
	 erreur = false;
	 try {
	 liste.setNom("");
	
	 } catch (ElectionsException e) {
	 erreur = true;
	 System.out.println("");
	 }
	 Assert.assertEquals(true, erreur);
	 // vérification validité voix
	 erreur = false;
	 try {
	 liste.setVoix(-4);
	 } catch (ElectionsException e) {
	 erreur = true;
	 }
	 Assert.assertEquals(true, erreur);
	 // vérification validité sièges
	 erreur = false;
	  try {
	 liste.setSieges(-4);
	 } catch (ElectionsException e) {
	 erreur = true;
	 }
	 Assert.assertEquals(true, erreur);
	 }

}
