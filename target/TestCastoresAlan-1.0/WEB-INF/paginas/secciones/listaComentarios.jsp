<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="coments">
    <div class="container">
        <div class="row">
            <div class="card col-md-9 bg-secondary">
                <br/>
                <h5 class="text-white">Comentarios</h5>
                <br/>
                <c:forEach var="comentario" items="${comentarios}" varStatus="status">
                    <c:choose>
                        <c:when test="${comentario.idRespuesta == 0}">
                            <br/>
                            <div class="card bg-info text-white">
                                <div class="card-header">
                                    <h5 class="card-title">Por: ${comentario.autor}, Fecha: ${comentario.fecha}</h5>
                                    <c:if test="${comentario.idUsuario == user.idUsuario}">
                                        <div class="col-md-3">
                                            <a href="${pageContext.request.contextPath}/ControladorServlets?tipo=comentarios&accion=eliminar&idNoticia=${noticia.idNoticia}&idComentario=${comentario.idComentario}" class="btn btn-danger btn-block">
                                                <i class="fas fa-trasht"></i> Eliminar comentario
                                            </a>
                                        </div>
                                    </c:if>
                                </div>
                                <div class="card-body">
                                    <p class="mx-2 text-secondary text-white">${comentario.comentario}</p>
                                </div>
                                <c:forEach var="comentarin" items="${comentarios}" varStatus="status">
                                    <c:if test="${comentarin.idRespuesta == comentario.idComentario}">
                                        <br/>
                                        <div class="card bg-light text-dark mx-5">
                                            <div class="card-header">
                                                <h5 class="card-title">Por: ${comentarin.autor}, Fecha: ${comentarin.fecha}</h5>
                                                <c:if test="${comentarin.idUsuario == user.idUsuario}">
                                                    <div class="col-md-3">
                                                        <a href="${pageContext.request.contextPath}/ControladorServlets?tipo=comentarios&accion=eliminar&idNoticia=${noticia.idNoticia}&idComentario=${comentarin.idComentario}" class="btn btn-danger btn-block">
                                                            <i class="fas fa-trasht"></i> Eliminar comentario
                                                        </a>
                                                    </div>
                                                </c:if>
                                            </div>
                                            <div class="card-body">
                                                <p class="mx-2 text-secondary">${comentarin.comentario}</p>
                                            </div>
                                        </div>
                                        <br/>
                                    </c:if>
                                </c:forEach>
                                <div class="card mx-5">
                                    <form action="${pageContext.request.contextPath}/ControladorServlets?tipo=comentarios&accion=crear&idNoticia=${noticia.idNoticia}&idRespuesta=${comentario.idComentario}" method="POST" class="form-group">
                                        <div class="modal-body">
                                            <div class="form-group">
                                                <label for="comment" class="text-dark">Comentario</label>
                                                <textarea class="form-control" name="comment" rows="3"></textarea>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button class="btn btn-primary" type="submit">Responder</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <br/>
                        </c:when>
                        <c:otherwise>

                        </c:otherwise>
                    </c:choose>

                </c:forEach>
                <div class="card mx-5">
                    <form action="${pageContext.request.contextPath}/ControladorServlets?tipo=comentarios&accion=crear&idNoticia=${noticia.idNoticia}&idRespuesta=0" method="POST" class="form-group">
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="comment">Comentario</label>
                                <textarea class="form-control" name="comment" rows="3"></textarea>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary" type="submit">Comentar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>