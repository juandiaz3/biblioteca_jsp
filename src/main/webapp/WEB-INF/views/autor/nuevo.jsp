<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

<div class="container">

		<spring:hasBindErrors name="autor">
			<div class="alert alert-danger" role="alert" >
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>

		<form:form action="nuevoAutor" method="post" modelAttribute="autor" >
			<div class="form-group">
				<label for="inputNombre">Nombre</label>
				<form:input type="text" path="nombre" class="form-control" id="nombre" name="nombre" placeholder="Introduzca el nombre" />
			</div>
			<div class="form-group">
				<label for="inputPrimerApellido">Primer apellido</label>
				<form:input type="text" path="primerApellido" class="form-control" id="primerApellido" name="primerApellido" placeholder="Introduzca el primer apellido" />
			</div>
			<div class="form-group">
				<label for="inputSegundoApellido">Segundo apellido</label>
				<form:input type="text" path="segundoApellido" class="form-control" id="segundoApellido" name="segundoApellido" placeholder="Introduzca el segundo apellido" />
			</div>
			<div class="form-group">
				<label for="inputFechaNacimiento">Fecha de nacimiento</label>
				<form:input type="date" path="fechaNacimiento" class="form-control" id="fechaNacimiento" name="fechaNacimiento" />
			</div>
			<div class="form-group">
				<label for="inputLugarNacimiento">Lugar de nacimiento</label>
				<form:input type="text" path="lugarNacimiento" class="form-control" id="lugarNacimiento" name="lugarNacimiento" placeholder="Introduzca el lugar de nacimiento" />
			</div>
		
		
<!-- 		<div class="form-check"> -->
<%-- 			<form:input type="checkbox" class="form-check-input" id="exampleCheck1" /> --%>
<%-- 			<label class="form-check-label" for="exampleCheck1">Check me out</form:label> --%>
<!-- 		</div> -->
		<button type="submit" class="btn btn-primary">Crear</button>
		
	</form:form>
</div>

</body>
</html>