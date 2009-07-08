package dao;

import java.util.List;

import model.Order;

public interface OrderDao {
	public Order create(Order order);
	public boolean update(Order order);
	public boolean delete(Order order);
	public Order findByPrimaryKey(Long primaryKey);
	public List findByExample(Order order, boolean fuzzy);
	public List findAll();
}
