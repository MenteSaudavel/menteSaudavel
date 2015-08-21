<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mente Saudável</title>

<link rel="stylesheet" href="css/bootstrap.css">

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
			<a class="navbar-brand" href="menuPacienteServlet">Mente Saudável <span
				class="glyphicon glyphicon-home"> </span></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Consulta <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="agendarConsultaServlet">Agendar Consulta</a></li>
						<li><a href="visualizarConsultaServlet">Visualizar
								Consulta</a></li>
					</ul>
				</li>
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><span class="glyphicon glyphicon-option-vertical"></span></a>
				
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuDivider">
						<li>
							<a href="editarUsuarioServlet">
								Conta de Usuário <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
							</a>
						</li>
						
						<li role="separator" class="divider"></li>
						
						<li>
							<a href="sairServlet">
								Sair <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
							</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> 
</nav>