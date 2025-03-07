package in.mindcraft.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.mindcraft.pojos.Register;
import in.mindcraft.service.RegisterService;

@RestController
public class HomeController 
{
	private final RegisterService registerService;
	
	public HomeController(RegisterService registerService)
	{
		this.registerService = registerService;
	}
	
	@GetMapping("/getEmployees")
	public List<Map<String, Object>> getEmployees()
	{
		List<Map<String, Object>> result = registerService.getEmployees();
		return result;
	}
	
	@PostMapping("/insertEmployee")
	public ResponseEntity<Map<String, Object>> insertEmployee(@RequestBody Register register) {
		Map<String, Object> response = registerService.insertEmployee(register);
		if("success".equals(response.get("status"))) {
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		}
		
	}
}
