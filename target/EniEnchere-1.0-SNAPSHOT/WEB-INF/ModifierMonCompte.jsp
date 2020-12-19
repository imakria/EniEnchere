<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Modifier compte</title>
<!-- Bootstrap-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!--Google Font Family-->

<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Chilanka&display=swap"
	rel="stylesheet">
<!--Custom Styles CSS-->
<link rel="stylesheet" href="../style.css">
</head>
<body>
	<div class="logo">
			<%@ include file="logoTop.jsp"%>
	</div>
	
	<section id="modificationProfil">

		<div class="container">
            <div class="heading">
                <h2>Mon profil</h2>
            </div>
                
           <div class="row">
               <div class="col-lg-10 col-lg-offset-1">
                    <form id="modification-form" method="post" action="" role="form">
                        <div class="row" id="inscriptionRow">
                        
                        	<div class="col-md-6">
                                <label for="pseudo">Pseudo: *</label>
                                <input id="pseudo" type="text" name="pseudo" class="inscription-control" placeholder="Votre pseudo" value="${utilisateur.pseudo}">                                
                                <c:if test="${!empty messageErreurPseudo }">
                                	<p class="comments">${messageErreurPseudo }</p>                               
                                </c:if>
                            </div>
                            <div class="col-md-6">
                                <label for="name">Nom: *</label>
                                <input id="name" type="text" name="name" class="inscription-control" placeholder="Votre Nom" value="${utilisateur.nom}">
                                <c:if test="${!empty messageErreurNom }">
                                	<p class="comments">${messageErreurNom }</p>                               
                                </c:if>
                            </div>
                            <div class="col-md-6">
                                <label for="firstname">Prénom: *</label>
                                <input id="firstname" type="text" name="firstname" class="inscription-control" placeholder="Votre prénom" value="${utilisateur.prenom}">
                                <c:if test="${!empty messageErreurPrenom }">
                                	<p class="comments">${messageErreurPrenom }</p>                               
                                </c:if>
                            </div>
                            <div class="col-md-6">
                                <label for="email">Email: *</label>
                                <input id="email" type="text" name="email" class="inscription-control" placeholder="Votre Email" value="${utilisateur.email}">
                                
                                <c:if test="${!empty messageErreurEmail }">
                                	<p class="comments">${messageErreurEmail }</p>                               
                                </c:if>
                                                              
                            </div>
                            <div class="col-md-6">
                                <label for="phone">Téléphone: </label>
                                <input id="phone" type="tel" name="phone" class="inscription-control" placeholder="Votre Téléphone" value="${utilisateur.telephone}">
                                <c:if test="${!empty messageErreurPhone }">
                                	<p class="comments">${messageErreurPhone }</p>                               
                                </c:if>
                            </div>
                            <div class="col-md-6">
                                <label for="street">Rue: *</label>
                                <input id="street" name="street" class="inscription-control" placeholder="Votre rue" value="${utilisateur.rue}">
                                <c:if test="${!empty messageErreurRue }">
                                	<p class="comments">${messageErreurRue }</p>                               
                                </c:if>
                            </div>
                            <div class="col-md-6">
                                <label for="zipCode">Code postal: *</label>
                                <input id="zipCode" name="zipCode" class="inscription-control" placeholder="Votre code postal" value="${utilisateur.code_postal}">
                                <c:if test="${!empty messageErreurZipcode }">
                                	<p class="comments">${messageErreurZipcode }</p>                               
                                </c:if>
                            </div>
                            
                            <div class="col-md-6">
                                <label for="city">Ville: *</label>
                                <input id="city" name="city" class="inscription-control" placeholder="Votre ville: " value="${utilisateur.ville}">
                                <c:if test="${!empty messageErreurVille }">
                                	<p class="comments">${messageErreurVille }</p>                               
                                </c:if>                                                            
                            </div>
                            
                            <div class="col-md-12 passwordPart">
                                <label for="password">Mot de passe actuel: *</label>
                                <input id="oldPassword" type="password" name="oldPassword" class="inscription-control" placeholder="Votre mot de passe" >
                                <c:if test="${!empty messageErreurPassword }">
                                	<p class="comments">${messageErreurPassword }</p>                               
                                </c:if>
                            </div>
                                                     
                            <div class="col-md-6 passwordPart">
                                <label for="password">Nouveau mot de passe: *</label>
                                <input id="password" type="password" name="password" class="inscription-control" placeholder="Votre mot de passe">
                                <c:if test="${!empty messageErreurPassword }">
                                	<p class="comments">${messageErreurPassword }</p>                               
                                </c:if>
                            </div>
                            
                            <div class="col-md-6 passwordPart">
                                <label for="confirmation">Confirmation: *</label>
                                <input id="confirmation" type="password" name="confirmation" class="inscription-control">
                                <c:if test="${!empty messageErreurConfirmation }">
                                	<p class="comments">${messageErreurConfirmation }</p>                               
                                </c:if>
                            </div>  
                            
                            <div class="col-md-12 creditPart">
                            	<label for="credit">Crédit:</label>
                                <input id="credit" type="number" name="credit" class="inscription-control" value="${utilisateur.credit}">                            
                            </div>                         
                            
                            <c:if test="${!empty infoUpdate }">
             
                					<a href="${pageContext.request.contextPath}/user/accueil" class="col-md-12 btn-labeled btn-success"><i class="glyphicon glyphicon-ok"></i>Votre compte a été créé modifier succès - cliquez ici pour retourner sur la page d'accueil</a>
                                                        
                            </c:if>
                            
                            <div class="col-md-12 divBtn">
								<div class="col-md-6 btnCreer">
									<input type="submit" class="btn-primary buttonInscription btnEnregistrer" value="Enregistrer">
								</div>
								<div class="col-md-6 ">

									<a href = "${pageContext.request.contextPath}/user/suppressionCompte">
									<!--<input type="reset" class="btn-primary buttonInscription" value="Supprimer mon compte" onclick="confirmerSuppression()">  -->
									 <button type="button" class="btn-primary buttonInscription" onclick=" return confirm('Êtes vous sûre de vouloir supprimer votre compte!') location.href='<%=request.getContextPath()%>/user/suppressionCompte';">Supprimer mon compte</button>									
									</a>

								</div>
							</div> 

                        </div>

                    </form>
                </div>
           </div>
        </div>
      </section>
</body>
</html>