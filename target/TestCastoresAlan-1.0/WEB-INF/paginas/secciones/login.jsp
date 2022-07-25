<section id="login">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Inicio sesion</h4>
                    </div>
                    <form action="${pageContext.request.contextPath}/ControladorServlets?tipo=sesion&accion=iniciar" method="POST" class="form-group">
                        <div class="card-body">
                            <div class="form-group">
                                <label for="user">Usuario</label>
                                <input type="text" class="form-control" name="user" required/>
                            </div>
                            <div class="form-group">
                                <label for="pass">Contraseña</label>
                                <input type="password" class="form-control" name="pass" required/>
                            </div>
                        </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Iniciar Sesion</button>
                    
                    <a href="#" class="btn btn-primary btn-block" data-toggle="modal" data-target="#agregarUsuarioModal">
                        Crear usuario
                    </a>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
</section>
<jsp:include page="agregarUsuario.jsp"/>