package in.microsoft.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.microsoft.dao.CustomerDAO;
import in.microsoft.pojo.Customer;

@Controller
public class CustomerController 
{
	private CustomerDAO cdao = new CustomerDAO();

    @RequestMapping("/deposit")
    public ModelAndView deposit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException 
    {
    	ModelAndView mv = new ModelAndView();
		mv.setViewName("deposit.jsp");
		System.out.println("Depositing Amount");
		return mv;
    }
    
    @RequestMapping("/depositAmount")
    public ModelAndView depositAmount(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        ModelAndView mv = new ModelAndView();
        int acc_no = Integer.parseInt(request.getParameter("accNo"));
        double amount = Double.parseDouble(request.getParameter("amount"));

        cdao.deposit(acc_no, amount);

        double updatedBalance = cdao.getBalance(acc_no);
        mv.addObject("updatedBalance", updatedBalance);
        mv.setViewName("deposit_success.jsp");
        return mv;
    }

    @RequestMapping("/withdraw")
    public ModelAndView withdraw(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException 
    {
    	ModelAndView mv = new ModelAndView();
		mv.setViewName("withdraw.jsp");
		System.out.println("Withdrawing Amount");
		return mv;
    }
    
    @RequestMapping("/withdrawAmount")
    public ModelAndView withdrawAmount(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        ModelAndView mv = new ModelAndView();
        int acc_no = Integer.parseInt(request.getParameter("accNo"));
        double amount = Double.parseDouble(request.getParameter("amount"));

        cdao.withdraw(acc_no, amount);

        double updatedBalance = cdao.getBalance(acc_no);
        mv.addObject("updatedBalance", updatedBalance);
        mv.setViewName("withdraw_success.jsp");
        return mv;
    }
    
    @RequestMapping("/view")
	public ModelAndView view() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view.jsp");
		System.out.println("Viewing Account");	
		return mv;
	}
	
	@RequestMapping("/viewAccount")
	public ModelAndView viewAccount(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException
	{
		ModelAndView mv = new ModelAndView();
		int acc_no = Integer.parseInt(request.getParameter("acc_no"));
        
		System.out.println("Fetching Customers Details:" +acc_no);
		List<Customer> customers = cdao.view(acc_no); 

	    mv.addObject("customers", customers);
		mv.setViewName("view_balance.jsp");
		return mv;
	}

}
