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
		<li><a href="cadastrarPsicologoServlet"> Cadastrar Psic�logo</a></li>
		<li><a href="agendarConsultaServlet"> Agendar Consulta </a></li>
		<li><a href="pesquisarPsicologoServlet"> Pesquisar Psic�logo </a></li>
		<li><a href="pesquisarPacienteServlet"> Pesquisar Paciente </a></li>
	</ul>

	<form method="post" action="editarPsicologoServlet">

		<table>
			
			<tr>
				<td> <input type="hidden" name="id" value="${psicologo.id }"> </td>
			</tr>
			
			<tr>
				<td>Nome do Psic�logo</td>
				<td><input type="text" name="nome" required value="${psicologo.nome }"></td>
			</tr>

			<tr>
				<td>Telefone do Consult�rio</td>
				<td><input type="text" name="telefoneConsultorio" required value="${psicologo.telefoneConsultorio }">
				</td>
			</tr>

			<tr>
				<td>Conv�nio</td>
				
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
				<td>N�mero do CRP</td>
				<td><input type="text" name="crp" required value="${psicologo.crp }"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Editar"></td>
			</tr>

		</table>

	</form>

	<c:if test="${cadastrado == true }"> Psic�logo editado com sucesso! </c:if>

</body>
</html>