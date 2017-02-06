package elections;

import java.util.Comparator;


public class CompareListes implements Comparator<ListeElectorale> {
	
	public int compare(ListeElectorale l1, ListeElectorale l2){
		
		if(l1.getVoix() == l2.getVoix()) 
			return 0;
		else if(l1.getVoix() > l2.getVoix()) 
			return 1;
		else 
			return -1;
	}

}
