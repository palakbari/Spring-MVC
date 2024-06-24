package springMVC.Controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringController {


	
	@RequestMapping("/add")
	public String add(Model model)
	{
		model.addAttribute("a",30);
		model.addAttribute("b",10);
		return "add";
	}
	
	@RequestMapping("/details")
	public String details(Model model)
	{
		model.addAttribute("name","Palak");
		model.addAttribute("address","Dahanu");
		return "details";
	}
	
	@RequestMapping("/help")
	public ModelAndView help()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("name","Palak");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/addition")
	public ModelAndView addition()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("a",40);
		mv.addObject("b",10);
		mv.setViewName("add");
		return mv;
	}
	
//	@RequestMapping("/button")
//	public ModelAndView add()
//	{
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("button");
//		return mv;
//	}
//	
	
	@RequestMapping("/button")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("Addition....");
		
		int a=Integer.parseInt(request.getParameter("n1"));
		int b=Integer.parseInt(request.getParameter("n2"));
		
		int c=a+b;
		System.out.println(c);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("c",c);
		return mv;
	}
	
//	@RequestMapping("/sub")
//	public ModelAndView sub(HttpServletRequest request, HttpServletResponse response)
//	{
//		System.out.println("Subtraction....");
//		
//		int a=Integer.parseInt(request.getParameter("n1"));
//		int b=Integer.parseInt(request.getParameter("n2"));
//		
//		int c=a-b;
//		System.out.println(c);
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result");
//		mv.addObject("c",c);
//		return mv;
//	}
//	
//	@RequestMapping("/mul")
//	public ModelAndView mul(HttpServletRequest request, HttpServletResponse response)
//	{
//		System.out.println("Multiplication....");
//		
//		int a=Integer.parseInt(request.getParameter("n1"));
//		int b=Integer.parseInt(request.getParameter("n2"));
//		
//		int c=a*b;
//		System.out.println(c);
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result");
//		mv.addObject("c",c);
//		return mv;
//	}
//	
//	@RequestMapping("/div")
//	public ModelAndView div(HttpServletRequest request, HttpServletResponse response)
//	{
//		System.out.println("Division....");
//		
//		int a=Integer.parseInt(request.getParameter("n1"));
//		int b=Integer.parseInt(request.getParameter("n2"));
//		
//		int c=a/b;
//		System.out.println(c);
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result");
//		mv.addObject("c",c);
//		return mv;
//	}
	
}
