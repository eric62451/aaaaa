/*
 * Eric Tam
 * 007989423
 * CS157B
 * 03/20/2015
 */

package webservice.dao;

import java.util.List;
import webservice.hibernate.*;

public interface Hw2DAO {
	
	public void addProduct(Product pro);
	public void addCustomer(Customer cust);
	public void addCart(Cart cart, Customer cust);
	public Cart findCart(int id);
	public List<Cart> getAllCarts();
	public List<Product> getAllProducts();
	public List<Customer> getAllCustomers();
	//public void updateProduct(int id, double price);
	public void deleteCart(int id);
	public Customer findCustomer(int id);
	public Product findProduct(int id);

}
