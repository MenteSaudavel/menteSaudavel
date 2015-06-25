<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<ul>
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
					<c:forEach var="convenio" items="${lista}">	
						<select name="idConvenio">
								
							<option></option>
							<option value="${convenio.id }">${convenio.nome }</option>
								
						</select>		
					</c:forEach>	
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