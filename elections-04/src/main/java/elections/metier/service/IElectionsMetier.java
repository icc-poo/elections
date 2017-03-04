package elections.metier.service;

import elections.dao.entities.ListeElectorale;

public interface IElectionsMetier {

	/**
	 * demande le seuil electoral
	 * @return double : le seuil electoral
	 */
	public double getSeuilElectoral();
	
	/**
	 * demande le nombre de sieges à pourvoir
	 * @return int : le nombre de sièges à pourvoir
	 */
	public int getNbSiegesAPourvoir();
	
	/**
	 * rend le tableau des listes en compétition
	 * @return ListeElectorale[] : le tableau des listes en compétition
	 */
	ListeElectorale[] getListesElectorales();
	
	/**
	 * calcul des sièges des listes candidates
	 * @param listesElectorales ListesElectorales[] : les listes avec les voix mais sans les sièges
	 * @return ListeElectorales[] : les listes avec les sièges
	 */
	ListeElectorale[] calculerSieges(ListeElectorale[] listesElectorales);
	
	/**
	 * enregistre les resultats de l'élection
	 * @param listesElectorales ListeElectorale[] : les listes candidates à enregistrer
	 */
	public void recordResultats(ListeElectorale[] listesElectorales);
	
}
