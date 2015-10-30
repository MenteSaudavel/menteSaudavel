<%@ include file="topAdm.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-7">
			<form method="post" action="cadastrarPsicologoServlet">
		
					<div class="form-group">
						<label class="control-label">Nome do Psic�logo</label>
						<div class="form-group has-error">
							<input type="text" name="nome" required class="form-control" data-toggle="tooltip" data-placement="right" title="Nome completo do psic�logo">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label">Telefone do Consult�rio</label>
						<div class="form-group has-error">
							<input type="text" name="telefoneConsultorio" required class="form-control" data-toggle="tooltip" data-placement="right" title="O telefone deve ser preenchido no formato: (00) 0000-0000">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label">Conv�nios que atende</label>
						<div class="form-group has-error">
							<select name="idConvenio" required class="form-control" data-toggle="tooltip" data-placement="right" title="Selecione somente os conv�nios que o psic�logo atende, se sobrar espa�o n�o selecionar nada">
								<option></option>
									<c:forEach var="convenio" items="${lista}">	
											<option value="${convenio.id }">${convenio.nome }</option>
									</c:forEach>	
							</select>
						</div>
							<br>				
							<div class="collapse" id="collapseExample">
							  <div class="form-group">
							  
									<select name="idConvenio2" class="form-control" data-toggle="tooltip" data-placement="right" title="Selecione somente os conv�nios que o psic�logo atende, se sobrar espa�o n�o selecionar nada">
										<option></option>
											<c:forEach var="convenio" items="${lista}">	
												<option value="${convenio.id }">${convenio.nome }</option>
											</c:forEach>	
									</select>
									<br>
									<select name="idConvenio3" class="form-control" data-toggle="tooltip" data-placement="right" title="Selecione somente os conv�nios que o psic�logo atende, se sobrar espa�o n�o selecionar nada">
										<option></option>
											<c:forEach var="convenio" items="${lista}">	
												<option value="${convenio.id }">${convenio.nome }</option>
											</c:forEach>	
									</select>
									<br>
									<select name="idConvenio4" class="form-control" data-toggle="tooltip" data-placement="right" title="Selecione somente os conv�nios que o psic�logo atende, se sobrar espa�o n�o selecionar nada">
										<option></option>
											<c:forEach var="convenio" items="${lista}">	
												<option value="${convenio.id }">${convenio.nome }</option>
											</c:forEach>	
									</select>
									<br>
									<select name="idConvenio5" class="form-control" data-toggle="tooltip" data-placement="right" title="Selecione somente os conv�nios que o psic�logo atende, se sobrar espa�o n�o selecionar nada">
										<option></option>
											<c:forEach var="convenio" items="${lista}">	
												<option value="${convenio.id }">${convenio.nome }</option>
												
											</c:forEach>	
									</select>  
							  </div>
							</div>
							
							<button class="btn btn-info" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">Escolher mais conv�nios <span class="glyphicon glyphicon-plus-sign"></span> </button>
							
					  </div>
					<div class="form-group">
						<label class="control-label">N�mero do CRP</label>
						<div class="form-group has-error">
							<input type="text" name="crp" required class="form-control" data-toggle="tooltip" data-placement="right" title="N�mero do CRP do psic�logo">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label">Confirmar n�mero do CRP</label>
						<div class="form-group has-error">
							<input type="text" name="confCrp" required class="form-control" data-toggle="tooltip" data-placement="right" title="Confirme o n�mero do CRP">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label">Regi�o do CRP</label>
						<div class="form-group has-error">
							<select name="idUf" class="form-control" data-toggle="tooltip" data-placement="right" title="Selecione a regi�o na qual o psic�logo atua">
								<option></option>
									<c:forEach var="uf" items="${listaUf}">	
										<option value="${uf.id }">${uf.sigla }</option>			
									</c:forEach>	
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label">E-mail</label>
						<div class="form-group has-error">
							<input type="email" name="email" required class="form-control" data-toggle="tooltip" data-placement="right" title="Email do psic�logo que ser� utilizado para acessar o sistema">
						</div>
					</div>
					
					<div class="form-group">
						<div class="control-label pull-right"> <button type="reset" class="btn btn-danger" data-toggle="tooltip" data-placement="bottom" title="Este bot�o limpa o valor cadastrado em todos os campos"> Limpar <span class="glyphicon glyphicon-erase" aria-hidden="true"></span> </button>
							<button type="submit" class="btn btn-success" class="btn btn-success" data-toggle="tooltip" data-placement="bottom" title="Todos os campos em vermelho s�o obrigat�rios, certifique-se de preench�-los"> Cadastrar <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span> </button> 
						</div>
					</div>
		
			</form>
		</div>
	</div>
</div>
	
	<div>
		
	</div>
	
	<form method="get" action="menuAdministradorServlet">
			<div class="form-group">
				<div class="col-sm-7 control-label"> <button type="submit" class="btn btn-primary">  <span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> Voltar </button> </div>
			</div>
	</form>
	<br>
	<br>
	<c:if test="${cadastrado == true }">
		<div class="alert alert-success alert-dismissible">
			<span class="glyphicon glyphicon-thumbs-up"></span>
			Psic�logo cadastrado com sucesso!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div>
	</c:if>
	<c:if test="${cadastrado == false }">
		<div class="alert alert-danger alert-dismissible">
			<span class="glyphicon glyphicon-alert"></span>
			Erro ao cadastrar psic�logo, certifique-se de que tudo foi digitado corretamente e tente de novo.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div>
	</c:if>
	
	
<jsp:include page="footerAdm.jsp"></jsp:include>