<%@ include file="topAdm.jsp" %>
	
<div class="container-fluid">
	<div class="row">
		<div class="col-md-7">
			<form method="post" action="cadastrarPacienteServlet">
	
					<div class="form-group">
						<label class="control-label"> Nome do paciente </label>
						<div class="form-group has-error">
							<input type="text" name="nome" maxlength="100" required class="form-control" data-toggle="tooltip" data-placement="right" title="Nome completo do paciente">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label"> Telefone </label>
						<div class="form-group has-error">
							<input type="text" name="telefone" maxlength="20" required class="form-control" data-toggle="tooltip" data-placement="right" title="Se o paciente não tiver telefone, preencher em escrio (Não possui). O telefone deve ser preenchido no formato: (00) 0000-0000">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label"> CPF </label>
						<div class="form-group has-error">
							<input type="text" name="cpf" maxlength="14" required class="form-control" data-toggle="tooltip" data-placement="right" title="O CPF do paciente deve ser preenchido no formato: 000.000.000-00">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label"> Convênio </label>
							<div class="form-group has-error">
								<select name="idConvenio" class="form-control">
									<option></option>
										<c:forEach var="convenio" items="${lista}">	
											<option value="${convenio.id }">${convenio.nome }</option>
										</c:forEach>	
								</select>
							</div> 	
					</div>
					
					<div class="form-group">
						<label class="control-label"> Número da carteirinha do convênio </label>
						<div class="form-group has-error">
							<input type="text" name="numeroCarteirinha" maxlength="20" required class="form-control" data-toggle="tooltip" data-placement="right" title="Número da carteirinha do convênio.">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label">Confirmar número da carteirinha do convênio </label>
						<div class="form-group has-error">
							<input type="text" name="confNumCarteirinha" maxlength="20" required class="form-control" data-toggle="tooltip" data-placement="right" title="Confirmar número da carteirinha do convênio">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label"> E-mail </label>
						<div class="form-group has-error">
							<input type="email" name="email" maxlength="50" required class="form-control" data-toggle="tooltip" data-placement="right" title="Email do paciente que será utilizado para acessar o sistema">
						</div>
					</div>
					
					<div class="form-group">
						<div class="control-label pull-right"> <button type="reset" class="btn btn-danger" data-toggle="tooltip" data-placement="bottom" title="Este botão limpa o valor cadastrado em todos os campos"> Limpar <span class="glyphicon glyphicon-erase" aria-hidden="true"></span> </button>
						 <button type="submit" class="btn btn-success" class="btn btn-success" data-toggle="tooltip" data-placement="bottom" title="Todos os campos em vermelho são obrigatórios, certifique-se de preenchê-los"> Cadastrar <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span> </button> </div>
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
		
		<br>
		<br>
		<c:if test="${cadastrado == true }">
			<div class="alert alert-success alert-dismissible" role="alert">
				<span class="glyphicon glyphicon-thumbs-up"></span>
				Paciente cadastrado com sucesso!
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			</div>
		</c:if>
		<c:if test="${cadastrado == false }">
			<div class="alert alert-danger alert-dismissible" role="alert">
				<span class="glyphicon glyphicon-alert"></span>
				Erro ao cadastrar paciente, certifique-se de que tudo foi digitado corretamente e tente de novo.
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			</div>
		</c:if>
		
<jsp:include page="footerAdm.jsp"></jsp:include>