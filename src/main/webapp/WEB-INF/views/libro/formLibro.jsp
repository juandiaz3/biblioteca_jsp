<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="../includes/init.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/nuevoLibro" var="urlFormLibro" />
<link rel="stylesheet" href="${urlPublic}/bootstrap-4.4.1-dist/css/bootstrap.min.css" >
</head>
<body>

<div class="container">

	<jsp:include page="../includes/menu.jsp"></jsp:include>
	
	<div class="container">

		<spring:hasBindErrors name="libro">
			<div class="alert alert-danger" role="alert">
				<ul>
					<c:forEach items="${errors.allErrors}" var="error">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>
	
		<form:form action="${urlFormLibro}" method="post" enctype="multipart/form-data" modelAttribute="libro" >
			<form:hidden path="idLibro" />
			<div class="form-group">
				<label for="titulo">Titulo</label>
				<form:input class="form-control" type="text" id="titulo" path="titulo" />
			</div>
			<div class="form-group">
				<label for="editorial">Editorial</label>
				<form:select id="editorial" class="form-control" path="editorial">
					
						<c:forEach items="${editoriales}" var="editorial">
							<form:option value="${editorial.idEditorial}">${editorial.nombre}</form:option>
						</c:forEach>
				</form:select>
			</div>
<!-- 			<div class="form-group"> -->
<!-- 				<label for="inputPortada">Autor</label> -->
<!-- 				<form:input class="form-control" type="text" id="autorNombre" path="autor" /> -->
<!-- 			</div> -->
			<div class="form-group">
				<label for="portada">Portada</label>
				<form:input class="form-control" type="text" id="portada" path="portada" />
			</div>
			<div class="form-group">
				<label for="selAutor">Autor</label>
				<form:select id="selAutor" class="form-control" path="autor">
					
					<c:forEach items="${autores}" var="autor">
						<form:option value="${autor.idAutor}">${autor.nombre} ${autor.primerApellido} ${autor.segundoApellido}</form:option>
					</c:forEach>
				</form:select>
			</div>
			
			<button type="submit" class="btn btn-primary">Crear</button>
		</form:form>
	</div>
</div>

</body>
</html>