package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

/**
 * Servlet implementation class Balence
 */
public class Balence extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			HttpSession hs = req.getSession();
			String pwd=(String)hs.getAttribute("pass");
			String pass =req.getParameter("pass");
			int accno=(int)hs.getAttribute("accno");
			
			if(pwd.equals(pass))
             {
				Model m=new Model();
				m.setAccno(accno);
				boolean status=m.viewbalence();
				int bal=m.getBalence();
				if(status == true)
				{
					hs.setAttribute("newbal", bal);
					res.sendRedirect("/BankProjectmvc/balencesuccess.jsp");
				}
				else
				{
					res.sendRedirect("/BankProjectmvc/balencefail.html");
					
				}
				
				
             }
			else
			{
				res.sendRedirect("/BankProjectmvc/balenceerror");
			}
		}
			
			
			
			
			catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
