<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="../includes/init.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/libros/nuevoLibro" var="urlFormLibro" />
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
	
		<form:form action="${urlFormLibro}?${_csrf.parameterName}=${_csrf.token}" method="post" modelAttribute="libro" enctype="multipart/form-data" >
			<form:hidden path="idLibro" name="idLibro" />
			<div class="form-group">
				<label for="titulo">Titulo</label>
				<form:input class="form-control" type="text" id="titulo" path="titulo" name="titulo" />
			</div>
			<div class="form-group">
				<label for="editorial">Editorial</label>
				<form:select id="editorial" class="form-control" path="editorial" name="editorial">
					
						<c:forEach items="${editoriales}" var="editorial">
							<form:option value="${editorial}">${editorial.nombre}</form:option>
						</c:forEach>
				</form:select>
			</div>
<!-- 			<div class="form-group"> -->
<!-- 				<label for="inputPortada">Autor</label> -->
<!-- 				<form:input class="form-control" type="text" id="autorNombre" path="autor" /> -->
<!-- 			</div> -->
			<div class="form-group">
				<label for="filePortada">Portada</label>
				<form:input class="form-control" type="hidden" id="portada" path="portada" name="portada"/>
				<c:choose>
					<c:when test="${not empty libro.portada}">
						<input class="form-control" type="file" id="filePortada" path="filePortada" name="filePortada" value="${urlPublic}/${libro.portada}">
							${libro.portada}
						</input>
					</c:when>
					<c:otherwise>
						<input class="form-control" type="file" id="filePortada" path="filePortada" name="filePortada"/>
					</c:otherwise>
				</c:choose>
			</div>
			
			<img src="${urlPublic}/${libro.portada}" />
			
			<div class="form-group">
				<label for="autor">Autor</label>
				<form:select id="autor" class="form-control" path="autor" name="autor">
					
					<c:forEach items="${autores}" var="autor">
						<form:option value="${autor}">${autor.nombre} ${autor.primerApellido} ${autor.segundoApellido}</form:option>
					</c:forEach>
				</form:select>
			</div>
			
			<button type="submit" class="btn btn-primary">Crear</button>
		</form:form>
	</div>
</div>

</body>
</html>

<script>
	$(document).ready(function(){
		let imagen = ${libro.portada};
		if(imagen.length > 0){
			console.log("El libro ya tiene portada " + ${libro.portada});
		}
	});
</script>