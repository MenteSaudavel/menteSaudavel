<%@ include file="topPaciente.jsp" %>

	<style>
   		.oculto{
   			display:none;
   		}
	</style>	

<div class="container-fluid">
	<div class="row">
		<div class="col-md-7">	
			<form action="editarUsuarioServlet" method="post">
				
				<table class="oculto">
					<c:forEach var="paciente" items="${listaPaciente }">
						<input type="hidden" value="${paciente.id}" name="id">
					</c:forEach>
				</table>
				
				<div class="form-group">
					<label class="control-label" for="email">Email</label>
					
					<input type="text" id="email" name="email" required class="form-control" value="${usuario.email }">
				</div>
				
				<div class="form-group">
					<label class="control-label" for="senha">Digite a nova senha</label>
					
					<input type="password" id="senha" name="senhaNova" required class="form-control">
				</div>				
				
				<div class="form-group">
					<label class="control-label" for="confirmarSenha">Confirme a nova senha</label>
					
					<input type="password" id="confirmarSenha" name="confirmarSenha" required class="form-control">
				</div>				
				
				<div class="form-group">
					<div class="control-label pull-right">
						<a class="btn btn-danger" href="menuPacienteServlet">
							Cancelar <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span>
						</a>
						<button type="submit" class="btn btn-success">Salvar <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span> </button>
					</div>
				</div>
				
			</form>
			
			<c:forEach var="paciente" items="${listaPacienteUsuario }">
			  <c:if test="${paciente.usuario.id == 0}">
				<form action="vincularUsuarioServlet" method="post">
					<button class="btn btn-warning" type="submit"><span class="badge"><b>Clique aqui para confirmar seu perfil</b> <span class="glyphicon glyphicon-alert"></span></span></button>
				</form>
			   </c:if>
			</c:forEach>
			
		</div>
	</div>
</div>
	
	<br>
	<c:if test="${vinculado == true }">
		<div class="alert alert-success alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-thumbs-up"></span>
	 		Perfil confirmado com sucesso!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	</c:if>
	
	<c:if test="${vinculado == false }">
		<div class="alert alert-danger alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-alert"></span>
	 		Erro ao confirmar perfil, recarregue a p�gina e tente novamente.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	</c:if>
	
	<c:if test="${editado == true }">
		<div class="alert alert-success alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-thumbs-up"></span>
	 		Perfil editado com sucesso!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	</c:if>
	
	<c:if test="${editado == false }">
		<div class="alert alert-danger alert-dismissible" role="alert">
	 		<span class="glyphicon glyphicon-alert"></span>
	 		Erro ao editar perfil, tente novamente.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	</c:if>
	
	<c:if test="${not empty erroEditar }">
		<div class="alert alert-danger alert-dismissible" role="alert">
		 	<span class="glyphicon glyphicon-alert"></span>
		 	${erroEditar }
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div>
	</c:if>

	<form method="get" action="menuPacienteServlet">
		<div class="form-group">
			<div class="col-sm-7 control-label"> <button type="submit" class="btn btn-primary">  <span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> Voltar </button> </div>
		</div>
	</form>

<jsp:include page="footerPaciente.jsp"></jsp:include>