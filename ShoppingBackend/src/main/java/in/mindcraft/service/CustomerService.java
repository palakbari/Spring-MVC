package in.mindcraft.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import in.mindcraft.pojo.Cart;
import in.mindcraft.pojo.Product;

@Service
public class CustomerService 
{
	private final JdbcTemplate jdbcTemplate;
	
	public CustomerService(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Map<String, Object> addToCart(Cart cart)
	{
		String cartSql = "Insert into Cart (cart_id, username) values (?,?)";
        int cartId = jdbcTemplate.queryForObject("Select nextval('cart_seq')", int.class);
        int cartResult = jdbcTemplate.update(cartSql, cartId, cart.getUsername());

        for (Product product : cart.getCart()) 
        {
            String productSql = "Insert into Cart_Product (cart_id, pro_id, quantity) VALUES (?,?,?)";
            jdbcTemplate.update(productSql, cartId, product.getPro_id(), product.getPro_quantity());
        }

        Map<String, Object> response = new HashMap<>();
        if (cartResult > 0) 
        {
            response.put("status", "success");
            response.put("message", "Cart and Products Inserted Successfully!");
        } else {
            response.put("status", "error");
            response.put("message", "Failed to Insert Cart and Products!");
        }
        return response;
	}
	
	public List<Map<String, Object>> getFromCart(int cartId) 
	{
        String sql = "Select p.* from Product p INNER JOIN Cart_Product cp ON p.pro_id = cp.pro_id WHERE cp.cart_id = ?";
        return jdbcTemplate.queryForList(sql, cartId);
    }

	public List<Product> getCart(String username) 
	{
        String sql = "Select p.pro_id, p.pro_name, p.pro_cost, cp.quantity AS pro_quantity, p.pro_discount " +
                     "from Product p " +
                     "INNER JOIN Cart_Product cp ON p.pro_id = cp.pro_id " +
                     "INNER JOIN Cart ct ON cp.cart_id = ct.cart_id " +
                     "where ct.username = ?";
        return jdbcTemplate.query(sql, ps -> ps.setString(1, username), new RowMapper<Product>() 
        {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
                return new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_cost"), rs.getInt("pro_quantity"), rs.getInt("pro_discount"));
            }
        });
    }
	
	public double displayBill(String username) 
	{
        double bill = 0;
        String sql = "SELECT p.pro_cost, p.pro_discount, cp.quantity AS pro_quantity " +
                     "FROM Product p " +
                     "INNER JOIN Cart_Product cp ON p.pro_id = cp.pro_id " +
                     "INNER JOIN Cart ct ON cp.cart_id = ct.cart_id " +
                     "WHERE ct.username = ?";
        List<Product> products = jdbcTemplate.query(sql, ps -> ps.setString(1, username), new RowMapper<Product>() 
        {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
                int cost = rs.getInt("pro_cost");
                int discount = rs.getInt("pro_discount");
                int quantity = rs.getInt("pro_quantity");
                return new Product(rs.getInt("pro_id"), rs.getString("pro_name"), cost, quantity, discount);
            }
        });

        for (Product p : products) 
        {
            bill += p.getPro_quantity() * (p.getPro_cost() - p.getPro_discount());
        }

        return bill;
    }

	public List<Product> payBill(String username) 
	{
        double bill = displayBill(username);
        List<Product> ordered = new ArrayList<>();
        String selectSql = "Select p.pro_id, p.pro_name, p.pro_cost, cp.quantity AS pro_quantity, p.pro_discount " +
                           "from Product p " +
                           "INNER JOIN Cart_Product cp ON p.pro_id = cp.pro_id " +
                           "INNER JOIN Cart ct ON cp.cart_id = ct.cart_id " +
                           "where ct.username = ?";
        List<Product> products = jdbcTemplate.query(selectSql, ps -> ps.setString(1, username), (rs, rowNum) -> 
        	new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_cost"), rs.getInt("pro_quantity"), rs.getInt("pro_discount")));

        String customerSql = "Select balance from Customer where c_name = ?";
        Double balance = jdbcTemplate.query(customerSql, ps -> ps.setString(1, username), rs -> 
        {
            if (rs.next()) {
                return rs.getDouble("balance");
            } else {
                return null;
            }
        });

        if (balance == null || balance < bill) 
        {
            return null;
        }

        for (Product p : products) 
        {
            ordered.add(p);
            jdbcTemplate.update("Update Product set pro_quantity = pro_quantity - ? where pro_id = ?", p.getPro_quantity(), p.getPro_id());
        }

        jdbcTemplate.update("Update Customer set balance = balance - ? where c_name = ?", bill, username);
        jdbcTemplate.update("Delete from Cart where username = ?", username);

        return ordered;
    }

	 
    public void addBalance(String username, int amount) 
    {
        jdbcTemplate.update("Update Customer set balance = balance + ? where c_name = ?", amount, username);
    }

    public int displayBalance(String username) 
    {
        String sql = "Select balance from Customer where c_name = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
