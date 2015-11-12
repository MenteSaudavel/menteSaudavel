<%@ include file="topPsicologo.jsp" %>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-7">
				
				<div class="form-group">
					<form action="editarTurnosServlet" method="post">
						<label class="control-label"> Selecione até três turnos para esta data  </label>
						<input type="hidden" value="${agenda.id }" name="idAgenda">
						<ul class="list-group">
							<c:if test="${agenda.turno1.id!=0 }"><li class="list-group-item">Manhã <input type="checkbox" class="pull-right" value="1" name="idTurno1" <c:if test="${agenda.turno1.id==1 }">checked="checked"</c:if> ></li></c:if>
		  					<c:if test="${agenda.turno2.id!=0 }"><li class="list-group-item">Tarde <input type="checkbox" class="pull-right" value="2" name="idTurno2" <c:if test="${agenda.turno2.id==2 }">checked="checked"</c:if> ></li></c:if>
		  					<c:if test="${agenda.turno3.id!=0 }"><li class="list-group-item">Noite <input type="checkbox" class="pull-right" value="3" name="idTurno3" <c:if test="${agenda.turno3.id==3 }">checked="checked"</c:if> ></li></c:if>
		  					<c:if test="${agenda.turno1.id==0 }"><li class="list-group-item">Manhã <input type="checkbox" class="pull-right" value="1" name="idTurno1"></li></c:if>
		  					<c:if test="${agenda.turno2.id==0 }"><li class="list-group-item">Tarde <input type="checkbox" class="pull-right" value="2" name="idTurno2"></li></c:if>
		  					<c:if test="${agenda.turno3.id==0 }"><li class="list-group-item">Noite <input type="checkbox" class="pull-right" value="3" name="idTurno3"></li></c:if>
						</ul>
						<button type="submit" class="btn btn-success pull-right">Salvar <span class="glyphicon glyphicon-ok-sign"></span></button>
					</form>
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