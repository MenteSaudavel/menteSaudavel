<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pesquisar Psicólogo</title>
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
	
		<div>
		
			<form method="post" action="pesquisarPsicologoServlet">
			
				<table>
					<tr>
						<td> Nome do Psicólogo: </td> <td> <input type="text" name="nomePesquisaPsicologo" required> </td> <td> <input type="submit" value="Pesquisar"> </td>
					</tr>
				</table>
			</form>
			
		</div>
		${msg}
	
</body>
</html>