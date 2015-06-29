<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pesquisar Psic�logo</title>

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

		<div class="row">
		  <div class="col-lg-4">
		  	<form method="post" action="pesquisarPsicologoServlet">
			<div class="input-group">
		      <input type="text" class="form-control" placeholder="Nome do Psic�logo" name="nomePesquisaPsicologo" required>
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="submit">Pesquisar</button>
		      </span>
		    </div><!-- /input-group -->
		    </form>
		  </div><!-- /.col-lg-6 -->
		</div><!-- /.row -->
	
		<!--  <div>
		
			<form method="post" action="pesquisarPsicologoServlet">
			
				<table>
					<tr>
						<td> Nome do Psic�logo: </td> <td> <input type="text" name="nomePesquisaPsicologo" required> </td> <td> <input type="submit" value="Pesquisar"> </td>
					</tr>
				</table>
			</form>
			
		</div> -->
		${msg}
	
</body>
</html>