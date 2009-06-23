package dao;

import java.util.List;

import model.Product;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

public class HibernateProductDao extends AbstractDao implements ProductDao {
	public Product create(Product product) {
		if (product.getId() != null && product.getId() != 0) {
			product = null;
		} else {
			super.save(product);
		}
		return product;
	}

	public boolean update(Product product) {
		boolean successFlag = true;
		try {
			if (product.getId() == null || product.getId() == 0) {
				successFlag = false;
			} else {
				super.save(product);
			}
		} catch (Throwable th) {
			successFlag = false;
		}

		return successFlag;
	}

	public boolean delete(Product product) {
		boolean successFlag = true;
		try {
			super.delete(product);
		} catch (Throwable th) {
			successFlag = false;
		}

		return successFlag;
	}

	public Product findByPrimaryKey(Long primaryKey) {
		Product product = (Product) super.findByPrimaryKey(Product.class, primaryKey);
		return product;
	}

	public List findAll() {
		String queryString = "from Product";
		Query queryResult = this.getSession().createQuery(queryString);
		List allProducts = queryResult.list();
		return allProducts;
	}

	public List findByExample(Product product, boolean fuzzy) {
		List products = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(Product.class);
		Example example = Example.create(product);
		
		if(fuzzy) {
			example.enableLike(MatchMode.ANYWHERE);
			example.ignoreCase();
			example.excludeZeroes();
		}
		criteria.add(example);
		products = criteria.list();
		return products;
	}

}
