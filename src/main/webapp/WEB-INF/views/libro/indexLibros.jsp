<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Libros</title>
<spring:url value="../includes/menu.jsp" var="urlMenu" />
</head>
<body>

<jsp:include page="${urlMenu}"></jsp:include>

	<div class="container">
		<div class="row">
			<form class="form-inline" action="filtrarLibro" method="post" >
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
	
		<c:if test="${mensaje != null}">
			<div class="alert alert-success" role="alert">${mensaje}</div>
		</c:if>
	
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">Lista de autores</div>
				<div class="panel-body">
					<table class="table table-striped">
						<thead>
							<tr>
								<td>Título</td>
								<td>Portada</td>
								<td>Editorial</td>
								<td>Autor</td>
								<td></td>
								<td></td>
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
									<td><a class="btn btn-sm btn-primary" href="editar/${autor.idAutor}">Editar</a></td>
									<td><a class="btn btn-sm btn-primary" href="borrar/${autor.idAutor}">Borrar</a></td>
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