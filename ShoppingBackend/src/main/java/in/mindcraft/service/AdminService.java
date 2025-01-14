package in.mindcraft.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import in.mindcraft.pojo.Customer;
import in.mindcraft.pojo.Product;

@Service
public class AdminService 
{
	private final JdbcTemplate jdbcTemplate;
	
	public AdminService(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Map<String, Object> addProduct(Product product)
	{
		String sql = "INSERT INTO Product VALUES (?,?,?,?,?)";
		int result = jdbcTemplate.update(sql, product.getPro_id(), product.getPro_name(), product.getPro_cost(), product.getPro_quantity(), product.getPro_discount());
		Map<String, Object> response = new HashMap<>();
		if(result > 0)
		{
			response.put("status", "success");
			response.put("message", "Row Inserted Successfully!!!");
		}
		else
		{
			response.put("status", "error");
			response.put("message", "Failed to Insert Product!!!");
		}
		return response;
	}
	
	public List<Map<String, Object>> getProducts()
	{
		String sql = "SELECT * FROM Product";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}
	
	public Map<String, Object> addCustomer(Customer customer)
	{
		String sql = "INSERT INTO Customer VALUES (?,?,?)";
		int result = jdbcTemplate.update(sql, customer.getC_id(), customer.getC_name(), customer.getBalance());
		Map<String, Object> response = new HashMap<>();
		if(result > 0)
		{
			response.put("status", "success");
			response.put("message", "Row Inserted Successfully!!!");
		}
		else
		{
			response.put("status", "error");
			response.put("message", "Failed to Insert Customer!!!");
		}
		return response;
	}
	
	public List<Map<String, Object>> getCustomers()
	{
		String sql = "SELECT * FROM Customer";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}

	
}
