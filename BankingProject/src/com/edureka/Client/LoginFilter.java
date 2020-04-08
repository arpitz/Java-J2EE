package com.edureka.Client;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edureka.Model.User;
import com.edureka.Service.UserService;
import com.edureka.Service.impl.UserServiceImpl;

@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
	
	private UserService userService;
	private AbstractApplicationContext ctx;
	
	@Autowired
	public void setUserService(UserService userService){
		this.userService = userService;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String userUI = request.getParameter("user");
		String passUI = request.getParameter("pass");
		HttpSession session = ((HttpServletRequest)request).getSession();
		
		User userDB = userService.fetchUserById(1);	
		String usernameDB = userDB.getUsername();
		String passDB = userDB.getPassword();
		
		if(userUI.equals(usernameDB) && passUI.equals(passDB)){
			session.setAttribute("UserName", userUI);
			RequestDispatcher rd = request.getRequestDispatcher("Main_Menu.jsp");
			rd.forward(request, response);
			//chain.doFilter(request, response);
		} else {
			session.setAttribute("message", "Invalid User id/Password");
			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
			rd.include(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = ctx.getBean("userService", UserServiceImpl.class);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		ctx.close();
	}

}
