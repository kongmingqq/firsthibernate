package dao;

import java.util.List;

import model.Product;

public interface ProductDao {
	public Product create(Product product);
	public boolean update(Product product);
	public boolean delete(Product product);
	public Product findByPrimaryKey(Long primaryKey);
	public List findByExample(Product product, boolean fuzzy);
	public List findAll();
}
