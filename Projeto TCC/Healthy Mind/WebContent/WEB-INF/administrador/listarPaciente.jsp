<%@ include file="topAdm.jsp" %>
	
	<style>
	 .hoverOpcao:hover{
		color: #127a9c;
	}
	</style>
	
	<div class="bs-example">
	    <ul class="nav nav-tabs">
	        <li class="active"><a data-toggle="tab" href="#listarPaciente" class="btn btn-info hoverOpcao">Lista de Pacientes</a></li>
	        <li><a data-toggle="tab" href="#pesquisarPaciente" class="btn btn-info hoverOpcao">Pesquisar Paciente</a></li>
	    </ul>
	    <div class="tab-content">
	        <div id="listarPaciente" class="tab-pane fade in active">
	            <br>
	            
	              <div class="container-fluid">
	            	<div class="panel panel-primary">
				  	<!-- Default panel contents -->
				  	<div class="panel-heading"> 
				  		<span class="glyphicon glyphicon-th-list"></span> <b>Lista de Pacientes</b>
				  		<span class="pull-right"> <a href="listarPacienteServlet" class="btn btn-warning btn-sm"> <span class="glyphicon glyphicon-refresh"></span></a> </span>
				  		   
				  	 </div>
				
				
				  		<!-- Table -->
				  		<table class="table table-hover table-condensed">
				  			<thead>
						   		<tr class="info">
									<td class="text-center"> <b> Nome do Paciente </b></td>
									<td class="text-center"><b> Telefone</b></td>
									<td class="text-center"><b> Número da Carteirinha</b></td>
									<td class="text-center"> <b>Cpf </b></td>
									<td class="text-center"> <b>Convênio</b></td>
									<td class="text-center"><b> Editar</b></td>
									<td class="text-center"><b> Ver Perfil </b></td>
								</tr>
							</thead>
							
							<tbody>
								<c:if test="${empty listaPaciente }">
									<tr class="warning">
										<td colspan="7"> Paciente Não Encontrado! </td>
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
										<td class="text-center">
											<c:if test="${paciente.usuario.id != '0' }">
									 			<a href="listarUsuarioPacienteServlet?id=${paciente.id }" class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-eye-open"></span></a>
									 		</c:if>
									 		<c:if test="${paciente.usuario.id == '0' }">
					 							<a class="btn btn-default btn-sm" data-toggle="modal" data-target="#msgUsuarioVazio"><span class="glyphicon glyphicon-eye-close"></span></a>
					 						</c:if>
									 	</td> 
									</tr>
								</c:forEach>
							</tbody>	
				  		</table>
					</div>
	              </div>
	            
	        </div>
	        <div id="pesquisarPaciente" class="tab-pane fade">
	             <br>
	            <div class="container-fluid">
			     <div class="row">
				  <div class="col-md-6">
				   <form method="post" action="pesquisarPacienteServlet">
					<div class="input-group">
					      <input type="text" class="form-control" placeholder="Nome do Paciente" name="nomePesquisaPaciente" required>
					      <span class="input-group-btn">
					        <button class="btn btn-info" type="submit">Pesquisar <span class="glyphicon glyphicon-search"></span></button>
					      </span>
				    </div><!-- /input-group -->
				   </form>
				  </div><!-- /.col-lg-6 -->
				</div><!-- /.row -->
	           </div>
	        </div>
	    </div>
	</div>
	
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
	<form method="get" action="menuAdministradorServlet">
		<div class="form-group">
			<div class="col-sm-7 control-label"> <button type="submit" class="btn btn-primary">  <span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> Voltar </button> </div>
		</div>
	</form>
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