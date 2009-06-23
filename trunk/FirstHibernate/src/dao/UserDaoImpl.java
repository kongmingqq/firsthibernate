package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import model.User;

public class UserDaoImpl extends AbstractDao implements UserDao {

	@Override
	public User create(User user) {
		if (user.getId() != null && user.getId() != 0) {
			user = null;
		} else {
			super.save(user);
		}
		return user;
	}

	@Override
	public boolean update(User user) {
		boolean successFlag = true;
		try {
			if (user.getId() == null || user.getId() == 0) {
				successFlag = false;
			} else {
				super.save(user);
			}
		} catch (Throwable th) {
			successFlag = false;
		}

		return successFlag;
	}

	@Override
	public boolean delete(User user) {
		boolean successFlag = true;
		try {
			super.delete(user);
		} catch (Throwable th) {
			successFlag = false;
		}

		return successFlag;
	}

	@Override
	public User findByPrimaryKey(Long primaryKey) {
		User user = (User) super.findByPrimaryKey(User.class, primaryKey);
		return user;
	}

	@Override
	public List findAll() {
		String queryString = "from User";
		Query queryResult = this.getSession().createQuery(queryString);
		List allUsers = queryResult.list();
		return allUsers;
	}

	@Override
	public List findByExample(User user, boolean fuzzy) {
		List users = null;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(User.class);
		Example example = Example.create(user);
		
		if(fuzzy) {
			example.enableLike(MatchMode.ANYWHERE);
			example.ignoreCase();
			example.excludeZeroes();
		}
		criteria.add(example);
		users = criteria.list();
		return users;
	}

}
