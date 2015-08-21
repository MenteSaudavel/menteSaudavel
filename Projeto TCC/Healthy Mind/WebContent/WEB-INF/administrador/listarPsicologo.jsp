<%@ include file="topAdm.jsp" %>

		<div class="panel panel-primary">
		  <!-- Default panel contents -->
		  <div class="panel-heading"><span class="glyphicon glyphicon-th-list"></span> <b>Lista de Psicólogos</b></div>
		
		  <!-- Table -->
		  <table class="table table-bordered">
		    	<tr class="info">
					<td class="text-center"> <b> Nome do Psicólogo </b></td>
					<td class="text-center"> <b> Telefone do Consultório </b></td>
					<td class="text-center"> <b> Convênio </b></td>
					<td class="text-center"> <b> Número do CRP </b></td>
					<td class="text-center"> <b> Editar </b></td>
					<td class="text-center"> <b> Apagar </b></td>
				</tr>
				
				<c:if test="${empty listaPsicologo }">
					<tr>
						<td colspan="7" class="alert alert-warning"> Psicólogo Não Encontrado! </td>
					</tr>
				</c:if>
				
				<c:forEach var="psicologo" items="${listaPsicologo}">
					<tr>
					 <td class="text-center"> ${psicologo.nome } </td>
					 <td class="text-center"> ${psicologo.telefoneConsultorio } </td>
					 <td class="text-center"> ${psicologo.convenio.nome } </td>
					 <td class="text-center"> ${psicologo.crp } </td>
					 <td class="text-center">
					 	<a href="editarPsicologoServlet?id=${psicologo.id }" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-edit"></span></a> 
					 </td>
					 <td class="text-center">
					 	<a href="apagarPsicologoServlet?id=${psicologo.id }" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span></a> 
					 </td>
					</tr>
				</c:forEach>
		  </table>
		</div>
	 
	 <form method="get" action="pesquisarPacienteServlet" class="form-group">
		<div class="form-group">
			<div class="col-sm-7 control-label"> <button type="submit" class="btn btn-primary">  <span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> Voltar </button> </div>
		</div>
	</form>		 
	 
	 <br>
	 <br>
	 <c:if test="${apagado == true }">
	 	<div class="alert alert-success alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-thumbs-up"></span>
	 		Psicólogo apagado com sucesso!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>
	 <c:if test="${apagado == false }">
	 	<div class="alert alert-danger alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-alert"></span>
	 		Erro ao apagar psicólogo!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>	 
	 <c:if test="${editado == true }">
	 	<div class="alert alert-success alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-thumbs-up"></span>
	 		Psicólogo editado com sucesso!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>
	 <c:if test="${editado == false }">
	 	<div class="alert alert-danger alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-alert"></span>
	 		Erro ao editar psicólogo, certifique-se de que tudo foi digitado corretamente e tente de novo.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>
	 

<jsp:include page="footerAdm.jsp"></jsp:include>