<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome page</title>
</head>
<body>
		<%
		session = request.getSession();
		String name = (String)session.getAttribute("name");
		int accno = (int)session.getAttribute("accno");
		out.println("<h3>Welcome "+name+"</br>");
		out.println("Account Number : "+accno);
		out.println("</h3>");
	%>
		<br><br>
		<ul>
	     <li><a href="/BankProjectmvc/balence.html">View Balance</a></li>
         <li><a href="/BankProjectmvc/loan.html">Apply Loan</a></li>
         <li><a href="/BankProjectmvc/transfer.html">Transfer Money</a></li>
         <li><a href="/BankProjectmvc/changepwd.html">Change Password </a></li>  
         <li><a href="#">Change Name</a></li>
	    <li><a href="/BankProjectmvc/logout.jsp">Logout</a></li>
   		</ul>

</body>
</html>