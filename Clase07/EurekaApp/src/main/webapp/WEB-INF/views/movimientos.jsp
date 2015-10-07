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
	<h1>MOVIMIENTOS</h1>
	<a href="showPage.htm?pagina=home">Inicio</a>
	<form method="post" action="verMovimientos.htm">
		Cuenta: <input type="text" name="cuenta"/>
		<input type="submit" value="Consultar" />
	</form>
	<hr/>
	<table border="1">
		<thead>
			<tr>
				<th>CUENTA</th>
				<th>NRO.MOV.</th>
				<th>FECHA</th>
				<th>TIPO</th>
				<th>TIPO-NOMBRE</th>
				<th>ACCION</th>
				<th>IMPORTE</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${lista}" var="r">
				<tr>
					<td>${r.cuencodigo}</td>
					<td>${r.movinumero}</td>
					<td>${r.movifecha}</td>
					<td>${r.tipocodigo}</td>
					<td>${r.tiponombre}</td>
					<td>${r.tipoaccion}</td>
					<td>${r.moviimporte}</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
</body>
</html>