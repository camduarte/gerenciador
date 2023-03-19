<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada?accion=nuevaEmpresa" var="linkNuevaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="./logout-parcial.jsp"></c:import>

	<form action="${ linkNuevaEmpresa }" method="post">
		<label for="nombreEmpresa">Nombre Empresa:</label>
		<input id="nombreEmpresa" type="text" name="nombre">
		<label for="fechaAbertura">Fecha abertura</label>
		<input id="fechaAbertura" type="date" name="fecha">
		<button type="submit">Enviar</button>
	</form>
</body>
</html>