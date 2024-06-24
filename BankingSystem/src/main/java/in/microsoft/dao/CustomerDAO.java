package in.microsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.microsoft.pojo.Customer;
import in.microsoft.utils.DBUtils;

public class CustomerDAO 
{
	private Connection cn;
    private PreparedStatement pst1;
    private PreparedStatement pst2;
    private PreparedStatement pst3;
    private PreparedStatement pst4;

    public double getBalance(int acc_no) throws SQLException, ClassNotFoundException 
    {
        cn = DBUtils.openConnection();
        pst1 = cn.prepareStatement("SELECT balance FROM customer WHERE acc_no = ?");
        pst1.setInt(1, acc_no);
        ResultSet rs = pst1.executeQuery();
        double balance = 0.0;
        if (rs.next()) 
        {
            balance = rs.getDouble("balance");
        }
        DBUtils.closedConnection();
        return balance;
    }

    public void deposit(int acc_no, double amount) throws SQLException, ClassNotFoundException 
    {
        cn = DBUtils.openConnection();
        pst2 = cn.prepareStatement("UPDATE customer SET balance = balance + ? WHERE acc_no = ?");
       
        pst2.setInt(2, acc_no);
        pst2.setDouble(1, amount);
        pst2.executeUpdate();
        DBUtils.closedConnection();
    }
    
    public void withdraw(int acc_no, double amount) throws SQLException, ClassNotFoundException 
    {
        cn = DBUtils.openConnection();
	    pst3 = cn.prepareStatement("UPDATE customer SET balance = balance - ? WHERE acc_no = ?");
	    
	    pst3.setDouble(1, amount);
	    pst3.setInt(2, acc_no);        
	    pst3.executeUpdate();
        DBUtils.closedConnection();
    }
    
    public List<Customer> view(int acc_no) throws SQLException, ClassNotFoundException
	{
		cn = DBUtils.openConnection();
		List<Customer> list = new ArrayList<>();
		pst4 = cn.prepareStatement("Select * from customer where acc_no like ?");
		pst4.setInt(1, acc_no);
		ResultSet rs = pst4.executeQuery();
		while(rs.next())
		{
			list.add(new Customer(rs.getInt("acc_no"), rs.getString("name"), rs.getDouble("balance")));
		}
		System.out.println("Show Account Details");
		DBUtils.closedConnection();
		return list;
	}

}
