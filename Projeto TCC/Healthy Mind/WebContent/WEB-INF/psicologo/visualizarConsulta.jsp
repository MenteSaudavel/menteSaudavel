<%@ include file="topPsicologo.jsp" %>

<div class="container-fluid">
	<div >
		<div >
			
		<div class="panel panel-primary">
			<div class="panel-heading"><span class="glyphicon glyphicon-th-list"></span> <b>Consultas Agendadas</b></div>
		
			  	<!-- Table -->
			 	 <table class="table table-hover table-condensed">
			  		<thead>
			    		<tr class="info">
			    			<td class="text-center"><b>Nome do Paciente</b></td>
			    			<td class="text-center"><b>Telefone do Paciente</b></td>
			    			<td class="text-center"><b>Data</b></td>
			    			<td class="text-center"><b>Hora</b></td>
			    			<td class="text-center"><b>Tipo da Consulta</b></td>
			    			<td class="text-center"><b>Status da Consulta</b></td>
			    			<td class="text-center"><b>Desmarcar Consulta</b></td>
			    		</tr>
			    	</thead>
			    	<c:if test="${empty listaConsulta }">
						<tr class="warning">
							<td colspan="7">No momento não há consultas agendadas! </td>
						</tr>
					</c:if>
			    	<tbody>
			    		<c:forEach var="consulta" items="${listaConsulta}">
				    		<tr>
				    			<td class="text-center">${consulta.paciente.nome }</td>
				    			<td class="text-center">${consulta.paciente.telefone }</td>
				    			<td class="text-center"><fmt:formatDate pattern="dd/MM/yyyy" value="${consulta.dataConsulta }"/></td>
				    			<td class="text-center"><fmt:formatDate pattern="HH:mm" value="${consulta.hora }"/></td>
				    			<td class="text-center">${consulta.tipoConsulta }</td>
				    			<td class="text-center"><c:if test="${consulta.statusConsulta==false }"><label class="alert-danger">Desmarcada</label></c:if><c:if test="${consulta.statusConsulta==true }"><span class="success"><label class="alert-success">Agendada</label></span></c:if><c:if test="${consulta.statusConsulta==true }"><span class="info"><label class="alert-info">Realizada</label></span></c:if></td>
				    			<td class="text-center"><a href="<c:if test="${consulta.statusConsulta==true }">desmarcarConsultaServlet?idConsulta=${consulta.id }</c:if> <c:if test="${consulta.statusConsulta==false }">#</c:if><c:if test="${consulta.statusConsulta==null }">#</c:if>" class="btn btn-sm btn-danger" <c:if test="${consulta.statusConsulta==false }">disabled="disabled"</c:if> <c:if test="${consulta.statusConsulta==null }">disabled="disabled"</c:if> ><span class="glyphicon glyphicon-remove-sign"></span></a></td>
				    		</tr>
			    		</c:forEach>
			    	</tbody>
			    </table>
			</div>
		</div>
	</div>
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
</div>
	<form method="get" action="menuPsicologoServlet" class="form-group">
		<div class="form-group">
			<div class="col-sm-7 control-label"> <button type="submit" class="btn btn-primary">  <span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> Voltar </button> </div>
		</div>
	</form>
<jsp:include page="footerPsicologo.jsp"></jsp:include>