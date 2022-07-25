<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="main-header" class="py-2 bg-info text-white">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h2 class="text-center">
                    ${user.usuario}
                </h2>
                <h3 class="text-center">
                    <c:choose>
                        <c:when test="${user.tipoUser == 1}">
                            Interno
                        </c:when>
                        <c:otherwise>
                            Externo
                        </c:otherwise>
                    </c:choose>
                </h3>
            </div>
        </div>
    </div>
</header>