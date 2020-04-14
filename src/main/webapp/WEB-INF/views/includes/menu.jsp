<spring:url value="includes/menu.jsp" var="urlMenu" />

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Biblioteca</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="/indexLibros">Libros<span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="/home">Autores</a>
      <a class="nav-item nav-link" href="#">Editoriales</a>
    </div>
  </div>
</nav>