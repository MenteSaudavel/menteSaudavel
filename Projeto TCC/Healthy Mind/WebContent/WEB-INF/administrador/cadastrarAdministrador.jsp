<%@ include file="topAdm.jsp" %>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-7">
				<form method="post" action="cadastrarAdministradorServlet">

					<div class="form-group">
						<label class="control-label"> Nome do administrador </label>
						<div class="form-group has-error">
							<input type="text" name="nome" maxlength="50" required class="form-control"  data-toggle="tooltip" data-placement="right" title="Nome completo do administrador">
						</div>
					</div>
				
					<div class="form-group">
						<label class="control-label"> Telefone </label>
						<div class="form-group has-error">
							<input type="text" name="telefone" maxlength="20" required class="form-control" data-toggle="tooltip" data-placement="right" title="Se o administrador não tiver telefone, preencher em escrio (Não possui). O telefone deve ser preenchido no formato: (00) 0000-0000">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label"> Função </label>
						<div class="form-group has-error">
							<input type="text" name="funcao" maxlength="50" required class="form-control" data-toggle="tooltip" data-placement="right" title="Função que o administrador exerce na instituição">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label"> E-mail </label>
						<div class="form-group has-error">
							<input type="email" name="email" maxlength="50" required class="form-control" data-toggle="tooltip" data-placement="right" title="Email do administrador que será utilizado para acessar o sistema">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label"> Senha </label>
						<div class="form-group has-error">
							<input type="password" name="senha" required class="form-control" data-toggle="tooltip" data-placement="right" title="Para maior segurança, escolha uma senha que 
							contenha no mínimo 8(oito) caracteres">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label"> Confirmar Senha </label>
						<div class="form-group has-error">
							<input type="password" name="confirmarSenha" required class="form-control" data-toggle="tooltip" data-placement="right" title="Confirme a senha">
						</div>
					</div>
										
					<div class="form-group">
						<div class="control-label pull-right">
							<button type="reset" class="btn btn-danger" data-toggle="tooltip" data-placement="bottom" title="Este botão limpa o valor cadastrado em todos os campos">
								Limpar <span class="glyphicon glyphicon-erase"
									aria-hidden="true"></span>
							</button>
							<button type="submit" class="btn btn-success" data-toggle="tooltip" data-placement="bottom" title="Todos os campos em vermelho são obrigatórios, certifique-se de preenchê-los">
								Cadastrar <span class="glyphicon glyphicon-ok-sign"
									aria-hidden="true"></span>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<form method="get" action="menuAdministradorServlet">
		<div class="form-group">
			<div class="col-sm-7 control-label">
				<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-circle-arrow-left"
						aria-hidden="true"></span> Voltar
				</button>
			</div>
		</div>
	</form>

	<br>
	<br>
	<c:if test="${cadastrado == true }">
		<div class="alert alert-success alert-dismissible" role="alert">
			<span class="glyphicon glyphicon-thumbs-up"></span>
			Administrador cadastrado com sucesso!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div>
	</c:if>
	<c:if test="${cadastrado == false }">
		<div class="alert alert-danger alert-dismissible" role="alert">
			<span class="glyphicon glyphicon-alert"></span>
			Erro ao cadastrar administrador, certifique-se de que tudo foi digitado corretamente e tente de novo.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div>
	</c:if>
	
<jsp:include page="footerAdm.jsp"></jsp:include>