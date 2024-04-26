package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Model;

/**
 * Servlet implementation class Forgotpwd
 */
public class Forgotpwd extends HttpServlet 
{
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			int  accno=Integer.parseInt(req.getParameter("accno"));
			String name=req.getParameter("name");
			String email=req.getParameter("email");
			String np=req.getParameter("np");
			Model m=new Model();
			
			m.setAccno(accno);
			m.setName(name);
			m.setEmail(email);
			boolean status =m.forgotpwd(np);
			if(status==true)
			{
				res.sendRedirect("/BankProjectmvc/forgotpwdsuccess.html");
			}
			else
			{
				res.sendRedirect("/BankProjectmvc/forgotpwdfail.html");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
}
