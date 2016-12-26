
package elections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Zaïlachi Rani
 */
public class Election {
	
	private int i = 1;
	private int j;
	private int nbVoix;
	private int nbVoixTotal;
	private int nbVoixUtiles;
	private int nbSieges;
	private int nbSiegesAPourvoir;
	private int nbSiegesPourvus = 0;
	private int nbSiegesRestants = 0;
	private float moyenneMax;
	private int iPoidsMax;
	private float quotientElectoral;
	private boolean saisie = true;
	private String nomListe = "";
	private ArrayList<ListeElectorale> tabListes = new ArrayList<ListeElectorale>();
	private Scanner input = new Scanner(System.in);
	
	public Election(){
		
		System.out.println("####################################################################################");
		System.out.println("Initialisation des listes");
		System.out.println("####################################################################################");
		initListes();
		System.out.println("####################################################################################");
		System.out.println("Calcul du nombre de voix utiles");
		System.out.println("####################################################################################");
		calcVoixUtiles();
		System.out.println("Il y a "+this.nbVoixUtiles+" voix utiles sur un total de  "+nbVoixTotal+" voix\n");
		System.out.println("####################################################################################");
		System.out.println("Répartition des sièges...");
		System.out.println("####################################################################################");;
		repartitionSieges();
		System.out.println("####################################################################################");
		System.out.println("Résultats des élections :");
		System.out.println("####################################################################################");
		for(ListeElectorale l : tabListes){
			if(l.isElimine())
				System.out.println("La liste "+l.getNom()+" a été éliminée");
		}
		for(ListeElectorale l : tabListes){
			if(!l.isElimine())
				System.out.println(l);
		}
	}
	
	public void initListes(){
		
		
		while(saisie){											
			
			System.out.println("Nombre de sièges à pourvoir :");
			this.nbSiegesAPourvoir = input.nextInt();
		    
			if(nbSiegesAPourvoir <= 0) 
				System.out.println("Erreur: Tapez un nombre entier > 0");
		    else
		    	saisie = false;
		 }
		
		//Saisie des listes
		while(!nomListe.equals("*")){
			
			System.out.println("Veuillez entrer le nom de la liste " +i);
			nomListe = input.next();
			if(nomListe.equals("*")) 
				break;
			
			System.out.println("Nbre de voix de la liste [" +nomListe+ "]");
			nbVoix = input.nextInt();
			nbVoixTotal += nbVoix;
			
			tabListes.add(new ListeElectorale(i, nomListe, nbVoix, 0, false));
			i++;
		}
		
		//Tri des listes en fonction de leur nombre de voix
		Collections.sort(tabListes, new CompareListes());
	}

	public void calcVoixUtiles(){
		
		for(i=0 ; i<tabListes.size() ; i++){
			
			if(((float)tabListes.get(i).getVoix() / nbVoixTotal) < 0.05) 
				tabListes.get(i).setElimine(true);
			else 
				nbVoixUtiles += tabListes.get(i).getVoix();
		}
		
	}
	
	public void repartitionSieges(){
		
		quotientElectoral = nbVoixUtiles / nbSiegesAPourvoir;
		
		for(i=0 ; i<tabListes.size() ; i++){
	    	
	    	if(!tabListes.get(i).isElimine()){
                
	    		nbSieges = (int)(tabListes.get(i).getVoix()/quotientElectoral);
	    		tabListes.get(i).setSieges(nbSieges);
	    		nbVoix = tabListes.get(i).getVoix();
	    		//tabListes.get(i).setMoyenneListe(nbVoix/(nbSieges+1));
                nbSiegesPourvus += tabListes.get(i).getSieges();
                System.out.println(tabListes.get(i).getNom()+" obtient "+tabListes.get(i).getSieges()+" sieges");
	    	}
	    }
		System.out.println(nbSiegesPourvus+" sieges pourvus");
		
		
		//Calcul de la moyenne de voix par siege
		System.out.println("\nPondération de chaque liste");
		System.out.println("Quotient Electoral ~ "+quotientElectoral+" voix par siège\n");
		for(ListeElectorale l : tabListes){
			if(!l.isElimine()){
				float moyenne = l.getVoix() / (l.getSieges()+1);
				l.setMoyenneListe(moyenne);
				System.out.println(l.getNom()+" a une moyenne de "+l.getMoyenneListe()+" voix par siege");
			}	
		}
			
		nbSiegesRestants = nbSiegesAPourvoir-nbSiegesPourvus;
		//Repartition des sieges restants
		
		for(i=0 ; i<nbSiegesRestants ; i++){
			
			moyenneMax = -1;
			for(j=0 ; j<tabListes.size() ; j++){
				
				if((!tabListes.get(j).isElimine()) && ((tabListes.get(j).getMoyenneListe()) > moyenneMax)){
					moyenneMax = tabListes.get(j).getMoyenneListe();
					iPoidsMax = j;
				}
			}
			
			System.out.println("\nAVT MODIF :\n" +tabListes.get(iPoidsMax).getNom() +" a une moyenne de "+tabListes.get(iPoidsMax).getMoyenneListe()+" par siege");
			nbSieges = tabListes.get(iPoidsMax).getSieges();
			System.out.println(tabListes.get(iPoidsMax).getNom() +" a "+nbSieges+" sieges");

			tabListes.get(iPoidsMax).addSieges(1);
			nbSieges = tabListes.get(iPoidsMax).getSieges();
			nbVoix = tabListes.get(iPoidsMax).getVoix();
			
			System.out.println("APRES MODIF :\n"+tabListes.get(iPoidsMax).getNom() +" a mnt "+nbSieges+" sieges");
			tabListes.get(iPoidsMax).setMoyenneListe(nbVoix/(nbSieges+1));
			System.out.println(tabListes.get(iPoidsMax).getNom() +" a une nouvelle moyenne de "+tabListes.get(iPoidsMax).getMoyenneListe()+" par siege");
		}	
	}

	//Getters et Setters
	
	public int getNbVoixTotal() {
		return nbVoixTotal;
	}

	public void setNbVoixTotal(int nbVoixTotal) {
		this.nbVoixTotal = nbVoixTotal;
	}

	public int getNbVoixUtiles() {
		return nbVoixUtiles;
	}

	public void setNbVoixUtiles(int nbVoixUtiles) {
		this.nbVoixUtiles = nbVoixUtiles;
	}

	public int getNbSiegesAPourvoir() {
		return nbSiegesAPourvoir;
	}

	public void setNbSiegesAPourvoir(int nbSiegesAPourvoir) {
		this.nbSiegesAPourvoir = nbSiegesAPourvoir;
	}

	public int getNbSiegesPourvus() {
		return nbSiegesPourvus;
	}

	public void setNbSiegesPourvus(int nbSiegesPourvus) {
		this.nbSiegesPourvus = nbSiegesPourvus;
	}

	public float getQuotientElectoral() {
		return quotientElectoral;
	}

	public void setQuotientElectoral(float quotientElectoral) {
		this.quotientElectoral = quotientElectoral;
	}

	public ArrayList<ListeElectorale> getTabListes() {
		return tabListes;
	}

	public void setTabListes(ArrayList<ListeElectorale> tabListes) {
		this.tabListes = tabListes;
	}
}
