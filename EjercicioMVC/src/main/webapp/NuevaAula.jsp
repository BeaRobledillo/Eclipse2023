<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>API y Web</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="style.css">
<title>Nueva Aula</title>
</head>
<body>

	<h1>Nuevo actor</h1>

	<form action="./insertar">
		<div class="form-group">
			<label for="nombre">Nombre:</label> <input type="text"
				class="form-control" placeholder="Nombre" name="nombre">
		</div>
		<div class="form-group">
			<label for="capacidad">Capacidad:</label> <input type="number"
				class="form-control" placeholder="Capacidad" name="capacidad">
		</div>
		<button type="submit" class="btn btn-primary">Enviar</button>
	</form>

</body>
</html>