package istia.st.elections.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import projet.ElectionsException;
import projet.ListeElectorale;

public class ElectionsDaoFile implements IElectionsDao{
	/**
	7. * le nom du fichier qui contient les donn�es n�cessaires au calcul des si�ges
*/
private String inFileName = null;

 /**
 * le nom du fichier qui contiendra les r�sultats
13. */
String outFileName = null;

 /**
 * le nom du fichier de logs
 */ 
 private String logFileName = null;

 /**
 * le seuil �lectoral
 */
 private double seuilElectoral;
/**
 * le nombre de si�ges � pourvoir
 */ private int nbSiegesAPourvoir;

 /** * les listes en comp�tition 
  * */
 private ListeElectorale[] listesElectorales = null;


 /**
 * constructeur avec param�tres
 * @param inFileFileName String : le nom du fichier qui contient les donn�es n�cessaires au calcul
des si�ges
 * @param outFileName String : le nom du fichier qui contiendra les r�sultats
 * @param logFileName String : le nom du fichier qui contiendra les messages d'erreurs �ventuels
 * @throws ElectionsException si probl�me quelconque
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
 * @return double : seuil �lectoral
 */
 public double getSeuilElectoral(){
 return seuilElectoral;
 }


 /**
 * getNbSiegesAPourvoir
 *
 * @return int : nombre de si�ges � pourvoir
 */
 public int getNbSiegesAPourvoir() {
 return nbSiegesAPourvoir;
}


 /** * getListesElectorales
 * * @return ListeElectorale[] : tableau des listes �lectorales */
 public ListeElectorale[] getListesElectorales() {
	
 return listesElectorales;
 }

 /**
 * enregistrement des r�sultats dans le fichier [outFileName]
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
