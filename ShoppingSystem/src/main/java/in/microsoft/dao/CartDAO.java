package in.microsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.microsoft.pojos.Cart;
import in.microsoft.utils.DBUtils;

public class CartDAO 
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
	
	public double calculateSum(List<Double> numbers) 
	{
        return numbers.stream().mapToDouble(Double::doubleValue).sum();
    }
	
	public void addProductsToCart(String username, int pro_id, String pro_name, Double pro_price, int pro_quantity , int pro_discount, String invoiced) throws SQLException, ClassNotFoundException 
	{
		
		cn = DBUtils.openConnection();
		pst1 = cn.prepareStatement("Insert into cart values(?,?,?,?,?,?,?)");
		pst1.setString(1, username);
		pst1.setInt(2, pro_id);
		pst1.setString(3, pro_name);
		pst1.setDouble(4, pro_price);
		pst1.setInt(5, pro_quantity);
		pst1.setInt(6, pro_discount);
		pst1.setString(7, invoiced);
		pst1.execute();

		pst2 = cn.prepareStatement("Update product set quantity = quantity - 1 where name = ?"); 
		pst2.setString(1, pro_name);
		pst2.execute();	
		pst7 = cn.prepareStatement("Select quantity from product where name = ?");
		pst7.setInt(1, pro_id);
		ResultSet rs =  pst7.executeQuery();
		while(rs.next()) 
		{
			int quants = rs.getInt(1);
			System.out.println("the items are over!!!");
			if(quants < 1) 
			{
				pst8 = cn.prepareStatement("Delete from product where name = ?");
				pst8.setInt(1, pro_id);
				pst8.execute();
			}
		}
		
		DBUtils.closedConnection();
	}
	
	public List<Cart> showCart(String username) throws SQLException, ClassNotFoundException
	{
		cn = DBUtils.openConnection();
		List<Cart> cart_list = new ArrayList<>();
		pst2 = cn.prepareStatement("Select * from cart where username = ? and invoiced = 'No'");
		pst2.setString(1, username);
		ResultSet rst = pst2.executeQuery();
		while(rst.next()) 
		{
			cart_list.add(new Cart(rst.getString(1), rst.getInt(2), rst.getString(3), rst.getDouble(4),rst.getInt(5), rst.getInt(6), rst.getString(7)));
		}
		DBUtils.closedConnection();
		return cart_list;
	}
	
	public List<Cart> billPay(String username) throws SQLException, ClassNotFoundException
	{
		cn = DBUtils.openConnection();
		List<Cart> cart_list = new ArrayList<>();
//		List<Double> discountAmount = new ArrayList<>();
		pst3 = cn.prepareStatement("Select * from cart where username = ? and invoiced = 'No'");
		pst3.setString(1, username);
		ResultSet rst = pst3.executeQuery();
		while(rst.next()) 
		{
			cart_list.add(new Cart(rst.getString(1), rst.getInt(2), rst.getString(3), rst.getDouble(4),rst.getInt(5), rst.getInt(6), rst.getString(7)));
		}
		DBUtils.closedConnection();
		return cart_list;
	}
	
	public double billPay1(String username) throws SQLException, ClassNotFoundException
	{
		cn = DBUtils.openConnection();
		List<Double> actual_Amount = new ArrayList<>();
		double sum = 0;
		pst4 = cn.prepareStatement("Select * from cart where username = ? and invoiced = 'No'");
		pst4.setString(1, username);
		ResultSet rst = pst4.executeQuery();
		while(rst.next()) 
		{
			double actualAmt = rst.getDouble(4);
			actual_Amount.add((double) actualAmt);
			sum = calculateSum(actual_Amount);
			System.out.println("List is" +actual_Amount);
		}
		DBUtils.closedConnection();
		return sum;
	}
	
	public double billPay2(String username) throws SQLException, ClassNotFoundException
	{
		cn = DBUtils.openConnection();
		List<Double> discount_Amount = new ArrayList<>();
		double sum = 0;
		pst5 = cn.prepareStatement("Select * from cart where username = ? and invoiced = 'No'");
		pst5.setString(1, username);
		ResultSet rst = pst5.executeQuery();
		while(rst.next()) 
		{
			double discountAmt = (rst.getDouble(6) / 100) * rst.getDouble(4);
			double actualAmt = rst.getDouble(4);
			double finalAmt = actualAmt - discountAmt;
			discount_Amount.add((double) finalAmt);
			sum = calculateSum(discount_Amount);
			System.out.println("List is" +discount_Amount);
		}
		DBUtils.closedConnection();
		return sum;
	}
	
	public double billPay3(String username) throws SQLException, ClassNotFoundException
	{
		cn = DBUtils.openConnection();
		List<Double> saved_Amount = new ArrayList<>();
		double sum = 0;
		pst6 = cn.prepareStatement("Select * from cart where username = ? and invoiced = 'No'");
		pst6.setString(1, username);
		ResultSet rst = pst6.executeQuery();
		while(rst.next()) 
		{
			double discountAmt = (rst.getDouble(6) / 100) * rst.getDouble(4);
			saved_Amount.add((double) discountAmt);
			sum = calculateSum(saved_Amount);
			System.out.println("List is" +saved_Amount);
		}
		DBUtils.closedConnection();
		return sum;
	}
}
