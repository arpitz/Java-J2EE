package com.edureka.Client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edureka.Service.UserService;
import com.edureka.Service.impl.UserServiceImpl;

@WebServlet("/transact")
public class Transact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;
	private AbstractApplicationContext ctx;
	
	@Autowired
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int account_number = Integer.parseInt(request.getParameter("acc_number"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		String debitButton = request.getParameter("debitFrom");
		
		String result = "";
		
		if(debitButton != null){
			result = userService.debitFromAccount(account_number, amount);
		} else {
			result = userService.creditToAccount(account_number, amount);
		}
		HttpSession session = request.getSession();
		session.setAttribute("message", result);
		RequestDispatcher rd = request.getRequestDispatcher("Transactions.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void init(ServletConfig config) throws ServletException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = ctx.getBean("userService", UserServiceImpl.class);
	}

	public void destroy() {
		ctx.close();
	}

}
