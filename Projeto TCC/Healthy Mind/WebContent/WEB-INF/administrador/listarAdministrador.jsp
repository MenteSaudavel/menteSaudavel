<%@ include file="topAdm.jsp" %>

		<div class="panel panel-primary">
		  <!-- Default panel contents -->
		  <div class="panel-heading"><span class="glyphicon glyphicon-th-list"></span> <b>Lista de Administradores</b></div>
		
		  <!-- Table -->
		  <table class="table table-bordered">
		    	<tr class="info">
					<td class="text-center"> <b> Nome do Administrador </b></td>
					<td class="text-center"> <b> Telefone</b></td>
					<td class="text-center"> <b> Função </b></td>
					<td class="text-center"> <b> Editar </b></td>
					<td class="text-center"> <b> Apagar </b></td>
				</tr>
				
				<c:if test="${empty listaAdministrador }">
					<tr>
						<td colspan="7" class="alert alert-warning"> A lista de administradores está vazia! </td>
					</tr>
				</c:if>
				
				<c:forEach var="administrador" items="${listaAdministrador}">
					<tr>
					 <td class="text-center"> ${administrador.nome } </td>
					 <td class="text-center"> ${administrador.telefone } </td>
					 <td class="text-center"> ${administrador.funcao} </td>
					 <td class="text-center">
					 	<a href="editarAdministradorServlet?id=${administrador.id }" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-edit"></span></a> 
					 </td>
					 <td class="text-center">
					 	<a href="apagarAdministradorServlet?id=${administrador.id }" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span></a> 
					 </td>
					</tr>
				</c:forEach>
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
	 		Administrador apagado com sucesso!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>
	 <c:if test="${apagado == false }">
	 	<div class="alert alert-danger alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-alert"></span>
	 		Erro ao apagar administrador, tente novamente.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>	 
	 <c:if test="${editado == true }">
	 	<div class="alert alert-success alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-thumbs-up"></span>
	 		Administrador editado com sucesso!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>
	 <c:if test="${editado == false }">
	 	<div class="alert alert-danger" role="alert">
	 		<span class="glyphicon glyphicon-alert"></span>
	 		Erro ao editar administrador, certifique-se de que tudo foi digitado corretamente e tente de novo.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>
	 

<jsp:include page="footerAdm.jsp"></jsp:include>