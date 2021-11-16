<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@page import="es.eoi.modelo.Cliente"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/estilos.css">
<script type="text/javascript" src="js/script.js" defer></script>
<title>Hotel La Casona</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<%
		Cliente clie = (Cliente)session.getAttribute("cliente");
	%>

	<h2>Tu Perfil</h2>	

	<form action="MiPerfil" method="post">

		<label>Id cliente: </label>
		<input type="text" name="Id Cliente" value="<%=clie.getIdclientes() %>" required>
		<label>Nombre: </label>
		<input type="text" name="nombre" value="<%=clie.getNombre() %>" required>
		<label>Apellidos: </label>
		<input type="text" name="apellidos" value="<%=clie.getApellidos() %>" required>
		<label>Dni: </label>
		<input type="text" name="dni" value="<%=clie.getDni() %>" required>
		<label>Telefono: </label>
		<input type="tel" name="tel" value="<%=clie.getTel() %>" required>
		<label>Email: </label>
		<input type="email" name="email" value="<%=clie.getEmail() %>" required>
		<label>Rol: </label>
		<input type="text" name="rol" value="<%=clie.getRol() %>" required>
		<label>Password: </label>
		<input type="password" name="pass" value="<%=clie.getPass() %>" required>
		<input type="hidden" name="id" value="<%=clie.getIdclientes() %>">
		<input type="submit" value="Actualizar">
	
	</form>

	<a href="MiPerfil?opcion=b">Darme de baja</a>

</body>
</html>

