<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>EUREKABANK</title>
	<link rel="stylesheet" type="text/css" 
		href='<c:url value="/resources/css/estilos.css"/>'>
	<link rel="stylesheet" type="text/css" 
		href='<c:url value="/resources/menu/menu.css"/>'>
	<script type="text/javascript" 
		src="<c:url value="/resources/jquery/jquery.js"/>"></script>
	<script type="text/javascript" 
		src="<c:url value="/resources/js/egcc.js"/>"></script>
</head>
<body>
	<div id="EGCC_PAGE">
	
		<div id="EGCC_HEADER">
			<table style="width: 100%;">
				<tr>
					<td><img alt="" src="<c:url value="/resources/img/logo.gif"/>"/></td>
					<td>
						Usuario:${sessionScope.logonController.empleadoBean.usuario}<br/>
						<a href="#">Salir</a>
					</td>
				</tr>
			</table>
		</div>
		
		<div id="EGCC_MENU">
			<jsp:include page="/WEB-INF/views/menu.jsp"/>
		</div>
		
		<div id="EGCC_CONTENT">
			<br/><br/><br/>
		</div>
	
		<div id="EGCC_FOOTER">
			Derechos Reservados @ Iberotec - 2015
		</div>
	</div>
</body>
</html>
