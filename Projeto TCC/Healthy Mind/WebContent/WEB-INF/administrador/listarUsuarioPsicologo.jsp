<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


	<c:forEach var="psi" items="${listaUsuario}">
	<input type="hidden" value="${psi.usuario.tipoPerfil }" name="tipoPerfil">
		<div class="modal-content">
			<div class="modal-header">
		        <h4 class="modal-title"><span class="glyphicon glyphicon-th-list"></span> <b>Informações sobre a conta de usuário</b></h4>
		    </div>
		    
		    <div class="modal-body">
		        
			  <!-- Table -->
			  <table class="table table-condensed table-bordered">
			    	<tr class="info">
						<td class="text-center"> <b> Email </b></td>
						<td class="text-center"> <b> Tipo do Perfil</b></td>
						<td class="text-center"> <b> Status do Perfil </b></td>
						<td class="text-center"> <b> Inativar </b></td>
						<td class="text-center"> <b> Ativar </b></td>
					</tr>
					
					<c:if test="${empty listaUsuario }">
						<tr>
							<td colspan="5" class="alert alert-warning"> Usuário não encontrado. </td>
						</tr>
					</c:if>
					
					<tr >
						 <td class="text-center"> ${psi.usuario.email } </td>
						 <td class="text-center"> <c:if test="${psi.usuario.tipoPerfil == 'administrador' }">Administrador</c:if> <c:if test="${psi.usuario.tipoPerfil == 'psiiente' }">psiiente</c:if> <c:if test="${psi.usuario.tipoPerfil == 'psicologo' }">Psicólogo</c:if> </td>
						 <td class="text-center"> <c:choose> <c:when test="${psi.usuario.statusPerfil == false}"><label class="alert-success">Ativo</label></c:when> <c:when test="${psi.usuario.statusPerfil == true}"><label class="alert-danger">Inativo</label></c:when> </c:choose> </td>
						 <td class="text-center">
						 	<a href="inativarUsuarioServlet?id=${psi.usuario.id }" class="btn btn-warning btn-sm" id="inativar"><span class="glyphicon glyphicon-ban-circle"></span></a> 
						 </td>
						 <td class="text-center">
						 	<a href="ativarUsuarioServlet?id=${psi.usuario.id }" class="btn btn-success btn-sm" id="ativar"><span class="glyphicon glyphicon-ok-circle"></span></a>
						 </td>
					</tr>
						
					
			  </table>		        
		      
		    </div>
		    
		    <div class="modal-footer">
		    	<c:if test="${psi.usuario.tipoPerfil == 'administrador' }"><a href="listarAdministradorServlet" class="btn btn-info">Ok</a></c:if>
		    	<c:if test="${psi.usuario.tipoPerfil == 'psiiente' }"><a href="listarpsiienteServlet" class="btn btn-info">Ok</a></c:if>
		    	<c:if test="${psi.usuario.tipoPerfil == 'psicologo' }"><a href="listarPsicologoServlet" class="btn btn-info">Ok</a></c:if>
		    </div>
		</div><!-- /.modal-content -->
</c:forEach>
	