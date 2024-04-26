package com.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Model 
{
//variables 
	private int accno;
	private String name;
	private String pass;
	private String email;
	private int balence;
	String path="oracle.jdbc.driver.OracleDriver";
	String  url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="system";
	String pwd="system";
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setBalence(int balence) {
		this.balence = balence;
	}
	
	public int getAccno() {
		return accno;
	}
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}
	public String getEmail() {
		return email;
	}
	public int getBalence() {
		return balence;
	}
	public Model()
	{
		try
		{
		Class.forName(path);
		System.out.println("Drivers are Loaded ");
		con=DriverManager.getConnection(url,user,pwd);
		System.out.println("Connection is established");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public boolean homelogin()
	{
		try
		{
		String sql="SELECT * FROM BANKAPP WHERE ACCNUMBER=? AND PASSWORD=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,accno);
		pstmt.setString(2,pass);
		
		rs = pstmt.executeQuery();
		//main logic
		//create the medium
		
		//Only fetching the data
		 if(rs.next()==true)
		 {
			 accno=rs.getInt(1);
			 name=rs.getString(2);
			 pass=rs.getString(3);
			 email=rs.getString(4);
			 balence= rs.getInt(5);
			return true;
		 }
		 else
		 {
			 return false;
		 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean register()
	{
		try
		{
		String sql="INSERT INTO BANKAPP VALUES(?,?,?,?,?)";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, accno);
		pstmt.setString(2,name);
		pstmt.setString(3,pass);
		pstmt.setString(4,email);
		pstmt.setInt(5, balence);
		int row=pstmt.executeUpdate();
		if(row==0)
		{
			return false;
		}
		else
		{
			return true;
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean viewbalence()
	{
		try
		{
		String sql = "SELECT BALENCE FROM BANKAPP WHERE ACCNUMBER=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, accno);
		rs = pstmt.executeQuery();
		if(rs.next()==true)
		{
			balence = rs.getInt("balence");
			return true;
		}
		else
		{
			return false;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean changepassword(String np)
	{
		try
		{
			String sql="UPDATE BANKAPP SET PASSWORD=? WHERE ACCNUMBER =? AND PASSWORD=? ";
			
		pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1,np);
		pstmt.setInt(2,accno);
		pstmt.setString(3,pass);
		int row=pstmt.executeUpdate();
		if(row==0)
		{
			return false;
		}
		else
		{
			return true;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	 public boolean transfer(int taccno,int amount)
	{
			try
			{
				String sql1="UPDATE BANKAPP SET BALENCE=BALENCE-? WHERE ACCNUMBER=?";
pstmt=con.prepareStatement(sql1);
				
				
				pstmt.setInt(1,amount);
				pstmt.setInt(2,accno);
				int row1=pstmt.executeUpdate();
				String sql2="UPDATE BANKAPP SET BALENCE=BALENCE+? WHERE ACCNUMBER=?";
				pstmt=con.prepareStatement(sql2);
				
				
				pstmt.setInt(1,amount);
				pstmt.setInt(2,taccno);
				int row2=pstmt.executeUpdate();
				if (row1==0||row2==0)
				{
					return false;
					
				}
				else
				{
					return true;
					
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return true;
			}
			}
	public boolean forgotpwd(String np) 
	{
		try
		{
		String sql="UPDATE BANKAPP SET PASSWORD=? WHERE ACCNUMBER=? AND NAME=? AND  EMAIL=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,np);
		pstmt.setInt(2,accno);
		pstmt.setString(3,name);
		pstmt.setString(4,email);
		int row=pstmt.executeUpdate();
			if(row==0)
			{
				return false;
				
			}
			else 
			{
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

}
