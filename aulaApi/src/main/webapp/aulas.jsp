<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aulas</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
<h1>Lista de aulas</h1>
	<p><a href="./aula" class="btn btn-primary">Obtener Aulas</a></p>
<form> 
    <input type="text" class="form-control" placeholder="Texto a buscar" name="search"><input type="submit" class="btn btn-success"></form>

	<table class="table table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>capacidad</th>
				
			</tr>
		</thead>
		<tbody>
			<!--   for (Todo todo: todos) {  -->
			<c:forEach var="aula" items="${aula}">

				<tr>
					<td><c:out value="${aula.id}" /></td>
					<td><c:out value="${aula.nombre}" /></td>
					<td><c:out value="${aula.capacidad}" /></td>
					
					<td><a href="editar?id=<c:out value='${aula.id}' />">Editar</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="borrar?id=<c:out value='${aula.id}' />">Borrar</a></td>
				</tr>
			</c:forEach>
			<!-- } -->
		</tbody>

	</table>

</body>
</html>