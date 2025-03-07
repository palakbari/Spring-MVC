package in.mindcraft.controller;

import org.springframework.web.bind.annotation.RestController;

import in.mindcraft.pojo.Cart;
import in.mindcraft.pojo.Customer;
import in.mindcraft.pojo.Product;
import in.mindcraft.service.CustomerService;
import jakarta.servlet.http.HttpSession;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class CustomerController 
{
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService)
	{
		this.customerService = customerService;
	}
	
	//methods
	
	@PostMapping("/addToCart")
    public ResponseEntity<Map<String, Object>> addToCart(@RequestBody Cart cart) {
        Map<String, Object> response = customerService.addToCart(cart);
        if ("success".equals(response.get("status"))) {
            return ResponseEntity.ok(response);
        } 
        else 
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

	@GetMapping("/getFromCart/{cartId}")
    public ResponseEntity<List<Product>> getFromCart(@PathVariable int cartId, HttpSession session) 
	{
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null)
        {
        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<Map<String, Object>> productMaps =  customerService.getFromCart(cartId);
        List<Product> products = new ArrayList<>();
        for (Map<String, Object> productMap : productMaps) 
        {
            // Assuming each map represents a product, create a Product object
            Product product = new Product();
            product.setPro_id((int) productMap.get("pro_id"));
            product.setPro_name((String) productMap.get("pro_name"));
            product.setPro_cost((int) productMap.get("pro_cost"));
            product.setPro_quantity((int) productMap.get("pro_quantity"));
            product.setPro_discount((int) productMap.get("pro_discount"));
            products.add(product);
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/displayBill")
    public ResponseEntity<Map<String, Object>> displayBill(HttpSession session) 
    {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null)
        {
        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        double bill = customerService.displayBill(customer.getC_name());
        Map<String, Object> response = new HashMap<>();
        response.put("bill", bill);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/payBill")
    public ResponseEntity<Map<String, Object>> payBill(HttpSession session) 
    {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null)
        {
        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<Product> orderedProducts = customerService.payBill(customer.getC_name());
    	if (orderedProducts == null)
    	{
    		Map<String, Object> response = new HashMap<>();
    		response.put("result", "Insufficient Balance in Wallet");
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    	}
    	double paidbill = customerService.displayBill(customer.getC_name());
        Map<String, Object> response = new HashMap<>();
        response.put("result", "Payment Successful");
        return ResponseEntity.ok(response); 
    }

    @PostMapping("/addBalance")
    public ResponseEntity<String> addBalance(@RequestBody Map<String, Object> payload, HttpSession session) 
    {
    	Customer customer = (Customer) session.getAttribute("customer");
    	System.out.println(customer);
	    if (customer == null) 
	    {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
	    }
        int amount = (int) payload.get("amount");
        System.out.println(amount);
        customerService.addBalance(customer.getC_name(), amount);
        return ResponseEntity.ok("Balance added successfully");
    }

    @GetMapping("/displayBalance/{username}")
    public ResponseEntity<Map<String, Object>> displayBalance(@PathVariable String username, HttpSession session) 
    {
    	Customer customer = (Customer) session.getAttribute("customer");
	    if (customer == null) 
	    {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	    }
	    int balance = customerService.displayBalance(customer.getC_name());
        Map<String, Object> response = new HashMap<>();
        response.put("balance", balance);
        return ResponseEntity.ok(response);
    }
}
