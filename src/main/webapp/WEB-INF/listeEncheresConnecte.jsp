<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
    <!--Pour icone-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css">
    <!--Custom Styles CSS-->
    <link rel="stylesheet" href="../style.css">
    <!--Jquery-->
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.0/jquery.min.js"></script>

</head>
<body>
<section id="enchereConnecte">


    <nav class="navbar navbar-default">
        <div class="container-fluid">
            ${compteCree }

            <c:if test="${!empty compteCree}">
                <div class="alert alert-success" role="alert">Compte crée
                    avec succès !!! Merci de valider le lien ennvoyé à
                        ${utilisateur.email }</div>
            </c:if>

            <c:if test="${!empty articleMisEnVente}">
                <div class="alert alert-success" role="alert">Votre article :
                        ${nomArticle} est valide et vient d'être mis aux enchères !!!</div>
            </c:if>
            <!-- Hamburger pour le format mobile -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed"
                        data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                        aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span> <span
                        class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">ENI-Enchères</a>
            </div>
            <div class="collapse navbar-collapse navbarDiv"
                 id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav divNavbar">
                    <li class="active"><a href="#">Enchères<span
                            class="sr-only">(current)</span></a></li>
                    <li><a
                            href="${pageContext.request.contextPath}/user/mettre_en_vente">Vendre
                        un article</a></li>
                    <c:if test="${!empty id }">

                        <li><a
                                href="${pageContext.request.contextPath}/user/monprofil?id=${id}">Mon
                            profil</a></li>
                    </c:if>
                    <li><a href="${pageContext.request.contextPath}/deconnexion">Déconnexion</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container-fluid">
        <div class="titrePage">
            <p>Liste des enchères</p>
        </div>
        <form action="${pageContext.request.contextPath}/user/ServletFiltre">
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
                        <input class="form-control my-0 py-1" type="text" placeholder="Le nom de l'article contient" aria-label="Search" name="keyword">
                    </div>
                    <div class="row categorieContainer">
                        <div class="titreCategorie">
                            <label for="categories">Catégorie :</label>
                        </div>

                        <div class="btn-group divDropDown">
                            <button type="button" class="btn btn-default dropdown-toggle"
                                    data-toggle="dropdown" aria-haspopup="true"
                                    aria-expanded="false" id="categories">
                                Choisissez la catégorie <span class="caret littleScare"></span>
                            </button>
                            <ul class="dropdown-menu divDropDown">
                                <c:forEach items="${listeCategories}" var="categorie">
                                    <option onclick="filterSelection(${categorie.noCategorie})">${categorie.libelle}</option>
                                </c:forEach>
                            </ul>
                        </div>


                    </div>
                    <div class="row divRadioEtCheckbox">
                        <div class="col divAchats col-12 col-md-4">
                            <div class="radio">
                                <label> <input type="radio" name="filtering" value="0"
                                               class="rbFilter" id="filteringON" checked> <strong>Achats</strong>
                                </label>
                            </div>
                            <div class="divCheckboxAchat">
                                <div id="filterOnControls">
                                    <div class="checkbox">
                                        <label> <input type="checkbox"
                                                       name="encheresOuvertes" value="encheresOuvertes">
                                            enchères ouvertes
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label> <input type="checkbox" name="mesEncheres"
                                                       value="mesEncheres"> mes enchères
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label> <input type="checkbox"
                                                       name="mesEncheresRemportees" value="mesEncheresRemportees">
                                            mes enchères remportées
                                        </label>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="col divMesVentes col-12 col-md-4">
                            <div class="radio">
                                <label> <input name="filtering" type="radio" value="1"
                                               class="rbFilter" id="filteringOff"> <strong>Mes
                                    ventes</strong>
                                </label>
                            </div>
                            <div class="divCheckMesVentes">
                                <div id="filterOnControls">
                                    <div class="checkbox">
                                        <label> <input type="checkbox"
                                                       name="mesVentesEnCours" value="mesVentesEnCours"
                                                       disabled> mes ventes en cours
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label> <input type="checkbox"
                                                       name="ventesNonDebutees" value="ventesNonDebutees"
                                                       disabled> ventes non débutées
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label> <input type="checkbox" name="ventesTerminees"
                                                       value="ventesTerminees" disabled> ventes
                                            terminées
                                        </label>
                                    </div>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-4">
                    <div class="colonne2">
                        <div class="col btnRechercherConnecte">
                            <button type="submit"
                                    class="btn btn-lg btn-primary btnRechercher shadow p-3 mb-5 ">
                                Rechercher</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <div class="alignerCarteProduit ">
            <c:forEach items="${listeArticlesVendus}" var="articleVendu">
                <div class="card-product filterDiv ${articleVendu.noCategorie} show">
                    <img
                            src="${pageContext.servletContext.contextPath}/demoUpload/${articleVendu.image}"
                            class="" />
                    <div class="">
                        <h2 class="">
                            <a
                                    href="${pageContext.request.contextPath}/encherir?idArticle=${articleVendu.noArticle}&prixVente=${articleVendu.prixVente}">${articleVendu.nomArticle}</a>
                        </h2>
                        <p class="">Prix : ${articleVendu.prixVente} points</p>
                        <p class="">Fin de l'enchère :	${articleVendu.dateFinEncheres}</p>
                        <p class="">
                            Vendeur:

                            <a	href="${pageContext.request.contextPath}/user/monprofil1?id=${id}">${utilisateur.pseudo}</a>
                        </p>
                    </div>
                </div>

            </c:forEach>
        </div>

    </div>

    <!-- jQuery pour selectionner et deselectionner radioButton -->
    <script src="../script.js"></script>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</section>
</body>
</html>