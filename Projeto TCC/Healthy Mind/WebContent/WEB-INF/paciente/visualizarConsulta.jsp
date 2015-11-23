<%@ include file="topPaciente.jsp" %>

<div class="container-fluid">
	<div class="panel panel-primary">

		<div class="panel-heading"><span class="glyphicon glyphicon-th-list"></span> <b>Consultas Agendadas</b> </div>
		
		<table class="table table-hover table-condensed">
		   	<thead>
				<tr class="info">
					<td class="text-center"><b>Psicólogo</b></td>
					<td class="text-center"><b>Data da Consulta</b></td>
					<td class="text-center"><b>Hora da Consulta</b></td>
					<td class="text-center"><b>Tipo da Consulta</b></td>
					<td class="text-center"><b>Status da Consulta</b></td>
					<td class="text-center"><b>Desmarcar</b></td>
				</tr>
			</thead>
			<c:if test="${empty listaConsulta }">
				<tr class="warning">
					<td colspan="6"> No momento não há consultas agendadas.</td>
				</tr>
			</c:if>
			<tbody>
				<c:forEach var="consulta" items="${listaConsulta}">
					<tr>
						<td class="text-center">${consulta.psicologo.nome }</td>
						<td class="text-center"><fmt:formatDate pattern="dd/MM/yyyy" value="${consulta.dataConsulta }" /></td>
						<td class="text-center"><fmt:formatDate pattern="HH:mm" value="${consulta.hora }"/></td>
						<td class="text-center">${consulta.tipoConsulta }</td>
						<td class="text-center"><c:if test="${consulta.statusConsulta==false }"><label class="alert-danger">Desmarcada</label></c:if><c:if test="${consulta.statusConsulta==true }"><label class="alert-success">Agendada</label></c:if></td>
				    	<td class="text-center"><a href="<c:if test="${consulta.statusConsulta==true }">desmarcarConsultaServlet?idConsulta=${consulta.id }</c:if> <c:if test="${consulta.statusConsulta==false }">#</c:if><c:if test="${empty consulta.statusConsulta }">#</c:if>" class="btn btn-sm btn-danger" <c:if test="${consulta.statusConsulta==false }">disabled="disabled"</c:if> <c:if test="${empty consulta.statusConsulta }">disabled="disabled"</c:if> ><span class="glyphicon glyphicon-remove-sign"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
			<c:if test="${consultaCadastrada==true }">
				<div class="alert alert-success alert-dismissible">
					<span class="glyphicon glyphicon-thumbs-up"></span>
						Consulta agendada com sucesso.
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				</div>
			</c:if>
			
			<c:if test="${consultaCadastrada==false }">
				<div class="alert alert-danger alert-dismissible">
					<span class="glyphicon glyphicon-alert"></span>
						Erro ao agendar consulta.
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				</div>
			</c:if>
	<c:if test="${desmarcado == true }">
		<div class="alert alert-success alert-dismissible" role="alert">
			<span class="glyphicon glyphicon-thumbs-up"></span>
	 		Consulta desmarcada com sucesso!
	 		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	 	</div>
	</c:if>
	<c:if test="${desmarcado == false }">
		<div class="alert alert-danger alert-dismissible">
			<span class="glyphicon glyphicon-alert"></span>
				Erro ao desmarcar consulta!
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div>
	</c:if>
	<c:if test="${remarcado == true }"> <div class="alert alert-success" role="alert"> Consulta remarcada com sucesso! </div> </c:if>
	<c:if test="${remarcado == false }"> <div class="alert alert-danger" role="alert"> Erro ao remarcar consulta! </div> </c:if>
	
</div>

	<form method="get" action="menuPacienteServlet" class="form-group">
		<div class="form-group">
			<div class="col-sm-7 control-label">
				<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-circle-arrow-left"
						aria-hidden="true"></span> Voltar
				</button>
			</div>
		</div>
	</form>

	
<jsp:include page="footerPaciente.jsp"></jsp:include>