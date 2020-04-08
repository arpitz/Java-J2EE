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

import com.edureka.Model.CreditCard;
import com.edureka.Service.UserService;
import com.edureka.Service.impl.UserServiceImpl;


@WebServlet("/authorizeCreditCard")
public class Authorize extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;
	private AbstractApplicationContext ctx;
	
	private static final String AUTHORIZE_SUCCESS_MSG = "The card is authorized and the transaction is approved.";
	private static final String AUTHORIZE_ERROR_MSG = "The card cannot be authorized and the transaction is rejected.";
	private static final int MIN_AMOUNT = 100000;
	
	@Autowired
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		CreditCard cCard = new CreditCard();
		cCard.setName(request.getParameter("name"));
		cCard.setCardNumber(request.getParameter("cardNumber"));
		cCard.setCvv2(Integer.parseInt(request.getParameter("cvv2")));
		cCard.setAmount(Integer.parseInt(request.getParameter("amount")));
		
		CreditCard fetchedCard = userService.authorizeCreditCard(cCard);
		
		if(fetchedCard.getCardNumber().equals(cCard.getCardNumber()) && cCard.getAmount() < MIN_AMOUNT){
			session.setAttribute("message", AUTHORIZE_SUCCESS_MSG);
		}
		else {
			session.setAttribute("message", AUTHORIZE_ERROR_MSG);
		}
		RequestDispatcher rd = request.getRequestDispatcher("Authorize_credit_card.jsp");
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
