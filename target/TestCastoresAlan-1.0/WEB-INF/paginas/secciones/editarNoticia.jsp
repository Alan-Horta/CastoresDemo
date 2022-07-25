<div class="modal fade" id="editarNoticiaModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Cliente</h5>
                <button class="btn close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/ControladorServlets?tipo=noticias&accion=editar&idNoticia=${noticia.idNoticia}" method="POST" class="form-group">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="title">Titulo</label>
                        <input type="text" class="form-control" name="title" value="${noticia.titulo}" required/>
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Cuerpo</label>
                        <textarea class="form-control" name="descripcion" rows="3">${noticia.descripcion}</textarea>
                    </div>
                    
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Editar noticia</button>
                </div>
            </form>
        </div>
    </div>
</div>