<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Psicólogo</title>

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

		<form method="post" action="editarPsicologoServlet" class="form-horizontal">
			
			<div class="form-group">
				<div> <input type="hidden" name="id" value="${psicologo.id }"> </div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Nome do Psicólogo</label>
				<div class="col-sm-5"><input type="text" name="nome" required value="${psicologo.nome }" class="form-control"></div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Telefone do Consultório</label>
				<div class="col-sm-5"><input type="text" name="telefoneConsultorio" required value="${psicologo.telefoneConsultorio }" class="form-control">
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Convênio</label>
				
				<div class="col-sm-5">
					<select name="idConvenio" class="form-control">
							<option></option>
						<c:forEach var="convenio" items="${lista}">	
								
							<option value="${convenio.id }" <c:if test="${psicologo.idConvenio == convenio.id }"> selected </c:if> >${convenio.nome }</option>
								
						</c:forEach>	
					</select>	
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Número do CRP</label>
				<div class="col-sm-5"><input type="text" name="crp" required value="${psicologo.crp }" class="form-control"></div>
			</div>

			<div class="form-group">
				<div class="col-sm-7 control-label"><input type="submit" value="Editar" class="btn btn-success"></div>
			</div>

		</form>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.11.3.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
		
</body>
</html>