<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mot de passe oublié</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="style.css">
<!-- CDN Google font "Chilanka" -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Chilanka&display=swap"
	rel="stylesheet">
</head>
<body>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<div class="form-gap"></div>
	<section id="password">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="text-center">
								<h3>
									<i class="fa fa-lock fa-4x"></i>
								</h3>
								<h2 class="text-center">Mot de passe oublié?</h2>
								<p>Vous pouvez réinitialiser votre mot de passe ici.</p>
								<div class="panel-body">

									<form
										action="${pageContext.request.contextPath}/ServletPassword"
										id="register-form" role="form" autocomplete="off" class="form"
										method="post">

										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon"><i
													class="glyphicon glyphicon-envelope color-blue"></i></span> <input
													id="email" name="email" placeholder="adresse email"
													class="form-control" type="email">
											</div>
										</div>
										<div class="form-group">
											<input name="recover-submit"
												class="btn btn-lg btn-primary btn-block"
												value="Réinitialiser" type="submit">
										</div>

										<input type="hidden" class="hide" name="token" id="token"
											value="">
									</form>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</section>
	</div>
</body>

</html>