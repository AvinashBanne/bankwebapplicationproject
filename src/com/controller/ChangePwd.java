package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;


public class ChangePwd extends HttpServlet 
{
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			String op=req.getParameter("op");
			String np=req.getParameter("np");
			HttpSession hs=req.getSession();
			int accno=(int)hs.getAttribute("accno");
			Model m=new Model();
			m.setAccno(accno);
			m.setPass(op);
			boolean status=m.changepassword(np);
			if(status==true)
			{
				res.sendRedirect("/BankProjectmvc/changepwdsuccess.html");
			}
			else
			{
				res.sendRedirect("/BankProjectmvc/changepwdfail");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
