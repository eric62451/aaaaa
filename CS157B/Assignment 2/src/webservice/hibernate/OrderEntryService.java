/*
 * Eric Tam
 * 007989423
 * CS157B
 * 03/20/2015
 */
package webservice.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;

import webservice.dao.*;

public class OrderEntryService {
	
	SessionFactory sessionfactory;
	Session session;
	Hw2DAO dao;
	
	public OrderEntryService() {
		sessionfactory = HibernateUtil.getSessionFactory();
		session = sessionfactory.openSession();
		dao = new ConcreteHw2DAO(session);
		
		Transaction transaction = session.beginTransaction();
		Product pone = new Product("Diamond",3499);
		Product ptwo = new Product("Dress", 999.99);
		Cart oone = new Cart();
		Customer cone = new Customer("Jessica");
		oone.setCustomer(cone);
		oone.addProduct(pone);
		oone.addProduct(ptwo);
		cone.setCart(oone);
		//Cart otwo = new Cart();
		//Customer ctwo = new Customer("Erica");
		Product pthree = new Product("Laptop",649);
		Product pfour = new Product("Smartphone", 300);
		oone.calculateTotal();
		//otwo.addProduct(pthree);
		//otwo.addProduct(pfour);
		//otwo.setCustomer(ctwo);
		//ctwo.setCart(otwo);
		//session.save(otwo);
		session.save(oone);
		//session.save(ctwo);
		session.save(pthree);
		session.save(pfour);
		transaction.commit();
		session.clear();
		
	}
	
	public void close(){
		session.clear();
		session.close();
		sessionfactory.close();
	}
	
	public String getAllCarts(){
		List<Cart> carts = dao.getAllCarts();
		String ret = "";
		for(Cart i : carts){
			ret = ret+i.toString()+"\n";
		}
		session.beginTransaction().commit();
		return ret;
	}
	
	public String getCartByID(int id){
		Cart temp = dao.findCart(id);
		String ret;
		if(temp != null) ret = temp.toString();
		else ret = "No Order found with ID: " +id ;
		session.beginTransaction().commit();
		return ret;
	}
	
	public String getAllProducts(){
		List<Product> products = dao.getAllProducts();
		String ret = "";
		for(Product i : products){
			ret = ret+i.toString()+"\n";
		}
		return ret;
	}
	
	public String getAllCustomers(){
		List<Customer> customers = dao.getAllCustomers();
		String ret = "";
		for(Customer i : customers){
			ret = ret+i.toString()+"\n";
		}
		return ret;
	}
	
	public String addNewOrder(String products, int id){
		if(products == null) return "products cannot be empty/null";
		products = products.replaceAll(" ", "");
		String[] pid = products.split(",");
		Cart temp = new Cart();
		Customer cust = dao.findCustomer(id);
		if(cust != null) temp.setCustomer(cust);
		else return "Customer with ID: " + id + " Does not exist!";
		List<Product> prod = new ArrayList<Product>();
		for(int i=0;i<pid.length;i++){
			Product a = dao.findProduct(Integer.parseInt(pid[i]));
			if(a != null) temp.addProduct(a);
			else return "Product with ID: " + pid[i] + " does not exist!";
		}
		cust.setCart(temp);
		temp.calculateTotal();
		dao.addCart(temp, cust);
		
		return "Order added";
	}
	
	public String addNewCustomer(String name){
		if(name == null) return "Customer name cannot be empty/null";
		Customer cust = new Customer(name);
		dao.addCustomer(cust);
		return "Customer Added";
	}
	
	public String addNewProduct(String name, double price){
		if(name == null) return "Product name cannot be empty/null";
		Product prod = new Product(name,price);
		dao.addProduct(prod);
		return "Product Added";
	}
	
	public String updateProductPrice(int id, double price){
		Product prod = dao.findProduct(id);
		if(prod == null) return "Product with ID: " + id +" does not exist!";
		prod.setPrice(price);
		dao.addProduct(prod);
		return "Product Updated";
	}
	
	public String deleteOrder(int id){
		Cart temp = dao.findCart(id);
		Customer cust = temp.getCustomer();
		cust.setCart(null);
		dao.addCustomer(cust);
		dao.deleteCart(id);
		return "Order Deleted";
	}
	
}
