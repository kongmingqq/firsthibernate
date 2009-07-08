package dao;

import org.hibernate.Session;

import junit.framework.TestCase;

public class HibernateUtilTest extends TestCase {
	public void testGetSession() {
		Session s1 = HibernateUtil.getSession();
		Session s2 = HibernateUtil.getSession();
		assertEquals(s1,s2);
	}
}
