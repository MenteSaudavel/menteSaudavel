<%@ include file="topAdm.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-7">
			<form action="cadastrarConvenioServlet" method="post">
			
				<div class="form-group">
					<label class="control-label">Nome do Convênio</label>
					<input type="text" name="nome" required class="form-control">
				</div>
			
				<div class="form-group">
					<label class="control-label">Nome do Presidente</label>
					<input type="text" name="presidente" required class="form-control">
				</div>
					
		
				<div class="form-group">
					<label class="control-label">CNPJ</label>
					<input type="text" name="cnpj" required class="form-control">
				</div>
					
					
				<div class="form-group">
					<label class="control-label">Telefone</label>	
					<input type="text" name="telefone" required class="form-control">
				</div>
					
				<div class="form-group">
					<label class="control-label">Endereço</label>	
					<input type="text" name="endereco" required class="form-control">
				</div>
					
					
				<div class="form-group">
					<label class="control-label">CEP</label>	
					<input type="text" name="cep" required class="form-control">
				</div>
					
					
				<div class="form-group">
					<label class="control-label">Cidade</label>	
					<input type="text" name="cidade" required class="form-control">
				</div>
					
					
				<div class="form-group">
					<label class="control-label">UF</label>	
					<input type="text" name="uf" required class="form-control">
				</div>
				
				
				<div class="form-group">
					 <div class="control-label pull-right"> 
					 	<button type="reset" class="btn btn-danger"> Limpar <span class="glyphicon glyphicon-erase" aria-hidden="true"></span> </button>
					 	<button type="submit" class="btn btn-success"> Cadastrar <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span> </button> 
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