/*
 * Eric Tam
 * 007989423
 * CS157B
 * 03/20/2015
 */

package webservice.hibernate;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;


@Entity
public class Cart {
	
	private int id;
	private Customer customer;
	private List<Product> products;
	private double total;
	
	public Cart() {
		products = new ArrayList<Product>();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@OneToOne
	//@JoinColumn(name="customer_Id")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.REFRESH})
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@OneToMany
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.REFRESH})
	//@JoinTable(name="order_product",joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public void addProduct(Product temp){
		products.add(temp);
	}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		String ret = "Order ID: " + id + ", Customer Name: "+customer.getName()+", Total: "+getTotal()+", Products: "+ products.get(0).getName();
		for(int i = 1; i<products.size();i++){
			ret = ret +", " + products.get(i).getName();
		}
		return ret;
	}
	
	public void calculateTotal(){
		double t = 0;
		for(Product i:products){
			t = t+i.getPrice();
		}
		total = t;
	}
	

}
