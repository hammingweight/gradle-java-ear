package javaeems.chapter1.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

public class ModelEJBTest {

	private ModelEJB ejb;
	
	@Before
	public void setUp() {
		ejb = new ModelEJB();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("foobar");
		ejb.em = emf.createEntityManager();
	}
	
	@Test(expected=MessageException.class)
	public void testNothingInDB() throws MessageException {
		ejb.getStoredMessage();
	}

}
