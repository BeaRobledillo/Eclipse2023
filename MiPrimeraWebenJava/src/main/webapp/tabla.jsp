<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabla</title>
</head>
<body>
	<h1>Tabla de multiplicar</h1>

	<form method="post" action="tablaDeMultiplicar.jsp">
		<label for="numero">Ingrese un número:</label> <br> <input
			type="text" id="numero" name="numero" required> <br>
		<br>
		<button type="submit">Mostrar tabla de multiplicar</button>
		<br>
	</form>

</body>
</html>