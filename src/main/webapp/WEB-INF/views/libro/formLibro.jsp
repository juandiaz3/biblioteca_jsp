<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="nuevoLibro" method="post" enctype="multipart/form-data" modelAttribute="libro" >
		<div class="form-group">
			<label for="inputTitulo">Titulo</label>
			<form:input class="form-control" type="text" id="titulo" path="titulo" />
		</div>
		<div class="form-group">
			<label for="inputEditorial">Editorial</label>
			<form:input class="form-control" type="text" id="editorial" path="editorial" />
		</div>
		<div class="form-group">
			<label for="inputPortada">Autor</label>
			<form:input class="form-control" type="text" id="autorNombre" path="autor.nombre" />
		</div>
		<div class="form-group">
			<label for="inputPortada">Portada</label>
			<form:input class="form-control" type="file" id="portada" path="portada" />
		</div>
		
		<button type="submit" class="btn btn-primary">Crear</button>
	</form:form>


</body>
</html>