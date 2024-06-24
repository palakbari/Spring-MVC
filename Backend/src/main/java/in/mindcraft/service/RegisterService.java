package in.mindcraft.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import in.mindcraft.pojos.Register;

@Service
public class RegisterService  
{
	private final JdbcTemplate jdbcTemplate;
	
	public RegisterService(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Map<String, Object>> getEmployees()
	{
		String sql = "SELECT * FROM Register";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}
	
	public Map<String, Object> insertEmployee(Register register) {
		String sql = "INSERT INTO REGISTER VALUES(?, ?)";
		int result = jdbcTemplate.update(sql, register.getName(), register.getMobile_number());
		Map<String, Object> response = new HashMap<>();
		if(result > 0) {
			response.put("status", "success");
			response.put("message", "Employee Inserted Successfully!!");
		} else {			
			response.put("status", "error");
			response.put("message", "Employee Insertion Failed!!");
		}
		return response;
	}
}
