<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- meta de base pour du bootstrap -->
<meta name="viewport" content="width=device-width, initial-scale=1"
	charset="UTF-8">
<!-- Lien au .css -->
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<!-- CDN Google font "Chilanka" -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Chilanka&display=swap"
	rel="stylesheet">
<!-- CDN Bootstrap 3 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Acquisition</title>
</head>
<body> 
	<section id=page_acquisition>
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">ENI-Encheres</a>
				</div>
			</div>
		</nav>
		<div class="container-fluid">
			<div class="row">
				<div>
					<h1>Vous avez remporté la vente</h1>
				</div>
			</div>
		</div>
		<!-- Infos vente -->
		<div class="container-fluid infos_vente">
			<div class="row">
				<div class="col-xs-12 col-sm-8">
					<div class="col-xs-4 col-sm-4">
						<img class="img-responsive" src="exemple_image.jpg">
					</div>
					<div class="col-xs-8 col-sm-8 texte_vente">
						<h4>PC Gamer pour travailler</h4>
						<div class="zone_description">
							<label for="texte_description">Description :</label>
							<p id="texte_description">Lorem ipsum dolor sit amet,
								consectetur adipiscing elit. In ac mauris quam. Fusce iaculis
								commodo sapien, non commodo massa condimentum a. In cursus magna
								a nisi dapibus rhoncus non et est.</p>
						</div>
						<p>Meilleure offre : 210 pts</p>
						<p>Mise à prix : 185 points</p>
						<br>
						<p>
							Retrait : 10 allée des Alouettes<br>44800 Saint Herblain
						</p>
						<br>
						<p>Vendeur: jojo44</p>
						<p>06060606</p>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12 col-sm-8">
					<button>Back</button>
				</div>
			</div>
		</div>
	</section>
</body>
</html>