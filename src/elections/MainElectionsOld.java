/*package elections;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class CompareListes implements Comparator<ListeElectorale>{
	
	public int compare(ListeElectorale l1, ListeElectorale l2){
		
		if(l1.getVoix() == l2.getVoix()) 
			return 0;
		else if(l1.getVoix() > l2.getVoix()) 
			return 1;
		else 
			return -1;
}
	
public class MainElections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int voixUtiles = 0;
		int siegesRest = 0;
		int iMax = 0;
		int i = 1;
		int j = 0;
		float quotientElectoral, moyenneMax;
		
			
		
		
		
		
	
		
	
		
		
		
		for(ListeElectorale l : tListes){
			
			System.out.println(l);
		}
		
		//Copie de tListes dans un tableau à taille fixe
		
		tabListes = tListes.toArray(tabListes);
		
		//On détermine quelles listes sont eligibles et le nombre de voix utiles
		
		for(i = 0 ; i < tabListes.length ; i++){
			
			System.out.println(tabListes[i].getNom() + " " + tabListes[i].getVoix());
			if(((float)tabListes[i].getVoix() / voixTotal) < 0.05){
				
				tabListes[i].setElimine(true);
			}else 
				voixUtiles += tabListes[i].getVoix();
		}
				
				
		
		//Listes non éliminées ?
	    
		if(voixUtiles == 0){
	    	
	    	System.out.println("Erreur : Toutes les listes ont été éliminées");
	    	System.exit(1);
	    }
	    
	    
	    //Répartition des sièges au quotient
	    
	    quotientElectoral = voixUtiles / nbSiegesAPourvoir;
	    nbSiegesPourvus = 0;
	    for(i = 0 ; i < tabListes.length ; i++){
	    	
	    	if(!tabListes[i].isElimine()){
                
	    		int nbSieges = Math.abs((int)(tabListes[i].getVoix()/quotientElectoral));
	    		tabListes[i].setSieges(nbSieges);
                nbSiegesPourvus += tabListes[i].getSieges();
	    	}else 
	    		
	    		tabListes[i].setSieges(0);
	    }
	    
	    siegesRest = nbSiegesAPourvoir - nbSiegesPourvus;
	    
	    
	    //Répartition des sièges restants à la plus forte moyenne
	    //Un siège est attribué à chaque tour de boucle
	    
	    for(i = 0 ; i < siegesRest ; i++){
	    	
	    	//Recherche de la liste ayant la + forte moyenne
	    	moyenneMax = -1;
	    	for(j = 0 ; j < tabListes.length ; j++){
	    		
	    		if((!tabListes[j].isElimine()) && tabListes[j].getMoyenneListe() > moyenneMax){
	    			
	    			moyenneMax = (float) tabListes[j].getMoyenneListe();
	    			iMax = j;
	    		}
	    	}
	    	tabListes[iMax].addSiege(1);
	    }
	    	
	    
	    //Affichage des résultats
	    System.out.println("Résultats après répartition de sièges restants: ");
	    System.out.println("\n");
	    for(ListeElectorale l : tabListes){
	    	if(!l.isElimine())
	    		System.out.println(l);
	    } 		
	}
}

*/
	    
	    
                

		

		
		



