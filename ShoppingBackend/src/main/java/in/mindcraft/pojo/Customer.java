package in.mindcraft.pojo;

public class Customer 
{
	private int c_id;
	private String c_name;
	private int balance;
	
	public Customer() {}
	
	public Customer(int c_id, String c_name, int balance) 
	{
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.balance = balance;
	}
	
	public int getC_id() 
	{
		return c_id;
	}
	public void setC_id(int c_id)
	{
		this.c_id = c_id;
	}
	
	public String getC_name() 
	{
		return c_name;
	}
	public void setC_name(String c_name) 
	{
		this.c_name = c_name;
	}
	
	public int getBalance() 
	{
		return balance;
	}
	public void setBalance(int balance) 
	{
		this.balance = balance;
	}

	public double getWallet() 
	{
		return 0;
	}
}
