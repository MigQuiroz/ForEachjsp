<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- La siugiente linea es la que nesecito para utilizar el for each segun el video -->
<!-- si la dejo no funciona el codigo y es en donde me lanza el problema -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- Si utilizo la siguiente linea para llamar book_list funciona pero lo llama en un solo renglon -->
<!--  <p> Modelo de carro: ${book_list}  <p>-->

<c:forEach items="${book_list}">
	<p>Book: ${item}</p>
</c:forEach>
hola
</body>
</html>