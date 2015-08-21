<%@ include file="topAdm.jsp" %>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-7">
				<form method="post" action="editarAdministradorServlet">
					
					<input type="hidden" name="id" value="${administrador.id }">
					
					<div class="form-group">
						<label class="control-label"> Nome do administrador </label> <input
							type="text" name="nome" required class="form-control" value="${administrador.nome }">
					</div>

					<div class="form-group">
						<label class="control-label"> Telefone </label> <input type="text"
							name="telefone" required class="form-control" value="${administrador.telefone }">
					</div>

					<div class="form-group">
						<label class="control-label"> Função </label> <input type="text"
							name="funcao" required class="form-control" value="${administrador.funcao }">
					</div>
										
					<div class="form-group">
						<div class="control-label pull-right">
							<button type="reset" class="btn btn-warning">
								Restaurar <span class="glyphicon glyphicon-refresh"
									aria-hidden="true"></span>
							</button>
							<button type="submit" class="btn btn-success">
								Salvar <span class="glyphicon glyphicon-ok-sign"
									aria-hidden="true"></span>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<form method="get" action="listarAdministradorServlet">
		<div class="form-group">
			<div class="col-sm-7 control-label">
				<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-circle-arrow-left"
						aria-hidden="true"></span> Voltar
				</button>
			</div>
		</div>
	</form>

<jsp:include page="footerAdm.jsp"></jsp:include>