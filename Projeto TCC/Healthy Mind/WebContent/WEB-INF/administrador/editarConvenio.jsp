<%@ include file="topAdm.jsp" %>
	
<div class="container-fluid">
	<div class="row">
		<div class="col-md-7">	
			<form action="editarConvenioServlet" method="post">
				
				<input type="hidden" name="id" value="${convenio.id }">
				
				<div class="form-group">
					<label class="control-label">Nome do Convênio</label>
					
					<input type="text" name="nome" required class="form-control" value="${convenio.nome }">
				</div>
				
				
				<div class="form-group">
					<label class="control-label">Nome do Presidente</label>
					
					<input type="text" name="presidente" required class="form-control" value="${convenio.presidente }">
				</div>
				
				
				<div class="form-group">
					<label class="control-label">CNPJ</label>
					
					<input type="text" name="cnpj" required class="form-control" value="${convenio.cnpj }">
				</div>
				
				
				<div class="form-group">
					<label class="control-label">Telefone</label>
					
					<input type="text" name="telefone" required class="form-control" value="${convenio.telefoneConvenio }">
				</div>
				
				
				<div class="form-group">
					<label class="control-label">Endereço</label>
					
					<input type="text" name="endereco" required class="form-control" value="${convenio.enderecoConvenio }">
				</div>
				
				
				<div class="form-group">
					<label class="control-label">CEP</label>
					
					<input type="text" name="cep" required class="form-control" value="${convenio.cep }">
				</div>
				
				
				<div class="form-group">
					<label class="control-label">Cidade</label>
					
					<input type="text" name="cidade" required class="form-control" value="${convenio.cidadeConvenio }">
				</div>
				
				<div class="form-group">
					<label class="control-label">UF</label>	
					<select name="idUf" class="form-control">
						<option></option>
						<c:forEach var="uf" items="${listaUf}">
							<option value="${uf.id }" <c:if test="${convenio.uf.id == uf.id }"> selected </c:if>>${uf.nome }</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<div class="control-label pull-right">
						<button type="reset" class="btn btn-warning" data-toggle="tooltip" data-placement="bottom" title="Este botão restaura o valor de todos os campos ao original">
							Restaurar <span class="glyphicon glyphicon-refresh"
								aria-hidden="true"></span>
						</button>
						<button type="submit" class="btn btn-success">Salvar <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span> </button>
					</div>
				</div>
			</form>			

		</div>
	</div>	
</div>

	<form method="get" action="listarConvenioServlet">
		<div class="form-group">
			<div class="col-sm-7 control-label"> <button type="submit" class="btn btn-primary">  <span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> Voltar </button> </div>
		</div>
	</form>
	
	<br>		
	<br>		

<jsp:include page="footerAdm.jsp"></jsp:include>