<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<link rel="stylesheet" href="css/bootstrap.css">
<style>
.form-signin {
	max-width: 450px;
	margin: 0 auto;
}

.navbar-default {
	background-color: #127a9c;
	border-color: #127a9c;
}

.navbar-default .navbar-brand {
	color: #ffffff;
}

.navbar-default .navbar-brand:hover, .navbar-default .navbar-brand:focus
	{
	color: #46cefb;
}

.navbar-default .navbar-text {
	color: #ffffff;
}

.navbar-default .navbar-nav>li>a {
	color: #ffffff;
}

.navbar-default .navbar-nav>li>a:hover, .navbar-default .navbar-nav>li>a:focus
	{
	color: #46cefb;
}

.navbar-default .navbar-nav>li>.dropdown-menu {
	background-color: #127a9c;
}

.navbar-default .navbar-nav>li>.dropdown-menu>li>a {
	color: #ffffff;
}

.navbar-default .navbar-nav>li>.dropdown-menu>li>a:hover,
	.navbar-default .navbar-nav>li>.dropdown-menu>li>a:focus {
	color: #46cefb;
	background-color: #084e74;
}

.navbar-default .navbar-nav>li>.dropdown-menu>li>.divider {
	background-color: #127a9c;
}

.navbar-default .navbar-nav>.active>a, .navbar-default .navbar-nav>.active>a:hover,
	.navbar-default .navbar-nav>.active>a:focus {
	color: #46cefb;
	background-color: #084e74;
}

.navbar-default .navbar-nav>.open>a, .navbar-default .navbar-nav>.open>a:hover,
	.navbar-default .navbar-nav>.open>a:focus {
	color: #46cefb;
	background-color: #084e74;
}

.navbar-default .navbar-toggle {
	border-color: #084e74;
}

.navbar-default .navbar-toggle:hover, .navbar-default .navbar-toggle:focus
	{
	background-color: #084e74;
}

.navbar-default .navbar-toggle .icon-bar {
	background-color: #ffffff;
}

.navbar-default .navbar-collapse, .navbar-default .navbar-form {
	border-color: #ffffff;
}

.navbar-default .navbar-link {
	color: #ffffff;
}

.navbar-default .navbar-link:hover {
	color: #46cefb;
}

@media ( max-width : 767px) {
	.navbar-default .navbar-nav .open .dropdown-menu>li>a {
		color: #ffffff;
	}
	.navbar-default .navbar-nav .open .dropdown-menu>li>a:hover,
		.navbar-default .navbar-nav .open .dropdown-menu>li>a:focus {
		color: #46cefb;
	}
	.navbar-default .navbar-nav .open .dropdown-menu>.active>a,
		.navbar-default .navbar-nav .open .dropdown-menu>.active>a:hover,
		.navbar-default .navbar-nav .open .dropdown-menu>.active>a:focus {
		color: #46cefb;
		background-color: #084e74;
	}
}
</style>


</head>
<body>

	<nav class="navbar navbar-default navbar-static-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="inicioServlet"><span
				class="glyphicon glyphicon-circle-arrow-left"></span></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">


			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>


	<div class="container">


		<form class="form-signin" action="loginServlet" method="post">

			<h2 class="form-signin-heading">
				<img alt="Mente Saudável" src="img/bitmap2.png">
			</h2>
			<label for="inputEmail" class="sr-only"></label> <input type="email"
				id="inputEmail" class="form-control input-lg"
				placeholder="Endereço de e-mail" name="email" required autofocus>
			<label for="inputPassword" class="sr-only"></label> <br> <input
				type="password" id="inputPassword" class="form-control input-lg"
				placeholder="Senha" name="senha" required> <br>
			<button class="btn btn-lg btn-success btn-block" type="submit">Entrar</button>

		</form>

	</div>

	<br>
	<c:if test="${logado == false }">
		<div class="alert alert-danger alert-dismissible" role="alert">
			<span class="glyphicon glyphicon-alert"></span>
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>Usuário não encontrado ou senha incorreta!</strong>
		</div>
	</c:if>
	
	<div class="container marketing navbar-fixed-bottom">

		<!-- FOOTER -->
		<footer class="footer">
			<hr>
			<p>
				&copy; 2015 Mente Saudável.  &middot; <a href="entrarEmContato.jsp">Fale Conosco</a> &middot;
			</p>
		</footer>

	</div>
	<!-- /.container -->
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

</body>
</html>