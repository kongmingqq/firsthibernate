package services;

import dao.HibernateUserDao;
import dao.HibernateUtil;
import dao.UserDao;
import model.*;
import junit.framework.TestCase;
/**
 * Dependent on Daos
 * @author mingkong
 *
 */
public class UserServiceTest extends TestCase {
	public void testCreate() {
		User user = new User();
		user.setName("A new user");
		user.setPassword("123");
		
		User addedUser = UserService.addUser(user);
		assertNotNull(addedUser);
		
		UserDao dao = new HibernateUserDao();
		HibernateUtil.beginTransaction();
		dao.delete(addedUser);
		HibernateUtil.commitTransaction();
		addedUser = UserService.addUser(null);
		assertNull(addedUser);
    } 
	
	public void testGetUserNull() {
        User u = UserService.getUser(new Long(-1));
        assertNull(u);
    } 

	public void testGetUser() {
		UserDao dao = new HibernateUserDao();
		User user = new User();
		user.setName("Test UserService");
		user.setPassword("123");
		
		HibernateUtil.beginTransaction();
		User dbUser = dao.create(user);
		Long id = dbUser.getId();
        HibernateUtil.commitTransaction();
		
		User serviceUser = UserService.getUser(id);
        assertEquals(dbUser.getName(),serviceUser.getName());
        assertEquals(dbUser.getPassword(),serviceUser.getPassword());
        //TODO: discovery more, should override equals()?
        
        HibernateUtil.beginTransaction();
		dao.delete(dbUser);
        HibernateUtil.commitTransaction();
    } 
	
	public void testGetUserList() {
		UserDao dao = new HibernateUserDao();
		
		HibernateUtil.beginTransaction();
		int listSize = dao.findAll().size();
        HibernateUtil.commitTransaction();
		
		int serviceListSize = UserService.getUserList().getUsers().size();
        assertEquals(listSize,serviceListSize);
    } 
	
/*	public void testGetUserException() {
        User u = null;
        try {
            u = UserService.getUser(2);
            assertNull(u);
            fail("Should have gotten Exception - used a bad user ID");
        } catch (Exception expected) {
            ; // Expected - intentional
        }
    } */ //method to test exception
}
