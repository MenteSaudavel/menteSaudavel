<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


	<c:forEach var="u" items="${listaUsuario}">
	<input type="hidden" value="${u.tipoPerfil }" name="tipoPerfil">
		<div class="modal-content">
			<div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title"><span class="glyphicon glyphicon-th-list"></span> <b>Informações sobre a conta de usuário</b></h4>
		    </div>
		    
		    <div class="modal-body">
		        
			  <!-- Table -->
			  <table class="table table-bordered">
			    	<tr class="info">
						<td class="text-center"> <b> Email </b></td>
						<td class="text-center"> <b> Tipo do Perfil</b></td>
						<td class="text-center"> <b> Status do Perfil </b></td>
						<td class="text-center"> <b> Inativar </b></td>
						<td class="text-center"> <b> Ativar </b></td>
					</tr>
					<tr >
						 <td class="text-center"> ${u.email } </td>
						 <td class="text-center"> <c:if test="${u.tipoPerfil == 'administrador' }">Administrador</c:if> <c:if test="${u.tipoPerfil == 'paciente' }">Paciente</c:if> <c:if test="${u.tipoPerfil == 'psicologo' }">Psicólogo</c:if> </td>
						 <td class="text-center"> <c:choose> <c:when test="${u.statusPerfil == false}">Ativo</c:when> <c:when test="${u.statusPerfil == true}">Inativo</c:when> </c:choose> </td>
						 <td class="text-center">
						 	<a href="inativarUsuarioServlet?id=${u.id }" class="btn btn-warning btn-sm" id="inativar"><span class="glyphicon glyphicon-ban-circle"></span></a> 
						 </td>
						 <td class="text-center">
						 	<a href="ativarUsuarioServlet?id=${u.id }" class="btn btn-success btn-sm" id="ativar"><span class="glyphicon glyphicon-ok-circle"></span></a>
						 </td>
					</tr>
						
					
			  </table>		        
		      
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
		      
		    </div>
		    
		    <div class="modal-footer">
		    	<c:if test="${u.tipoPerfil == 'administrador' }"><a href="listarAdministradorServlet" class="btn btn-info">Ok</a></c:if>
		    	<c:if test="${u.tipoPerfil == 'paciente' }"><a href="listarPacienteServlet" class="btn btn-info">Ok</a></c:if>
		    	<c:if test="${u.tipoPerfil == 'psicologo' }"><a href="listarPsicologoServlet" class="btn btn-info">Ok</a></c:if>
		    </div>
		</div><!-- /.modal-content -->
</c:forEach>
	