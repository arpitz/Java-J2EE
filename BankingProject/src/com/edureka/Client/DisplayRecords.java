package com.edureka.Client;

import java.io.IOException;
import java.util.List;

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

import com.edureka.Model.Record;
import com.edureka.Service.UserService;
import com.edureka.Service.impl.UserServiceImpl;

@WebServlet("/display")
public class DisplayRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	private AbstractApplicationContext ctx;
	
	@Autowired
	public void setUserService(UserService userService){
		this.userService = userService;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fromDate = request.getParameter("from");
		String toDate = request.getParameter("to");
		
		HttpSession session = request.getSession();
		List<Record> recordsList = userService.fetchAllRecords(fromDate, toDate);
		session.setAttribute("records", recordsList);
		
		RequestDispatcher rd = request.getRequestDispatcher("Display_Statement.jsp");
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
