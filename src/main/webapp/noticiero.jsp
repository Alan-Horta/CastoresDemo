
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/3556f97ea7.js" crossorigin="anonymous"></script>
        <title>Castores Test Alan</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/paginas/comun/headUser.jsp"/>
        <jsp:include page="WEB-INF/paginas/comun/btnUsusarioEdit.jsp"/>
        <c:if test="${user.tipoUser == 1}">
            <jsp:include page="WEB-INF/paginas/comun/btnNoticieroAdd.jsp"/>
            <jsp:include page="WEB-INF/paginas/secciones/agregarNoticia.jsp"/>
        </c:if>
        <jsp:include page="WEB-INF/paginas/secciones/listadoNoticias.jsp"/>
    </body>
</html>
