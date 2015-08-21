<%@ include file="topAdm.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-7">
			<form method="post" action="cadastrarPsicologoServlet">
		
					<div class="form-group">
						<label class="control-label">Nome do Psicólogo</label>
						<input type="text" name="nome" required class="form-control">
					</div>
					<div class="form-group">
						<label class="control-label">Telefone do Consultório</label>
						<input type="text" name="telefoneConsultorio" required class="form-control">
					</div>
					<div class="form-group">
						<label class="control-label">Convênio</label>
						<select name="idConvenio" class="form-control">
							<option></option>
							<c:forEach var="convenio" items="${lista}">	
									<option value="${convenio.id }">${convenio.nome }</option>
							</c:forEach>	
							</select>	
					</div>
					
					<div class="form-group">
						<label class="control-label">Número do CRP</label>
						<input type="text" name="crp" required class="form-control">
					</div>
					
					<div class="form-group">
						<label class="control-label">Confirmar número do CRP</label>
						<input type="text" name="confCrp" required class="form-control">
					</div>
					
					<div class="form-group">
						<label class="control-label">E-mail</label>
						<input type="email" name="email" required class="form-control">
					</div>
					
					<div class="form-group">
						<div class="control-label pull-right"> <button type="reset" class="btn btn-danger"> Limpar <span class="glyphicon glyphicon-erase" aria-hidden="true"></span> </button>
							<button type="submit" class="btn btn-success"> Cadastrar <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span> </button> 
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
	<br>
	<br>
	<c:if test="${cadastrado == true }">
		<div class="alert alert-success alert-dismissible">
			<span class="glyphicon glyphicon-thumbs-up"></span>
			Psicólogo cadastrado com sucesso!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div>
	</c:if>
	<c:if test="${cadastrado == false }">
		<div class="alert alert-danger alert-dismissible">
			<span class="glyphicon glyphicon-alert"></span>
			Erro ao cadastrar psicólogo, certifique-se de que tudo foi digitado corretamente e tente de novo.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div>
	</c:if>
	
	
<jsp:include page="footerAdm.jsp"></jsp:include>