package istia.st.elections.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import projet.ElectionsException;
import projet.ListeElectorale;

public class ElectionsDaoFile implements IElectionsDao{
	/**
	7. * le nom du fichier qui contient les données nécessaires au calcul des sièges
*/
private String inFileName = null;

 /**
 * le nom du fichier qui contiendra les résultats
13. */
String outFileName = null;

 /**
 * le nom du fichier de logs
 */ 
 private String logFileName = null;

 /**
 * le seuil électoral
 */
 private double seuilElectoral;
/**
 * le nombre de sièges à pourvoir
 */ private int nbSiegesAPourvoir;

 /** * les listes en compétition 
  * */
 private ListeElectorale[] listesElectorales = null;


 /**
 * constructeur avec paramètres
 * @param inFileFileName String : le nom du fichier qui contient les données nécessaires au calcul
des sièges
 * @param outFileName String : le nom du fichier qui contiendra les résultats
 * @param logFileName String : le nom du fichier qui contiendra les messages d'erreurs éventuels
 * @throws ElectionsException si problème quelconque
 *
 */
 public ElectionsDaoFile(String inFileName, String outFileName, String logFileName) {
 // on enregistre les noms des fichiers
 this.inFileName = inFileName;
 this.outFileName = outFileName;
 this.logFileName = logFileName;
 }

 /**
 * getSeuilElectoral
*
 * @return double : seuil électoral
 */
 public double getSeuilElectoral(){
 return seuilElectoral;
 }


 /**
 * getNbSiegesAPourvoir
 *
 * @return int : nombre de sièges à pourvoir
 */
 public int getNbSiegesAPourvoir() {
 return nbSiegesAPourvoir;
}


 /** * getListesElectorales
 * * @return ListeElectorale[] : tableau des listes électorales */
 public ListeElectorale[] getListesElectorales() {
	
 return listesElectorales;
 }

 /**
 * enregistrement des résultats dans le fichier [outFileName]
 * @param listesElectorales ListeElectorale[]
*/
 public void setListesElectorales(ListeElectorale[] listesElectorales) {
	 
	 BufferedWriter bw=null;
	 String outFileName="out-election.txt";
	 try{
		 bw= new BufferedWriter(new FileWriter(outFileName));
		 try{
			 bw.write(listesElectorales);
			 System.out.println("Enregistrement reussi");
			 
			 
		 }
		 finally{
			 bw.close();
		 }
		 
	 }catch(IOException ew){
		 ew.printStackTrace();
	 }
	 
	 
	 
	
 }

}
