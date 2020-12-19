<%--
  Created by IntelliJ IDEA.
  User: mak_t
  Date: 18/12/2020
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
          crossorigin="anonymous">
    <!--Google Font Family-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
            rel="stylesheet">
    <!--Pour icone-->
    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.15.1/css/all.css"
          integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp"
          crossorigin="anonymous">
    <!--Custom Styles CSS-->
    <link rel="stylesheet" href="style.css">
    <!--Jquery-->
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.0/jquery.min.js"></script>
    <!-- CDN Google font "Chilanka" -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link
            href="https://fonts.googleapis.com/css2?family=Chilanka&display=swap"
            rel="stylesheet">
    <title>Accueil</title>
</head>
<body>
<section id=accueilOffline>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <c:if test="${!empty email2 }">
                <div class="alert alert-success" role="alert">Mot de passe
                    réinitialisé !!! Merci de consulter votre boîte mail
                </div>
            </c:if>
            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">ENI-Encheres</a>
            </div>
            <div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/inscription">S'inscrire</a></li>
                    <li><a href="${pageContext.request.contextPath}/connexion">Se
                        connecter</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container-fluid">
        <div class="titrePage">
            <p>Liste des enchères</p>
        </div>
        <form action="${pageContext.request.contextPath}/ServletFiltre">
            <div class="row divPrincipaleAvecFiltre">
                <div class=" col12 col-md-8  colonne1">
                    <div class="row ">
                        <h4 class="filtreTitre">
                            <strong>Filtres :</strong>
                        </h4>
                    </div>
                    <div class="input-group">
                        <div class="input-group-prepend">
								<span class="input-group-text" id="basic-text1"><i
                                        class="fas fa-search text-black" aria-hidden="true"></i></span>
                        </div>
                        <input class="form-control my-0 py-1" type="text"
                               placeholder="Le nom de l'article contient" aria-label="Search">
                    </div>
                    <div class="row categorieContainer">
                        <div class="titreCategorie">
                            <label for="categories">Catégorie :</label>
                        </div>
                        <div class="btn-group divDropDown">
                            <button type="button" class="btn btn-default dropdown-toggle"
                                    data-toggle="dropdown" aria-haspopup="true"
                                    aria-expanded="false">
                                Choisissez votre catégorie... <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu divDropDown">
                                <c:forEach items="${listeCategories}" var="categorie">
                                    <option onclick="filterSelection(${categorie.noCategorie})">${categorie.libelle}</option>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                </div>
                <div class="col-12 col-md-4">
                    <div class="colonne2">
                        <div class="col btnRechercherConnecte">
                            <button type="submit"
                                    class="btn btn-lg btn-primary btnRechercher shadow p-3 mb-5 ">
                                Rechercher
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <div class="alignerCarteProduit ">
            <c:forEach items="${listeArticlesVendus}" var="articleVendu">
                <div class="card-product filterDiv ${articleVendu.noCategorie}">
                    <img
                            src="https://d1eh9yux7w8iql.cloudfront.net/product_images/286281_fef79c54-2ee2-4427-819c-5e1f2ed0b392.jpg"
                            class=""/>
                    <div class="">
                        <h2 class="">
                            <a
                                    href="${pageContext.request.contextPath}/encherir?idArticle=${articleVendu.noArticle}&prixVente=${articleVendu.prixVente}">${articleVendu.nomArticle}</a>
                        </h2>
                        <p class="">Prix : ${articleVendu.prixVente} points</p>
                        <p class="">Fin de l'enchère :
                                ${articleVendu.dateFinEncheres}</p>
                        <p class="">Vendeur: ${utilisateur.pseudo}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <!-- jQuery pour selectionner et deselectionner radioButton -->
    <script src="script.js"></script>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"
            integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ"
            crossorigin="anonymous">
    </script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
            integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
            crossorigin="anonymous">
    </script>
</section>
</body>

</html>
