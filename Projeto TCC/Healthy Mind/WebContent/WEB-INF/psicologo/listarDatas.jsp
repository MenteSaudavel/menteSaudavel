<%@ include file="topPsicologo.jsp" %>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-7">
				<label class="control-label">Clique no botão para mostrar os turnos cadastrados em cada data</label>
				<ul class="list-group">
					<c:if test="${empty listaData }">
			  			<li class="list-group-item list-group-item-danger">Nenhuma data cadastrada</li>
			  		</c:if>
					<c:forEach var="agenda" items="${listaData }">
						<input type="hidden" name="idAgenda" value="${agenda.id }">
			  			<li class="list-group-item"><fmt:formatDate pattern="dd/MM/yyyy" value="${agenda.data }" />
			  				<a class="btn btn-primary btn-sm pull-right" href="listarTurnosServlet?dataAtendimento=${agenda.data }&idAgenda=${agenda.id}"><span class="glyphicon glyphicon-plus-sign"></span></a>
			  			</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<form method="get" action="menuPsicologoServlet" class="form-group">
		<div class="form-group">
			<div class="col-sm-7 control-label"> <button type="submit" class="btn btn-primary">  <span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> Voltar </button> </div>
		</div>
	</form>
	<br>
	<br>
	<c:if test="${horarioCadastrado == true }">
		<div class="alert alert-success alert-dismissible">
			<span class="glyphicon glyphicon-thumbs-up"></span>
			Horário(s) disponibilizados para serem cadastrados nesse turno com sucesso.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div>
	</c:if>
	
	<c:if test="${horarioCadastrado == false }">
		<div class="alert alert-danger alert-dismissible">
			<span class="glyphicon glyphicon-alert"></span>
			Erro ao disponibilizar.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div>
	</c:if>
<jsp:include page="footerPsicologo.jsp"></jsp:include>