<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="#" data-toggle="modal" data-target="#editarNoticiaModal" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i>Editar Noticia
                </a>
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ControladorServlets?tipo=noticias&accion=eliminar&idNoticia=${noticia.idNoticia}" class="btn btn-danger btn-block">
                    <i class="fas fa-trash"></i>Eliminar
                </a>
            </div>
        </div>
    </div>
</section>