<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Conv�nio</title>

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
      <a class="navbar-brand" href="inicioServlet">Mente Saud�vel <span class="glyphicon glyphicon-home"> </span></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Conv�nios <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="cadastrarConvenioServlet">Cadastrar Conv�nio</a></li>
            <li><a href="listarConvenioServlet">Listar Conv�nio</a></li>
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
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Psic�logo <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="cadastrarPsicologoServlet">Cadastrar Psic�logo</a></li>
            <li><a href="pesquisarPsicologoServlet">Pesquisar Psic�logo</a></li>
          </ul>
        </li>
        
       	<li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Consulta <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="agendarConsultaServlet">Agendar Consulta</a></li>
            <li><a href="visualizarConsultaServlet">Visualizar Consulta</a></li>
          </ul>
        </li>      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
	
	<form action="editarConvenioServlet" method="post" class="form-horizontal">
		
		<input type="hidden" name="id" value="${convenio.id }">
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Nome do Conv�nio</label>
			
			<div class="col-sm-5">
				<input type="text" name="nome" required class="form-control" value="${convenio.nome }">
			</div>
		</div>
		
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Nome do Presidente</label>
			
			<div class="col-sm-5">
				<input type="text" name="presidente" required class="form-control" value="${convenio.presidente }">
			</div>
		</div>
		
		
		<div class="form-group">
			<label class="col-sm-2 control-label">CNPJ</label>
			
			<div class="col-sm-5">
				<input type="text" name="cnpj" required class="form-control" value="${convenio.cnpj }">
			</div>
		</div>
		
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Telefone</label>
			
			<div class="col-sm-5">
				<input type="text" name="telefone" required class="form-control" value="${convenio.telefoneConvenio }">
			</div>
		</div>
		
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Endere�o</label>
			
			<div class="col-sm-5">
				<input type="text" name="endereco" required class="form-control" value="${convenio.enderecoConvenio }">
			</div>
		</div>
		
		
		<div class="form-group">
			<label class="col-sm-2 control-label">CEP</label>
			
			<div class="col-sm-5">
				<input type="text" name="cep" required class="form-control" value="${convenio.cep }">
			</div>
		</div>
		
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Cidade</label>
			
			<div class="col-sm-5">
				<input type="text" name="cidade" required class="form-control" value="${convenio.cidadeConvenio }">
			</div>
		</div>
		
		
		<div class="form-group">
			<label class="col-sm-2 control-label">UF</label>
			
			<div class="col-sm-5">
				<input type="text" name="uf" required class="form-control" value="${convenio.uf }">
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-7 control-label">
				<button type="submit" class="btn btn-success">Salvar <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span> </button>
			</div>
		</div>
	
	</form>
	
	<form class="form-group" method="get" action="listarConvenioServlet">
		<div class="col-sm-7 control-label">
			<button type="submit" class="btn btn-danger">Cancelar <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span> </button>
		</div>
	</form>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.11.3.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
	
</body>
</html>