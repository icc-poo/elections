package istia.st.elections.dao;

import junit.framework.TestCase;
import projet.ListeElectorale;
//import istia.st.elections.dao.tests.ClassPathResource;
//import istia.st.elections.dao.tests.XmlBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory; 
import org.springframework.core.io.ClassPathResource;


public class JUnitTestsElectionDaoFile extends TestCase {
	 /**
	 * instance d'acc�s � la couche [dao]
	 */
	 private IElectionsDao electionsDao = null;
	
	 /**
	 * constructeur par d�faut
	 * <p>on r�cup�re aupr�s de Spring une instance de l'interface d'acc�s aux donn�es</p>
	 */
	public JUnitTestsElectionDaoFile() {
	 super();
	 electionsDao = (IElectionsDao)(new XmlBeanFactory(new ClassPathResource("spring-config-electionsDaoFile.xml"))).getBean("electionsDao");
	 }
	
	 /**
	 * affichage des donn�es de l'�lection
	 */
	 public void testLectureDataElections() {
	 // on affiche les donn�es de l'�lection
		 System.out.println("Nombre de si�ges � pourvoir : "+ electionsDao.getNbSiegesAPourvoir());
		 	System.out.println("Seuil �lectoral : "+ electionsDao.getSeuilElectoral());
		 		ListeElectorale liste[] = electionsDao.getListesElectorales();
		 		for(int i=0; i<liste.length; i++){
		 			System.out.println("["+liste[i].getNom()+","+liste[i].getVoix()+","+liste[i].getSieges()+","+liste[i].isElimine()+"]");

	 }
	 }
	
	public void testEcritureResultatsElections(){
	 // on cr�e un tableau de trois listes
		ListeElectorale[] listes;
		listes = new ListeElectorale[3];
		
		ListeElectorale listeA = new ListeElectorale(1, "A", 32000, 0, false);
		ListeElectorale listeB = new ListeElectorale(1, "B", 25000, 0, false);
		ListeElectorale listeC = new ListeElectorale(1, "C", 18000, 0, false);
		
		listes[0] = listeA;
		listes[1] = listeB;
		listes[2] = listeC;
		
		/*String testEcriture = "[" + listeA.getNom() + "," + listeA.getSieges() + "," + listeA.getSieges() + "," + listeA.isElimine() + "]" + "\n" 
				+ "[" + listeB.getNom() + "," + listeB.getSieges() + "," + listeB.getSieges() + "," + listeB.isElimine() + "]" + "\n"
				+ "[" + listeC.getNom() + "," + listeC.getSieges() + "," + listeC.getSieges() + "," + listeC.isElimine() + "]" + "\n";*/
		
		try{
			setListesElectorales(listes);
		  
		}catch(Exception er){
		  System.out.println("Creation de fichier impossible");
		  }
		 
		
		/*String chemin = "testEcriture.txt";
		File fichier = new File(chemin);
		
		try {
			fichier.createNewFile();
			FileWriter fw = new FileWriter(fichier);
			try {
				fw.write(testEcriture);
			} finally {
				fw.close();
			} 
		} catch (Exception e) {
			System.out.println("Creation de fichier impossible");
		}
	 }*/
	
	 // on rend ces donn�es persistantes


	}


}
