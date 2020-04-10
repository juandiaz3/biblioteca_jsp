<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

	<div class="row">
		<div class="col-sm-3">
			<p class="text-center">Portada del libro</p>
		</div>
		<div class="col-sm-9">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">DETALLES</h3>
				</div>
				<div class="panel-body">
					<ul>
						<li>${autor.idAutor}</li>
						<li>${autor.nombre}</li>
						<li>${autor.primerApellido}</li>
						<li>${autor.segundoApellido}</li>
						<li><fmt:formatDate value="${autor.fechaNacimiento}" pattern="dd-MM-yyyy" /></li>
						<li>${autor.lugarNacimiento}</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>