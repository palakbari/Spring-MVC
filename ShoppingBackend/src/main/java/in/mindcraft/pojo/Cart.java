package in.mindcraft.pojo;

import java.util.List;

public class Cart 
{
	private String username;
	private List<Product> cart;

	public Cart() 
	{
		super();
	}

	public Cart(String username, List<Product> cart) 
	{
		super();
		this.username = username;
		this.cart = cart;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}

	public List<Product> getCart() 
	{
		return cart;
	}

	public void setCart(List<Product> cart) 
	{
		this.cart = cart;
	}

}
