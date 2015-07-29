package webservice.hibernate;

import java.util.*;

import javax.persistence.*;

@Entity
public class Customer {
	
	private int id;
	private String name;
	private List<Cart> orders;
	
	public Customer(String name) {
		this.name = name;
		orders = new ArrayList<Cart>();
	}
	
	public Customer() {
		orders = new ArrayList<Cart>();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="Name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy="customer")
	public List<Cart> getOrders() {
		return orders;
	}
	public void setOrders(List<Cart> orders) {
		this.orders = orders;
	}
	public void addOrder(Cart temp){
		orders.add(temp);
	}

}
