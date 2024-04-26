package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Changepwdval extends HttpServlet 
{
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			String op=req.getParameter("op");
			String np=req.getParameter("np");
			String cnp=req.getParameter("cnp");
			if(op.length()==0 ||np.length()==0||cnp.length()==0)
			{
				
				res.sendRedirect("/BankProjectmvc/changepwderror.html");
			}
			else
			{ 

				if(np.equals(cnp))
				{
					req.getServletContext().getRequestDispatcher("/ChangePwd").forward(req,res);
				}
				else
				{
				req.getServletContext().getRequestDispatcher("").forward(req,res);
			    }
			}
		}
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
