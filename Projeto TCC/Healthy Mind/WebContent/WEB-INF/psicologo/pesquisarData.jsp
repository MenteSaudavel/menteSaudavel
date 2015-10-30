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
						<button class="btn btn-info" type="submit">Pesquisar</button>
					</span>
				</div>
				<!-- /input-group -->
			</form>
			<br>
			<c:if test="${pesquisado == true }">
				<ul class="list-group">
					<c:if test="${empty listaData }">
				  		<li class="list-group-item list-group-item-danger">Data não encontrada.</li>
				  	</c:if>
					<c:forEach var="agenda" items="${listaData }">
						<input type="hidden" name="idAgenda" value="${agenda.id }">
				  		<li class="list-group-item list-group-item-info"><fmt:formatDate pattern="dd/MM/yyyy" value="${agenda.data }" />
							<a class="btn btn-primary btn-sm pull-right" href="editarHorarioServlet?idAgenda=${agenda.id}"><span class="glyphicon glyphicon-pencil"></span></a>
				  		</li>
					</c:forEach>
				</ul>
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