<%@ include file="topPsicologo.jsp" %>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-7">
				
			<form method="post" action="pesquisarDataServlet">
				<label class="control-label">Selecione uma data que esteja já cadastrada</label>
				<div class="input-group">
					<input type="date" class="form-control"
						name="pesquisarData"
						required> <span class="input-group-btn">
						<button class="btn btn-info" type="submit">Pesquisar <span class="glyphicon glyphicon-search"></span></button>
					</span>
				</div>
				<!-- /input-group -->
			</form>
			<br>
			<c:if test="${pesquisado == true }">
				<label class="control-label">Clique no botão para editar os horários deste dia</label>
				<ul class="list-group">
					<c:if test="${empty listaData }">
				  		<li class="list-group-item list-group-item-danger">Data não encontrada.</li>
				  	</c:if>
					<c:forEach var="agenda" items="${listaData }">
						<input type="hidden" name="idAgenda" value="${agenda.id }">
						<input type="hidden" value="${agenda.data }" name="dataAtendimento"> 
				  		<li class="list-group-item list-group-item-info"><fmt:formatDate pattern="dd/MM/yyyy" value="${agenda.data }" />
				  			
				  			<div class="btn-group pull-right" role="group" aria-label="...">
							  <a class="btn btn-sm btn-info" href="editarTurnosServlet?idAgenda=${agenda.id }&dataAtendimento=${agenda.data}" data-toggle="tooltip" data-placement="bottom" title="Editar Turnos"><span class="glyphicon glyphicon-pencil"></span></a>
							  <a class="btn btn-sm btn-warning" href="editarHorarioServlet?idAgenda=${agenda.id}" data-toggle="tooltip" data-placement="bottom" title="Editar Horário(s)"><span class="glyphicon glyphicon-pencil"></span></a>
							</div>

				  		</li>
					</c:forEach>
				</ul>
			</c:if>
			<c:if test="${horaEditada==true }">
				<div class="alert alert-success alert-dismissible">
					<span class="glyphicon glyphicon-thumbs-up"></span>
						Horário(s) editado(s) com sucesso.
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				</div>
			</c:if>
			
			<c:if test="${horaEditada==false }">
				<div class="alert alert-danger alert-dismissible">
					<span class="glyphicon glyphicon-alert"></span>
						Erro ao editar horário(s).
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				</div>
			</c:if>
			<c:if test="${turnoEditado==true }">
				<div class="alert alert-success alert-dismissible">
					<span class="glyphicon glyphicon-thumbs-up"></span>
						Turno(s) editado(s) com sucesso.
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				</div>
			</c:if>
			<c:if test="${turnoEditado==false }">
				<div class="alert alert-danger alert-dismissible">
					<span class="glyphicon glyphicon-alert"></span>
						Erro ao editar turno(s).
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				</div>
			</c:if>
			</div>
		</div>
	</div>
	
	<form method="get" action="menuPsicologoServlet" class="form-group">
		<div class="form-group">
			<div class="col-sm-7 control-label"> <button type="submit" class="btn btn-primary">  <span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> Voltar </button> </div>
		</div>
	</form>
	
<jsp:include page="footerPsicologo.jsp"></jsp:include>