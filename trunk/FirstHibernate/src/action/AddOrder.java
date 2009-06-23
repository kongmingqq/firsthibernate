package action;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import model.*;

import org.hibernate.HibernateException;

import util.HibernateUtil;
import util.UserInterfaceUtil;
import dao.*;

public class AddOrder extends Action {

	@Override
	public void perform() {
		//select a user
		Action action = new ListUsers();
		action.perform();
		long userid = UserInterfaceUtil.promptAndGetLong("Order for which user? (id)");
		
		HibernateUtil.beginTransaction();
		UserDao userDao = new HibernateUserDao();
		User user = userDao.findByPrimaryKey(userid);
		HibernateUtil.commitTransaction();
		
		Order order = new Order();
		order.setUser(user);
		order.setOrderTime(new Date());
		
		int keepAdding = 1;
		while (keepAdding == 1) {
			action = new ListProducts();
			action.perform();
			
			long productid = UserInterfaceUtil.promptAndGetLong("Order which book? (id)");

			HibernateUtil.beginTransaction();
			ProductDao productDao = new HibernateProductDao();
			Product product = productDao.findByPrimaryKey(productid);
			HibernateUtil.commitTransaction();
			
			if(product!=null) {
				order.getProducts().add(product);
			} else {
				System.out.println("Invalid product id.");
			}
			keepAdding = UserInterfaceUtil.promptAndGetInt("Add another product? 1=y 0=n ");
		}

		try {
			HibernateUtil.beginTransaction();
			OrderDao orderDao = new HibernateOrderDao();
			orderDao.create(order);
			HibernateUtil.commitTransaction();
			System.out.println("Your order has been placed!");
		} catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("DB Insert failed");
			System.out.println(e.getClass()+e.getMessage());
		}
	}

}
