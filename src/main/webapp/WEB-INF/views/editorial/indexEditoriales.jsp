<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ include file="../includes/init.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editoriales</title>
<spring:url value="/resources" var="urlPublic" />
<link rel="stylesheet" href="${urlPublic}/bootstrap-4.4.1-dist/css/bootstrap.min.css" >
</head>
<body>

	<div class="container">
	
		<jsp:include page="../includes/menu.jsp"></jsp:include>
		
		<br>
		
		<div class="row">
			<form class="form-inline" action="filtrarEditorial" method="post" >
				<div class="form-group">
					<label for="inputFiltrarNombre">Título</label>
					<input type="text" class="form-control" id="inputFiltrarNombre" name="inputFiltrarNombre" placeholder="Introduzca el nombre" />
				</div>
				<button type="submit" class="btn btn-primary">Filtrar</button>
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
				<div class="panel-heading">Listado de editoriales</div>
				<div class="panel-body">
					<table class="table table-striped">
						<thead>
							<tr>
								<td>Nombre</td>
								<td>Pais</td>
								<td></td>
								<sec:authorize access="hasAnyAuthority('ADMIN')">
									<td></td>
									<td></td>
								</sec:authorize>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${editoriales}" var="editorial">
								<tr>
									<td>${editorial.nombre}</td>
									<td>${editorial.pais}</td>
									<td><a class="btn btn-sm btn-primary" href="detalleEditorial/${editorial.idEditorial}">Ver detalle</a></td>
									<sec:authorize access="hasAnyAuthority('ROLE_ADMIN')">
										<td><a class="btn btn-sm btn-primary" href="modificarEditorial/${editorial.idEditorial}">Editar</a></td>
										<td><a class="btn btn-sm btn-primary" href="borrarEditorial/${editorial.idEditorial}">Borrar</a></td>
									</sec:authorize>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<div class="row">
			<a class="btn btn-sm btn-primary" href="nuevaEditorial">Nueva editorial</a>
		</div>


	</div>

</body>
</html>