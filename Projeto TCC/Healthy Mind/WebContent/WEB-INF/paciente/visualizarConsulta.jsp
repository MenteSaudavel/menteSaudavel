<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visualizar Consulta</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.css">

</head>
<body>

<nav class="navbar navbar-default navbar-static-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="inicioServlet">Mente Saudável <span class="glyphicon glyphicon-home"> </span></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
     
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Convênios <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="cadastrarConvenioServlet">Cadastrar Convênio</a></li>
            <li><a href="listarConvenioServlet">Listar Convênio</a></li>
          </ul>
        </li>
        
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Paciente <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="cadastrarPacienteServlet">Cadastrar Paciente</a></li>
            <li><a href="pesquisarPacienteServlet">Pesquisar Paciente</a></li>
          </ul>
        </li>
        
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Psicólogo <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="cadastrarPsicologoServlet">Cadastrar Psicólogo</a></li>
            <li><a href="pesquisarPsicologoServlet">Pesquisar Psicólogo</a></li>
          </ul>
        </li>
        
       	<li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Consulta <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="agendarConsultaServlet">Agendar Consulta</a></li>
            <li><a href="visualizarConsultaServlet">Visualizar Consulta</a></li>
          </ul>
        </li>        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

	<div class="panel panel-primary">

		<div class="panel-heading"><span class="glyphicon glyphicon-th-list"></span> <b>Consultas Agendadas</b> </div>
		
		<table class="table">
		
			<tr class="info">
				<td><b>Psicólogo</b></td>
				<td><b>Data da Consulta</b></td>
				<td><b>Hora da Consulta</b></td>
				<td><b>Remarcar</b></td>
				<td><b>Desmarcar</b></td>
			</tr>
			
			<c:if test="${empty listaConsulta }">
				<tr>
					<td colspan="7" class="alert alert-warning"> No momento não há consultas agendadas. </td>
				</tr>
			</c:if>
			
			<c:forEach var="consulta" items="${listaConsulta}">
				<tr>
					<td>${consulta.psicologo.nome }</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${consulta.dataConsulta }" /></td>
					<td>${consulta.horaConsulta }</td>
					<td> <a href="remarcarConsultaServlet?idConsulta=${consulta.idConsulta }" class="glyphicon glyphicon-edit"></a> </td>
					<td> <a href="desmarcarConsultaServlet?idConsulta=${consulta.idConsulta }" class="glyphicon glyphicon-trash"> </a> </td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<c:if test="${desmarcado == true }"> <div class="alert alert-success" role="alert"> Consulta desmarcada com sucesso! </div> </c:if>
	<c:if test="${desmarcado == false }"> <div class="alert alert-danger" role="alert"> Erro ao desmarcar consulta! </div> </c:if>
	<c:if test="${remarcado == true }"> <div class="alert alert-success" role="alert"> Consulta remarcada com sucesso! </div> </c:if>
	<c:if test="${remarcado == false }"> <div class="alert alert-danger" role="alert"> Erro ao remarcar consulta! </div> </c:if>
	

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.11.3.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>