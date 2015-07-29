/*
 * Eric Tam
 * 007989423
 * CS157B
 * 03/20/2015
 */
package webservice.hibernate;

import java.util.*;

import javax.persistence.*;

@Entity
//@Table(name="CUSTOMER_INFO")
public class Customer {
	
	private int id;
	private String name;
	private Cart cart;
	
	public Customer(String name) {
		this.name = name;
	}
	
	public Customer() {
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
	
	@OneToOne
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart order) {
		this.cart = order;
	}
	
	@Override
	public String toString() {
		if(cart != null) return "Customer ID: " + id + ", Name: " + name + ", Order ID: "+ cart.getId();
		else return "Customer ID: " + id + ", Name: " + name + ", Order ID: "+ cart;
	}

}
