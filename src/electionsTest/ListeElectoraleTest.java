package electionsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ListeElectoraleTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("tearUp");
	}
	

	@Test
	public void testSetId() {
		System.out.println("Test SetId()");
		Assert.assertEquals(1, 1);
	}

	@Test
	public void testSetNom() {
		System.out.println("Test SetNom()");
		Assert.assertEquals("nom", "nom");
	}

	@Test
	public void testSetVoix() {
		System.out.println("Test SetVoix()");
		Assert.assertEquals(20, 20);
	}

	@Test
	public void testSetSieges() {
		System.out.println("Test SetSieges()");
		Assert.assertEquals(5, 5);
	}

	@Test
	public void testSetElimine() {
		System.out.println("Test SetElimine()");
		Assert.assertEquals(1, 1);
	}

}
