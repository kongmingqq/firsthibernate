package util;
import model.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class HibernateUtil {
	private static SessionFactory factory;
	
	public static Configuration getInitializedConfiguration() {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(Product.class);
		config.addAnnotatedClass(Order.class);
		config.configure();
		return config;
	}
	
	public static Session getSession() {
		if (factory == null) {
			Configuration config = HibernateUtil.getInitializedConfiguration();
			factory = config.buildSessionFactory();
		}
		Session hibernateSession = factory.getCurrentSession();
		return hibernateSession;
	}
	
	public static void closeSession() {
		HibernateUtil.getSession().close();
	}
	
	public static void recreateDatabase() {
		Configuration config = HibernateUtil.getInitializedConfiguration();
		new SchemaExport(config).create(true,true);
	}
	
	public static Session beginTransaction() {
		Session hibernateSession = HibernateUtil.getSession();
		hibernateSession.beginTransaction();
		return hibernateSession;
	}
	
	public static void commitTransaction() {
		HibernateUtil.getSession().getTransaction().commit();
	}
	
	public static void rollbackTransaction() {
		HibernateUtil.getSession().getTransaction().rollback();
	}
	
	public static void main(String[] args) {
		HibernateUtil.recreateDatabase();
	}
}
