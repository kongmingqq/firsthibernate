package config;

import javax.xml.bind.JAXBContext;

import model.User;
import dao.HibernateUserDao;

import junit.framework.TestCase;

public class JAXBContextResolverTest extends TestCase {
	private final Class jaxbClass = User.class;
	private final Class nonJaxbClass = HibernateUserDao.class;
	
	/**
	 * Tests that JAXBContextResolver can return correct corresponding 
	 * @throws Exception
	 */
	public void testGetContext() throws Exception {
		JAXBContextResolver cr = new JAXBContextResolver();
		JAXBContext c = cr.getContext(jaxbClass);
		assertNotNull(c);
		c = null;
		cr.getContext(nonJaxbClass);
		assertNull(c);
	}

}
