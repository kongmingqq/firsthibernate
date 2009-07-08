package dao;

import org.hibernate.Session;

public abstract class AbstractDao {
	Session session;
	
	protected void setSession(Session session) {
		this.session = session;
	}
	
	protected Session getSession() {
		return HibernateUtil.getSession();
		//if(session==null) setSession(HibernateUtil.getSession());
		//return session;
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
