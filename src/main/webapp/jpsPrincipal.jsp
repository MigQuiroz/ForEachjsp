<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--  <p> Modelo de carro: ${book_list}  <p>-->

<c:forEach items="${book_list}">
	<p>Book: ${item}</p>
</c:forEach>

</body>
</html>