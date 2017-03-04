package elections.dao.service;

import java.io.IOException;
import java.util.List;

import elections.dao.entities.*;

public class ElectionsDaoFile implements IElectionsDao {

	//fichier contenant les données d'initialisation
	private String initFile = null;
	
	//fichier contenant les données de résultat
	private String outFile = null;
	
	
	//fichier de logs
	private String logFile = null;
	
	private double seuilElectoral;
	private int nbSiegesAPourvoir;
	private List<ListeElectorale> listesElectorales = null;
	
	/**
	* constructeur avec paramètres
	* @param initFile String : le nom du fichier qui contient les données nécessaires au calcul
	sièges
	* @param outFile String : le nom du fichier qui contiendra les résultats
	* @param logFile String : le nom du fichier qui contiendra les messages d'erreurs éventuels
	* @throws ElectionsException si problème quelconque
	*
	*/
	public ElectionsDaoFile(String inFile, String outFile) {
	// on enregistre les noms des fichiers
		this.initFile = inFile;
		this.outFile  = outFile;
		this.logFile  = logFile;
	}
	
	/**
	* getSeuilElectoral
	*
	* @return double : seuil électoral
	*/
	public double getSeuilElectoral() {
		
		try {
			List<String> initData = IoUtil.getInitDataFromFile(initFile);
			seuilElectoral = Double.parseDouble(initData.get(0));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seuilElectoral;
	}
	
	/**
	* getNbSiegesAPourvoir
	*
	* @return int : nombre de sièges à pourvoir
	*/
	public int getNbSiegesAPourvoir() {
		
		try {
			List<String> initData = IoUtil.getInitDataFromFile(initFile);
			
			nbSiegesAPourvoir = Integer.parseInt(initData.get(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nbSiegesAPourvoir;
	}
	
	/**
	* getListesElectorales
	*
	* @return ListeElectorale[] : tableau des listes électorales
	*/
	public List<ListeElectorale> getListesElectorales() {
		
		return listesElectorales;
	}
	
	/**
	* enregistrement des résultats dans le fichier [outFileName]
	* @param listesElectorales ListeElectorale[]
	*/
	public void setListesElectorales(List<ListeElectorale> listesElectorales) {

			IoUtil.saveListesToFile(listesElectorales, logFile,  outFile);
	}
	
	
	public String getInitFile() {
		return initFile;
	}

	public String getOutFile() {
		return outFile;
	}

	public String getLogFile() {
		return logFile;
	}
	
	
}
	
	
	
	
	
	
