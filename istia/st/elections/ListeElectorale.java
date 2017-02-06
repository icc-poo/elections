package istia.st.elections;

import java.io.*;
/**
 * @author Viorel FLORICA
 * */
public class ListeElectorale {

	/**
	 * identité de la liste
	 */
	private int id;
	
	/**
	 * nom de la liste
	 */
	private String nom;
	
	/**
	 * nombre de voix de la liste
	 */
	private int voix;
	
	/**
	 * nombre de sièges de la liste
	 */
	private int sieges;
	
	/**
	 * indique si la liste est éliminée ou non
	 */
	private boolean elimine;
	

	/**
	 * constructeur par défaut
	 */
	public ListeElectorale(){
	}
	
	/**
	 * 
	 * @param id int : identité de la liste
	 * @param nom String : le nom de la liste
	 * @param voix int : son nombre de voix
	 * @param sieges int : son nombre de sieges
	 * @param elimine boolean : son état éliminé ou non
	 */
	public ListeElectorale(int id, String nom, int voix, int sieges, boolean elimine){
		this.setId(id);
		this.setNom(nom);
		this.setVoix(voix);
		this.setSieges(sieges);
		this.setElimine(elimine);
	}
	
	/**
	 * 
	 * @return int : l'identifiant de la liste
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * initialise l'identifiant de liste
	 * @param id int : identifiant de la liste
	 * @throws ElectionsException si id<1
	 */
	public void setId(int id) {
		if(id<1){
			throw new ElectionsException("L'id ne peut être inférieur à 1!");
		}
		this.id = id;
	}
	
	/**
	 * 
	 * @return String : le nom de la liste
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * initialise le nom de la liste
	 * @param nom String : nom de la liste
	 * @throws ElectionsException si le nom est vide ou blanc
	 */
	public void setNom(String nom) {
		if (nom.trim() == ""){
			throw new ElectionsException("Le nom de la liste ne peut être vide!");
		}
		this.nom = nom;
	}
	
	/**
	 * 
	 * @return int : le nombre de voix de la liste
	 */
	public int getVoix() {
		return voix;
	}
	
	/**
	 * initialise le nombre de voix de la liste
	 * @param voix int : le nombre de voix de la liste
	 * @throws ElectionsException si voix<0
	 */
	public void setVoix(int voix) {
		if (voix<0){
			throw new ElectionsException("Le nombre de voix ne peut être négatif!");
		}
		this.voix = voix;
	}
	
	/**
	 * 
	 * @return int : le nombre de sièges de la liste
	 */
	public int getSieges() {
		return sieges;
	}
	
	/**
	 * fixe le nombre de sièges de la liste
	 * @param sieges int : le nombre de sièges de la liste
	 * @throws ElectionsException si sieges<0
	 */
	public void setSieges(int sieges) {
		if(sieges < 0){
			throw new ElectionsException("Le nombre de sièges ne peut être < 0");
		}
		this.sieges = sieges;
	}
	
	/**
	 * 
	 * @return boolean : valeur du champ elimine
	 */
	public boolean isElimine() {
		return elimine;
	}
	
	/**
	 * modifie l'état éliminé de la liste
	 * @param elimine boolean : son état éliminé ou non
	 */
	public void setElimine(boolean elimine) {
		this.elimine = elimine;
	}
	
	/**
	 * @return String : identité de la liste électorale
	 */
	@Override
	public String toString() {
		return "[" + id + "," + nom + "," + voix + "," + sieges + ","
				+ elimine + "]";
	}
}