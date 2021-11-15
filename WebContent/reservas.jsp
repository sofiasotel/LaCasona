<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="es.eoi.modelo.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div>
	
	<h3> Registro de una RESERVA</h3>
	
	<form action="Reservas" method="post">
	<table>
	<tr>
		<td>Fecha Reserva</td>
		<td><input type="datetime" name="fecha_reserva"></td>
	</tr>
	<tr>
		<td>Fecha Entrada</td>
		<td><input type="datetime" name="fecha_entrada"></td>
	</tr>	
	<tr>
		<td>Fecha Salida</td>
		<td><input type="datetime" name="fecha_salida"></td>
	</tr>	
	<tr>
		<td>Número personas</td>
		<td><input type="number" name="num_personas"></td>
	</tr>	
	<tr>
		<td> Tipo habitación </td>
		<td> <select name="tipoHab">
				<option>Individual</option>
				<option>Matrimonial</option>
				<option>Doble</option>
			</select>
	</tr>		
	<tr>
		<td>Extra</td>
		<td><input type="text" name="extra"></td>
	</tr>
	<tr>		
		<td><input type="submit" value="Enviar"></td>
	</tr>	
	</table>
	</form>
	</div>
	
</body>
</html>