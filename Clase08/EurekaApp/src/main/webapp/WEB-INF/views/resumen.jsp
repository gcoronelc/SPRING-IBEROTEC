<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>RESUMEN DE MOVIMIENTOS</h1>
	<p>Usuario: ${sessionScope.logonController.empleadoBean.usuario}</p>
	<a href="showPage.htm?pagina=home">Inicio</a>
	<a href="verResumenMov.htm">Ver Resumen</a>
	<hr />
	<table border="1">
		<thead>
			<tr>
				<th>SUCU.CODIGO</th>
				<th>SUCU.NOMBRE</th>
				<th>INGRESO</th>
				<th>SALIDA</th>
				<th>DIFERENCIA</th>
			</tr>
		</thead>

		<c:forEach items="${resumen}" var="r">
			<tbody>
				<tr>
					<td>${r.sucucodigo}</td>
					<td>${r.sucunombre}</td>
					<td>${r.ingreso}</td>
					<td>${r.salida}</td>
					<td>${r.diferencia}</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>