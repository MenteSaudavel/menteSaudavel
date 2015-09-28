<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mente Saud�vel</title>

<style>
.x{
	padding: 0px;
}

</style>

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
      <a class="navbar-brand">Mente Saud�vel</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

      		
      <ul class="nav navbar-nav navbar-right">

      	<li>

      		<a href="loginServlet" class="btn btn-navbar">
      				Entrar <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
      		</a>

      	</li>

      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="container">
<div class="row row-offcanvas row-offcanvas-right">
	<div class="jumbotron">
	      
	        <h1 align=center><span class="label label-info">Mente Saud�vel</span></h1>
	       	<br>
				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					</ol>
			
					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<p align=center>
								<img alt="" src="img/logo-novo2 - C�pia.png">
							</p>
							<div class="carousel-caption">...</div>
						</div>
						<div class="item">
							<p align=center>
								<img alt="" src="img/logo-novo2 - C�pia.png">
							</p>
							<div class="carousel-caption">...</div>
						</div>
						
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

	        	<br>
	        <p><a class="btn btn-success btn-lg" href="loginServlet" role="button">Entrar &raquo;</a></p>
	     
	</div>
</div>
</div>

	<!-- <a href="cadastrarAdministradorServlet">Cadastrar</a>	 --> 
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
		
</body>
</html>