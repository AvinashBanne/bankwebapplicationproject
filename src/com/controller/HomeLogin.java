package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

public class HomeLogin extends HttpServlet{
	public void service(HttpServletRequest req ,HttpServletResponse res)
	{
		try
		{
		//Collecting the form data
		String accno = req.getParameter("accno");
		String pass = req.getParameter("pass");
		int accnum = Integer.valueOf(accno);
	
		//Creating the object of Model, which will also laod the driver and 
		//establish the connection
		Model m = new Model();
		
		//Sending accnum and password to Model using setter methods
		m.setAccno(accnum);
		m.setPass(pass);
		
		//Invoking the login()
		boolean status = m.homelogin();
		
		//Checking is staus is true or false
		if(status == true)
		{
			//Login is successfull
			//From Model, taking all the data using getter methods
			int a = m.getAccno();
			String b = m.getName();
			String c = m.getPass();
			String d = m.getEmail();
			int e = m.getBalence();
			
			//Creating a new session
			HttpSession hs = req.getSession(true);
			
			//Storing the data in the session
			hs.setAttribute("accno", a);
			hs.setAttribute("name", b);
			hs.setAttribute("pass", c);
			hs.setAttribute("email", d);
			hs.setAttribute("balance", e);
			
			//sending the control to welcome.jsp
			res.sendRedirect("/BankProjectmvc/Welcome.jsp");
		}
		else
		{
			//Login is failed
			res.sendRedirect("/BankProjectmvc/Incorrect.html");
		}
		
		
	}
	catch(Exception e) 
	{
		e.printStackTrace();
	}
	}
}
