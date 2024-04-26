package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterValidation extends HttpServlet 
{
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			
		
		String accno=req.getParameter("accno");
		String name =req.getParameter("name");
		String pass=req.getParameter("pass");
		String email=req.getParameter("email");
		String balence =req.getParameter("balence");
		if(accno.length()==0 ||name.length()==0||pass.length()==0||email.length()==0||balence.length()==0)
		{
			res.sendRedirect("/BankProjectmvc/InvalidReg.html");
		}
		else
		{
			req.getServletContext().getRequestDispatcher("/Register").forward(req, res);
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
