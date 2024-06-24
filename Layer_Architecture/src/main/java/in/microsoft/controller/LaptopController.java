package in.microsoft.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.microsoft.dao.LaptopDAO;
import in.microsoft.pojos.Laptop;

@Controller
public class LaptopController {

	private LaptopDAO lapdao = new LaptopDAO();
	
	@RequestMapping("/insert")
	public void addLaptop(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double cost = Double.parseDouble(request.getParameter("cost"));
	
		Laptop lap = new Laptop(id, name, cost);
		
		lapdao.addLaptop(lap);
	}
	
	@RequestMapping("/showdata")
	public ModelAndView showLaptops() throws ClassNotFoundException
	{
		ModelAndView mv = new ModelAndView();
		try 
		{
            List<Laptop> list = lapdao.getLaptops();
            System.out.println(list);
            mv.setViewName("result");
            mv.addObject("list",list);
        } 
		catch (SQLException e) 
		{
            mv.addObject("error", "Error fetching laptop data: " + e.getMessage());
        }
        return mv;
	}
}
