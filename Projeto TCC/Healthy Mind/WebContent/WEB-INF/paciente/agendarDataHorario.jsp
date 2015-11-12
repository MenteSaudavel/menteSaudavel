<%@ include file="topPaciente.jsp" %>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-7">
				
				<form action="agendarDataHoraServlet" method="post">
				
					<div class="panel panel-primary">
					
						<div class="panel-heading"><span class="glyphicon glyphicon-th-list"></span> <b>Selecione um horário</b> </div>
				
						<table class="table table-hover table-condensed">
							
							<thead>
								<tr class="info">
									<td class="text-center"><b>Data</b></td>
									<td class="text-center"><b>Turno</b></td>
									<td class="text-center" colspan="4"><b>Horários</b></td>
									
								</tr>
							</thead>
							
							<tbody>
								<c:if test="${empty listaDataHora }">
									<tr>
										<td colspan="10" class="alert alert-warning"> Este psicologo ainda não disponibilizou horários. </td>
									</tr>
								</c:if>
								<c:forEach var="horario" items="${listaDataHora}">
									<input type="hidden" value="${horario.agenda.data }" name="data">
									<tr>
										<td class="text-center"><fmt:formatDate pattern="dd/MM/yyyy" value="${horario.agenda.data }"/></td>
										<td class="text-center"><c:if test="${horario.turno.id==1 }">Manhã</c:if><c:if test="${horario.turno.id==2 }">Tarde</c:if><c:if test="${horario.turno.id==3 }">Noite</c:if></td>
										<td class="text-center"><c:if test="${empty horario.hora1 }"><span class="glyphicon glyphicon-minus"></span></c:if><c:if test="${not empty horario.hora1 }"><fmt:formatDate pattern="HH:mm" value="${horario.hora1 }"/> <input type="radio" name="hora" value="${horario.hora1 }" required></c:if></td>
										<td class="text-center"><c:if test="${empty horario.hora2 }"><span class="glyphicon glyphicon-minus"></span></c:if><c:if test="${not empty horario.hora2 }"><fmt:formatDate pattern="HH:mm" value="${horario.hora2 }"/> <input type="radio" name="hora" value="${horario.hora2 }" required></c:if></td>
										<td class="text-center"><c:if test="${empty horario.hora3 }"><span class="glyphicon glyphicon-minus"></span></c:if><c:if test="${not empty horario.hora3 }"><fmt:formatDate pattern="HH:mm" value="${horario.hora3 }"/> <input type="radio" name="hora" value="${horario.hora3 }" required></c:if></td>
										<td class="text-center"><c:if test="${empty horario.hora4 }"><span class="glyphicon glyphicon-minus"></span></c:if><c:if test="${not empty horario.hora4 }"><fmt:formatDate pattern="HH:mm" value="${horario.hora4 }"/> <input type="radio" name="hora" value="${horario.hora4 }" required></c:if></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					
					</div>
					
					<div class="form-group">
						<label class="control-label">Selecione o tipo da consulta</label>
						<div class="checkbox">
							<label class="control-label">
								<input type="radio" name="tipoConsulta" value="Presencial" required> Presencial
							</label>
						<div class="checkbox">
							<label class="control-label">
								<input type="radio" name="tipoConsulta" value="Online" required> Online
							</label>
						</div>
						</div>
					</div>
					
					<button type="submit" class="btn btn-success pull-right">
						Salvar <span class="glyphicon glyphicon-ok-sign"
						aria-hidden="true"></span>
					</button>
					
				</form>
	
			</div>
		</div>
	</div>

<jsp:include page="footerPaciente.jsp"></jsp:include>