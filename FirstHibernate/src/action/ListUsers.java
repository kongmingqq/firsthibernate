package action;

import java.util.List;

import org.hibernate.HibernateException;

import util.HibernateUtil;
import dao.HibernateUserDao;
import dao.UserDao;

public class ListUsers extends Action {

	@Override
	public void perform() {
		
		try {
			HibernateUtil.beginTransaction();
			UserDao userDao = new HibernateUserDao();
			List allUsers = userDao.findAll();
			System.out.println(allUsers);
			HibernateUtil.commitTransaction();
		} catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("DB Insert failed");
			System.out.println(e.getClass()+e.getMessage());
		}
	}

}
