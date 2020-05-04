<%@ include file="../includes/init.jsp" %>

<spring:url value="/libros/indexLibros" var="urlIndexLibros" />
<spring:url value="/autores/home" var="urlIndexAutores" />
<spring:url value="/editoriales/indexEditoriales" var="urlIndexEditoriales" />
<spring:url value="/login" var="urlLogin" />

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Biblioteca</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav mr-auto">
      <a class="nav-item nav-link active" href="${urlIndexLibros}">Libros<span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="${urlIndexAutores}">Autores</a>
      <a class="nav-item nav-link" href="${urlIndexEditoriales}">Editoriales</a>
    </div>
    
    <div class="navbar-nav navbar-right">
    	<a class="nav-item nav-link" href="${urlLogin}">Login</a>
    </div>
  </div>
</nav>