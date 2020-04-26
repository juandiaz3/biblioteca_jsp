<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="includes/init.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<spring:url value="/login" var="urlLogin" />
<spring:url value="/resources" var="urlPublic" />
<link rel="stylesheet" href="${urlPublic}/bootstrap-4.4.1-dist/css/bootstrap.min.css" >
</head>
<body>

	<jsp:include page="./includes/menu.jsp"></jsp:include>

	<div class="container py-4">
	
		<c:if test="${info != null}">
			<div class="alert alert-success" role="alert">${info}</div>
		</c:if>
		
		<c:if test="${error != null }">
			<div class="alert alert-danger" role="alert">${error}</div>
		</c:if>
	
		<div class="card border-primary text-center">
			<div class="card-header">
				Por favor, introduzca sus credenciales
			</div>
			<div class="card-body">
				<form action="${urlLogin}" method="post">
					<div class="form-group col-sm-6">
						<label for="username">Usuario</label>
						<input class="form-control" type="text" id="username" name="username" path="username" placeholder="Usuario" autofocus required/>
					</div>
					<div class="form-group col-sm-6">
						<label for="password">Contraseña</label>
						<input class="form-control" type="password" id="password" name="password" path="password" placeholder="Contraseña" required />
					</div>
					<div class="form-group col-sm-6">
						<input class="btn btn-lg btn-primary btn-block" type="submit" value="Sign In" />
					</div>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</div>
		</div>
	</div>
	
	<jsp:include page="./includes/footer.jsp"></jsp:include>

</body>
</html>