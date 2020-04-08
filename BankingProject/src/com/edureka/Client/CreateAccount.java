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

import com.edureka.Model.NewAccount;
import com.edureka.Service.UserService;
import com.edureka.Service.impl.UserServiceImpl;


@WebServlet("/newAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	private AbstractApplicationContext ctx;
	
	@Autowired
	public void setUserService(UserService userService){
		this.userService = userService;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewAccount newAcc = new NewAccount();
		newAcc.setName(request.getParameter("name"));
		newAcc.setDob(request.getParameter("dob"));
		newAcc.setAddress(request.getParameter("address"));
		newAcc.setEmail(request.getParameter("email"));
		newAcc.setType(request.getParameter("accountTypes"));
		
		String result = userService.createAccount(newAcc);
		HttpSession session = request.getSession();
		session.setAttribute("message", result);
		RequestDispatcher rd = request.getRequestDispatcher("Account_Creation.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void init(ServletConfig config) throws ServletException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = ctx.getBean("userService", UserServiceImpl.class);
	}

	public void destroy() {
		// TODO Auto-generated method stub
		ctx.close();
	}

}
