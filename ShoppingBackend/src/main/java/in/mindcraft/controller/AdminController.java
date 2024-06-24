package in.mindcraft.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.mindcraft.pojo.Customer;
import in.mindcraft.pojo.Product;
import in.mindcraft.service.AdminService;

@RestController
public class AdminController 
{
	private final AdminService adminService;
	
	public AdminController(AdminService adminService)
	{
		this.adminService = adminService;
	}
	
	//methods
	@PostMapping("/addProduct")
	public ResponseEntity<Map<String, Object>> addProduct(@RequestBody Product product)
	{
		Map<String, Object> response = adminService.addProduct(product);
		if("success".equals(response.get("status")))
		{
			return ResponseEntity.ok(response);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		}	
	}
	
	@GetMapping("/getProducts")
	public List<Map<String, Object>> getProducts()
	{
		List<Map<String, Object>> result = adminService.getProducts();
		return result;
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Map<String, Object>> addCustomer(@RequestBody Customer customer)
	{
		Map<String, Object> response = adminService.addCustomer(customer);
		if("success".equals(response.get("status")))
		{
			return ResponseEntity.ok(response);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		}	
	}
	
	@GetMapping("/getCustomers")
	public List<Map<String, Object>> getCustomers()
	{
		List<Map<String, Object>> result = adminService.getCustomers();
		return result;
	}
	
	
}
