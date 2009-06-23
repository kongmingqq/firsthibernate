package dao;

import java.util.List;

import model.User;

public interface UserDao {
	public User create(User user);
	public boolean update(User user);
	public boolean delete(User user);
	public User findByPrimaryKey(Long primaryKey);
	public List findByExample(User user, boolean fuzzy);
	public List findAll();
}
