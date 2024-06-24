package in.microsoft.pojo;

public class Customer 
{
	private int acc_no;
	private String name;
	private double balance;
	
	public Customer() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(int acc_no, String name, double balance) 
	{
		super();
		this.acc_no = acc_no;
		this.name = name;
		this.balance = balance;
	}
	
	public int getAcc_no() 
	{
		return acc_no;
	}
	
	public void setAcc_no(int acc_no) 
	{
		this.acc_no = acc_no;
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
	
	@Override
	public String toString() 
	{
		return "Customer [acc_no=" + acc_no + ", name=" + name + ", balance=" + balance + "]";
	}
}
