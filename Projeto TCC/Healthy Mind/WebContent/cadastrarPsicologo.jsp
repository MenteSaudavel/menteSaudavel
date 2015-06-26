<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Insert title here</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="alert alert-danger" role="alert">
  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  <span class="sr-only">Error:</span>
  Enter a valid email address
</div>

	<ul class="navbar navbar-default" role="navbar">
		<li><a href="inicioServlet"> Inicio </a></li>
		<li><a href="cadastrarPacienteServlet"> Cadastrar Paciente </a></li>
		<li><a href="cadastrarPsicologoServlet"> Cadastrar Psicólogo</a></li>
		<li><a href="agendarConsultaServlet"> Agendar Consulta </a></li>
		<li> <a href="pesquisarPsicologoServlet"> Pesquisar Psicólogo </a> </li>
		<li> <a href="pesquisarPacienteServlet"> Pesquisar Paciente </a> </li>
	</ul>

	<form method="post" action="cadastrarPsicologoServlet">

		<table>

			<tr>
				<td>Nome do Psicólogo</td>
				<td><input type="text" name="nome" required></td>
			</tr>

			<tr>
				<td>Telefone do Consultório</td>
				<td><input type="text" name="telefoneConsultorio" required>
				</td>
			</tr>
		
			<tr>
				<td>Convênio</td>
				
				<td>
				<select name="idConvenio">
					<c:forEach var="convenio" items="${lista}">	
								
							<option></option>
							<option value="${convenio.id }">${convenio.nome }</option>
								
					</c:forEach>	
					</select>	
				</td>
					
			</tr>
			
			<tr>
				<td>Número do CRP</td>
				<td><input type="text" name="crp" required></td>
			</tr>

			<tr>
				<td><input type="submit" value="Cadastrar" required></td>
			</tr>

		</table>

	</form>

	<c:if test="${cadastrado == true }"> Psicólogo cadastrado com sucesso! </c:if>

</body>
</html>