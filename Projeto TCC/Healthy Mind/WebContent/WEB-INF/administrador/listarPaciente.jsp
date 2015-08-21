<%@ include file="topAdm.jsp" %>
	
	<div class="panel panel-primary">
  		<!-- Default panel contents -->
  		<div class="panel-heading"> <span class="glyphicon glyphicon-th-list"></span> <b>Lista de Pacientes</b> </div>


  		<!-- Table -->
  		<table class="table table-bordered">
  			<thead>
		   		<tr class="info">
					<td class="text-center"> <b> Nome do Paciente </b></td>
					<td class="text-center"><b> Telefone</b></td>
					<td class="text-center"><b> Número da Carteirinha</b></td>
					<td class="text-center"> <b>Cpf </b></td>
					<td class="text-center"> <b>Convênio</b></td>
					<td class="text-center"><b> Editar</b></td>
					<td class="text-center"><b> Apagar </b></td>
				</tr>
			</thead>
			
			<tbody>
				<c:if test="${empty listaPaciente }">
					<tr>
						<td colspan="7" class="alert alert-warning"> Paciente Não Encontrado! </td>
					</tr>
				</c:if>
						
				<c:forEach var="paciente" items="${listaPaciente}">
					<tr>
						<td class="text-center"> ${paciente.nome } </td>
						<td class="text-center"> ${paciente.telefone } </td>
						<td class="text-center"> ${paciente.numeroCarteirinha } </td>
						<td class="text-center"> ${paciente.cpf } </td>
						<td class="text-center"> ${paciente.convenio.nome }</td>
						<td class="text-center">
							<a href="editarPacienteServlet?id=${paciente.id }" class="btn btn-info btn-sm">
							<span class="glyphicon glyphicon-edit"></span>
							</a>
						</td>
						<td class="text-center"> <a href="apagarPacienteServlet?id=${paciente.id }" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>	
  		</table>
	</div>
	
	<form method="get" action="pesquisarPacienteServlet">
		<div class="form-group">
			<div class="col-sm-7 control-label"> <button type="submit" class="btn btn-primary">  <span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> Voltar </button> </div>
		</div>
	</form>
	<br>
	<br>
	 <c:if test="${apagado == true }">
	 	<div class="alert alert-success alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-thumbs-up"></span>
	 		Paciente apagado com sucesso!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>
	 <c:if test="${apagado == false }">
	 	<div class="alert alert-danger alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-alert"></span>
	 		Erro ao apagar paciente, tente novamente!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>
	 <c:if test="${editado == true }">
	 	<div class="alert alert-success alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-thumbs-up"></span>
	 		Paciente editado com sucesso!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>
	 <c:if test="${editado == false }">
	 	<div class="alert alert-danger alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-alert"></span>
	 		Erro ao editar paciente, certifique-se de que tudo foi digitado corretamente e tente de novo.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>
	

	
<jsp:include page="footerAdm.jsp"></jsp:include>