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
	<h1>CONSULTAR CLIENTES</h1>
	<a href="showPage.htm?pagina=home">Inicio</a>
	<form method="post" action="verClientes.htm">
	<table>
		<tr>
			<td>CODIGO</td>
			
			
			
			
			
			
			<td>PATERNO</td>
			<td rowspan="2"><input type="submit" value="Consultar"/></td>
		</tr>
		<tr>
			<td><input type="text" name="codigo" /></td>
			<td><input type="text" name="paterno" /></td></td>
		</tr>
	</table>
	</form>
	<hr/>
	<h2>RESULTADO</h2>
	<table border="1">
		<thead>
			<tr>
				<th>CODIGO</th>
				<th>PATERNO</th>
			</tr>
		</thead>
			<c:forEach items="${lista}" var="r">
				<tr>
					<td>${r.codigo}</td>
					<td>${r.paterno}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>