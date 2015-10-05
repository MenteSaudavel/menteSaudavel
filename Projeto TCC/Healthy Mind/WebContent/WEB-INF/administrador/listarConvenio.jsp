<%@ include file="topAdm.jsp" %>

	<div class="panel panel-primary">
	
		<div class="panel-heading"><span class="glyphicon glyphicon-th-list"></span> <b>Lista de Conv�nios</b> </div>
		
		<table class="table table-bordered">
			<thead>
				<tr class="info">
					<td class="text-center"><b>Nome do Conv�nio</b></td>
					<td class="text-center"><b>Nome do Presidente</b></td>
					<td class="text-center"><b>CNPJ</b></td>
					<td class="text-center"><b>Telefone</b></td>
					<td class="text-center"><b>Endere�o</b></td>
					<td class="text-center"><b>CEP</b></td>
					<td class="text-center"><b>Cidade</b>
					<td class="text-center"><b>UF</b>
					<td class="text-center"><b>Editar</b></td>
				</tr>
			</thead>
			
			<tbody>
				<c:if test="${empty listaConvenio }">
					<tr>
						<td colspan="10" class="alert alert-warning"> No momento n�o h� nenhum conv�nio cadastrado. </td>
					</tr>
				</c:if>
				
				<c:forEach var="convenio" items="${listaConvenio}">
					<tr>
						<td class="text-center">${convenio.nome }</td>
						<td class="text-center">${convenio.presidente }</td>
						<td class="text-center">${convenio.cnpj }</td>
						<td class="text-center">${convenio.telefoneConvenio }</td>
						<td class="text-center">${convenio.enderecoConvenio }</td>
						<td class="text-center">${convenio.cep }</td>
						<td class="text-center">${convenio.cidadeConvenio }</td>
						<td class="text-center">${convenio.uf.nome }</td>
						<td class="text-center"> 
							<a href="editarConvenioServlet?id=${convenio.id }" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-edit"></span></a> 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<form method="get" action="menuAdministradorServlet" class="form-group">
		<div class="form-group">
			<div class="col-sm-7 control-label"> <button type="submit" class="btn btn-primary">  <span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> Voltar </button> </div>
		</div>
	</form>	
	
	<br>
	<br>
	 <c:if test="${apagado == true }">
	 	<div class="alert alert-success alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-thumbs-up"></span>
	 		Conv�nio apagado com sucesso!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>
	 <c:if test="${apagado == false }">
	 	<div class="alert alert-danger alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-alert"></span>
	 		Erro ao apagar conv�nio, tente novamente.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>
	 <c:if test="${editado == true }">
	 	<div class="alert alert-success alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-thumbs-up"></span>
	 		Conv�nio editado com sucesso!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>
	 <c:if test="${editado == false }">
	 	<div class="alert alert-danger alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-alert"></span>
	 		Erro ao editar conv�nio, certifique-se de que tudo foi digitado corretamente e tente de novo.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>

<jsp:include page="footerAdm.jsp"></jsp:include>