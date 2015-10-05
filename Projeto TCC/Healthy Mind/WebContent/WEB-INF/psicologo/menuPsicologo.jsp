<%@ include file="topPsicologo.jsp" %>
	
	<link href="css/carousel.css" rel="stylesheet">
	
	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
			
					<c:forEach var="psicologo" items="${listaPsicologo }">
						<h1 align=center>Seja bem-vindo(a)</h1>
						<h1 align=center>${psicologo.nome }</h1>
					</c:forEach>
					
				<div class="carousel-caption">...</div>
			</div>
			<div class="item">
				<p align=center>
					<img alt="" src="img/logo-slogan-novo1.png">
				</p>
				<div class="carousel-caption">...</div>
			</div>
			
		</div>
		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>

<jsp:include page="footerPsicologo.jsp"></jsp:include>