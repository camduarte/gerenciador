<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,ar.com.camd.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ not empty empresa }">
		Empresa ${ empresa.nombre } registrada!
	</c:if>
	<br>

	Lista de empresas: <br>
	<ul>
		<c:forEach items="${ empresas }" var="empresa">
			<li>${ empresa.nombre } - <fmt:formatDate value="${ empresa.fechaAbertura }" pattern="dd/MM/yyyy"/>
				<a href="./entrada?accion=MostrarEmpresa&id=${empresa.id}">Modificar</a>
				<a href="./entrada?accion=EliminarEmpresa&id=${empresa.id}">Eliminar</a>
			</li>
		</c:forEach>
	</ul>

</body>
</html>