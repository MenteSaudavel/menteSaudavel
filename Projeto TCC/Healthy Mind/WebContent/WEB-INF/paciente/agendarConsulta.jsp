<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agendar Consulta</title>

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
			<a class="navbar-brand" href="inicioServlet">Mente Saudável <span
				class="glyphicon glyphicon-home"> </span></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Convênios <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="cadastrarConvenioServlet">Cadastrar Convênio</a></li>
						<li><a href="listarConvenioServlet">Listar Convênio</a></li>
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
					aria-expanded="false">Psicólogo <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="cadastrarPsicologoServlet">Cadastrar
								Psicólogo</a></li>
						<li><a href="pesquisarPsicologoServlet">Pesquisar
								Psicólogo</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Consulta <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="agendarConsultaServlet">Agendar Consulta</a></li>
						<li><a href="visualizarConsultaServlet">Visualizar
								Consulta</a></li>
					</ul></li>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-7">
				<form action="agendarConsultaServlet" method="post">

					<div class="form-group">
						<label class="control-label"> Selecione um psicólogo </label> <select
							name="idPsicologo" class="form-control">
							<option></option>
							<c:forEach var="psicologo" items="${listaPsicologo}">
								<option value="${psicologo.id }">${psicologo.nome }</option>
							</c:forEach>
						</select>
					</div>

					<div class="form-group">
						<label class="control-label"> Data da Consulta </label>
						<input type="text" name="dataConsulta" class="form-control" required>
					</div>

					<div class="form-group">
						<label class="control-label"> Hora da Consulta </label>
						<input type="time" name="horaConsulta" class="form-control" required>
					</div>

					<div class="form-group">
						<div class="control-label pull-right">
							<button type="reset" class="btn btn-danger">
								Limpar <span class="glyphicon glyphicon-erase"
									aria-hidden="true"></span>
							</button>
							<button type="submit" class="btn btn-success">
								Agendar <span class="glyphicon glyphicon-ok-sign"
									aria-hidden="true"></span>
							</button>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>

	<form method="get" action="menuPacienteServlet" class="form-group">
		<div class="form-group">
			<div class="col-sm-7 control-label">
				<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-circle-arrow-left"
						aria-hidden="true"></span> Voltar
				</button>
			</div>
		</div>
	</form>

	<br>
	<br>
	<c:if test="${agendado == true }">
		<div class="alert alert-success" role="alert">Consulta agendada
			com sucesso!</div>
	</c:if>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

</body>
</html>