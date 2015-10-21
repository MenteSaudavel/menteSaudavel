<%@ include file="topAdm.jsp" %>

		<div class="panel panel-primary">
		  <!-- Default panel contents -->
		  <div class="panel-heading"><span class="glyphicon glyphicon-th-list"></span> <b>Lista de Administradores</b></div>
		
		  <!-- Table -->
		  <table class="table table-hover">
		  	<thead>
		    	<tr class="info">
					<td class="text-center"> <b> Nome do Administrador </b></td>
					<td class="text-center"> <b> Telefone</b></td>
					<td class="text-center"> <b> Função </b></td>
					<td class="text-center"> <b> Email </b></td>
					<td class="text-center"> <b> Editar </b></td>
					<td class="text-center"> <b> Ver perfil </b></td>
				</tr>
			</thead>
				<c:if test="${empty listaAdministrador }">
					<tr>
						<td colspan="7" class="alert alert-warning"> A lista de administradores está vazia! </td>
					</tr>
				</c:if>
			<tbody>
				<c:forEach var="administrador" items="${listaAdministrador}">
					<tr class="">
					 <td class="text-center"> ${administrador.nome } </td>
					 <td class="text-center"> ${administrador.telefone } </td>
					 <td class="text-center"> ${administrador.funcao} </td>
					 <td class="text-center"> ${administrador.email} </td>
					 <td class="text-center">
					 	<a href="editarAdministradorServlet?id=${administrador.id }" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-edit"></span></a> 
					 </td>
					 <td class="text-center">
					 	<c:if test="${administrador.usuario.id != '0' }">
					 		<a href="listarUsuarioAdministradorServlet?id=${administrador.id }" class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-eye-open"></span></a>
					 	</c:if>
					 	<c:if test="${administrador.usuario.id == '0' }">
					 		<a class="btn btn-default btn-sm" data-toggle="modal" data-target="#msgUsuarioVazio"><span class="glyphicon glyphicon-eye-close"></span></a>
					 	</c:if> 
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
	
	<!-- Modal -->
	<div class="modal fade bs-example-modal-lg" id="myModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
	
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div>
	
	<div class="modal fade bs-example-modal-lg" id="msgUsuarioVazio">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
		        	<h4 class="modal-title"><span class="glyphicon glyphicon-th-list"></span> <b>Informações sobre a conta de usuário</b></h4>
		    	</div>
		    	<div class="modal-body">
		    		<div class="alert alert-danger" role="alert" align=center>
		    			Este perfil de usuário ainda não acessou o sistema, por isso não é possível ver suas informações.
		    		</div>
		    	</div>
		    	<div class="modal-footer">
		    		<a type="button" data-dismiss="modal" aria-label="Close"><span class="btn btn-info">Ok</span></a>
		    	</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div>
	 <br>
	 <br>
	 <c:if test="${inativado == true }">
	 	<div class="alert alert-success alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-thumbs-up"></span>
	 		Perfil de acesso inativado com sucesso!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>
	 <c:if test="${inativado == false }">
	 	<div class="alert alert-danger" role="alert">
	 		<span class="glyphicon glyphicon-alert"></span>
	 		Erro ao inativar perfil de acesso.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>
	 
	 	 <c:if test="${ativado == true }">
	 	<div class="alert alert-success alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-thumbs-up"></span>
	 		Perfil de acesso ativado com sucesso!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>
	 <c:if test="${ativado == false }">
	 	<div class="alert alert-danger" role="alert">
	 		<span class="glyphicon glyphicon-alert"></span>
	 		Erro ao ativar perfil de acesso.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	 </c:if>
	 
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
	 		Erro ao apagar convênio, tente novamente.
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