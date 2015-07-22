<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de pacientes</title>

<link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>

<nav class="navbar navbar-inverse navbar-static-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand">Mente Saudável</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      
        <li><a href="inicioServlet"> <span class="glyphicon glyphicon-home"> </span> <span class="sr-only">(current)</span></a></li>
      
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
        
        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
	
	<div class="panel panel-info">
  		<!-- Default panel contents -->
  		<div class="panel-heading"> <a class="glyphicon glyphicon-list-alt"></a> Lista de Pacientes  </div>


  		<!-- Table -->
  		<table class="table">
	   		<tr>
				<td> <b> Nome do Paciente </b></td>
				<td><b> Telefone</b></td>
				<td><b> Número da Carteirinha</b></td>
				<td> <b>Cpf </b></td>
				<td> <b>Convênio</b></td>
				<td><b> Editar</b></td>
				<td><b> Apagar </b></td>
			</tr>
					
			<c:if test="${empty listaPaciente }">
				<tr>
					<td colspan="7" class="alert alert-danger"> Paciente Não Encontrado! </td>
				</tr>
			</c:if>
					
			<c:forEach var="paciente" items="${listaPaciente}">
				<tr>
					<td> ${paciente.nome } </td>
					<td> ${paciente.telefone } </td>
					<td> ${paciente.numeroCarteirinha } </td>
					<td> ${paciente.cpf } </td>
					<td> ${paciente.convenio.nome }</td>
					<td> <a href="editarPacienteServlet?id=${paciente.id }" class="glyphicon glyphicon-pencil"> </a> </td>
					<td> <a href="apagarPacienteServlet?id=${paciente.id }" class="glyphicon glyphicon-trash"> </a> </td>
				</tr>
			</c:forEach>
  		</table>
	</div>
	 <c:if test="${apagado == true }"> <div class="alert alert-success" role="alert"> Paciente apagado com sucesso! </div> </c:if>
	 <c:if test="${editado == true }"> <div class="alert alert-success" role="alert"> Paciente editado com sucesso! </div> </c:if>
	 <c:if test="${editado == false }"> <div class="alert alert-danger" role="alert"> Erro ao editar paciente! </div> </c:if>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.11.3.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
	 
</body>
</html>