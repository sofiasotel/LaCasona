<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://fontawesome.com/v4.7/icons/">;
<title>Proyecto: La Casona</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

		<%
		List<Habitacion> habitaciones = (List<Habitacion>)request.getAttribute("habitaciones");
		Cliente clie = (Cliente)session.getAttribute("clientes");
	%>
	<h2>Listado de Habitaciones de La Casona</h2>
	
	<span id="msginfo">
		<%=request.getAttribute("msginfo")==null ? "&nbsp;" : request.getAttribute("msginfo") %>
	</span>
	<table>
		<tr>
			<th>Número de habitación</th>
			<th>Tipo de habitación</th>
			<th>Disponibilidad</th>
			<th>Acciones</th> 				<!-- Acciones de editar y borrar -->
		</tr>
			<% 
				if (habitaciones != null) {
					for(Habitacion h : habitaciones) {
			%>
			
			<td><%=h.getN_habitacion()%></td>
			<td><%=h.getTipo()%></td>
			<td><%=h.getDisponibilidad() %></td>
			
						
			<td>
			<%
				if (clie.getRol().equals("admin")) {
			%>
			
			<a href="altas?operacion=e&habitacion_id=<%=h.getDisponibilidad() %>">Editar</a>
			<a href="altas?operacion=r&habitacion_id=<%=h.getDisponibilidad() %>">Reservar habitación</a>
			</td>
		
		</tr>
			<%
					}
				}
			%>
	</table>
	
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>