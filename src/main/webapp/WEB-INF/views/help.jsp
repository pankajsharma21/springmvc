<%@page import="java.time.LocalDateTime"%>
<%@page isELIgnored="false" %> <!--this tag is used to enable expression language if its true Expression language get ignored by page  -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Help</title>
</head>
<body>
<h1>this is help page</h1>
<%
String name =(String) request.getAttribute("name");
Integer id = (Integer) request.getAttribute("id");
//uncomment if print unformated date
/* LocalDateTime time =(LocalDateTime)request.getAttribute("time"); */
//print formated date
String time =(String)request.getAttribute("time");
%>
<h1>this is name <%=name %></h1>
<h1>this is id  <%=id %></h1>
<h1>now time is :<%=time.toString()%></h1> <!-- if we need tostring than we use otherwise its automatic convert into to string -->
<!-- Print Using Jsp Expression Language -->
<h1>this is School name ${school }</h1>
<h1>phone number is ${phone}</h1>
<!-- we can also print time like this -->
<h1>marks : ${marks}</h1> <!--print without travers or using jstl  -->
<hr>
<!--travers list by using jstl directory and Expression language because expression language direct print without travers  -->
<c:forEach var="item" items="${marks}">
<h1>${item }</h1>
<%-- <h1><c:out value="${item}"></c:out></h1> --%> <!--we can also print by this //uncomment it   -->
</c:forEach>
</body>
</html>