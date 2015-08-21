<%@ include file="topAdm.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-7">
			<form method="post" action="editarPsicologoServlet">
				
				<div class="form-group">
					<div> <input type="hidden" name="id" value="${psicologo.id }"> </div>
				</div>
				
				<div class="form-group">
					<label class="control-label">Nome do Psicólogo</label>
					<input type="text" name="nome" required value="${psicologo.nome }" class="form-control">
				</div>
	
				<div class="form-group">
					<label class="control-label">Telefone do Consultório</label>
					<input type="text" name="telefoneConsultorio" required value="${psicologo.telefoneConsultorio }" class="form-control">
				</div>
	
				<div class="form-group">
					<label class="control-label">Convênio</label>
					
						<select name="idConvenio" class="form-control">
								<option></option>
							<c:forEach var="convenio" items="${lista}">	
									
								<option value="${convenio.id }" <c:if test="${psicologo.convenio.id == convenio.id }"> selected </c:if> >${convenio.nome }</option>
									
							</c:forEach>	
						</select>	
				</div>
				
				<div class="form-group">
					<label class="control-label">Número do CRP</label>
					<input type="text" name="crp" required value="${psicologo.crp }" class="form-control">
				</div>
	
				<div class="form-group">
					<div class="control-label pull-right">
						<button type="reset" class="btn btn-warning">
							Restaurar <span class="glyphicon glyphicon-refresh"
								aria-hidden="true"></span>
						</button>
						<button type="submit" class="btn btn-success">Salvar <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span> </button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

	<form method="get" action="listarPsicologoServlet">
		<div class="form-group">
			<div class="col-sm-7 control-label"> <button type="submit" class="btn btn-primary">  <span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> Voltar </button> </div>
		</div>
	</form>

<jsp:include page="footerAdm.jsp"></jsp:include>