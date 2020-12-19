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
<!-- CDN Google font "Chilanka" -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Chilanka&display=swap"
	rel="stylesheet">
<!--Custom Styles CSS-->

<link rel="stylesheet" href="../style.css">
<script>
            /* Cette fonction permet d'afficher une vignette pour chaque image sÃ©lectionnÃ©e */
            function readFilesAndDisplayPreview(files) {
                let imageList = document.querySelector('#list'); 
                imageList.innerHTML = "";
                
                for ( let file of files ) {
                    let reader = new FileReader();
                    
                    reader.addEventListener( "load", function( event ) {
                        let span = document.createElement('span');
                        span.innerHTML = '<img widht="300" src="' + event.target.result + '" class="figure-img img-fluid rounded" alt="TestImage" />';
                        imageList.appendChild( span );
                        
                    });

                    reader.readAsDataURL( file );
                }
            }
        </script>

</head>
<body>

  <%@ include file="logoTop.jsp"%>
  <section id="ajout-produit">
	<!-- debut partie produit -->
	<div>
	  <h1>Nouvelle vente</h1>
	</div>	
	<div class="">
	  <div class="">
		<div class="col-lg-5">
			<!-- <img class="img-responsive" src="../exemple_image.jpg"> -->
			<figure id="list" class="img-responsive1">
			</figure>
		</div>
	  </div>
		
	  <div class="container">
	   <div class="row">	
		<div class="col-lg-6">	
		
          <form id="ajout-produit-form" method="post" action="${pageContext.servletContext.contextPath}/user/mettre_en_vente" enctype="multipart/form-data">
	
			<div class="col-lg-12">
			  <label for="article">Article :</label> 
			  <input id="article" type="text" name="article" class="form-control" placeholder="" value="">
			</div>
						
			<div class="col-lg-12">
               <label for="description">Description :</label>
               <textarea id="description" name="description" class="form-control" placeholder="" rows="4"></textarea>                             
            </div>
            
            <div class="col-lg-12">
			  <label for="categorie">Catégorie</label> 
			    <select name="derouleur_categories" id="categorie" class="form-control">
				  <option>Informatique</option>
				  <option>Ameublement</option>
				  <option>Vetement</option>
				  <option>Sport et Loisirs</option>
				</select>
			</div>
           
            
            
            <div class="col-lg-12">
              <label for="file">Photo de l'article</label>
              <input id="file" type="file" name="multiPartServlet" class="form-control" value="file" accept="image/*" multiple onchange="readFilesAndDisplayPreview(this.files);" >
            </div>
            
           
            
            <div class="col-lg-12">
              <label for="price">Mise à prix : </label>
              <input id="price" type="number" name="price" class="form-control" min="" step="10" value="140">
            </div>
            
            <div class="col-lg-12">
              <label for="beginning-date">Début de l'enchère : </label>
              <input type="date" id="beginning-date" name="beginning-date" placeholder="  /  /  " class="form-control" min="2018-01-01" max="2025-12-31" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
            </div>
                            
            <div class="col-lg-12">
              <label for="ending-date">Fin de l'enchère : </label>
              <input type="date" id="ending-date" name="ending-date" placeholder="  /  /  " class="form-control" min="2018-01-01" max="2025-12-31" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
            </div>
            
           <div class="col-lg-12">                 
            <fieldset>
    		  <legend>Retrait</legend>
    		  <div class="col-lg-12">
			    <label for="street">Rue :</label> 
			    <input id="street" type="text" name="street" class="form-control" placeholder="" value="${utilisateur.rue}">
			  </div>
			  <div class="col-lg-12">
			    <label for="zipCode">Code postal :</label> 
			    <input id="zipCode" type="text" name="zipCode" class="form-control" placeholder="" value="${utilisateur.code_postal}">
			  </div>
			  <div class="col-lg-12">
			    <label for="city">Ville :</label> 
			    <input id="city" type="text" name="city" class="form-control" placeholder="" value="${utilisateur.ville}">
			 </div>          
            </fieldset>
           </div>  
            
               
            <div class="col-md-12 divBtn">
			  <div class="col-md-5 btnCreer">
			    <input type="submit" class="btn-primary buttonEnregistrer" value="Enregistrer">
		      </div>
			  <div class="col-md-5 ">
			    <input type="reset" class="btn-primary buttonAnnuler" value="Annuler" onclick="location.href='${pageContext.request.contextPath}/user/accueil'">
			  </div>
			</div>    
			
          </form>
        </div>	
       </div>
	  </div>  	  
	</div>
	
  </section>
  

</body>
</html>