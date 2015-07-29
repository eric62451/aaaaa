/*
 * Eric Tam
 * 007989423
 * CS157B
 * 03/20/2015
 */

package webservice.restful;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import webservice.hibernate.OrderEntryService;

@Path("/")
public class Restful{

	private static OrderEntryService service = new OrderEntryService();
	
	
	@GET
	@Path("/orders")
	@Produces(MediaType.TEXT_PLAIN)
	public String allOrders() 
    { 
		return service.getAllCarts();
    }
	
	@GET
	@Path("/orders/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String orderByID(@PathParam("id") int id) 
    { 
		return service.getCartByID(id);
    }
	
	@GET
	@Path("/products")
	@Produces(MediaType.TEXT_PLAIN)
	public String allProducts() 
    { 
		return service.getAllProducts();
    }
	
	@GET
	@Path("/customers")
	@Produces(MediaType.TEXT_PLAIN)
	public String allCustomers() 
    { 
		return service.getAllCustomers();
    }
	
	@POST
	@Path("/orders")
	@Produces(MediaType.TEXT_PLAIN)
	public String newOrder(@FormParam("products") String products, @FormParam("customer") int id) 
    { 
		return service.addNewOrder(products, id);
    }
	
	@POST
	@Path("/customers")
	@Produces(MediaType.TEXT_PLAIN)
	public String newCustomer(@FormParam("name") String name) 
    { 
		return service.addNewCustomer(name);
    }
	
	@POST
	@Path("/products")
	@Produces(MediaType.TEXT_PLAIN)
	public String newProduct(@FormParam("name") String name, @FormParam("price") double price) 
    { 
		return service.addNewProduct(name, price);
    }
	
	@PUT
	@Path("/products/{id}/{newprice}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProductPrice(@PathParam("id") int id, @PathParam("newprice") double price) 
    { 
		return service.updateProductPrice(id,price);
    }
	
	@DELETE
	@Path("/orders/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteOrder(@PathParam("id") int id) 
    { 
        return service.deleteOrder(id);
    }
    
	
}
