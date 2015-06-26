<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Paciente</title>
</head>
<body>

	<ul>
		<li> <a href="inicioServlet"> Inicio </a> </li>
		<li><a href="cadastrarPacienteServlet"> Cadastrar Paciente </a></li>
		<li><a href="cadastrarPsicologoServlet"> Cadastrar Psic�logo </a></li>
		<li> <a href="agendarConsultaServlet"> Agendar Consulta </a> </li>
		<li> <a href="pesquisarPsicologoServlet"> Pesquisar Psic�logo </a> </li>
		<li> <a href="pesquisarPacienteServlet"> Pesquisar Paciente </a> </li>
	</ul>

	<div>
		<form method="post" action="editarPacienteServlet">
			<table>
				<tr> 
					<td>Preencha as informa��es do paciente</td> 
				</tr>
				
				<tr>
					<td> <input type="hidden" name="id" value="${paciente.id }"> </td>
				</tr>
				
				<tr>
					<td> Nome do paciente </td> <td> <input type="text" name="nome" required value="${paciente.nome }"> </td>
				</tr>
				
				<tr>
					<td> Telefone </td> <td> <input type="text" name="telefone" required value="${paciente.telefone }"> </td>
				</tr>
				
				<tr>
					<td> CPF </td> <td> <input type="text" name="cpf" required value="${paciente.cpf }"> </td>
				</tr>
				
				<tr>
					<td> Conv�nio </td> 
					
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
					<td> N�mero da carteirinha do conv�nio </td> <td> <input type="text" name="numeroCarteirinha" required value="${paciente.numeroCarteirinha }"> </td>
				</tr>
				
				<tr>
					<td> <input type="submit" value="Editar"> </td>
				</tr>
				
			</table>
		</form>
		
		<c:if test="${cadastrado == true }"> Paciente cadastrado com sucesso! </c:if>
		
	</div>

</body>
</html>