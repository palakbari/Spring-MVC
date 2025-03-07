package in.mindcraft.pojo;

public class Product 
{
	private int pro_id;
	private String pro_name;
	private int pro_cost;
	private int pro_quantity;
	private int pro_discount;
	
	public Product() {}
	
	public Product(int pro_id, String pro_name, int pro_cost, int pro_quantity, int pro_discount) 
	{
		super();
		this.pro_id = pro_id;
		this.pro_name = pro_name;
		this.pro_cost = pro_cost;
		this.pro_quantity = pro_quantity;
		this.pro_discount = pro_discount;
	}
	
	public int getPro_id() 
	{
		return pro_id;
	}
	public void setPro_id(int pro_id) 
	{
		this.pro_id = pro_id;
	}
	
	public String getPro_name() 
	{
		return pro_name;
	}
	public void setPro_name(String pro_name) 
	{
		this.pro_name = pro_name;
	}
	
	public int getPro_cost() 
	{
		return pro_cost;
	}
	public void setPro_cost(int pro_cost) 
	{
		this.pro_cost = pro_cost;
	}
	
	public int getPro_quantity() 
	{
		return pro_quantity;
	}
	public void setPro_quantity(int pro_quantity) 
	{
		this.pro_quantity = pro_quantity;
	}
	
	public int getPro_discount() 
	{
		return pro_discount;
	}
	public void setPro_discount(int pro_discount) 
	{
		this.pro_discount = pro_discount;
	}
}
