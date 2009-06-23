package action;

import model.Product;

import org.hibernate.HibernateException;

import util.HibernateUtil;
import util.UserInterfaceUtil;
import dao.HibernateProductDao;
import dao.ProductDao;

public class AddProducts extends Action {

	@Override
	public void perform() {
		int keepAdding = 1;
		while (keepAdding == 1) {
			Product product = new Product();
			String title = UserInterfaceUtil.promptAndGetString("What is Product Title? ");
			product.setTitle(title);
			Double price = UserInterfaceUtil.promptAndGetDouble("What is Product Price? ");
			product.setPrice(price);
			try {
				HibernateUtil.beginTransaction();
				ProductDao productDao = new HibernateProductDao();
				productDao.create(product);
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
