<%@ include file="topPaciente.jsp" %>


	<style>
   		.oculto{
   			display:none;
   		}
	</style>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-7">
				<form action="agendarConsultaServlet" method="post">
					
					<input type="hidden" value="${idPaciente }" name="idPaciente">
					
					<div class="form-group">
						<label class="control-label"> Selecione um psicólogo </label>
						<select name="idPsicologo" class="form-control" required>
							<option></option>
							<c:forEach var="psicologo" items="${listaPsicologo}">
								<option value="${psicologo.id }">${psicologo.nome }</option>
							</c:forEach>
						</select>
					</div>

					<div class="form-group">
						<label class="control-label"> Data da Consulta </label>
						<input type="date" name="dataConsulta" class="form-control" required>
					</div>

					<div class="form-group">
						<label class="control-label"> Hora da Consulta </label>
						<input type="time" name="horaConsulta" class="form-control" required>
					</div>

					<div class="form-group">
						<div class="control-label pull-right">
							<button type="reset" class="btn btn-danger">
								Limpar <span class="glyphicon glyphicon-erase"
									aria-hidden="true"></span>
							</button>
							<button type="submit" class="btn btn-success">
								Agendar <span class="glyphicon glyphicon-ok-sign"
									aria-hidden="true"></span>
							</button>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>

	<form method="get" action="menuPacienteServlet" class="form-group">
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
	<c:if test="${agendado == true }">
		<div class="alert alert-success" role="alert">Consulta agendada
			com sucesso!</div>
	</c:if>

<jsp:include page="footerPaciente.jsp"></jsp:include>