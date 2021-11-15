<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br>
<h2>Registro de Cliente</h2>
	
  <form action="<%= request.getContextPath() %>/Altas" method="post">
	<table>
	
	 	<tr>
		<td>Nombre </td>
		<td><input type="text" name="nombre" required></td>
	  	</tr>
	  	
	  	<tr>	
		<td>Apellidos </td>
		<td><input type="text" name="apellidos" required></td>
	  	</tr>
	  	
		<tr>
		<td>DNI </td>
		<td><input type="text" name="dni" required></td>
		</tr>
		
		<tr>
		<td>Teléfono </td>
		<td><input type="tel" name="tel" required></td>
		</tr>
		
		<tr>
		<td>Email </label>
		<td><input type="email" name="email" required></td>
		</tr>
		
		<tr>
		<td>Rol </label>
		<td><input type="text" name="rol" placeholder="admin | cliente" required></td>
		</tr>
		
		<tr>
		<td>Password </label>
		<td><input type="password" name="pass" required></td>
		</tr>
	
	</table>		
	<input type="submit" value="Registrar">
	</form>
<br>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>