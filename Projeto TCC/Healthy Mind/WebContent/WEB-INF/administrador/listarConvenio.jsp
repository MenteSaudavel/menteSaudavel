<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de convênios</title>

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
	
		<div class="panel-heading"><span class="glyphicon glyphicon-th-list"></span> <b>Lista de Convênios</b> </div>
		
		<table class="table">
		
			<tr class="info">
				<td><b>Nome do Convênio</b></td>
				<td><b>Nome do Presidente</b></td>
				<td><b>CNPJ</b></td>
				<td><b>Telefone</b></td>
				<td><b>Endereço</b></td>
				<td><b>CEP</b></td>
				<td><b>Cidade</b>
				<td><b>UF</b>
				<td><b>Editar</b></td>
				<td><b>Apagar</b></td>
			</tr>
			
			<c:if test="${empty listaConvenio }">
				<tr>
					<td colspan="10" class="alert alert-warning"> No momento não há nenhum convênio cadastrado. </td>
				</tr>
			</c:if>
			
			<c:forEach var="convenio" items="${listaConvenio}">
				<tr>
					<td>${convenio.nome }</td>
					<td>${convenio.presidente }</td>
					<td>${convenio.cnpj }</td>
					<td>${convenio.telefoneConvenio }</td>
					<td>${convenio.enderecoConvenio }</td>
					<td>${convenio.cep }</td>
					<td>${convenio.cidadeConvenio }</td>
					<td>${convenio.uf }</td>
					<td> <a href="editarConvenioServlet?id=${convenio.id }" class="glyphicon glyphicon-pencil"></a> </td>
					<td> <a href="apagarConvenioServlet?id=${convenio.id }" class="glyphicon glyphicon-trash"> </a> </td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	 <c:if test="${apagado == true }"> <div class="alert alert-success" role="alert"> Convênio apagado com sucesso! </div> </c:if>
	 <c:if test="${apagado == false }"> <div class="alert alert-danger" role="alert"> Erro ao apagar convênio! </div> </c:if>
	 <c:if test="${editado == true }"> <div class="alert alert-success" role="alert"> Convênio editado com sucesso! </div> </c:if>
	 <c:if test="${editado == false }"> <div class="alert alert-danger" role="alert"> Erro ao editar convênio! </div> </c:if>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.11.3.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>

</body>
</html>