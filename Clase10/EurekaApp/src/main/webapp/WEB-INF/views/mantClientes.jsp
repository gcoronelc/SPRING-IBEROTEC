<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MANTENIMIENTO DE CLIENTES</title>
</head>
<body>
	<h1>MANTENIMIENTO DE CLIENTES</h1>
	<form id="form1">
		<table>
			<tr>
				<td>
					<table>
						<tr>
							<td>CODIGO</td>
							<td>PATERNO</td>
							<td>MATERNO</td>
						</tr>
						<tr>
							<td><input type="text" size="15" name="codigo" /></td>
							<td><input type="text" size="15" name="paterno" /></td>
							<td><input type="text" size="15" name="materno" /></td>
						</tr>
					</table>
				</td>
				<td valign="bottom">
					<input id="btnConsultar" type="button" value="Consultar" />
					<input id="btnNuevo" type="button" value="Nuevo" />
					<input id="btnExcel" type="button" value="Excel" />
				</td>
			</tr>
		</table>
	</form>
	<hr/>
	<div id="divWork"></div>
	
</body>
<script type="text/javascript">

	$("#btnConsultar").click(function(){
		var data = $("#form1").serialize();
		$("#divWork").html("<p>Consultando al servidor.</p>");
		$.post("clienteConsultar",data,function(paginaHTML){
			$("#divWork").html(paginaHTML);
		});
	});
	
	$("#btnConsultar2").click(function(){
		var data = $("#form1").serialize();
		$("#divResultado").html("<p>Consultando al servidor.</p>");
		$.post("verClientes2.htm",data,function(dataJson){
			var objJson = eval('(' + dataJson + ')');
			var tablaHTML = toTabla(objJson);
			$("#divResultado").html(tablaHTML);
			//alert(rpta)
		});
	});
	
	$("#btnConsultar3").click(function(){
		var data = $("#form1").serialize();
		$("#divResultado").html("<p>Consultando al servidor.</p>");
		$.post("verClientes3.htm",data,function(objJson){
			var tablaHTML = toTabla(objJson);
			$("#divResultado").html(tablaHTML);
			//alert(rpta)
		});
	});	
		
	$("#btnExcel").click(function(){
		var data = $("#form1").serialize();
		var url = "clientesToExcel2?" + data;
		window.location.href = url;
	});

	function toTabla(objJson){
		var tabla = "<table border=1><tr><th>CODIGO</th><th>PATERNO</th></tr>";
		for(var i=0; i < objJson.length; i++){
			var bean = objJson[i];
			tabla += "<tr>";
			tabla += "<td>" + bean.codigo + "</td>";
			tabla += "<td>" + bean.paterno + "</td>";
			tabla += "</tr>";
		}
		tabla += "</table>";
		return tabla;
	}
</script>
</html>