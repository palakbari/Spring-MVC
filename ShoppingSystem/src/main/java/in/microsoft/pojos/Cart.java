package in.microsoft.pojos;

public class Cart 
{
	private String username;
	private int pro_id;
	private String pro_name;
	private double pro_price;
	private int pro_quantity;
	private int pro_discount;
	private String invoiced;

	public Cart() 
	{
		super();
	}

	public Cart(String username, int pro_id, String pro_name, double pro_price, int pro_quantity, int pro_discount, String invoiced) 
	{
		super();
		this.username = username;
		this.pro_id = pro_id;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
		this.pro_quantity = pro_quantity;
		this.pro_discount = pro_discount;
		this.invoiced = invoiced;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
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

	public double getPro_price() {
		return pro_price;
	}

	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}

	public int getPro_quantity() {
		return pro_quantity;
	}

	public void setPro_quantity(int pro_quantity) {
		this.pro_quantity = pro_quantity;
	}

	public int getPro_discount() {
		return pro_discount;
	}

	public void setPro_discount(int pro_discount) {
		this.pro_discount = pro_discount;
	}

	public String getInvoiced() {
		return invoiced;
	}

	public void setInvoiced(String invoiced) {
		this.invoiced = invoiced;
	}


	
}