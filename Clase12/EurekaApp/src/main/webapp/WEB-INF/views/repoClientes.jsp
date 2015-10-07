<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REPORTE DE CLIENTES</title>
</head>
<body>
	<h1>REPORTE DE CLIENTES</h1>
	<hr />
	<input type="button" id="btnTraerReporte" value="Traer Reporte">
	<hr />
	<div id="divReporte">
		<p>Aquí se vera el reporte.</p>
	</div>
</body>
<script type="text/javascript">
	$("#btnTraerReporte")
			.click(
					function() {
						var html = "<object width='800' height='400' data='repoClientes.htm'></object>";
						$("#divReporte").html(html);
					});
</script>
</html>