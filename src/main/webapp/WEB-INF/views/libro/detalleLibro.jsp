<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ include file="../includes/init.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources" var="urlPublic" />
<link rel="stylesheet" href="${urlPublic}/bootstrap-4.4.1-dist/css/bootstrap.min.css" >
</head>
<body>

	<div class="row">
		<div class="col-sm-3">
			<p class="text-center">Detalle del libro</p>
		</div>
		<div class="col-sm-9">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">DETALLE</h3>
				</div>
				<div class="panel-body">
					<ul>
						<li>${libro.idLibro}</li>
						<li>${libro.titulo}</li>
						<li>${libro.editorial.nombre}</li>
						<li>${libro.portada}</li>
						<li>${libro.autor.nombre} ${libro.autor.primerApellido} ${libro.autor.segundoApellido}</li>
					</ul>
				</div>
			</div>
		</div>
	</div>

</body>
</html>