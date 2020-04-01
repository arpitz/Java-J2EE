package com.edureka.Module8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		Cookie ck = new Cookie("username", user);
		response.addCookie(ck);
		
		PrintWriter pw = response.getWriter();
		pw.write("<html><body>");
		pw.write("<p> Welcome to Servlet</p>");
		pw.write("<span> Username : </span>" + user);
		pw.write("<br>");
		pw.write("<span> Password : </span>" + pass);
		pw.write("</html></body>");
	}

}
