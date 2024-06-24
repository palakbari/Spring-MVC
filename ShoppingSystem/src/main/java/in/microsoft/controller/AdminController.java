package in.microsoft.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.microsoft.dao.CustomerDAO;
import in.microsoft.dao.ProductDAO;
import in.microsoft.pojos.Customer;
import in.microsoft.pojos.Product;

@Controller
public class AdminController 
{
	private ProductDAO pdao = new ProductDAO();
	private CustomerDAO cdao = new CustomerDAO();
	
	@RequestMapping("/addProducts")
	public ModelAndView addProducts()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("add_product.jsp");
		System.out.println("Adding Products");
		return mv;
	}
	
	@RequestMapping("/getProducts") 
    public ModelAndView getProducts(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException
	{
		ModelAndView mv = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int discount = Integer.parseInt(request.getParameter("discount"));
		
		System.out.println("Getting Products Details");
		Product pro = new Product(id, name, price, quantity, discount);
		
		pdao.addProducts(pro);
		mv.setViewName("add_product_success.jsp");
		return mv;
	}
	
	@RequestMapping("/displayProducts")
	public ModelAndView showProducts() throws SQLException, ClassNotFoundException
	{
		ModelAndView mv = new ModelAndView();
		List<Product> list = pdao.showProducts();
		for (Product pro: list) 
		{ 
			System.out.println(pro.toString());
		}
		mv.setViewName("display_product.jsp");
		mv.addObject("list", list);
		System.out.println("Showing all Products");
		return mv;
	}
	
	@RequestMapping("/addCustomers")
	public ModelAndView addCustomers()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("add_customer.jsp");
		System.out.println("Adding Customers");
		return mv;
	}
	
	@RequestMapping("/getCustomers") 
    public ModelAndView getCustomers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException
	{
		ModelAndView mv = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double balance = Double.parseDouble(request.getParameter("balance"));
		
		System.out.println("Getting Customers Details");
		Customer customer = new Customer(id, name, balance);
		
		cdao.addCustomers(customer);
		mv.setViewName("add_customer_success.jsp");
		return mv;
	}
	
	@RequestMapping("/displayCustomers")
	public ModelAndView showCustomers() throws SQLException, ClassNotFoundException
	{
		ModelAndView mv = new ModelAndView();
		List<Customer> list = cdao.showCustomers();
		for (Customer customer: list) 
			{ 
				System.out.println(customer.toString());
			}
		mv.setViewName("display_customer.jsp");
		mv.addObject("list", list);
		System.out.println("Showing all Customers");
		return mv;
	}
	
	@RequestMapping("/removeCustomers")
	public ModelAndView removeCustomers() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("remove_customer.jsp");
		System.out.println("Deleting Customer");	
		return mv;
	}
	
	@RequestMapping("/deleteCustomer")
	public ModelAndView deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		ModelAndView mv = new ModelAndView();
		int cid = Integer.parseInt(request.getParameter("customerId"));
		System.out.println("Getting Customer Del");
		cdao.removeCustomers(cid);
		mv.setViewName("remove_customer_success.jsp");
		return mv;
	}
}
