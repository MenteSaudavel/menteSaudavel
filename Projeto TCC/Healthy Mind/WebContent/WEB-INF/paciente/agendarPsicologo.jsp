<%@ include file="topPaciente.jsp" %>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-7">
				
				<div class="alert alert-info" role="alert" align="justify">
					<h4><b>Aten��o!</b></h4>
					<p>
							Enquanto estiver agendando uma consulta, n�o tilize as setas
						do navegador para voltar e n�o saia da p�gina de agendamento antes da
						mensagem de confirma��o do agendamento. N�o agende mais de uma consulta
						at� t�-la realizado.
						<b>Insistir em fazer os fatores listados acima causar� problemas.</b>
					</p>
					<br>
					<p>
							Se desejar alterar as informa��es da sua consulta, desmarque-a
						acessando "Visualizar Consulta" na barra de navega��o e agende-a
						novamente.
					</p>
				</div>
				
				<form action="agendarPsicologoServlet" method="post">
					
					<div class="form-group">
						<label class="control-label"> Selecione um psic�logo </label>
						<select name="idPsicologo" class="form-control" required>
							<option></option>
							<c:forEach var="psicologo" items="${listaPsicologo}">
								<option value="${psicologo.id }">${psicologo.nome }</option>
							</c:forEach>
						</select>
					</div>

					<div class="form-group">
						<div class="control-label pull-right">
							<button type="submit" class="btn btn-success">
								Pr�ximo <span class="glyphicon glyphicon-circle-arrow-right"
									aria-hidden="true"></span>
							</button>
						</div>
					</div>

				</form>
			
			</div>
		</div>
	</div>
		<br>	
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
