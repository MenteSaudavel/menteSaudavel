<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

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
			<a class="navbar-brand" href="inicioServlet">Mente Saudável</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">


			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	
	<div class="container">
			
		<div class="col-md-4">
	      <form class="form-signin" action="loginServlet" method="post">
	      	
	        <h2 class="form-signin-heading"><img alt="Mente Saudável" src="img/bitmap3.png"></h2>
	        <label for="inputEmail" class="sr-only"></label>
	        <input type="email" id="inputEmail" class="form-control" placeholder="Endereço de e-mail" name="email" required autofocus>
	        <label for="inputPassword" class="sr-only"></label>
	        <br>
	        <input type="password" id="inputPassword" class="form-control" placeholder="Senha" name="senha" required>
	        <br>
	        <button class="btn btn-lg btn-success btn-block" type="submit">Entrar</button>
	        
	      </form>
		</div>
	</div>
	
	<br>
	<c:if test="${logado == false }"><div class="alert alert-danger" role="alert">Usuário não encontrado.</div></c:if>
	
</body>
</html>