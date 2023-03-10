<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/nuevaEmpresa" var="linkServletNuevaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${ linkServletNuevaEmpresa }" method="post">
		<label for="nombreEmpresa">Nombre Empresa:</label>
		<input id="nombreEmpresa" type="text" name="nombre">
		<button type="submit">Enviar</button>
	</form>
</body>
</html>