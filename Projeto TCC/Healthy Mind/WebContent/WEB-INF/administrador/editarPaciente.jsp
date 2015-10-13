<%@ include file="topAdm.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-7">	
			<form method="post" action="editarPacienteServlet">
	
					<div class="form-group">
						<div> <input type="hidden" name="id" value="${paciente.id }"> </div>
					</div>
					
					<div class="form-group">
						<label class="control-label"> Nome do paciente </label>
						<input type="text" name="nome" required value="${paciente.nome }" class="form-control">
					</div>
					
					<div class="form-group">
						<label class="control-label"> Telefone </label>
						<input type="text" name="telefone" required value="${paciente.telefone }" class="form-control">
					</div>
					
					<div class="form-group">
						<label class="control-label"> CPF </label>
						<input type="text" name="cpf" required value="${paciente.cpf }" class="form-control">
					</div>
					
					<div class="form-group">
						<label class="control-label"> Convênio </label> 
						
							<select name="idConvenio" class="form-control">
								
								<option></option>
								
								<c:forEach var="convenio" items="${lista}">	
									<option value="${convenio.id }" <c:if test="${paciente.convenio.id == convenio.id }"> selected </c:if> > ${convenio.nome }</option>
								</c:forEach>	
							</select>										
					</div>
					
					<div class="form-group">
						<label class="control-label"> Número da carteirinha do convênio </label>
						<input type="text" name="numeroCarteirinha" required value="${paciente.numeroCarteirinha }" class="form-control">
					</div>
					
				<div class="form-group">
					<div class="control-label pull-right">
						<button type="reset" class="btn btn-warning" data-toggle="tooltip" data-placement="bottom" title="Este botão restaura o valor de todos os campos ao original">
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
	
	
	<form method="get" action="listarPacienteServlet">
		<div class="form-group">
			<div class="col-sm-7 control-label"> <button type="submit" class="btn btn-primary">  <span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> Voltar </button> </div>
		</div>
	</form>

<jsp:include page="footerAdm.jsp"></jsp:include>