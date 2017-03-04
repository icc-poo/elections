package elections.dao.service;

import java.util.List;

import elections.dao.entities.*;

public interface IElectionsDao {

	/**
	 * demande le seuil électoral
	 * @return double : le seuil électoral
	 */
	public double getSeuilElectoral();
	
	/**
	 * demande le nombre de sièges à pourvoir
	 * @return int : nombre de sièges à pourvoir
	 */
	public int getNbSiegesAPourvoir();
	
	/**
	 * demande le tableau de listes en compétition
	 * @return ListeElectorale[] : les listes en compétition
	 */
	public List<ListeElectorale> getListesElectorales();
	
	/**
	 * enregistre les résultats des listes en compétition
	 * @param listesElectorales ListesElectorales[] : les listes en compétition
	 */
	public void setListesElectorales(List<ListeElectorale> listesElectorales);
	
	/**
	 * retourne le nom du fichier contenant les données d'initialisation(seuil électoral, nombre de listes)
	 * @return String : nom du fichier d'initialisation
	 */
	public String getInitFile();
	
	/**
	 * retourne le fichier d'enregistrement des résulats
	 * @return String : Nom du fichier d'enregistrement des résultats
	 */
	public String getOutFile();
	
	/**
	 * retourne le fichier de logs
	 * return String : Nom du fichier de logs
	 */
	public String getLogFile();
	
}
