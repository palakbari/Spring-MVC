package in.microsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.microsoft.pojos.Customer;
import in.microsoft.utils.DBUtils;

public class CustomerDAO 
{
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	private PreparedStatement pst4;
	private PreparedStatement pst5;
	private PreparedStatement pst6;
	private PreparedStatement pst7;
	private PreparedStatement pst8;
	private PreparedStatement pst9;
	
	public void addCustomers(Customer customer) throws SQLException, ClassNotFoundException
	{
		cn = DBUtils.openConnection();
		pst1 = cn.prepareStatement("Insert into customer values (?,?,?)");
		pst1.setInt(1, customer.getId());
		pst1.setString(2, customer.getName());
		pst1.setDouble(3, customer.getBalance());
		pst1.execute();
		DBUtils.closedConnection();
	}
	
	public boolean checkCustomer(String username) throws SQLException, ClassNotFoundException
	{
		boolean b = false;
		cn = DBUtils.openConnection();
		pst2 = cn.prepareStatement("Select * from customer where name = ?");
		pst2.setString(1, username);
		ResultSet resultSet = pst2.executeQuery();
        b = resultSet.next();
		DBUtils.closedConnection();
        return b;
	}
	
	public List<Customer> showCustomers() throws SQLException, ClassNotFoundException
	{
		cn = DBUtils.openConnection();
		List<Customer> list = new ArrayList<>();
		pst3 = cn.prepareStatement("Select * from customer");
		ResultSet rs = pst3.executeQuery();
		while(rs.next())
		{
			list.add(new Customer(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
		}
		System.out.println("Show Customers");
		DBUtils.closedConnection();
		return list;
	}
	
	public void removeCustomers(int c) throws SQLException, ClassNotFoundException
	{
   	 	cn = DBUtils.openConnection();
   	 	pst4 = cn.prepareStatement("Delete from customer where id = ?");
		pst4.setInt(1, c);
		pst4.execute();
		DBUtils.closedConnection();
	}
	
	public boolean checkBalance(String username, double amt) throws SQLException, ClassNotFoundException
	{
		double balance = 0.0;
		boolean isSufficient = false;
		cn = DBUtils.openConnection();
		pst5 = cn.prepareStatement("Select balance from customer where id = ?");
		pst5.setString(1, username);
		ResultSet resultSet = pst5.executeQuery();
        if(resultSet.next()) 
        {
        	balance = resultSet.getDouble(1);
        }
        
        System.out.println(balance);
        if(amt < balance) 
        {
        	isSufficient = true;
        	balance = balance - amt;
        	pst6 = cn.prepareStatement("Update customer set balance = ? where id = ?");	
        	pst6.setDouble(1, balance);
        	pst6.setString(2, username);
        	pst6.execute();
        	pst7 = cn.prepareStatement("Update cart set invoiced = 'Yes' where id = ?");
        	pst7.setString(1, username);
        	pst7.execute();
        }
		return isSufficient;
	}
	
	public void addBalance(String name, int amount) throws SQLException, ClassNotFoundException 
	{
		cn = DBUtils.openConnection();
		pst8 = cn.prepareStatement("Update Customer set balance = balance + ? where name = ?");
		pst8.setInt(1, amount);
		pst8.setString(2, name);
		pst8.execute();
		DBUtils.closedConnection();
	}
	
	public int displayBalance(String name) throws SQLException, ClassNotFoundException
	{
		cn = DBUtils.openConnection();
		int balance = 0;
		pst9 = cn.prepareStatement("Select * from Customer where name = ?");
		pst9.setString(1, name);
		ResultSet rs = pst9.executeQuery();
		if(rs.next()) 
		{
			balance = rs.getInt("balance");
		}
		DBUtils.closedConnection();
		return balance;
	}
}
