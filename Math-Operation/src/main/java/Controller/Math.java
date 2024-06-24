package Controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Math {
	
	@RequestMapping(value = {"/add", "/sub", "/mul", "/div"}, method = RequestMethod.POST)
	public ModelAndView performOperation(HttpServletRequest request) {
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		String operation = request.getServletPath().substring(1); 

		int result = 0;
		switch (operation) {
			case "add":
				result = a + b;
				break;
			case "sub":
				result = a - b;
				break;
			case "mul":
				result = a * b;
				break;
			case "div":
				if (b != 0) {
					result = a / b;
				} 
				else 
				{
					return new ModelAndView("error", "message", "Division by zero is not allowed.");
				}
				break;
			default:
				return new ModelAndView("error", "message", "Invalid operation.");
		}
		
		ModelAndView mv = new ModelAndView("result");
		mv.addObject("result", result);
		return mv;
	}
}
