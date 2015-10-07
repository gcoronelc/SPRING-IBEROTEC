<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REGISTRAR DEPOSITO</title>
</head>
<body>
	<h1>REGISTRAR DEPOSITO</h1>
	<form id="form1">
		<p>
			Cuenta:
			<input type="text" name="cuenta" />
		</p>
		<p>
			Importe:
			<input type="text" name="importe" />
		</p>
		<input type="button" id="btnProcesar" value="Procesar" />
	</form>
	<div id="divResultado">
	</div>
</body>
<script type="text/javascript">
	
	$("#btnProcesar").click(function(){
		var data = $("#form1").serialize();
		$.post("procDeposito.htm",data,function(objJson){
			var texto = "";
			if(objJson.code == 1){
				texto = "<p style='color: blue;'>" + objJson.mensaje + "</p>";
			} else {
				texto = "<p style='color: red;'>" + objJson.mensaje + "</p>";
			}
			$("#divResultado").html(texto);
		});
	});

</script>
</html>