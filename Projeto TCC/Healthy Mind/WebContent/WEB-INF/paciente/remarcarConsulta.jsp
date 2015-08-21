<%@ include file="topPaciente.jsp" %>

	<form action="remarcarConsultaServlet" method="post"
		class="form-horizontal">

		<div class="form-group">
			<div>
				<input type="hidden" name="idConsulta"
					value="${consulta.idConsulta }">
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label"> Selecione um psicólogo
			</label>

			<div class="col-sm-5">
				<select name="idPsicologo" class="form-control">
					<option></option>
					<c:forEach var="psicologo" items="${listaPsicologo}">
						<option value="${psicologo.id }"
							<c:if test="${consulta.psicologo.id == psicologo.id }"> selected </c:if>>${psicologo.nome }</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label"> Data da Consulta </label>
			<div class="col-sm-5">
				<input type="text" name="dataConsulta" class="form-control" required
					value='<fmt:formatDate pattern="dd/MM/yyyy" value="${consulta.dataConsulta }" />' >
					
					<!-- value='<fmt:formatDate pattern="dd/MM/yyyy" value="${consulta.dataConsulta }" /> -->
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label"> Hora da Consulta </label>
			<div class="col-sm-5">
				<input type="time" name="horaConsulta" class="form-control" required
					value="${consulta.horaConsulta }">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-7 control-label">
				<button type="submit" class="btn btn-success">Remarcar <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span> </button>
			</div>
		</div>
	
	</form>
	
	<form class="form-group" method="get" action="visualizarConsultaServlet">
		<div class="col-sm-7 control-label">
			<button type="submit" class="btn btn-danger">Cancelar <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span> </button>
		</div>
	</form>

<jsp:include page="footerPaciente.jsp"></jsp:include>