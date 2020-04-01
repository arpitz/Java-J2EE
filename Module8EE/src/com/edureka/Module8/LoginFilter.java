package com.edureka.Module8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
response.setContentType("text/html");
		
		String user = request.getParameter("name");
		String pass = request.getParameter("pass");
		PrintWriter pw = response.getWriter();
		pw.write("<html><body>");
		if(user.equals("arpit") && pass.equals("arpit123")){
			
			RequestDispatcher rd = request.getRequestDispatcher("welcome");
			rd.forward(request, response);
			chain.doFilter(request, response);
		} else {
			pw.write("<p> Username or password is invalid</p>");
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		}
		pw.write("</html></body>");
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
