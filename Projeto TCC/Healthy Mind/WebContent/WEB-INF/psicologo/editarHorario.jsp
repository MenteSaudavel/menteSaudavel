<%@ include file="topPsicologo.jsp" %>

		<div class="container-fluid">
			<div class="row">
				<div class="col-md-7">
					<div class="form-group">
						<label class="control-label">Selecione um dos turnos que cadastrou</label>
						<div class="input-group">
							<ul class="nav nav-tabs" role="tablist">
								<c:forEach var="horario" items="${listaHorario }">
									<li role="presentation"><a href='<c:if test="${horario.turno.id==1 }">#morning</c:if><c:if test="${horario.turno.id==2 }">#afternoon</c:if><c:if test="${horario.turno.id==3 }">#evening</c:if>' data-toggle="tab" aria-expanded="false" class="btn btn-primary"><c:if test="${horario.turno.id==1 }">Manhã</c:if><c:if test="${horario.turno.id==2 }">Tarde</c:if><c:if test="${horario.turno.id==3 }">Noite</c:if></a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
					
						<div class="tab-content">
							<div id="morning" class="tab-pane fade">
								<form action="editarHorarioServlet" method="post">
									<input type="hidden" name="id" value="${horario.id }">
									<div class="form-group">
										<label class="control-label">Selecione os horários que deseja cadastrar</label>
										<ul class="list-group">
						  					<li class="list-group-item">08:00<input type="checkbox" class="pull-right" name="hora1" value="08:00" <c:if test="${not empty horario.hora1 }">checked="checked"</c:if> ></li>
						  					<li class="list-group-item">09:00<input type="checkbox" class="pull-right" name="hora2" value="09:00" <c:if test="${not empty horario.hora2 }">checked="checked"</c:if> ></li>
						  					<li class="list-group-item">10:00<input type="checkbox" class="pull-right" name="hora3" value="10:00" <c:if test="${not empty horario.hora3 }">checked="checked"</c:if> ></li>
						  					<li class="list-group-item">11:00<input type="checkbox" class="pull-right" name="hora4" value="11:00" <c:if test="${not empty horario.hora4 }">checked="checked"</c:if> ></li>
										</ul>
										<button type="submit" class="btn btn-success pull-right">OK</button>
									</div>
								</form>
							</div>
							<div id="afternoon" class="tab-pane fade">
								<form action="cadastrarHorarioServlet" method="post">
									<input type="hidden" name="id" value="${horario.id }">
									<div class="form-group">
										<label class="control-label">Selecione os horários que deseja cadastrar</label>
										<ul class="list-group">
						  					<li class="list-group-item">14:00<input type="checkbox" class="pull-right" name="hora1" value="14:00" <c:if test="${not empty horario.hora1 }">checked="checked"</c:if> ></li>
						  					<li class="list-group-item">15:00<input type="checkbox" class="pull-right" name="hora2" value="15:00" <c:if test="${not empty horario.hora2 }">checked="checked"</c:if> ></li>
						  					<li class="list-group-item">16:00<input type="checkbox" class="pull-right" name="hora3" value="16:00" <c:if test="${not empty horario.hora3 }">checked="checked"</c:if> ></li>
						  					<li class="list-group-item">17:00<input type="checkbox" class="pull-right" name="hora4" value="17:00" <c:if test="${not empty horario.hora4 }">checked="checked"</c:if> ></li>
										</ul>
										<button type="submit" class="btn btn-success pull-right">OK</button>
									</div>
								</form>
							</div>
							<div id="evening" class="tab-pane fade">
								<form action="cadastrarHorarioServlet" method="post">
									<input type="hidden" name="id" value="${horario.id }">
									<div class="form-group">
										<label class="control-label">Selecione os horários que deseja cadastrar</label>
										<ul class="list-group">
						  					<li class="list-group-item">19:00<input type="checkbox" class="pull-right" name="hora1" value="19:00" <c:if test="${not empty horario.hora1 }">checked="checked"</c:if> ></li>
						  					<li class="list-group-item">20:00<input type="checkbox" class="pull-right" name="hora2" value="20:00" <c:if test="${not empty horario.hora2 }">checked="checked"</c:if> ></li>
						  					<li class="list-group-item">21:00<input type="checkbox" class="pull-right" name="hora3" value="21:00" <c:if test="${not empty horario.hora3 }">checked="checked"</c:if> ></li>
						  					<li class="list-group-item">22:00<input type="checkbox" class="pull-right" name="hora4" value="22:00" <c:if test="${not empty horario.hora4 }">checked="checked"</c:if> ></li>
										</ul>
										<button type="submit" class="btn btn-success pull-right">OK</button>
									</div>
								</form>
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