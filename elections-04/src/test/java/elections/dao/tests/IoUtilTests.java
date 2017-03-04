package elections.dao.tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;

import elections.dao.entities.ListeElectorale;
import elections.dao.service.IoUtil;

public class IoUtilTests {
	
	private List<ListeElectorale> listes = new ArrayList<ListeElectorale>();
	private String logFileName = null;
	private String outFile = null;
	
	@BeforeClass
	public static void setUpClass(){
		
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("+      Début des tests    +");
		System.out.println("+++++++++++++++++++++++++++\n\n");
		
		
	}
	
	@AfterClass
	public static void tearDownClass() throws IOException{
		
		System.out.println("\n\n+++++++++++++++++++++++++++");
		System.out.println("+       Fin des tests     +");
		System.out.println("+++++++++++++++++++++++++++\n\n");
		
	}
	
	@Before
	public void setUp(){
		
		TestName name = new TestName();
		System.out.println("===========================================");
		System.out.println("| Test "+name.getMethodName()+" |");
		System.out.println("===========================================");
	}
	
	@After
	public void tearDown(){
		
		TestName name = new TestName();
		System.out.println("===========================================");
		System.out.println("| Fin du test "+ name.getMethodName()+" |");
		System.out.println("===========================================");
		
	}
	
	@Test
	public void saveListToFileTest() throws IOException { 
		
		ListeElectorale l1 = new ListeElectorale(1, "A", 2000, 5, false);
		ListeElectorale l2 = new ListeElectorale(2, "B", 1000, 2, false);
		listes.add(0,l1);
		listes.add(1,l2);
		
		outFile = "elections-out.xml";
		logFileName = "elections-log";
		
		System.out.println(listes.toString());
		System.out.println("### Ecriture des listes dans le fichier \""+outFile+"\" ###");
		
		assertTrue(IoUtil.saveListesToFile(listes, logFileName, outFile));
	}
	
	@Test
	public void getStringFromFileTest(){
		
		String str = IoUtil.getStringFromFile(outFile);
		System.out.println("\n### Récupération des listes avec getStringFromFile...###\n");
		System.out.println(str);
	}
	
	@Test
	public void convertFromXmlTest(){
		
		System.out.println("\n\n### Récupération des listes dans \"String xml\" ###\n");
		String xml = IoUtil.getStringFromFile(outFile);
		System.out.println("\n*String récupéré : \n"+xml+"\n\n");
		
		List<ListeElectorale> listesDest = new ArrayList<ListeElectorale>();
		
		System.out.println("### Conversion du \"String xml\" vers listeDest ###");
		listesDest = IoUtil.convertFromXml(xml);
		System.out.println(listesDest.toString());
	}
	

}
