<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Paciente</title>
</head>
<body>

	<ul>
		<li> <a href="inicioServlet"> Inicio </a> </li>
		<li><a href="cadastrarPacienteServlet"> Cadastrar Paciente </a></li>
		<li><a href="cadastrarPsicologoServlet"> Cadastrar Psicólogo </a></li>
		<li> <a href="agendarConsultaServlet"> Agendar Consulta </a> </li>
		<li> <a href="pesquisarPsicologoServlet"> Pesquisar Psicólogo </a> </li>
		<li> <a href="pesquisarPacienteServlet"> Pesquisar Paciente </a> </li>
	</ul>

	<div>
		<form method="post" action="cadastrarPacienteServlet">
			<table>
				<tr> 
					<td>Preencha as informações do paciente</td> 
				</tr>
				
				<tr>
					<td> Nome do paciente </td> <td> <input type="text" name="nome" required> </td>
				</tr>
				
				<tr>
					<td> Telefone </td> <td> <input type="text" name="telefone" required> </td>
				</tr>
				
				<tr>
					<td> CPF </td> <td> <input type="text" name="cpf" required> </td>
				</tr>
				
				<tr>
					<td> Convênio </td>
					
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
					<td> Número da carteirinha do convênio </td> <td> <input type="text" name="numeroCarteirinha" required> </td>
				</tr>
				
				<tr>
					<td> <input type="submit" value="Cadastrar"> </td>
				</tr>
				
			</table>
		</form>
		
		<c:if test="${cadastrado == true }"> Paciente cadastrado com sucesso! </c:if>
		
	</div>

</body>
</html>