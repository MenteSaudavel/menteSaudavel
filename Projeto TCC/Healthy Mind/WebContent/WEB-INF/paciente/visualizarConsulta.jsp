<%@ include file="topPaciente.jsp" %>

	<div class="panel panel-primary">

		<div class="panel-heading"><span class="glyphicon glyphicon-th-list"></span> <b>Consultas Agendadas</b> </div>
		
		<table class="table">
		
			<tr class="info">
				<td><b>Psicólogo</b></td>
				<td><b>Data da Consulta</b></td>
				<td><b>Hora da Consulta</b></td>
				<td><b>Remarcar</b></td>
				<td><b>Desmarcar</b></td>
			</tr>
			
			<c:if test="${empty listaConsulta }">
				<tr>
					<td colspan="7" class="alert alert-warning"> No momento não há consultas agendadas. </td>
				</tr>
			</c:if>
			
			<c:forEach var="consulta" items="${listaConsulta}">
				<tr>
					<td>${consulta.psicologo.nome }</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${consulta.dataConsulta }" /></td>
					<td>${consulta.horaConsulta }</td>
					<td> <a href="remarcarConsultaServlet?idConsulta=${consulta.idConsulta }" class="glyphicon glyphicon-edit"></a> </td>
					<td> <a href="desmarcarConsultaServlet?idConsulta=${consulta.idConsulta }" class="glyphicon glyphicon-trash"> </a> </td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<c:if test="${desmarcado == true }"> <div class="alert alert-success" role="alert"> Consulta desmarcada com sucesso! </div> </c:if>
	<c:if test="${desmarcado == false }"> <div class="alert alert-danger" role="alert"> Erro ao desmarcar consulta! </div> </c:if>
	<c:if test="${remarcado == true }"> <div class="alert alert-success" role="alert"> Consulta remarcada com sucesso! </div> </c:if>
	<c:if test="${remarcado == false }"> <div class="alert alert-danger" role="alert"> Erro ao remarcar consulta! </div> </c:if>
	
<jsp:include page="footerPaciente.jsp"></jsp:include>