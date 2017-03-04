package elections.dao.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import elections.dao.service.IElectionsDao;
import elections.dao.service.IoUtil;

@RunWith(SpringJUnit4ClassRunner.class)
public class JUnitTestsElectionsDaoFile {

	/**
	 * instance d'accès à la couche [dao]
	 */
	// couche [dao]
	@Autowired
	@Qualifier("electionsDaoFile")
	private IElectionsDao electionsDaoFile;

	@Test
	public void testInitFileGood() {
		assertEquals("elections-in-good.txt", electionsDaoFile.getInitFile());
		
	}
	
	@Test
	public void testLectureDataElections() throws IOException {
		
		String bad = "elections-in-bad.txt";
		List l = new ArrayList();
		
		l = IoUtil.getInitDataFromFile(bad);
		
	}

	@Test
	public void testEcritureResultatsElections(){
		
		electionsDaoFile.setListesElectorales(null);
	}
}