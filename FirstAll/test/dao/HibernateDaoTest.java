/**
 * 
 */
package dao;

import model.User;
import junit.framework.TestCase;

//TODO implement test database for this test

/**
 * Test Hibernate DAOs. Now only userDao is tested. Ideally should test all DAOs. 
 * Also this test should not touch production database.
 * @author mingkong
 *
 */
public class HibernateDaoTest extends TestCase {
	/**
	 * 
	 */
	public void testUserDaoCreate() {
		UserDao dao = new HibernateUserDao();
		User user = new User();
		user.setName("Test Create/Delete");
		user.setPassword("123");
		HibernateUtil.beginTransaction();
		User dbUser = dao.create(user);
		Long id = dbUser.getId();
		
		User dbUserQuery = dao.findByPrimaryKey(id);
		assertEquals(dbUser, dbUserQuery);

		//delete
		dao.delete(dbUserQuery);
		HibernateUtil.commitTransaction();
		
	}
	/**
	 * Test rollback. Notice that only InnoDB engine supports rollback. Specify MySQL5InnoDBDialect in 
	 * Hibernate configuration.
	 */
	public void testUserDaoRollback() {
		UserDao dao = new HibernateUserDao();
		User user = new User();
		user.setName("Test Rollback");
		user.setPassword("222222");
		
		HibernateUtil.beginTransaction();
		User dbUser = dao.create(user);
		Long id = dbUser.getId();
		HibernateUtil.rollbackTransaction();
		
		HibernateUtil.beginTransaction();
		User dbUserQuery = dao.findByPrimaryKey(id);
		HibernateUtil.commitTransaction();
		assertNull(dbUserQuery);
	}
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
