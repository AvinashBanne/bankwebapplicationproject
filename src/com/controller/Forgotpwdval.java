package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Forgotpwdval
 */
public class Forgotpwdval extends HttpServlet 
{
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			String accno=req.getParameter("accno");
			String name=req.getParameter("name");
			String email=req.getParameter("email");
			String pass=req.getParameter("np");
			String np=req.getParameter("np");
			String cnp=req.getParameter("cnp");
			if(accno.length()==0||name.length()==0||email.length()==0||pass.length()==0||np.length()==0||cnp.length()==0)
			{
				res.sendRedirect("/BankProjectmvc/forgotpwderror.html");
			}
			else
			{
				if(np.equals(cnp))
				{
					req.getServletContext().getRequestDispatcher("/Forgotpwd").forward(req,res);
				}
				else
				{
					res.sendRedirect("/BankProjectmvc/forgotpwderror.html");
				}
				
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
