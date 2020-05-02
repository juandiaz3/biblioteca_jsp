<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="../includes/init.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Libros</title>
<spring:url value="/resources" var="urlPublic" />
<link rel="stylesheet" href="${urlPublic}/bootstrap-4.4.1-dist/css/bootstrap.min.css" >
</head>
<body>

<jsp:include page="../includes/menu.jsp"></jsp:include>

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
								
								<sec:authorize access="hasAnyAuthority('ADMIN')">
									<td></td>
									<td></td>
								</sec:authorize>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${libros}" var="libro">
								<tr>
									<td>${libro.titulo}</td>
									<td>${libro.portada}</td>
									<td>${libro.editorial.nombre}</td>
									<td>${libro.autor.nombre} ${libro.autor.primerApellido} ${libro.autor.segundoApellido}</td>
									<td><a class="btn btn-sm btn-primary" href="detalle/${libro.idLibro}">Ver detalle</a></td>
									
									<sec:authorize access="hasAnyAuthority('ROLE_ADMIN')">
										<td><a class="btn btn-sm btn-primary" href="libros/modificarLibro/${libro.idLibro}">Editar</a></td>
										<td><a class="btn btn-sm btn-primary" href="libros/borrarLibro/${libro.idLibro}">Borrar</a></td>
									</sec:authorize>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<a class="btn btn-sm btn-primary" href="nuevoLibro">Nuevo libro</a>
	</div>


</body>
</html>