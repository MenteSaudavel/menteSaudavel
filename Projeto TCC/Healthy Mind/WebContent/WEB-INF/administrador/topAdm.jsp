<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mente Saudável</title>

<link rel="stylesheet" href="css/bootstrap.css">

<style>
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
			<a class="navbar-brand" href="menuAdministradorServlet">Mente
				Saudável <span class="glyphicon glyphicon-home"> </span>
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Administrador <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="cadastrarAdministradorServlet"><span
								class="glyphicon glyphicon-plus-sign"></span> Cadastrar
								Administrador</a></li>
						<li><a href="listarAdministradorServlet"><span
								class="glyphicon glyphicon-list-alt"></span> Lista de
								Administradores</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Convênio <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="cadastrarConvenioServlet"><span
								class="glyphicon glyphicon-plus-sign"></span> Cadastrar Convênio</a></li>
						<li><a href="listarConvenioServlet"><span
								class="glyphicon glyphicon-list-alt"></span> Lista de Convênios</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Paciente <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="cadastrarPacienteServlet"><span
								class="glyphicon glyphicon-plus-sign"></span> Cadastrar Paciente</a></li>
						<li><a href="listarPacienteServlet"><span
								class="glyphicon glyphicon-list-alt"></span> Lista de Pacientes</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Psicólogo <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="cadastrarPsicologoServlet"><span
								class="glyphicon glyphicon-plus-sign"></span> Cadastrar
								Psicólogo</a></li>
						<li><a href="listarPsicologoServlet"><span
								class="glyphicon glyphicon-list-alt"></span> Lista de Psicólogos</a></li>
					</ul></li>


			</ul>

			<ul class="nav navbar-nav navbar-right">

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">${usuario.email }<span
						class="glyphicon glyphicon-option-vertical"></span></a>

					<ul class="dropdown-menu" aria-labelledby="dropdownMenuDivider">
						<li><a href="editarUsuarioServlet"> Conta de Usuário <span
								class="glyphicon glyphicon-user" aria-hidden="true"></span>
						</a></li>

						<li role="separator" class="divider"></li>

						<li><a href="sairServlet"> Sair <span
								class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
						</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>