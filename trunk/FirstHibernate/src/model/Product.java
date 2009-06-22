package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FH_PRODUCT")
public class Product {
	private Integer id;
	private String title;
	private Double price;
	/*
	 * This is not necessary at least for now.
	 * 
	private List<Order> orders;

	@ManyToMany
	@JoinTable(name = "FH_ORDERLINE",
			joinColumns = { @JoinColumn(name = "order_id")},
			inverseJoinColumns = { @JoinColumn(name = "product_id")}
	)
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	*/

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
