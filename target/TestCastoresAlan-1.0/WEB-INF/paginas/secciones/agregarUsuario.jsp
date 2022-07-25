<div class="modal fade" id="agregarUsuarioModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Cliente</h5>
                <button class="btn close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/ControladorServlets?tipo=sesion&accion=crear" method="POST" class="form-group">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="user">Usuario</label>
                        <input type="text" class="form-control" name="user" required/>
                    </div>
                    <div class="form-group">
                        <label for="pass">Contraseña</label>
                        <input type="password" class="form-control" name="pass" required/>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required/>
                    </div>
                    <div class="form-group">
                        <label for="paterno">Apellido Paterno</label>
                        <input type="text" class="form-control" name="paterno" required/>
                    </div>
                    <div class="form-group">
                        <label for="materno">Apellido Materno</label>
                        <input type="text" class="form-control" name="materno"/>
                    </div>
                    <div class="form-group">
                        <label for="direccion">Direccion</label>
                        <input type="text" class="form-control" name="direccion" required/>
                    </div>
                    <div class="form-group">
                        <label for="intern">¿Eres usuario interno de Castores?</label>
                        <input type="checkbox" name="intern" value="1"/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar Usuario</button>
                </div>
            </form>
        </div>
    </div>
</div>