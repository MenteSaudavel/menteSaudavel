<%@ include file="topPsicologo.jsp" %>

<style>
	.oculto{
   		display:none;
   	}
</style>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-7">
		
		<form action="" method="post">
		
			<div class="form-group">
				<label class="control-label"> Selecione uma Data </label>
				<input type="date" name="dataAtendimento" class="form-control" required>
			</div>
			
			<div class="form-group">
				<label class="control-label"> Selecione até três turnos  </label>
				<ul class="list-group">
  					<li class="list-group-item">Manhã <input type="checkbox" class="pull-right" value="1" name="idTurno1"></li>
  					<li class="list-group-item">Tarde <input type="checkbox" class="pull-right" value="2" name="idTurno2"></li>
  					<li class="list-group-item">Noite <input type="checkbox" class="pull-right" value="3" name="idTurno3"></li>
				</ul>
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-success pull-right">Cadastrar <span class="glyphicon glyphicon-ok-sign"></span></button>
			</div>
			
		</form>
		
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
	<c:if test="${cadastrado == false }">
		<div class="alert alert-danger alert-dismissible">
			<span class="glyphicon glyphicon-alert"></span>
			Erro ao cadastrar, certifique-se de que tudo foi selecionado corretamente e tente de novo.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div>
	</c:if>
	<c:if test="${cadastrado == true }">
		<div class="alert alert-info">
			<span class="glyphicon glyphicon-hourglass"></span>
			Data cadastrada, vá para <a href="listarDatasServlet">cadastrar horários</a> para concluir o cadastramento ou cadastre mais datas antes.
		</div>
	</c:if>

<jsp:include page="footerPsicologo.jsp"></jsp:include>