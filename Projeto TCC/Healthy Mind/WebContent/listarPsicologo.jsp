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
		<li> <a href="cadastrarPsicologoServlet"> Cadastrar Psic�logo </a> </li>
		<li> <a href="agendarConsultaServlet"> Agendar Consulta </a> </li>
		<li> <a href="pesquisarPsicologoServlet"> Pesquisar Psic�logo </a> </li>
		<li> <a href="pesquisarPacienteServlet"> Pesquisar Paciente </a> </li>
	</ul>
	
			<table>
				<tr>
					<td> Nome do Psic�logo </td>
					<td> Telefone do Consult�rio </td>
					<td> Conv�nio </td>
					<td> N�mero do CRP </td>
					<td> Editar </td>
					<td> Apagar </td>
				</tr>
				
				<c:if test="${empty listaPsicologo }">
					<tr>
						<td colspan="7"> Psic�logo N�o Encontrado! </td>
					</tr>
				</c:if>
				
				<c:forEach var="psicologo" items="${listaPsicologo}">
					<tr>
					 <td> ${psicologo.nome } </td>
					 <td> ${psicologo.telefoneConsultorio } </td>
					 <td> ${psicologo.idConvenio } </td>
					 <td> ${psicologo.crp } </td>
					 <td> <a href="editarPsicologoServlet?id=${psicologo.id }"> Editar </a> </td>
					 <td> <a href="apagarPsicologoServlet?id=${psicologo.id }"> Apagar </a> </td>
					</tr>
				</c:forEach>
			</table>
	${msg}
</body>
</html>