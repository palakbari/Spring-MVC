package in.microsoft.pojos;

public class Product 
{
	private int pro_id;
	private String pro_name;
	private double pro_price;
	private int pro_quantity;
	private int pro_discount;
	
	public Product() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(int pro_id, String pro_name, double pro_price, int pro_quantity, int pro_discount) 
	{
		super();
		this.pro_id = pro_id;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
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
	
	public double getPro_price() 
	{
		return pro_price;
	}
	
	public void setPro_price(double pro_price) 
	{
		this.pro_price = pro_price;
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
	
	@Override
	public String toString() 
	{
		return "Product [pro_id=" + pro_id + ", pro_name=" + pro_name + ", pro_price=" + pro_price + ", pro_quantity="
				+ pro_quantity + ", pro_discount=" + pro_discount + "]";
	}
	
}
