<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Filme</title>
</head>
<body>
	<form action="inserir" method="post">
		<input type="text" name="titulo">
		<select name=genero.id>
		<c:forEach var="genero" items="${generos}">
			<option value="${genero.id}">${genero.nome}</option>
		</c:forEach>
		</select>
		<input type="submit">
	</form>
</body>
</html>