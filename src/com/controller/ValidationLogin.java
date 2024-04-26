package com.controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ValidationLogin extends HttpServlet 
{

	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try{
			System.out.println("control inside the Validation");
			String accno = req.getParameter("accno");
			String pass=req.getParameter("pass");
			
			if(accno.length()!=4||pass.length()==0)
			{
				res.sendRedirect("/BankProjectmvc/Invalid.html");
				
			}
			else
			{
				req.getServletContext().getRequestDispatcher("/HomeLogin").forward(req, res);
			}
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	

}
