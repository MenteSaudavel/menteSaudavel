<%@ include file="topAdm.jsp" %>
	
		<div class="row">
		  <div class="col-lg-4">
		   <form method="post" action="pesquisarPacienteServlet">
			<div class="input-group">
			      <input type="text" class="form-control" placeholder="Nome do Paciente" name="nomePesquisaPaciente" required>
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="submit">Pesquisar</button>
			      </span>
		    </div><!-- /input-group -->
		   </form>
		  </div><!-- /.col-lg-6 -->
		</div><!-- /.row -->
	
		<form method="get" action="menuAdministradorServlet" class="form-group">
			<div class="form-group">
				<div class="col-sm-7 control-label"> <button type="submit" class="btn btn-primary">  <span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> Voltar </button> </div>
			</div>
		</form>	

<jsp:include page="footerAdm.jsp"></jsp:include>