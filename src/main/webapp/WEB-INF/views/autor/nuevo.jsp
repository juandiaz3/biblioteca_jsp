<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="../includes/init.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/autores/nuevoAutor" var="urlFormAutor" />
<spring:url value="/resources" var="urlPublic" />
<link rel="stylesheet" href="${urlPublic}/bootstrap-4.4.1-dist/css/bootstrap.min.css" >
</head>
<body>

<div class="container">

	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container">

		<spring:hasBindErrors name="autor">
			<div class="alert alert-danger" role="alert">
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>

		<form:form action="${urlFormAutor}" method="post" modelAttribute="autor">
			<form:hidden path="idAutor" name="idAutor" />
			<div class="form-group">
				<label for="inputNombre">Nombre</label>
				<form:input type="text" path="nombre" class="form-control" id="nombre" name="nombre" placeholder="Introduzca el nombre" />
			</div>
			<div class="form-group">
				<label for="inputPrimerApellido">Primer apellido</label>
				<form:input type="text" path="primerApellido" class="form-control" id="primerApellido" name="primerApellido"
					placeholder="Introduzca el primer apellido" />
			</div>
			<div class="form-group">
				<label for="inputSegundoApellido">Segundo apellido</label>
				<form:input type="text" path="segundoApellido" class="form-control" id="segundoApellido" name="segundoApellido"
					placeholder="Introduzca el segundo apellido" />
			</div>
			<div class="form-group">
				<!-- 				<label for="inputFechaNacimiento">Fecha de nacimiento</label> -->
				<form:input type="date" path="fechaNacimiento" class="form-control" id="fechaNacimiento" name="fechaNacimiento" />
			</div>
			<div class="form-group">
				<label for="inputLugarNacimiento">Lugar de nacimiento</label>
				<form:input type="text" path="lugarNacimiento" class="form-control" id="lugarNacimiento" name="lugarNacimiento"
					placeholder="Introduzca el lugar de nacimiento" />
			</div>


			<!-- 		<div class="form-check"> -->
			<%-- 			<form:input type="checkbox" class="form-check-input" id="exampleCheck1" /> --%>
			<%-- 			<label class="form-check-label" for="exampleCheck1">Check me out</form:label> --%>
			<!-- 		</div> -->
			<button type="submit" class="btn btn-primary">Crear</button>

		</form:form>
	</div>
</div>

</body>
</html>