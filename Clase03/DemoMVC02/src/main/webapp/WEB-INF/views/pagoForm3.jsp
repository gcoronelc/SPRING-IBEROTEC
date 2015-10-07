<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>CALCULO DE PAGO</h1>
<form method="post" action="pagoProcess3.htm">
	<input type="hidden" value="Gustavo" name="nombre" />
	Horas por día:
	<input type="text" name="horasDia" /><br/>
	Días al mes:
	<input type="text" name="dias" /><br/>
	Pago por hora:
	<input type="text" name="pagoHora" /><br/>
	<input type="submit" value="Procesar" />
</form>
<h2>RESULTADO</h2>
<p>Ingresos: ${pagoDto.ingresos}</p>
<p>Renta: ${pagoDto.renta}</p>
<p>Neto: ${pagoDto.neto}</p>
</body>
</html>