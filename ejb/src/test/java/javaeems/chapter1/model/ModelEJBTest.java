package javaeems.chapter1.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ModelEJBTest {

	private ModelEJB ejb;
	
	private EntityManagerFactory emf;
	
	@Before
	public void setUp() {
		ejb = new ModelEJB();
		emf = Persistence.createEntityManagerFactory("foobar");
		ejb.em = emf.createEntityManager();
	}
	
	@After
	public void tearDown() {
		if (ejb.em != null) {
			ejb.em.close();
		}
		if (emf != null) {
			emf.close();
		}
	}
	
	@Test(expected=MessageException.class)
	public void testNothingInDB() throws MessageException {
		ejb.getStoredMessage();
	}

}
