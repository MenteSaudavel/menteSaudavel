<%@ include file="topAdm.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-7">
			<form action="cadastrarConvenioServlet" method="post">
			
				<div class="form-group">
					<label class="control-label">Nome do Convênio</label>
					<div class="form-group has-error">
						<input type="text" name="nome" maxlength="30" required class="form-control" data-toggle="tooltip" data-placement="right" title="Nome comercial do convênio">
					</div>
				</div>
			
				<div class="form-group">
					<label class="control-label">Nome do Presidente</label>
					<div class="form-group has-error">
						<input type="text" name="presidente" maxlength="30" required class="form-control" data-toggle="tooltip" data-placement="right" title="Nome do presidente do convênio">
					</div>
				</div>
					
		
				<div class="form-group">
					<label class="control-label">CNPJ</label>
					<div class="form-group has-error">
						<input type="text" name="cnpj" maxlength="18" required class="form-control" data-toggle="tooltip" data-placement="right" title="Número do CPNJ do convênio. Deve ser preenchido no formato: 00.000.000/0000-00">
					</div>
				</div>
					
					
				<div class="form-group">
					<label class="control-label">Telefone</label>
					<div class="form-group has-error">
						<input type="text" name="telefone" maxlength="20" required class="form-control" data-toggle="tooltip" data-placement="right" title="O telefone deve ser preenchido no formato: (00) 0000-0000">
					</div>
				</div>
					
				<div class="form-group">
					<label class="control-label">Endereço</label>
					<div class="form-group has-error">	
						<input type="text" name="endereco" maxlength="50" required class="form-control" data-toggle="tooltip" data-placement="right" title="Endereço da sede do convênio">
					</div>
				</div>
					
					
				<div class="form-group">
					<label class="control-label">CEP</label>
					<div class="form-group has-error">
						<input type="text" name="cep" maxlength="9" required class="form-control" data-toggle="tooltip" data-placement="right" title="CEP da sede do convênio. Deve ser preenchido no formato: 00000-000">
					</div>
				</div>
					
					
				<div class="form-group">
					<label class="control-label">Cidade</label>
					<div class="form-group has-error">
						<input type="text" name="cidade" maxlength="20" required class="form-control" data-toggle="tooltip" data-placement="right" title="Cidade na qual reside a sede do convênio">
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label">UF</label>
					<div class="form-group has-error">
						<select name="idUf" class="form-control">
							<option></option>
							<c:forEach var="uf" items="${listaUf}">
								<option value="${uf.id }">${uf.nome }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				
				<div class="form-group">
					 <div class="control-label pull-right"> 
					 	<button type="reset" class="btn btn-danger" data-toggle="tooltip" data-placement="bottom" title="Este botão limpa o valor cadastrado em todos os campos"> Limpar <span class="glyphicon glyphicon-erase" aria-hidden="true"></span> </button>
					 	<button type="submit" class="btn btn-success" data-toggle="tooltip" data-placement="bottom" title="Todos os campos em vermelho são obrigatórios, certifique-se de preenchê-los"> Cadastrar <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span> </button> 
					 </div>
				</div>
			
			</form>
		</div>
	</div>
</div>
	<form method="get" action="menuAdministradorServlet" class="form-group">
			<div class="form-group">
				<div class="col-sm-7 control-label"> <button type="submit" class="btn btn-primary">  <span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> Voltar </button> </div>
			</div>
	</form>	
	
	<br>
	<br>
	<c:if test="${cadastrado == true }">
		<div class="alert alert-success alert-dismissible" role="alert">
			<span class="glyphicon glyphicon-thumbs-up"></span>
			Convênio cadastrado com sucesso!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div>
	</c:if>
	<c:if test="${cadastrado == false }">
		<div class="alert alert-success alert-dismissible" role="alert">
			<span class="glyphicon glyphicon-alert"></span>
			Erro ao cadastrar convênio!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div>
	</c:if>
	
<jsp:include page="footerAdm.jsp"></jsp:include>