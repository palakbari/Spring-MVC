package in.microsoft.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.microsoft.dao.AdminDAO;
import in.microsoft.pojo.Customer;

@Controller
public class AdminController 
{
	private AdminDAO adao = new AdminDAO();
	private static final int SESSION_TIMEOUT_SECONDS = 10; // 0.1 minutes

    @GetMapping("/checkSession")
    public void checkSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            long lastAccessedTime = session.getLastAccessedTime();
            long currentTime = System.currentTimeMillis();
            long timeoutInMillis = SESSION_TIMEOUT_SECONDS ;

            // Check if session has exceeded timeout
            if (currentTime - lastAccessedTime > timeoutInMillis) {
                handleSessionTimeout(request, response);
            }
        }
    }

    private void handleSessionTimeout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate the session
            response.sendRedirect("index.jsp"); // Redirect to the index page or any desired URL
            System.out.println("Session expired. Redirecting to index page.");
        }
    }
	
	@RequestMapping("/addCustomers")
	public ModelAndView addCustomers()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("add_customer.jsp");
		System.out.println("Adding Customer(s)");
		return mv;
	}
	
	@RequestMapping("/getCustomers") 
    public ModelAndView getCustomers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException
	{
		ModelAndView mv = new ModelAndView();
		int acc_no = Integer.parseInt(request.getParameter("acc_no"));
		String name = request.getParameter("name");
		double balance = Double.parseDouble(request.getParameter("balance"));
		
		System.out.println("Getting Customers Details:");
		Customer c = new Customer(acc_no, name, balance);
		
		adao.addCustomers(c);
		mv.setViewName("result.jsp");
		return mv;
	}
	
	
	@RequestMapping("/searchCustomersByNumber")
	public ModelAndView searchCustomersNo() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("search_customer_number.jsp");
		System.out.println("Searching Customer");	
		return mv;
	}
	
	@RequestMapping("/getCustomersNumber")
	public ModelAndView getCustomersNo(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException
	{
		ModelAndView mv = new ModelAndView();
		int acc_no = Integer.parseInt(request.getParameter("acc_no"));
        
		System.out.println("Fetching Customers Details:" +acc_no);
		List<Customer> customers = adao.searchCustomersNo(acc_no); 

	    mv.addObject("customers", customers);
		mv.setViewName("search_customer_details.jsp");
		return mv;
	}
		
	@RequestMapping("/searchCustomersByName")
	public ModelAndView searchCustomersN() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("search_customer_name.jsp");
		System.out.println("Searching Customer");	
		return mv;
	}
	
	@RequestMapping("/getCustomersName")
	public ModelAndView getCustomersN(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException
	{
		ModelAndView mv = new ModelAndView();
		String name = request.getParameter("name");
		List<Customer> customers = adao.searchCustomersN(name); 
	    mv.addObject("customers", customers);
		mv.setViewName("search_customer_details.jsp");
		System.out.println("Fetching Customers Details" +name);
		return mv;
	}
	
	@RequestMapping("/updateCustomersByNumber")
	public ModelAndView updateCustomers() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("update_customer.jsp");
		System.out.println("Updatinging Customer");	
		return mv;
	}
	
	@RequestMapping("/getUpdatedCustomers")
	public ModelAndView getUpdatedCustomers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
	    ModelAndView mv = new ModelAndView();
	    int acc_no = Integer.parseInt(request.getParameter("acc_no"));
	    List<Customer> customers = adao.updateCustomers(acc_no);
	    
	    Customer customer = customers.get(0);
	    request.setAttribute("customer", customer);
	    
	    mv.setViewName("update_customer_details.jsp");
	    System.out.println("Fetching Customers Details" + acc_no);
	    return mv;
	}
	@RequestMapping("/saveUpdatedCustomer")
	public ModelAndView saveUpdatedCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
	    ModelAndView mv = new ModelAndView();
	    int acc_no = Integer.parseInt(request.getParameter("acc_no"));
	    String newName = request.getParameter("name");
	    double newBalance = Double.parseDouble(request.getParameter("balance"));
	    
	    Customer updatedCustomer = new Customer(acc_no, newName, newBalance);
	    adao.updateCustomer(updatedCustomer);
	    
	    mv.setViewName("update_customer_success.jsp");
	    return mv;
	}
	
	@RequestMapping("/removeCustomersByNumber")
	public ModelAndView removeCustomers() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("remove_customer.jsp");
		System.out.println("Deleting Customer");	
		return mv;
	}
	
	@RequestMapping("/deleteCustomers")
	public ModelAndView deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException
	{
		ModelAndView mv = new ModelAndView();
		int acc_no = Integer.parseInt(request.getParameter("acc_no"));
		System.out.println("Getting Customer Account Delete");
		adao.removeCustomers(acc_no);
		mv.setViewName("remove_success.jsp");
		return mv;
	}
	
	@RequestMapping("/displayCustomers")
	public ModelAndView showCustomers() throws SQLException, ClassNotFoundException
	{
		ModelAndView mv = new ModelAndView();
		List<Customer> list = adao.showCustomers();
		for (Customer customer: list) 
			{ 
				System.out.println(customer.toString());
			}
		mv.setViewName("display_customer.jsp");
		mv.addObject("list", list);
		System.out.println("Showing all Customers");
		return mv;
	}
	
}
