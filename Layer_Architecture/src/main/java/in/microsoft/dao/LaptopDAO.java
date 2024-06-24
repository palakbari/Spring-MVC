package in.microsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.microsoft.pojos.Laptop;
import in.microsoft.utils.DBUtils;

public class LaptopDAO {

	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	
	public void addLaptop(Laptop lap) throws SQLException, ClassNotFoundException
	{
		cn=DBUtils.openConnection();
		pst1=cn.prepareStatement("Insert into laptop values (?,?,?)");
		pst1.setInt(1, lap.getId());
		pst1.setString(2, lap.getName());
		pst1.setDouble(3, lap.getCost());
		pst1.execute();
		DBUtils.closedConnection();
	}
	
	public List<Laptop> getLaptops() throws SQLException, ClassNotFoundException
	{
		cn=DBUtils.openConnection();
		List<Laptop> list = new ArrayList<Laptop>();
		pst2=cn.prepareStatement("Select * from laptop");
		ResultSet rs = pst2.executeQuery();
		while(rs.next())
		{
			list.add(new Laptop(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
		}
		DBUtils.closedConnection();
		return list;
	}
}
