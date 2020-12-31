<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Inscription</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <!-- CDN Google font "Chilanka" -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link
            href="https://fonts.googleapis.com/css2?family=Chilanka&display=swap"
            rel="stylesheet">
    <!--Custom Styles CSS-->
    <link rel="stylesheet" href="style.css">
</head>

<body>

<%@ include file="header.jsp" %>

<section id="connexion_et_monprofil">
    <div class="container-fluid">
        <div class="heading">
            <h2>Connexion</h2>
        </div>

        <form method="post" action="${pageContext.request.contextPath}/connexion" class="formLogin ">
            <c:if test="${!empty messageErreur }">
                <div class="alert alert-danger" role="alert">
                    <p>${messageErreur}</p>
                </div>
            </c:if>
            <!--partie erreur de Identifiant la div ligne 48 ferme la div qui souvre en fonction de l'erreur  -->
            <c:choose>
            <c:when test="${!empty messageErreur }">
            <div class="form-group col form-inline has-error">
                </c:when>
                <c:otherwise>
                <div class="form-group col form-inline">
                    </c:otherwise>
                    </c:choose>

                    <label for="identifiant"> Identifiant : </label>
                    <input type="text" name="identifiant" id="identifiant" placeholder="identifiant..."
                           class="form-control" required autofocus>
                </div>
                <!--  -->
                <!--partie erreur de mot de passe la div ligne 63 ferme la div qui souvre en fonction de l'erreur  -->
                <c:choose>
                <c:when test="${!empty messageErreur }">
                <div class="form-group col form-inline has-error">
                    </c:when>
                    <c:otherwise>
                    <div class="form-group col form-inline">
                        </c:otherwise>
                        </c:choose>

                        <label for="motDePasse">Mot de passe : </label>
                        <input type="password" name="motDePasse" id="motDePasse" placeholder="mot de passe..."
                               class="form-control" required>

                    </div>
                    <!--  -->
                    <div class="connexionDiv ">
                        <button class="btn btn-primary btnConnexion" type="submit">Connexion</button>

                        <div class="checkBoxDiv">
                            <label class="labelCheckBox"> <input type="checkbox"
                                                                 name="seSouvenirDeMoi" id="seSouvenirDeMoi">Se souvenir
                                de
                                moi
                            </label> <a href="${pageContext.request.contextPath}/ServletPassword" class="motDePasseOublie">Mot
                            de passe oublié</a>
                        </div>
                    </div>
                    <div>
                        <a href="${pageContext.request.contextPath}/inscription"
                           class="btn btn-primary btn-lg btnCreerCompte" role="button">Créer
                            un compte</a>
                    </div>
        </form>
    </div>
    <div class="push"></div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"
            integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous">

    </script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
            integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous">
    </script>
</section>

<%@ include file="footer.jsp" %>
</body>

</html>