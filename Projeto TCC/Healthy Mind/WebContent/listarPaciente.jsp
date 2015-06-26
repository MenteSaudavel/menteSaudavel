<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<ul>
		<li> <a href="inicioServlet"> Inicio </a> </li>
		<li> <a href="cadastrarPacienteServlet"> Cadastrar Paciente </a> </li>
		<li> <a href="cadastrarPsicologoServlet"> Cadastrar Psicólogo </a> </li>
		<li> <a href="agendarConsultaServlet"> Agendar Consulta </a> </li>
		<li> <a href="pesquisarPsicologoServlet"> Pesquisar Psicólogo </a> </li>
		<li> <a href="pesquisarPacienteServlet"> Pesquisar Paciente </a> </li>
	</ul>
	
	<table>
		<tr>
			<td> Nome do Paciente </td>
			<td> Telefone </td>
			<td> Número da Carteirinha </td>
			<td> Cpf </td>
			<td> Convenio </td>
			<td> Editar </td>
			<td> Apagar </td>
		</tr>
				
		<c:if test="${empty listaPaciente }">
			<tr>
				<td colspan="7"> Paciente Não Encontrado! </td>
			</tr>
		</c:if>
				
		<c:forEach var="paciente" items="${listaPaciente}">
			<tr>
				<td> ${paciente.nome } </td>
				<td> ${paciente.telefone } </td>
				<td> ${paciente.numeroCarteirinha } </td>
				<td> ${paciente.cpf } </td>
				<td> ${paciente.idConvenio } </td>
				<td> <a href="editarPacienteServlet?id=${paciente.id }"> Editar </a> </td>
				<td> <a href="apagarPacienteServlet?id=${paciente.id }"> Apagar </a> </td>
			</tr>
		</c:forEach>
	</table>
	${msg}	

</body>
</html>