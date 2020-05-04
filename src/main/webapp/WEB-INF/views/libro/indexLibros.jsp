<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../includes/init.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Libros</title>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/libros/filtrarLibro" var="urlFiltrarLibro" />
<spring:url value="/libros/ordenarLibros" var="urlOrdenarLibros" />
<link rel="stylesheet" href="${urlPublic}/bootstrap-4.4.1-dist/css/bootstrap.min.css" >
</head>
<body>

	<div class="container">
	
		<jsp:include page="../includes/menu.jsp"></jsp:include>
		
		<br>
		
		<div class="row">
			<form:form class="form-inline" action="${urlFiltrarLibro}" method="post" modelAttribute="libroFilter" >
				<div class="form-group">
					<label for="titulo">Título</label>
					<form:input type="text" class="form-control" id="titulo" name="titulo" path="titulo" placeholder="Introduzca el título" />
				</div>
				<div class="form-group">
					<label for="autor">Autor (no implementado)</label>
					<form:input type="text" class="form-control" id="autor" name="autor" path="autor" placeholder="Introduzca el autor" />
				</div>
				<button type="submit" class="btn btn-primary">Filtrar</button>
			</form:form>
			
			<form class="form-inline" action="${urlOrdenarLibros}" method="post" >
				<div class="form-group">
					<label for="inputFiltrarTitulo">Título</label>
					<select class="form-control" id="inputOrdenarLibros" name="inputOrdenarLibros">
						<option value="titulo asc">Por título ascendente</option>
						<option value="titulo desc">Por título descendente</option>
					</select>
				</div>
				<button type="submit" class="btn btn-primary">Ordenar</button>
			</form>
		</div>
	
		<br>

		<c:if test="${mensaje != null}">
			<div class="row">
				<div class="alert alert-success" role="alert">${mensaje}</div>
			</div>
		</c:if>

		<div class="row">

			<div class="panel panel-default">
				<div class="panel-heading">Listado de libros</div>
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
									<td>${libro.autor.nombre}${libro.autor.primerApellido} ${libro.autor.segundoApellido}</td>
									<td><a class="btn btn-sm btn-primary" href="detalle/${libro.idLibro}">Ver detalle</a></td>

									<sec:authorize access="hasAnyAuthority('ROLE_ADMIN')">
										<td><a class="btn btn-sm btn-primary" href="modificarLibro/${libro.idLibro}">Editar</a></td>
										<td><a class="btn btn-sm btn-primary" href="borrarLibro/${libro.idLibro}">Borrar</a></td>
									</sec:authorize>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<div class="row">
			<a class="btn btn-sm btn-primary" href="nuevoLibro">Nuevo libro</a>
		</div>


	</div>

</body>
</html>