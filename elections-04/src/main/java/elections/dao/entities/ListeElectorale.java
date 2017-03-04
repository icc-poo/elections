package elections.dao.entities;


public class ListeElectorale {
	
		private String nom;
		private int id;
		private int voix;
		private int sieges;
		private boolean elimine;
		private float moyenneListe;
		
		public ListeElectorale(){}
		
		
		/**
		 * 
		 * @param nom String : Nom de la liste
		 * @param voix int : Nombre de voix
		 * @param sieges int : Nombre de sieges
		 * @param elimine boolean : Etat elimine ou non 
		 */

		public ListeElectorale(int id, String nom, int voix, int sieges, boolean elimine){
			
			this.id = id;
			this.nom = nom;
			this.voix = voix;
			this.sieges = sieges;
			this.elimine = elimine;
		}


		/**
		 * @return int : Identifiant de la liste
		 */
		
		public int getId() {
			return id;
		}

		/**
		 * 
		 * @param id int : Identifiant de la liste
		 * @throws ElectionsException si id<1
		 */
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * @return String : Retourne le nom de la liste
		 */
		public String getNom() {
			return nom;
		}
		
		/**
		 * 
		 * @param nom String : Nom de la liste
		 * @throws ElectionsException si le nom est vide ou blanc
		 */
		public void setNom(String nom) throws ElectionsException {
			if(nom.isEmpty()) throw new ElectionsException(1,"Veuillez introduire une chaine de caractère pour le nom");
			this.nom = nom;
		}
		
		/**
		 * 
		 * @return int : Nombre de voix de la liste
		 */
		public int getVoix() {
			return voix;
		}
		
		/**
		 * 
		 * @param voix int : Nombre de voix de la liste 
		 */
		public void setVoix(int voix) throws ElectionsException {
			if(voix < 0) throw new ElectionsException(2, "# de voix  doit être >=0");
			this.voix = voix;
		}
		
		/**
		 * 
		 * @return int : Nombre de sieges de la liste
		 */
		public int getSieges() {
			return sieges;
		}
		
		/**
		 * Fixe le nbre de sieges de la liste
		 * @param sieges int : Nbre de sieges de la liste
		 */
		public void setSieges(int sieges) throws ElectionsException{
			if (sieges < 0) throw new ElectionsException(2, "Le # de sieges doit etre >= 0");
			this.sieges = sieges;
		}
		
		public void addSieges(int sieges){
			this.sieges += sieges;
		}
		
		
		public float getMoyenneListe() {
			return moyenneListe;
		}


		public void setMoyenneListe(float moyenneListe) {
			this.moyenneListe = moyenneListe;
		}
		
		/**
		 * 
		 * @return boolean : Retourne si liste elimine ou non
		 */
		public boolean isElimine() {
			return elimine;
		}

		/**
		 * 
		 * @param elimine boolean 
		 */

		public void setElimine(boolean elimine) {
			this.elimine = elimine;
		}
		
		public String toString(){
			return "La liste "+this.nom+" a obtenu "+this.voix+" voix  et "+ this.sieges + " sieges";
		}
		
}


