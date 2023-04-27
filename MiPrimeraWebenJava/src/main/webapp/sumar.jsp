<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultado de la suma de 2 números</title>
</head>
<body>
<h1>Resultado</h1>
	<%
	// Obtener los números ingresados por el usuario
	int num1 = Integer.parseInt(request.getParameter("numero1"));
	int num2 = Integer.parseInt(request.getParameter("numero2"));

	// Calcular la suma de los números
	int resultado = num1 + num2;
	%>

	<h1>
	<h3>	El resultado de la suma es:
		<%=resultado%></h3>
</body>
</html>