package action;

import java.util.List;

import org.hibernate.HibernateException;

import util.HibernateUtil;
import dao.HibernateProductDao;
import dao.ProductDao;

public class ListProducts extends Action {

	@Override
	public void perform() {
		
		try {
			HibernateUtil.beginTransaction();
			ProductDao productDao = new HibernateProductDao();
			List allProducts = productDao.findAll();
			System.out.println(allProducts);
			HibernateUtil.commitTransaction();
		} catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("DB Insert failed");
			System.out.println(e.getClass()+e.getMessage());
		}
	}

}