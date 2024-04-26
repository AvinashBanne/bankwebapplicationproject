package com.controller;

import java.io.*;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

/**
 * Servlet implementation class Transfer
 */
public class Transfer extends HttpServlet implements Servlet {
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			int taccno=Integer.parseInt(req.getParameter("taccno"));
			int amount=Integer.parseInt(req.getParameter("amount"));
			HttpSession hs=req.getSession();
			int accno=(int)hs.getAttribute("accno");
			Model m=new Model();
			m.setAccno(accno);
			boolean status1=m.viewbalence();
			if(status1==true)
			{
				int bal=m.getBalence();		
				if(bal>amount)
				{
					boolean status=m.transfer(taccno,amount);
					if(status==true)
					{
						res.sendRedirect("/BankProjectmvc/transfersuccess.html"); 
					}
					else
					{
						res.sendRedirect("/BankProjectmvc/transferfail.html");
						
						
					}
				}
				else
				{
					res.sendRedirect("/BankProjectmvc/transferfail.html");
				}
				}
			else
			{
				res.sendRedirect("/BankProjectmvc/transferfail.html");
			}
			
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
