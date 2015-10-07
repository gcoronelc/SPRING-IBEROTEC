<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${accion} CLIENTE</title>
</head>
<body>
<h2>${accion} CLIENTE</h2>
<form id="formEdit">
	<input type="hidden" name="codigo" value="${clienteBean.codigo}" />
	<input type="hidden" name="accion" value="${accion}" />
	<table>
		<tr>
			<td>Codigo</td>
			<td>${clienteBean.codigo}</td>
		</tr>
		<tr>
			<td>Paterno</td>
			<td>
				<input type="text" 
				<c:if test="${accion=='ELIMINAR'}">readonly="readonly"</c:if>
				name="paterno" value="${clienteBean.paterno}" />
			</td>
		</tr>
		<tr>
			<td>Materno</td>
			<td>
				<input type="text" 
				<c:if test="${accion=='ELIMINAR'}">readonly="readonly"</c:if>
				name="materno" value="${clienteBean.materno}" />
			</td>
		</tr>
		<tr>
			<td>Nombre</td>
			<td>
				<input type="text" 
				<c:if test="${accion=='ELIMINAR'}">readonly="readonly"</c:if>
				name="nombre" value="${clienteBean.nombre}" />
			</td>
		</tr>
		<tr>
			<td>DNI</td>
			<td>
				<input type="text" 
				<c:if test="${accion=='ELIMINAR'}">readonly="readonly"</c:if>
				name="dni" value="${clienteBean.dni}" />
			</td>
		</tr>
		<tr>
			<td>Ciudad</td>
			<td>
				<input type="text" 
				<c:if test="${accion=='ELIMINAR'}">readonly="readonly"</c:if>
				name="ciudad" value="${clienteBean.ciudad}" />
			</td>
		</tr>
		<tr>
			<td>Dirección</td>
			<td>
				<input type="text" 
				<c:if test="${accion=='ELIMINAR'}">readonly="readonly"</c:if>
				name="direccion" value="${clienteBean.direccion}" />
			</td>
		</tr>
		<tr>
			<td>Teléfono</td>
			<td>
				<input type="text" 
				<c:if test="${accion=='ELIMINAR'}">readonly="readonly"</c:if>
				name="telefono" value="${clienteBean.telefono}" />
			</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>
				<input type="text" 
				<c:if test="${accion=='ELIMINAR'}">readonly="readonly"</c:if>
				name="email" value="${clienteBean.email}" />
			</td>
		</tr>
	</table>
	<input type="button" id="btnProcesar" value="Procesar" />
</form>
</body>

<script type="text/javascript">

$("#btnProcesar").click(function(){
	var data = $("#formEdit").serialize();
	$.post("clienteGrabar.htm",data,function(objJson){
		alert(objJson.mensaje);
	});
});

</script>
</html>