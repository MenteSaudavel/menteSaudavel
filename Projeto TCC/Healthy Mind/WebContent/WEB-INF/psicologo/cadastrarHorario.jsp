<%@ include file="topPsicologo.jsp" %>

<style>
	 .hoverOpcao:hover{
		color: #127a9c;
	}
</style>

		<div class="container-fluid">
			<div class="row">
				<div class="col-md-7">
				
					<div class="form-group">
						<label class="control-label">Clique em um dos turnos para disponibilizar seus respectivos horários</label>
						<div class="input-group">
								
								<c:forEach var="turno" items="${listaTurno }">
									<br>
									<form action="cadastrarHorarioServlet" method="post">
										<input type="hidden" value="${turno.id }" name="idTurno">
										<input type="hidden" name="idAgenda" value="${idAgenda }">

										<button type="submit" class="btn btn-info">${turno.nome }</button>
									</form>
								</c:forEach>
								
								<!--  
								
								<form action="cadastrarHorarioServlet" method="post">
									<input type="hidden" value="${agenda.turno1.id }" name="idTurno">
									<input type="hidden" name="idAgenda" value="${idAgenda }">
									<button type="submit" class="btn btn-info"
											<c:if test="${disabled1==true}">
												disabled="disabled"
											</c:if>
									>
										<c:if test="${agenda.turno1.id==1 }">Manhã</c:if>
									</button>
								</form>
								<hr>
								<form action="cadastrarHorarioServlet" method="post">
									<input type="hidden" value="${agenda.turno2.id }" name="idTurno">
									<input type="hidden" name="idAgenda" value="${idAgenda }">
									<button type="submit" class="btn btn-info"
											<c:if test="${disabled2==true}">
												disabled="disabled"
											</c:if>
									>
										<c:if test="${agenda.turno2.id==2 }">Tarde</c:if>
									</button>
								</form>
								<hr>
								<form action="cadastrarHorarioServlet" method="post">
									<input type="hidden" value="${agenda.turno3.id }" name="idTurno">
									<input type="hidden" name="idAgenda" value="${idAgenda }">
									<button type="submit" class="btn btn-info"
											<c:if test="${disabled3==true}">
												disabled="disabled"
											</c:if>
									>
										<c:if test="${agenda.turno3.id==3 }">Noite</c:if>
									</button>
								</form>
								
								-->
						</div>
					</div>
				
				
				
				
				
				<!--  
					<div class="form-group">
						<label class="control-label">Selecione um dos turnos que cadastrou</label>
						<div class="input-group">
							<ul class="nav nav-tabs" role="tablist">
								<c:forEach var="turno" items="${listaTurno }">
									<li role="presentation"><a href='<c:if test="${turno.id==1 }">#morning</c:if><c:if test="${turno.id==2 }">#afternoon</c:if><c:if test="${turno.id==3 }">#evening</c:if>' data-toggle="tab" aria-expanded="false" class="btn btn-primary hoverOpcao">${turno.nome }</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
					
						<div class="tab-content">
							<div id="morning" class="tab-pane fade">
								<form action="cadastrarHorarioServlet" method="post">
									<input type="hidden" value="1" name="idTurno">
									<input type="hidden" name="idAgenda" value="${idAgenda }">
									<div class="form-group">
										<label class="control-label">Selecione os horários que deseja cadastrar</label>
										<ul class="list-group">
						  					<li class="list-group-item">08:00<input type="checkbox" class="pull-right" name="hora1" value="08:00"></li>
						  					<li class="list-group-item">09:00<input type="checkbox" class="pull-right" name="hora2" value="09:00"></li>
						  					<li class="list-group-item">10:00<input type="checkbox" class="pull-right" name="hora3" value="10:00"></li>
						  					<li class="list-group-item">11:00<input type="checkbox" class="pull-right" name="hora4" value="11:00"></li>
										</ul>
										<button type="submit" class="btn btn-success pull-right">OK <span class="glyphicon glyphicon-ok-sign"></span></button>
									</div>
								</form>
							</div>
							<div id="afternoon" class="tab-pane fade">
								<form action="cadastrarHorarioServlet" method="post">
									<input type="hidden" value="2" name="idTurno">
									<input type="hidden" name="idAgenda" value="${idAgenda }">
									<div class="form-group">
										<label class="control-label">Selecione os horários que deseja cadastrar</label>
										<ul class="list-group">
						  					<li class="list-group-item">14:00<input type="checkbox" class="pull-right" name="hora1" value="14:00"></li>
						  					<li class="list-group-item">15:00<input type="checkbox" class="pull-right" name="hora2" value="15:00"></li>
						  					<li class="list-group-item">16:00<input type="checkbox" class="pull-right" name="hora3" value="16:00"></li>
						  					<li class="list-group-item">17:00<input type="checkbox" class="pull-right" name="hora4" value="17:00"></li>
										</ul>
										<button type="submit" class="btn btn-success pull-right">OK <span class="glyphicon glyphicon-ok-sign"></span></button>
									</div>
								</form>
							</div>
							<div id="evening" class="tab-pane fade">
								<form action="cadastrarHorarioServlet" method="post">
									<input type="hidden" value="3" name="idTurno">
									<input type="hidden" name="idAgenda" value="${idAgenda }">
									<div class="form-group">
										<label class="control-label">Selecione os horários que deseja cadastrar</label>
										<ul class="list-group">
						  					<li class="list-group-item">19:00<input type="checkbox" class="pull-right" name="hora1" value="19:00"></li>
						  					<li class="list-group-item">20:00<input type="checkbox" class="pull-right" name="hora2" value="20:00"></li>
						  					<li class="list-group-item">21:00<input type="checkbox" class="pull-right" name="hora3" value="21:00"></li>
						  					<li class="list-group-item">22:00<input type="checkbox" class="pull-right" name="hora4" value="22:00"></li>
										</ul>
										<button type="submit" class="btn btn-success pull-right">OK <span class="glyphicon glyphicon-ok-sign"></span></button>
									</div>
								</form>
							</div>
						</div>
					-->	
										
				</div>
			</div>
		</div>	
		
	<form method="get" action="listarDatasServlet" class="form-group">
		<div class="form-group">
			<div class="col-sm-7 control-label"> <button type="submit" class="btn btn-primary">  <span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> Voltar </button> </div>
		</div>
	</form>	
	
<jsp:include page="footerPsicologo.jsp"></jsp:include>