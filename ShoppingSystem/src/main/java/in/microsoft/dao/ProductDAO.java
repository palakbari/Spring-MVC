package in.microsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.microsoft.pojos.Product;
import in.microsoft.utils.DBUtils;

public class ProductDAO 
{
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	
	public void addProducts(Product pro) throws SQLException, ClassNotFoundException
	{
		cn = DBUtils.openConnection();
		pst1 = cn.prepareStatement("Insert into product values (?,?,?,?,?)");
		pst1.setInt(1, pro.getPro_id());
		pst1.setString(2, pro.getPro_name());
		pst1.setDouble(3, pro.getPro_price());
		pst1.setInt(4, pro.getPro_quantity());
		pst1.setInt(5, pro.getPro_discount());
		pst1.execute();
		DBUtils.closedConnection();
	}
	
	public List<Product> showProducts() throws SQLException, ClassNotFoundException
	{
		cn = DBUtils.openConnection();
		List<Product> list = new ArrayList<>();
		pst2 = cn.prepareStatement("Select * from product");
		ResultSet rs = pst2.executeQuery();
		while(rs.next())
		{
			list.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getInt(5)));
		}
		System.out.println("Show Products");
		DBUtils.closedConnection();
		return list;
	}
	
	public void removeProducts(String c) throws ClassNotFoundException, SQLException 
	{
   	 	cn = DBUtils.openConnection();
   	 	pst3 = cn.prepareStatement("Delete from cart where name = ?");
		pst3.setString(1, c);
		pst3.execute();
		DBUtils.closedConnection();
   }
}
