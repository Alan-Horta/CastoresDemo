<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="noticiones">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <c:forEach var="noticia" items="${noticias}" varStatus="status">
                    <br/>
                    <a href="${pageContext.request.contextPath}/ControladorServlets?tipo=noticias&accion=ver&idNoticia=${noticia.idNoticia}" class="btn btn-secondary">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="text-dark">${noticia.titulo}</h4>
                                <h5 class="text-dark">Por: ${noticia.autor}</h5>
                                <h5 class="text-dark">Fecha: ${noticia.fecha}</h5>
                            </div>
                            <div class="car-body">
                                <p class="mx-2 text-secondary">${noticia.descripcion}</p>
                            </div>
                        </div>
                    </a>
                    <br/>
                </c:forEach>
            </div>
        </div>
    </div>
</section>