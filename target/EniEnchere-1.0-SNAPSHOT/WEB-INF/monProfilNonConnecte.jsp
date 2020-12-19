<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="fr">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Page Profil</title>
<!-- Bootstrap -->
<link rel="stylesheet"href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!--Google Font Family-->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Chilanka&display=swap"
	rel="stylesheet">
<!--Custom Styles CSS-->
<link rel="stylesheet" href="../style.css">
</head>


<body>
  <%@ include file="logoTop.jsp"%>
  <section id="connexion_et_monprofil">
	<div class="container-fluid">
		<div class="containerProfil">

			<div class="enLigne col ">
				<label class="labelProfil" for="nom">Pseudo : </label> <input class="form-control inputEnlectureSeul" type="text" placeholder="${utilisateur.pseudo}" readonly name="nom" id="nom">
			</div>
			<div class="enLigne col ">
				<label class="labelProfil" for="nom">Nom : </label> <input class="form-control inputEnlectureSeul" type="text" placeholder="${utilisateur.nom}" readonly name="nom" id="nom">
			</div>
			<div class="enLigne col ">
				<label class="labelProfil" for="prenom">Prénom : </label> <input class="form-control inputEnlectureSeul" type="text" placeholder="${utilisateur.prenom}" readonly name="prenom" id="prenom">
			</div>
			<div class="enLigne col ">
				<label class="labelProfil" for="email">Email : </label> <input class="form-control inputEnlectureSeul" type="text" placeholder="${utilisateur.email}" readonly name="email" id="email">
			</div>
			<div class="enLigne col ">
				<label class="labelProfil" for="telephone">Téléphone : </label> <input class="form-control inputEnlectureSeul" type="text" placeholder="${utilisateur.telephone}" readonly name="telephone" id="telephone">
			</div>
			<div class="enLigne col ">
				<label class="labelProfil" for="rue">Rue : </label> <input class="form-control inputEnlectureSeul" type="text" placeholder="${utilisateur.rue}" readonly name="rue" id="rue">
			</div>
			<div class="enLigne col ">
				<label class="labelProfil" for="codePostal">Code postal : </label> <input class="form-control inputEnlectureSeul" type="text" placeholder="${utilisateur.code_postal}" readonly name="codePostal" id="codePostal">
			</div>
			<div class="enLigne col ">
				<label class="labelProfil" for="ville">Ville : </label> <input class="form-control inputEnlectureSeul" type="text" placeholder="${utilisateur.ville}" readonly name="ville" id="ville">
			</div>
		</div>
	</div>



	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous">		
	</script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous">		
	</script>
  </section>
</body>

</html>