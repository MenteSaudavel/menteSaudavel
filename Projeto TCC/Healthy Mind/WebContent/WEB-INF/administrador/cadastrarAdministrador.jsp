<%@ include file="topAdm.jsp" %>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-7">
				<form method="post" action="cadastrarAdministradorServlet">

					<div class="form-group">
						<label class="control-label"> Nome do administrador </label> <input
							type="text" name="nome" required class="form-control"  data-toggle="tooltip" data-placement="right" title="Nome completo do administrador">
					</div>
				
					<div class="form-group">
						<label class="control-label"> Telefone </label> <input type="text"
							name="telefone" required class="form-control" data-toggle="tooltip" data-placement="right" title="Se o administrador n�o tiver telefone, preencher em escrio (N�o possui)">
					</div>

					<div class="form-group">
						<label class="control-label"> Fun��o </label> <input type="text"
							name="funcao" required class="form-control" data-toggle="tooltip" data-placement="right" title="Fun��o que o administrador exerce na institui��o">
					</div>

					<div class="form-group">
						<label class="control-label"> E-mail </label> <input type="email"
							name="email" required class="form-control" data-toggle="tooltip" data-placement="right" title="Email do administrador que ser� utilizado para acessar o sistema">
					</div>
					
					<div class="form-group">
						<label class="control-label"> Senha </label> <input type="password"
							name="senha" required class="form-control" data-toggle="tooltip" data-placement="right" title="Para sua seguran�a, escolha uma senha que 
							contenha no m�nimo 8(oito) caracteres">
					</div>
					
					<div class="form-group">
						<label class="control-label"> Confirmar Senha </label> <input type="password"
							name="confirmarSenha" required class="form-control" data-toggle="tooltip" data-placement="right" title="Confirme sua senha">
					</div>
										
					<div class="form-group">
						<div class="control-label pull-right">
							<button type="reset" class="btn btn-danger">
								Limpar <span class="glyphicon glyphicon-erase"
									aria-hidden="true"></span>
							</button>
							<button type="submit" class="btn btn-success">
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