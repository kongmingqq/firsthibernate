package dao;

import org.hibernate.Session;

import util.HibernateUtil;

public abstract class AbstractDao {
	protected Session getSession() {
		return HibernateUtil.getSession();
	}
	
	protected void save(Object pojo) {
		Session hibernateSession = this.getSession();
		hibernateSession.saveOrUpdate(pojo);
	}
	
	protected void delete(Object pojo) {
		Session hibernateSession = this.getSession();
		hibernateSession.delete(pojo);
	}
	
	protected Object findByPrimaryKey(Class c, Long primaryKey) {
		Session hibernateSession = this.getSession();
		Object pojo = hibernateSession.get(c, primaryKey);
		return pojo;
	}
}
