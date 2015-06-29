<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar conv�nio</title>

<link rel="stylesheet" href="css/bootstrap.css">

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
      <a class="navbar-brand">Mente Saud�vel</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="inicioServlet"> <span class="glyphicon glyphicon-home"> </span> <span class="sr-only">(current)</span></a></li>
        <li><a href="cadastrarPacienteServlet">Cadastrar Paciente</a></li>
        <li><a href="cadastrarPsicologoServlet">Cadastrar Psic�logo</a></li>
        <li><a href="pesquisarPacienteServlet">Pesquisar Paciente</a></li>
        <li><a href="pesquisarPsicologoServlet">Pesquisar Psic�logo</a></li>
        <li><a href="listarConvenioServlet">Conv�nios</a></li>
        <li><a href="cadastrarConvenioServlet">Cadastrar Conv�nio</a></li>
        
        
        <!--   <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Pesquisar <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="pesquisarPacienteServlet">Pesquisar Paciente</a></li>
            <li><a href="pesquisarPsicologoServlet">Pesquisar Psic�logo</a></li>
          </ul>
        </li> -->
        
        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
	
	<form action="editarConvenioServlet" method="post" class="form-horizontal">
		
		<input type="hidden" name="id" value="${convenio.id }">
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Nome do conv�nio</label>
			
			<div class="col-sm-5">
				<input type="text" name="nome" required class="form-control" value="${convenio.nome }">
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-7 control-label">
				<input type="submit" value="Editar" class="btn btn-success">
			</div>
		</div>
	
	</form>
	
</body>
</html>