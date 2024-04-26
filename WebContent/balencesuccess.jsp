<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert</title>
</head>
<body>
		<%
		session =request.getSession();
		int bal=(int)session.getAttribute("newbal");
		out.println("Balence is :"+bal);
		%>
		<br><br>
		<a href="/BankProjectmvc/Welcome.jsp">Back</a>
</body>
</html>