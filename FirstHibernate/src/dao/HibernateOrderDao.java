package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import model.Order;
import model.Product;

public class HibernateOrderDao extends AbstractDao implements OrderDao {
	public Order create(Order order) {
		if (order.getId() != null && order.getId() != 0) {
			order = null;
		} else {
			super.save(order);
		}
		return order;
	}

	public boolean update(Order order) {
		boolean successFlag = true;
		try {
			if (order.getId() == null || order.getId() == 0) {
				successFlag = false;
			} else {
				super.save(order);
			}
		} catch (Throwable th) {
			successFlag = false;
		}

		return successFlag;
	}

	public boolean delete(Order order) {
		boolean successFlag = true;
		try {
			super.delete(order);
		} catch (Throwable th) {
			successFlag = false;
		}

		return successFlag;
	}

	public Order findByPrimaryKey(Long primaryKey) {
		Order order = (Order) super.findByPrimaryKey(Order.class, primaryKey);
		return order;
	}

	public List findAll() {
		String queryString = "from Order";
		Query queryResult = this.getSession().createQuery(queryString);
		List allOrders = queryResult.list();
		return allOrders;
	}

	public List findByExample(Order order, boolean fuzzy) {
		List orders = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(Order.class);
		Example example = Example.create(order);
		
		if(fuzzy) {
			example.enableLike(MatchMode.ANYWHERE);
			example.ignoreCase();
			example.excludeZeroes();
		}
		criteria.add(example);
		orders = criteria.list();
		return orders;
	}
}
