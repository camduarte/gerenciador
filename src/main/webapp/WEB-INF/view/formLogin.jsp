<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="entrada" var="loginURL" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${ loginURL }" method="post">
		<label for="login">Usuario</label>
		<input id="login" type="text" name="login">
		<label for="contrasena">Contraseña</label>
		<input id="contrasena" type="password" name="contrasena">
		<input type="hidden" name="accion" value="Login">
		<button type="submit">Ingresar</button>
	</form>
</body>
</html>