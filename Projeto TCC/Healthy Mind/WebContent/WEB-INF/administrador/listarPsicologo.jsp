<%@ include file="topAdm.jsp" %>

	<div class="bs-example">
	    <ul class="nav nav-tabs">
	        <li class="active"><a data-toggle="tab" href="#listarPsicologo" class="btn btn-info">Lista de Psicólogos</a></li>
	        <li><a data-toggle="tab" href="#pesquisarPsicologo" class="btn btn-info">Pesquisar Psicólogo</a></li>
	    </ul>
	    
	    <div class="tab-content">
	        <div id="listarPsicologo" class="tab-pane fade in active">
	        	<br>
			    <div class="panel panel-primary">
				  <!-- Default panel contents -->
				  <div class="panel-heading">
				  	<span class="glyphicon glyphicon-th-list"></span> <b>Lista de Psicólogos</b>
				  	<span class="pull-right"> <a href="listarPsicologoServlet" class="btn btn-warning btn-sm"> <span class="glyphicon glyphicon-refresh"></span></a> </span>
				  </div>
				
				  <!-- Table -->
				  <table class="table table-bordered">
				    	<tr class="info">
							<td class="text-center"> <b> Nome do Psicólogo </b></td>
							<td class="text-center"> <b> Telefone do Consultório </b></td>
							<td class="text-center"> <b> Convênio </b></td>
							<td class="text-center"> <b> Número do CRP </b></td>
							<td class="text-center"> <b> Editar </b></td>
							<td class="text-center"> <b> Ver Perfil </b></td>
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
							 	<a href="visualizarPerfilUsuarioServlet?email=${psicologo.email }" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-eye-open"></span></a>
							 </td>
							</tr>
						</c:forEach>
				  </table>
				</div>
	        </div>
	        
	       	<div id="pesquisarPsicologo" class="tab-pane fade">
	       		<br>
			    <div class="row">
				  <div class="col-lg-4">
				  	<form method="post" action="pesquisarPsicologoServlet">
					<div class="input-group">
				      <input type="text" class="form-control" placeholder="Nome do Psicólogo" name="nomePesquisaPsicologo" required>
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
	 
	 <form method="get" action="menuPacienteServlet" class="form-group">
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