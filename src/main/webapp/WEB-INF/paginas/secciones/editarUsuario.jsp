
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/3556f97ea7.js" crossorigin="anonymous"></script>
        <title>Castores Test Alan</title>
    </head>
    <body>
        <jsp:include page="../comun/headUser.jsp"/>
        <jsp:include page="../comun/btnBack.jsp"/>
        <form action="${pageContext.request.contextPath}/ControladorServlets?tipo=sesion&accion=editar" method="POST" class="form-group">
            <jsp:include page="../comun/btnEditUsuarioNav.jsp"/>
            <section>
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="header">
                                    <h4>
                                        Editar cliente
                                    </h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label>Usuario: ${usuario.usuario}</label>
                                    </div>
                                    <div class="form-group">
                                        <label for="pass">Password</label>
                                        <input type="password" class="form-control" name="pass" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="name">Nombre</label>
                                        <input type="text" class="form-control" name="name" value="${persona.nombre}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="paterno">Apellido Paterno</label>
                                        <input type="text" class="form-control" name="paterno" value="${persona.apellidoPaterno}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="materno">Apellido Materno</label>
                                        <input type="text" class="form-control" name="materno" value="${persona.apellidoMaterno}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="dir">Direccion</label>
                                        <input type="text" class="form-control" name="dir" value="${persona.direccion}" required/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>
    </body>
</html>
