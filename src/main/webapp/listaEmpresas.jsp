<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.alura.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Lista de empresas: <br>

	<ul>
		<c:forEach items="${ empresas }" var="empresa">
			<li>${ empresa.nombre }</li>
		</c:forEach>
	</ul>

</body>
</html>