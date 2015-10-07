<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" 
	href='<c:url value="/resources/css/estilos.css"/>'>
<title>EUREKABANK</title>
<style type="text/css">
	#_LOGON{
		width: 300px;
		margin: 10px auto;
		padding: 10px;
		background-color: white;
		color: #1C1C1C;
	}
</style>
</head>
<body>
	<div id="_LOGON">
		<form method="post" action="logonIngresar.htm">
			<img alt="" src="<c:url value="/resources/img/logo.gif"/>"/>
			<h2>INICIO DE SESION</h2>
			<div class="egcc_msg_error">
				${error}
			</div>
			<label>Usuario</label><br/>
			<input type="text" name="usuario" /><br/>
			<label>Clave</label><br/>
			<input type="password" name="clave" /><br/>
			<input type="submit" value="Ingresar" />
		</form>
	</div>
</body>
</html>