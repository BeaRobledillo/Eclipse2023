<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sumar 2 n�meros</title>
</head>
<body>
<!-- pedir dos n�meros  -->
	<form action="sumar.jsp" method="post">
		<label>Primer n�mero:</label> 
		<input type="number" name="numero1"><br>
		<br> 
		<label>Segundo n�mero:</label> 
		<input type="number" name="numero2"><br>
		<br> <input type="submit" value="Sumar">
	</form>

</body>
</html>