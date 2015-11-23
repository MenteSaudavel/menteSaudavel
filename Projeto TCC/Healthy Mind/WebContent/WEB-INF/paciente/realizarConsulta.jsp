<%@ include file="topPaciente.jsp" %>

<!--
 *  Copyright (c) 2014 The WebRTC project authors. All Rights Reserved.
 *
 *  Use of this source code is governed by a BSD-style license
 *  that can be found in the LICENSE file in the root of the source
 *  tree.
-->

<style>
	
	.container {
		margin: 0 auto 0 auto;
		max-width: 40em;
		padding: 1em 1.5em 1.3em 1.5em;
	}
	
	html {
		/* avoid annoying page width change
		when moving from the home page */
		overflow-y: scroll;
	}
	
	video {
		background: #222;
		margin: 0 0 20px 0;
		width: 100%;
	}
	
	video {
	  height: 225px;
	  margin: 0 0 20px 0;
	  vertical-align: top;
	  width: calc(50% - 12px);
	}
	
	video#localVideo {
	  margin: 0 20px 20px 0;
	}
	
	@media screen and (max-width: 400px) {
	  button {
	    width: 83px;
	  }
	
	  button {
	    margin: 0 11px 10px 0;
	  }
	
	
	  video {
	    height: 90px;
	    margin: 0 0 10px 0;
	    width: calc(50% - 7px);
	  }
	  video#localVideo {
	    margin: 0 10px 20px 0;
	  }	
		
</style>

<div class="container">
	
    <video id="remoteVideo" autoplay></video>
    
    <video id="localVideo" autoplay muted></video>
    
    <div>
      <button id="startButton" class="btn btn-primary">Iniciar Imagem <span class="glyphicon glyphicon-facetime-video"></span></button>
      <button id="callButton" class="btn btn-success">Ligar <span class="glyphicon glyphicon-earphone"></span></button>
      <button id="hangupButton" class="btn btn-danger">Desligar <span class="glyphicon glyphicon-earphone"></span></button>
    </div>
    
    <script src="js1/adapter.js"></script>
  	<script src="js1/jsPC/main.js"></script>

  	<script src="js1/lib/ga.js"></script>
	
</div>

<jsp:include page="footerPaciente.jsp"></jsp:include>