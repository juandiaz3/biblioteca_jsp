<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="includes/init.jsp" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="springjsp.basico.home.titulo" /></title>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/autor" var="urlAutor" />
<link rel="stylesheet" href="${urlPublic}/bootstrap-4.4.1-dist/css/bootstrap.min.css" >
</head>
<body>

	<div class="container">

		<jsp:include page="includes/menu.jsp"></jsp:include>
		
		<br>

		<div class="row">
			<form class="form-inline" action="filtrarAutor" method="post">
				<div class="form-group">
					<label for="inputFiltrarNombre">Nombre</label> <input type="text" class="form-control" id="inputFiltrarNombre" name="inputFiltrarNombre"
						placeholder="Introduzca el nombre" />
				</div>
				<div class="form-group">
					<label for="inputFiltrarPrimerApellido">Primer apellido</label> <input type="text" class="form-control" id="inputFiltrarPrimerApellido"
						name="inputFiltrarPrimerApellido" placeholder="Introduzca el primer apellido" />
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
				<div id="aaa"></div>
			</div>
		</div>

		<div class="row">
			<a class="btn btn-sm btn-primary" href="nuevoAutor">Nuevo autor</a>
		</div>

		<jsp:include page="includes/footer.jsp"></jsp:include>
	</div>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

	<script>

		$(document).ready(function(){
			var element = document.createElement("p");
			var contentElement = document.createTextNode("Nuevo contenido");
			element.appendChild(contentElement);
			document.getElementById("aaa").appendChild(element);
		});
		
	</script>

</body>
</html>