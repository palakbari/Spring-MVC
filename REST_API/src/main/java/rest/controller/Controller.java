package rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Controller {

	private List<Product> list = new ArrayList<>();
	
	public Controller()
	{
		list.add(new Product(1, "Book", 50));
		list.add(new Product(2, "Bottle", 200));
		list.add(new Product(3, "Bag", 500));
	}
	
	//get(select)
	@RequestMapping(value="products", method = RequestMethod.GET)
	public List<Product> getProducts()
	{
		System.out.println("Get Products");
		System.out.println(list);
		return list;
	}
	
	//post(insert)
	@RequestMapping(value="products", method = RequestMethod.POST)
	public List<Product> addProduct(@RequestBody Product p1)
	{
		System.out.println("Add Products");
		list.add(p1);
		return list;
	}
	
	//put(update)
	@RequestMapping(value="products/{id}", method = RequestMethod.PUT)
	public List<Product> updateProduct(@PathVariable int id, @RequestBody Product p2)
	{
		for(Product p:list)
		{
			if(p.getId()==id)
			{
				p.setName(p2.getName());
				p.setCost(p2.getCost());
			}
		}
		return null;
	}
	
	//delete
	@RequestMapping(value="products/{id}", method = RequestMethod.DELETE)
	public List<Product> removeProduct(@PathVariable int id)
	{
		Product removepro = null;
		for(Product p:list)
		{
			if(p.getId()==id)
			{
				removepro = p;
				break;
			}
		}
		if(removepro!=null)
		{
			list.remove(removepro);
		}
		return null;
	}
	
	//get with particular variable
	@RequestMapping(value="products/{id}", method = RequestMethod.GET)
	public Product getproduct(@PathVariable int id) 
	{
		for(Product p:list)
		{
			if(p.getId()==id)
			{
				return p;
			}
		}
		return null;
	}	
}
