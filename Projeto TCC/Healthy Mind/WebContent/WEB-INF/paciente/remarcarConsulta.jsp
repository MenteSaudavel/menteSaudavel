<%@ include file="topPaciente.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-7">

			<form action="remarcarConsultaServlet" method="post">
		
				<div class="form-group">
					<div>
						<input type="hidden" name="idConsulta"
							value="${consulta.idConsulta }">
					</div>
				</div>
		
				<div class="form-group">
					<label class="control-label"> Selecione um psicólogo</label>
					<select name="idPsicologo" class="form-control">
						<option></option>
						<c:forEach var="psicologo" items="${listaPsicologo}">
							<option value="${psicologo.id }"
								<c:if test="${consulta.psicologo.id == psicologo.id }"> selected </c:if>>${psicologo.nome }</option>
						</c:forEach>
					</select>
				</div>
		
				<div class="form-group">
					<label class="control-label"> Data da Consulta </label>
						<input type="text" name="dataConsulta" class="form-control" required
							value='<fmt:formatDate pattern="dd/MM/yyyy" value="${consulta.dataConsulta }" />' >
							
							<!-- value='<fmt:formatDate pattern="dd/MM/yyyy" value="${consulta.dataConsulta }" /> -->
				</div>
		
				<div class="form-group">
					<label class="control-label"> Hora da Consulta </label>
					<input type="time" name="horaConsulta" class="form-control" required
							value="${consulta.horaConsulta }">
				</div>
		
				<div class="form-group">
					<div class="control-label pull-right">
						<button type="reset" class="btn btn-warning" data-toggle="tooltip" data-placement="bottom" title="Este botão restaura o valor de todos os campos ao original">
							Restaurar <span class="glyphicon glyphicon-refresh"
								aria-hidden="true"></span>
						</button>
						<button type="submit" class="btn btn-success">Remarcar <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span> </button>
					</div>
				</div>
			
			</form>
			
		</div>	
	</div>
</div>	
			
	<form method="get" action="visualizarConsultaServlet" class="form-group">
		<div class="form-group">
			<div class="col-sm-7 control-label"> <button type="submit" class="btn btn-primary">  <span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> Voltar </button> </div>
		</div>
	</form>

<jsp:include page="footerPaciente.jsp"></jsp:include>