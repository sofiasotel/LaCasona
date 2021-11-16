<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
	<%@ page import="es.eoi.modelo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Habitaciones Disponibles</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	
	<h2>Actualización de la habitación </h2>
	
	<form action="Reservas" method="post">
		
		<label>Número habitación: </label>
		<input type="number" name="número de habitación" required><br>
		<label>Tipo (individual/doble/triple): </label>
		<input type="text" name="tipo" required><br>
		<label>Disponibilidad: </label>
		<input type="checkbox" name="disponibilidad" required><br>
		<input type="submit" value="Actualizar">
		
	</form>
	
</body>
</html>