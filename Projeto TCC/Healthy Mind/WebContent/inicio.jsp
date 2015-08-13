<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mente Saud�vel</title>

<!-- Latest compiled and minified CSS -->
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
			<a class="navbar-brand" href="inicioServlet">Mente Saud�vel <span
				class="glyphicon glyphicon-home"> </span></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Conv�nios <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="cadastrarConvenioServlet">Cadastrar Conv�nio</a></li>
						<li><a href="listarConvenioServlet">Listar Conv�nio</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Paciente <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="cadastrarPacienteServlet">Cadastrar Paciente</a></li>
						<li><a href="pesquisarPacienteServlet">Pesquisar Paciente</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Psic�logo <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="cadastrarPsicologoServlet">Cadastrar
								Psic�logo</a></li>
						<li><a href="pesquisarPsicologoServlet">Pesquisar
								Psic�logo</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Consulta <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="agendarConsultaServlet">Agendar Consulta</a></li>
						<li><a href="visualizarConsultaServlet">Visualizar
								Consulta</a></li>
					</ul></li>
					
					<li><a href="cadastrarAdministradorServlet">Cadastrar Administrador</a></li>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> 
</nav>

	

	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img alt="" src="img/bitmap1.png">
				<div class="carousel-caption">...</div>
			</div>
			<div class="item">
				<img alt="" src="img/bitmap1.png">
				<div class="carousel-caption">...</div>
			</div>
			...
		</div>

		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>