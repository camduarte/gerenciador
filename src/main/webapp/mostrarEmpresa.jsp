<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada?accion=modificarEmpresa" var="linkModificarEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar Empresa</title>
</head>
<body>
	<form action="${ linkModificarEmpresa }" method="post">
		<label for="nombreEmpresa">Nombre Empresa:</label>
		<input id="nombreEmpresa" type="text" name="nombre" value="${ empresa.nombre }">
		<label for="fechaAbertura">Fecha abertura</label>
		<input id="fechaAbertura" type="date" name="fecha" value="${ empresa.fechaAbertura }">
		<input type="hidden" name="id" value="${ empresa.id }">
		<button type="submit">Modificar</button>
	</form>
</body>
</html>