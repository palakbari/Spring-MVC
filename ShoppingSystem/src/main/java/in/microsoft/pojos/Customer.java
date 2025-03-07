package in.microsoft.pojos;

public class Customer 
{
	private int id;
	private String name;
	private double balance;
	
	public Customer() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String name, double balance) 
	{
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public double getBalance() 
	{
		return balance;
	}

	public void setBalance(double balance) 
	{
		this.balance = balance;
	}

	public void addBalance(double add)
	{
		balance += add;
	}
	
	@Override
	public String toString() 
	{
		return "Customer [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}

}
