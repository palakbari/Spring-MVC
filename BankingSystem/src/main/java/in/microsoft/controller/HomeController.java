package in.microsoft.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController 
{
	@RequestMapping("/home")
	public ModelAndView Check_Status(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		
		if(username.equals("admin") && password.equals("admin"))
		{
			System.out.println("Admin Logged In Successfully!!!");
			mv.setViewName("admin_menu.jsp");
		}
		else if(username.equals(password))
		{
			System.out.println("Customer Logged In Successfully!!!");
			mv.setViewName("customer_menu.jsp");
		}
		else
		{
			System.out.println("ERROR");
			mv.setViewName("error.jsp");
		    mv.addObject("errorMessage", "Invalid username or password");
		}
		return mv;
	}

}