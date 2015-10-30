<%@ include file="topAdm.jsp" %>
	
	<style>
	 .hoverOpcao:hover{
		color: #127a9c;
	}
	</style>
	
	<div class="bs-example">
	    <ul class="nav nav-tabs">
	        <li class="active"><a data-toggle="tab" href="#listarPsicologo" class="btn btn-info hoverOpcao">Lista de Psicólogos</a></li>
	        <li><a data-toggle="tab" href="#pesquisarPsicologo" class="btn btn-info hoverOpcao">Pesquisar Psicólogo</a></li>
	    </ul>
	    
	    <div class="tab-content">
	        <div id="listarPsicologo" class="tab-pane fade in active">
	        	<br>
	        	<div class="container-fluid">
			    <div class="panel panel-primary">
				  <!-- Default panel contents -->
				  <div class="panel-heading">
				  	<span class="glyphicon glyphicon-th-list"></span> <b>Lista de Psicólogos</b>
				  	<span class="pull-right"> <a href="listarPsicologoServlet" class="btn btn-warning btn-sm"> <span class="glyphicon glyphicon-refresh"></span></a> </span>
				  </div>
				
				  <!-- Table -->
				  <table class="table table-hover table-condensed">
				 	<thead>
				    	<tr class="info">
							<td class="text-center"> <b> Nome do Psicólogo </b></td>
							<td class="text-center"> <b> Telefone do Consultório </b></td>
							<td class="text-center"> <b> Convênios </b></td>
							<td class="text-center"> <b> Número do CRP </b></td>
							<td class="text-center"> <b> Região do CRP </b></td>
							<td class="text-center"> <b> Editar </b></td>
							<td class="text-center"> <b> Ver Perfil </b></td>
						</tr>
					</thead>
						<c:if test="${empty listaPsicologo }">
							<tr>
								<td colspan="7" class="alert alert-warning"> Psicólogo Não Encontrado! </td>
							</tr>
						</c:if>
					<tbody>
						<c:forEach var="psicologo" items="${listaPsicologo}">
							<tr>
							 <td class="text-center"> ${psicologo.nome } </td>
							 <td class="text-center"> ${psicologo.telefoneConsultorio } </td>
							 <td class="text-center"> ${psicologo.convenio.nome } </td>
							 <td class="text-center"> ${psicologo.crp } </td>
							 <td class="text-center"> ${psicologo.uf.sigla } </td>
							 <td class="text-center">
							 	<a href="editarPsicologoServlet?id=${psicologo.id }" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-edit"></span></a> 
							 </td>
							 <td class="text-center">
							 	<c:if test="${psicologo.usuario.id != '0' }">
							 		<a href="listarUsuarioPsicologoServlet?id=${psicologo.id }" class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-eye-open"></span></a>
							 	</c:if>
							 	<c:if test="${psicologo.usuario.id == '0' }">
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
	        
	       	<div id="pesquisarPsicologo" class="tab-pane fade">
	       		<br>
	       	<div class="container-fluid">
			    <div class="row">
				  <div class="col-md-6">
				  	<form method="post" action="pesquisarPsicologoServlet">
					<div class="input-group">
				      <input type="text" class="form-control" placeholder="Nome do Psicólogo" name="nomePesquisaPsicologo" required>
				      <span class="input-group-btn">
				        <button class="btn btn-info" type="submit">Pesquisar <span class="glyphicon glyphicon-search"></span></button>
				      </span>
				    </div><!-- /input-group -->
				    </form>
				  </div><!-- /.col-md-4 -->
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
	 <form method="get" action="menuAdministradorServlet" class="form-group">
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