package action;

import org.hibernate.HibernateException;

import dao.UserDao;
import dao.UserDaoImpl;
import util.HibernateUtil;
import util.UserInterfaceUtil;
import model.User;

public class AddUsers extends Action {

	@Override
	public void perform() {
		int keepAdding = 1;
		while (keepAdding == 1) {
			User user = new User();
			String name = UserInterfaceUtil.promptAndGetString("What is User Name? ");
			user.setName(name);
			try {
				HibernateUtil.beginTransaction();
				UserDao userDao = new UserDaoImpl();
				userDao.create(user);
				HibernateUtil.commitTransaction();
			} catch(HibernateException e) {
				e.printStackTrace();
				System.out.println("DB Insert failed");
				System.out.println(e.getClass()+e.getMessage());
			}
			keepAdding = UserInterfaceUtil.promptAndGetInt("Continue? 1=y 0=n ");
		}
	}

}
