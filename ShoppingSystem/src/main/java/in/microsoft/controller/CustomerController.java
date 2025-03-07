package in.microsoft.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.microsoft.dao.CartDAO;
import in.microsoft.dao.CustomerDAO;
import in.microsoft.dao.ProductDAO;
import in.microsoft.pojos.Cart;
import in.microsoft.pojos.Product;

@Controller
public class CustomerController 
{
	private ProductDAO pdao = new ProductDAO();
	private CustomerDAO cdao = new CustomerDAO();
	private CartDAO ctdao = new CartDAO();
	
	public boolean checkcustomer(String username) throws SQLException, ClassNotFoundException
	{
		System.out.println(cdao.checkCustomer(username));
		System.out.println(username);
		boolean c = cdao.checkCustomer(username);
		return c;
	}
	
	@RequestMapping("/addProductsToCart")
	public ModelAndView addProductsToCart() throws SQLException, ClassNotFoundException
	{
		ModelAndView mv = new ModelAndView();
		List<Product> list = pdao.showProducts();
		mv.setViewName("add_products_to_cart.jsp");
		mv.addObject("list",list);
		return mv;
	}
	
	@RequestMapping("/getProductsFromCart")
	public ModelAndView getProductsFromCart(HttpServletRequest request, HttpServletResponse response, @RequestParam("pro_id") int pro_id, @RequestParam("pro_name") String pro_name, @RequestParam("pro_price") double pro_price, @RequestParam("pro_quantity") int pro_quantity, @RequestParam("pro_discount") int pro_discount) throws SQLException, ClassNotFoundException, InterruptedException, IOException 
	{
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String invoiced = "No";
		int quantity = 1;
		
		System.out.println("Get");
		ctdao.addProductsToCart(username, pro_id, pro_name, pro_price, pro_quantity, pro_discount, invoiced);
		mv.setViewName("add_products_to_cart_success.jsp");
		return mv;
		
	}
	
	@RequestMapping("/displayProductsFromCart")
	public ModelAndView showCart(HttpServletRequest request, HttpServletResponse reponse) throws SQLException, ClassNotFoundException
	{
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		List<Cart> list = ctdao.showCart(username);
		mv.setViewName("display_product_from_cart.jsp");
		mv.addObject("list",list);
		System.out.println("Showing all Cart Items");
		return mv;
	}
	
	@RequestMapping("/displayandpayBill")
	public ModelAndView displayBill(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException
	{
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		List<Cart> list = ctdao.billPay(username);
		double actual_amt = ctdao.billPay1(username);
		double discount_amt = ctdao.billPay2(username);
		double saved_amt = ctdao.billPay3(username);
		
		mv.setViewName("display_bill.jsp");
		
		mv.addObject("list",list);
		mv.addObject("Amount_list",actual_amt);
		mv.addObject("Discount_list",discount_amt);
		mv.addObject("Saved_list",saved_amt);
		System.out.println("Moving To Bill Page!!!!");
		return mv;
	}
	
	@RequestMapping("payment")
	public ModelAndView payment(HttpServletRequest request, HttpServletResponse response,@RequestParam("discount_amt") double amt) throws SQLException, ClassNotFoundException, IOException
	{
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		if(cdao.checkBalance(username, amt)) 
		{
			System.out.println("Your Account has been debited with Rs. "+amt);
			mv.setViewName("pay_bill.jsp");
						
		}
		else 
		{
			System.out.println("Your Account Balance is limited.");
			mv.setViewName("pay_bill.jsp");			
		}
		return mv;
	}
	
	@RequestMapping("/addBalance")
	public ModelAndView addBalance(HttpSession session, HttpServletRequest request) throws SQLException, ClassNotFoundException
	{
		String name = (String) session.getAttribute("name");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		cdao.addBalance(name, amount);
		session.setAttribute("customer", name);
		
		ModelAndView mv = displayBalance(session);
		mv.addObject("result", amount + " added to Wallet successfully!");
		return mv;
	}
	
	@RequestMapping("displayBalance")
	public ModelAndView displayBalance(HttpSession session) throws SQLException, ClassNotFoundException
	{
		String name = (String) session.getAttribute("name");
		int balance = cdao.displayBalance(name);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("balance.jsp");
		mv.addObject("balance",  balance);
		return mv;
	}
}
