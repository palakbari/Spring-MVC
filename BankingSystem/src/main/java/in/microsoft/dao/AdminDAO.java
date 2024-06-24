package in.microsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.microsoft.pojo.Customer;
import in.microsoft.utils.DBUtils;

public class AdminDAO 
{
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	private PreparedStatement pst4;
	private PreparedStatement pst5;
	private PreparedStatement pst6;
	private PreparedStatement pst7;
	
	public void addCustomers(Customer c) throws SQLException, ClassNotFoundException
	{
		cn = DBUtils.openConnection();
		pst1 = cn.prepareStatement("Insert into customer values (?,?,?)");
		pst1.setInt(1, c.getAcc_no());
		pst1.setString(2, c.getName());
		pst1.setDouble(3, c.getBalance());
		pst1.execute();
		DBUtils.closedConnection();
	}
	
	public List<Customer> searchCustomersNo(int acc_no) throws SQLException, ClassNotFoundException
	{
		cn = DBUtils.openConnection();
		List<Customer> list = new ArrayList<>();
		pst2 = cn.prepareStatement("Select * from customer where acc_no like ?");
		pst2.setInt(1, acc_no);
		ResultSet rs = pst2.executeQuery();
		while(rs.next())
		{
			list.add(new Customer(rs.getInt("acc_no"), rs.getString("name"), rs.getDouble("balance")));
		}
		System.out.println("Show Customer(s)");
		DBUtils.closedConnection();
		return list;
	}
	
	public List<Customer> searchCustomersN(String name) throws SQLException, ClassNotFoundException
	{
		cn = DBUtils.openConnection();
		List<Customer> list = new ArrayList<>();
		pst3 = cn.prepareStatement("Select * from customer where name like ?");
		pst3.setString(1, name);
		ResultSet rs = pst3.executeQuery();
		while(rs.next())
		{
			list.add(new Customer(rs.getInt("acc_no"), rs.getString("name"), rs.getDouble("balance")));
		}
		System.out.println("Show Customer(s)");
		DBUtils.closedConnection();
		return list;
	}
	
	public List<Customer> updateCustomers(int acc_no) throws SQLException, ClassNotFoundException {
        cn = DBUtils.openConnection();
        List<Customer> list = new ArrayList<>();
        pst4 = cn.prepareStatement("Select * from customer where acc_no = ?");
        pst4.setInt(1, acc_no);
        ResultSet rs = pst4.executeQuery();
        while (rs.next()) {
            list.add(new Customer(rs.getInt("acc_no"), rs.getString("name"), rs.getDouble("balance")));
        }
        System.out.println("Show Customer(s)");
        DBUtils.closedConnection();
        return list;
    }

    public void updateCustomer(Customer c) throws SQLException, ClassNotFoundException {
        cn = DBUtils.openConnection();
        pst5 = cn.prepareStatement("UPDATE customer SET name = ?, balance = ? WHERE acc_no = ?");
        pst5.setString(1, c.getName());
        pst5.setDouble(2, c.getBalance());
        pst5.setInt(3, c.getAcc_no());
        pst5.executeUpdate();
        System.out.println("Customer details updated successfully");
        DBUtils.closedConnection();
    }
	
	public void removeCustomers(int id) throws ClassNotFoundException, SQLException 
	{
   	 	cn = DBUtils.openConnection();
   	 	pst6 = cn.prepareStatement("Delete from customer where acc_no = ?");
		pst6.setInt(1, id);
		pst6.execute();
		DBUtils.closedConnection();
   }
	
	public List<Customer> showCustomers() throws SQLException, ClassNotFoundException
	{
		cn = DBUtils.openConnection();
		List<Customer> list = new ArrayList<>();
		pst7 = cn.prepareStatement("Select * from customer");
		ResultSet rs = pst7.executeQuery();
		while(rs.next())
		{
			list.add(new Customer(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
		}
		System.out.println("Show Customer(s)");
		DBUtils.closedConnection();
		return list;
	}
}
