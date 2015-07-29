/*
 * Eric Tam
 * 007989423
 * CS157B
 * 03/20/2015
 */

package webservice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import webservice.hibernate.Cart;
import webservice.hibernate.Customer;
import webservice.hibernate.Product;

public class ConcreteHw2DAO implements Hw2DAO {

	private Session session;

	public ConcreteHw2DAO(Session session) {
		this.session = session;
	}

	@Override
	public void addProduct(Product pro) {
		Transaction transaction = session.beginTransaction();
		session.save(pro);
		transaction.commit();

	}

	@Override
	public void addCustomer(Customer cust) {
		Transaction transaction = session.beginTransaction();
		session.save(cust);
		transaction.commit();

	}

	@Override
	public void addCart(Cart cart, Customer cust) {
		Transaction transaction = session.beginTransaction();
		session.save(cart);
		session.save(cust);
		transaction.commit();

	}

	@Override
	public Cart findCart(int id) {
		return (Cart) session.get(Cart.class, id);
	}

	@Override
	public List<Cart> getAllCarts() {
		// TODO Auto-generated method stub
		return session.createCriteria(Cart.class).list();
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return session.createCriteria(Product.class).list();
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return session.createCriteria(Customer.class).list();
	}

//	@Override
//	public void updateProduct(int id, double price) {
//		Transaction transaction = session.beginTransaction();
//		session.clear();
//		Product temp = (Product) session.get(Product.class, id);
//		if (temp != null) {
//			temp.setPrice(price);
//			session.save(temp);
//			transaction.commit();
//		}
//
//	}

	@Override
	public void deleteCart(int id) {
		Transaction transaction = session.beginTransaction();
		session.clear();
		Cart temp = (Cart) session.get(Cart.class, id);
		session.delete(temp);
		transaction.commit();

	}

	@Override
	public Customer findCustomer(int id) {
		return (Customer) session.get(Customer.class, id);

	}

	@Override
	public Product findProduct(int id) {
		return (Product) session.get(Product.class, id);

	}

}
