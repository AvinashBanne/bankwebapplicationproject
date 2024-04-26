package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BalValidation
 */
public class BalValidation extends HttpServlet 
{
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			
			//get the password from viewbalence.html
			String pass=req.getParameter("pass");
			if(pass.length()==0)
			{
				res.sendRedirect("/BankProjectmvc/balenceerror.html");
			}
			else
			{
				req.getServletContext().getRequestDispatcher("/Balence").forward(req,res);
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
