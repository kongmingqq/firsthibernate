package services;

import java.util.List;

import model.User;
import model.UserList;
import dao.HibernateUserDao;
import dao.HibernateUtil;
import dao.UserDao;

public class UserService {
	private static UserDao dao = new HibernateUserDao(); 
	//TODO Spring IoC
	
	//TODO HibernateUtil should be decoupled
	public static User addUser(User user) {
		try {
			HibernateUtil.beginTransaction(); 
			user = dao.create(user);
			HibernateUtil.commitTransaction();
			return user;
		} catch (Exception e) {
			HibernateUtil.rollbackTransaction();
            e.printStackTrace();
            return null;
        }

	}
	
	public static User getUser(Long id) {
		User user = null;
		try {
			HibernateUtil.beginTransaction(); 
			user = dao.findByPrimaryKey(id);
			HibernateUtil.commitTransaction();
		} catch (Exception e) {
			HibernateUtil.rollbackTransaction();
            e.printStackTrace();
        }
		return user;
	}
	
	public static UserList getUserList() {
		try {
			UserList users = new UserList();
			HibernateUtil.beginTransaction(); 
			users.setUsers(dao.findAll());
			HibernateUtil.commitTransaction();
			return users;
		} catch (Exception e) {
			HibernateUtil.rollbackTransaction();
            e.printStackTrace();
            return null;
        }
	}
}
