<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Entre em contato</title>

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

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">
			<h1>Olá,</h1>
			<p>se deseja entrar em contato conosco, abaixo estão disponíveis
			nossas opções para contato. Leia a descrição de cada uma e utilize
			 a que se encaixa em sua situação.</p>
			<p>
			 Se você já possui cadastro no sistema, clique em entrar.
			</p>
			<p>
				<a class="btn btn-success btn-lg" href="loginServlet" role="button"> Entrar &raquo;</a>
			</p>
		</div>
	</div>

	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<h2>Telefone</h2>
				<p align="justify">
				Ligue neste telefone se você se encaixa em uma das opções descritas
				abaixo :<br><br>
				<b>1)</b> Empresários que desejam negociar para que o sistema funcione
				com seu convênio;<br>
				<br><b>2)</b> Psicólogos que possuem sua própria clínica
				e desejam utilizar o sistema.<br>
				</p>
				<br><h4><label class="label label-warning label-md"><b>(41) 5555-5555</b>
				</label></h4>
			</div>
			<div class="col-md-4">
				<h2>Email</h2>
				<p align="justify">Se você possui alguma dúvida, reclamação, sugestão, problema ao
				acessar o sistema ou algo que esteja relacionado a isto, nos mande
				um email para podermos lhe atender.<br>
				</p>
				<br><h4><label class="label label-warning"><b>mentesaudavel@outlook.com.br</b>
				</label></h4>
			</div>
		</div>

		<hr>

		<footer>
		<p>
			&copy; 2015 Mente Saudável. &middot; <a href="#"
				class="btn btn-info btn-md pull-right"><span
				class="glyphicon glyphicon-circle-arrow-up"></span></a><a href="http://portal.crppr.org.br/">Site CRP-PR</a> &middot; <a href="http://site.cfp.org.br/">Site CFP</a>
		</p>
		</footer>
	</div>
	<!-- /container -->

</body>
</html>