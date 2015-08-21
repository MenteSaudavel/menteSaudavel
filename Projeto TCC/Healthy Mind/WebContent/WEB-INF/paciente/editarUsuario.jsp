<%@ include file="topPaciente.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-7">	
			<form action="editarUsuarioServlet" method="post">
			
				<div class="form-group">
					<label class="control-label" for="email">Email</label>
					
					<input type="text" id="email" name="email" required class="form-control" value="${usuario.email }">
				</div>
				
				<div class="form-group">
					<label class="control-label" for="senhaAtual">Digite a senha atual</label>
					
					<input type="password" id="senhaAtual" name="senhaAtual" required class="form-control">
				</div>
				
				<div class="form-group">
					<label class="control-label" for="senha">Digite a nova senha</label>
					
					<input type="password" id="senha" name="senha" required class="form-control">
				</div>				
				
				<div class="form-group">
					<label class="control-label" for="confirmarSenha">Confirme a nova senha</label>
					
					<input type="password" id="confirmarSenha" name="confirmarSenha" required class="form-control">
				</div>				
				
				<div class="form-group">
					<div class="control-label pull-right">
						<a class="btn btn-danger" href="menuAdministradorServlet">
							Cancelar <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span>
						</a>
						<button type="submit" class="btn btn-success">Salvar <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span> </button>
					</div>
				</div>
				
			</form>
		</div>
	</div>
</div>

	<form method="get" action="menuAdministradorServlet">
		<div class="form-group">
			<div class="col-sm-7 control-label"> <button type="submit" class="btn btn-primary">  <span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> Voltar </button> </div>
		</div>
	</form>

<jsp:include page="footerPaciente.jsp"></jsp:include>