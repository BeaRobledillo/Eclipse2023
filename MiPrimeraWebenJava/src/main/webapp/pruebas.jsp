<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Probar cosas de JSP</title>
</head>
<body>
	<h1>Probar cosas de JSP</h1>
	<!-- Probad a generar una lista (li) con un bucle -->
	<h3>Lista:</h3>
	<ul>
		<%
		for (int i = 1; i <= 10; i++) {
		%>
		<li>Elemento <%=i%></li>
		<%
		}
		%>
	</ul>
	<!-- pedir un nombre y una contraseña y si es por ejemplo '123' y '123' decir acceso permitido -->
	<h3>Nombre y Contraseña:</h3>
	<form method="post">
		<label>
			<p>Dime tu nombre:</p>
		</label> <input type="text" name="nombre"> <label>
			<p>Dime una contraseña:</p>
		</label> <input type="password" name="contrasena" required> <br /> <br />
		<button type="submit">Enviar</button>
		<br /> <br />
		<%
		// Obtener los parámetros del formulario
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");

		// Verificar si el nombre y la contraseña son correctos
		if ("123".equals(nombre) && "123".equals(contrasena)) {
			out.println("<h4>Acceso permitido</h4>");
		} else {
			out.println("<h4>Acceso denegado</h4>");
		}
		%>

	</form>
</body>
</html>