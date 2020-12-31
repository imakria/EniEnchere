<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<nav class="navbar navbar-default">
    <div class="container-fluid topBanner">

        <!-- Hamburger pour le format mobile -->
        <div class="navbar-header ">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span>
            </button>
            <c:choose>
                <c:when test="${!empty id }">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/user/accueil">ENI-Enchères</a>
                </c:when>
                <c:otherwise>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/accueil">ENI-Enchères</a>
                </c:otherwise>
            </c:choose>

        </div>
        <div class="collapse navbar-collapse navbarDiv divNavbar" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav divNavbar">
                <c:choose>
                    <c:when test="${!empty id }">
                        <li class="active"><a href="${pageContext.request.contextPath}/user/accueil">Enchères<span
                                class="sr-only">(current)</span></a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="active"><a href="${pageContext.request.contextPath}/accueil">Enchères<span
                                class="sr-only">(current)</span></a></li>
                    </c:otherwise>
                </c:choose>

                <c:if test="${!empty id }">
                    <li><a href="${pageContext.request.contextPath}/user/mettre_en_vente">Vendre
                        un article</a></li>
                    <li><a href="${pageContext.request.contextPath}/user/monprofil?id=${id}">Mon
                        profil</a></li>
                    <li><a href="${pageContext.request.contextPath}/deconnexion">Déconnexion</a></li>
                </c:if>

            </ul>
        </div>
</nav>
