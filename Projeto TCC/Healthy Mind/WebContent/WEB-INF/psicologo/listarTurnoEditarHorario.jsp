<%@ include file="topPsicologo.jsp"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-7">
			<div class="form-group">
				<label class="control-label">Selecione um dos turnos cadastrados neste dia</label>
				<div class="input-group">
					<ul class="nav nav-tabs" role="tablist">
						<c:forEach var="horario" items="${listaHorario }">
							<a class="btn btn-info" href="listarHorarioServlet?idAgenda=${horario.agenda.id }&idTurno=${horario.turno.id}">
								<c:if test="${horario.turno.id==1 }">Manhã</c:if>
								<c:if test="${horario.turno.id==2 }">Tarde</c:if>
								<c:if test="${horario.turno.id==3 }">Noite</c:if>
							</a>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
	<form method="get" action="pesquisarDataServlet" class="form-group">
		<div class="form-group">
			<div class="col-sm-7 control-label"> <button type="submit" class="btn btn-primary">  <span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> Voltar </button> </div>
		</div>
	</form>
<jsp:include page="footerPsicologo.jsp"></jsp:include>