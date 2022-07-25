<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="noticionelegido">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <br/>
                <div class="btn-secondary">
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
                </div>
                <br/>
            </div>
        </div>
    </div>
</section>