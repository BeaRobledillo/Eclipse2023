<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabla de multiplicar</title>
</head>
<body>

	<h1>Tabla de multiplicar</h1>

	<!-- Recuperar el valor del número ingresado por el usuario  -->
	<%
	String numStr = request.getParameter("numero");

	// 	Verificar si el valor es un número válido
	if (numStr != null && !numStr.isEmpty()) {
		if (numStr.matches("[0-9]+")) {
			int numero = Integer.parseInt(numStr);
	%>
	<h2>
		<!-- 	Generar la tabla de multiplicar -->
		Tabla de multiplicar del
		<%=numero%></h2>
	<table>
		<%
		for (int i = 1; i <= 10; i++) {
		%>
		<tr>
			<td><%=numero%> x <%=i%> =</td>
			<td><%=numero * i%></td>
		</tr>
		<%
		}
		%>
	</table>
	<!-- 	Mostrar mensaje de error si el valor no es un número válido -->
	<%
	} else {
	%>
	<p>Número incorrecto</p>
	<%
	}
	}
	%>
	<br>
	<a href="tabla.jsp">Volver</a>
</body>
</html>