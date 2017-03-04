package elections.dao.service;

import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList l = new ArrayList();

		l.add("blablabla");
		l.add(10);
		l.add(0.02);
		
		ArrayList types = new ArrayList();
		
		types.add(10);
		types.add(0.1);
		types.add("string");
		
		for(int i = 0 ; i<l.size(); i++){
			System.out.println(l.get(i).getClass().equals(types.get(0).getClass()));
			
			boolean b = l.get(0).equals("blablabla");
		}

	}

}
