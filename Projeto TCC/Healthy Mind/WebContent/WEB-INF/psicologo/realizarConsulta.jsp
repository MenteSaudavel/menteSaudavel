<%@ include file="topPsicologo.jsp" %>

<!--
 *  Copyright (c) 2014 The WebRTC project authors. All Rights Reserved.
 *
 *  Use of this source code is governed by a BSD-style license
 *  that can be found in the LICENSE file in the root of the source
 *  tree.
-->
	<!--  faz parte do "em teste"
				<script type="text/javascript" src="js1/prettify.js"></script>
		        <script type="text/javascript" src="js1/loadAndFilter.js"></script>
		        <script type="text/javascript" src="js1/jquery.min.js"></script>
		        <link rel="stylesheet" type="text/css" href="js1/prettify.css" />
				
				
				<script>
					var P2P = require('socket.io-p2p');
					var io = require('socket.io-client');
					var socket = io();
					var p2p = new P2P(socket);
					p2p.on('peer-msg', function (data) {
					  console.log('From a peer %s', data);
					});

				</script>
				
				<script src="https://cdn.socket.io/socket.io-1.3.7.js"></script>
				<script src="js1/socket.io.js"></script>
        		<script type="text/javascript" src="js1/easyrtc.js"></script>
        		<script type="text/javascript" src="js1/demo_audio_video.js"></script>
        		
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
	    height: 150px;
	  }
	  video#remoteVideo {
	  	margin: 0 10px 20px 0;
	  	height: 150px;
	  }
		
</style>

<div class="container-fluid">
	
	
	
	<div class="container">
		
	    <br>
		<div class="row">
			
			<div class="col-md-6">
				<div class="embed-responsive embed-responsive-4by3">
					<video id="remoteVideo" autoplay></video>
				</div>
			</div>
			<div class="col-md-6">
				<div class="embed-responsive embed-responsive-4by3">
					<video id="localVideo" class="pull-right" autoplay muted></video>
				</div>
			</div>
		</div>
		<br>
		<div class="row">
		    <div class="col-md-12">
		      <button id="startButton" class="btn btn-primary">Iniciar Imagem <span class="glyphicon glyphicon-facetime-video"></span></button>
		      <button id="callButton" class="btn btn-success">Ligar <span class="glyphicon glyphicon-earphone"></span></button>
		      <button id="hangupButton" class="btn btn-danger">Desligar <span class="glyphicon glyphicon-earphone"></span></button>
		    </div>
		</div>
	    
	    <script src="js1/adapter.js"></script>
	  	<script src="js1/jsPC/main.js"></script>
	
	  	<script src="js1/lib/ga.js"></script>
	</div>
	
			
	
	<!-- em teste 		
				<div id="demoContainer">
                    <div id="connectControls">
                        <input type="checkbox" checked="checked" id="shareAudio" />Share audio
                        <input type="checkbox" checked="checked" id="shareVideo" />Share video<br />
                        <input type="checkbox" checked="checked" id="expectAudio" />Expect audio
                        <input type="checkbox" checked="checked" id="expectVideo" />Expect video<br />

                        <input type="checkbox" id="useFreshIce" onclick="easyrtc.setUseFreshIceEachPeerConnection(this.value);"/>Fresh Ice<br />
                        <button id="connectButton" onclick="connect()">Connect</button>
                        <button  onclick="allocateVideo()">Allocate video</button>
                        <button id="disconnectButton" onclick="disconnect()">Disconnect</button>
                        <button id="hangupButton" disabled="disabled" onclick="hangup()">Hangup</button>
                        <div id="iam">Not yet connected...</div>
                        <br />
                        <strong>Connected users:</strong>
                        <div id="otherClients"></div>
                    </div>

                    <div id="videos">
                        <video autoplay="autoplay" id="selfVideo"  class="easyrtcMirror" muted="muted" volume="0"></video>
                        <video autoplay="autoplay" id="callerVideo"></video>
                        <div id="acceptCallBox">
                            <div id="acceptCallLabel"></div>
                            <button id="callAcceptButton" >Accept</button> <button id="callRejectButton">Reject</button>
                        </div>
                    </div>
                </div>
	-->
	
	<!--  testar com internet
	
	<script type="text/javascript">
		// http://cdn.webrtc-experiment.com/socket.io/PeerConnection.js
	
		var peer = new PeerConnection('http://domain:port');
		peer.onStreamAdded = function(e) {
		   document.body.appendChild(e.mediaElement);
		};
	
		// the easiest method of "manual" peers connection is
		// call "sendParticipationRequest" and pass user-id of the target user
		peer.sendParticipationRequest(userid);
	
		// otherwise, call "startBroadcasting"
		// (behind the scene) this function will be invoked 
		// recursively until a participant found
		peer.startBroadcasting();
		Simplest Demo
	</script>
	
	<script type="text/javascript">
		var offerer = new PeerConnection('http://domain:port', 'message', 'offerer');
		offerer.onStreamAdded = function(e) {
		   document.body.appendChild(e.mediaElement);
		};
		var answerer = new PeerConnection('http://domain:port', 'message', 'answerer');
		answerer.onStreamAdded = function(e) {
		   document.body.appendChild(e.mediaElement);
		};
		answerer.sendParticipationRequest('offerer');
	</script>
	
	<script type="text/javascript">
		function getUserMedia(callback) {
		    var hints = {
		        audio: true,
		        video: {
		            optional: [],
		            
		            // capture super-hd stream!
		            mandatory: {
		                minWidth: 1280,
		                minHeight: 720,
		                maxWidth: 1920,
		                maxHeight: 1080,
		                minAspectRatio: 1.77
		            }
		        }
		    };
		    
		    navigator.getUserMedia(hints, function (stream) {
		        //    you can use "peer.addStream" to attach stream
		        //    peer.addStream(stream);
		        // or peer.MediaStream = stream;
		    
		        callback(stream);
		    
		        // preview local video
		        var video = document.createElement('video');
		        video.src = URL.createObjectURL(stream);
		        video.controls = true;
		        video.muted = true;
	
		        peer.onStreamAdded({
		            mediaElement: video,
		            userid: 'self',
		            stream: stream
		        });
		    });
		}
	</script>
	
	-->
	
</div>

<jsp:include page="footerPsicologo.jsp"></jsp:include>