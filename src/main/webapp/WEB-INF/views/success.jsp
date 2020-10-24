<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 class ="text-center">${desc }</h1>
<h1 style="color: green">${msg }</h1>
<hr>

<h1>welcome ${user.userName}</h1>
<h1>your email address is ${user.email}</h1>
<h1>your password is ${user.password} try to Secure it</h1>


</body>
</html>
