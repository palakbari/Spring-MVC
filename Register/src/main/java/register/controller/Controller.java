package register.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller 
{
	private List<Register> list = new ArrayList<>();
	
	public Controller()
	{
		list.add(new Register("Rohit", "Sharma", "rohitsharma45@gmail.com", "rohit45", 927399877, "Male", "Bsc.IT", "JAVA"));
	}
	
	//get(select)
	@RequestMapping(value="Registers", method = RequestMethod.GET)
	public List<Register> getRegisters()
	{
		System.out.println("Get Registers");
		System.out.println(list);
		
		return list;
	}
	
	
	//post(insert)
	@RequestMapping(value="Registers", method = RequestMethod.POST)
	public List<Register> addRegister(@RequestBody Register r1)
	{
		System.out.println("Add Registers");
		list.add(r1);
		return list;
	}
	
	//put(update)
	@RequestMapping(value="Registers/{firstname}", method = RequestMethod.PUT)
	public List<Register> updateRegisters(@PathVariable String fname, @RequestBody Register r2)
	{
		for(Register r:list)
		{
			if(r.getFirstname()==fname)
			{
				r.setLastname(r2.getLastname());
				r.setEmail(r2.getEmail());
				r.setPassword(r2.getPassword());
				r.setContact(r2.getContact());
				r.setGender(r2.getGender());
				r.setCourse(r2.getCourse());
				r.setCourse_subject(r2.getCourse_subject());
			}
		}
		return null;
	}
	
	//delete
	@RequestMapping(value="Registers/{firstname}", method = RequestMethod.DELETE)
	public List<Register> removeRegisters(@PathVariable String fname)
	{
		Register removeperson = null;
		for(Register r:list)
		{
			if(r.getFirstname()==fname)
			{
				removeperson = r;
				break;
			}
		}
		if(removeperson!=null)
		{
			list.remove(removeperson);
		}
		return null;
	}
	
	//get with particular variable
	@RequestMapping(value="Registers/{firstname}", method = RequestMethod.GET)
	public Register getregisters(@PathVariable String fname) 
	{
		for(Register r:list)
		{
			if(r.getFirstname()==fname)
			{
				return r;
			}
		}
		return null;
	}	
}
