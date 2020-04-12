<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Página principal</title>
</head>
<body>

	<jsp:include page="includes/menu.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
			<form class="form-inline" action="filtrarAutor" method="post" >
				<div class="form-group">
					<label for="inputFiltrarNombre">Nombre</label>
					<input type="text" class="form-control" id="inputFiltrarNombre" name="inputFiltrarNombre" placeholder="Introduzca el nombre">
				</div>
				<div class="form-group">
					<label for="inputFiltrarPrimerApellido">Primer apellido</label>
					<input type="text" class="form-control" id="inputFiltrarPrimerApellido" name="inputFiltrarPrimerApellido" placeholder="Introduzca el primer apellido">
				</div>
				<button type="submit" class="btn btn-primary">Filtrar</button>
			</form>
		</div>
	</div>
		
	<div class="container">
	
		<c:if test="${msgExito != null}">
			<div class="alert alert-success" role="alert">${msgExito}</div>
		</c:if>
	
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">Lista de autores</div>
				<div class="panel-body">
					<table class="table table-striped">
						<thead>
							<tr>
								<td>Nombre</td>
								<td>Primer apellido</td>
								<td>Segundo apellido</td>
								<td>Fecha nacimiento</td>
								<td>Lugar de nacimiento</td>
								<td></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${autores}" var="autor">
								<tr>
									<td>${autor.nombre}</td>
									<td>${autor.primerApellido}</td>
									<td>${autor.segundoApellido}</td>
									<td><fmt:formatDate value="${autor.fechaNacimiento}" pattern="dd-MM-yyyy" /></td>
									<td>${autor.lugarNacimiento}</td>
									<td><a class="btn btn-sm btn-primary" href="detalle/${autor.idAutor}">Ver detalle</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<a class="btn btn-sm btn-primary" href="nuevoAutor">Nuevo autor</a>
	</div>

</body>
</html>