<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
	<%@ page import="entity.Moeda" %>

		<!DOCTYPE html>
		<html lang="pt-br">

		<head>
			<meta charset="utf-8" />

			<script src="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/js/adminlte.min.js"></script>
			<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/css/adminlte.min.css" />
			<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
				integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
				crossorigin="anonymous"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
				integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
				crossorigin="anonymous"></script>
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
				integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
				crossorigin="anonymous"></script>
			<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
			<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>


		</head>

		<body>
			<nav class="main-header navbar navbar-expand navbar-white navbar-light">
				<!-- Left navbar links -->
				<ul class="navbar-nav">
					<li class="nav-item d-none d-sm-inline-block">
						<h1>ChatBot</h1>
					</li>
				</ul>
			</nav>
			<aside class="main-sidebar sidebar-dark-primary elevation-4">
				<div class="sidebar">
					<nav class="mt-2">
						<ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
							data-accordion="false">
							<li class="nav-item"><a href="dollar" class="nav-link">
									<i class="nav-icon fas fa-home"></i>
									<p>Ínicio</p>
								</a></li>
								<li class="nav-item"><a href="Dashboard.jsp" class="nav-link">
									<i class="nav-icon fas fa-home"></i>
									<p>Dashboard</p>
								</a></li>
						</ul>
					</nav>
				</div>
			</aside>
			<div class="container">
				<div class="row">
					<div class="" style="height: 805px;">
						<!-- /.card-header -->
						<br>
						<div class="col-md-12 ">
							<div class="
                      card card-primary card-outline
                      direct-chat direct-chat-primary 
                    " style=" left: 25%">
								<div class="card-header">
									<h3 class="card-title">Direct Chat</h3>
								</div>
								<div class="card-body">
									<div class="direct-chat-messages" id="newMessage" style="height: 650px">
										<div class="direct-chat-msg right"  >
											<div class="direct-chat-text">Seja bem vindo!</div>
											<div class="direct-chat-text">Se deseja um período
												específico de uma de nossas moedas entre com os seguintes
												dados sendo eles:</div>
											<div class="direct-chat-text">Código da moeda, Data de
												início e Fim.</div>
											<div class="direct-chat-text">Respectivamente nessa
												ordem.</div>
										</div>
									</div>
								</div>

								<div class="card-footer">
									<div class="input-group">
										<input type="text" name="message" id="message" placeholder="Digite..."
											class="form-control" /> <span class="input-group-append">
											<button type="submit" class="btn btn-primary" id="sendMsg">
												Enviar</button>
										</span>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<footer class="main-footer" style="">
				<strong>Copyright © 2021 <a href="https://github.com/GabrielRinaldin/inFomoney"> GitHub</a>.
				</strong> All rights reserved.
				<div class="float-right d-none d-sm-inline-block">
					<b>Version</b> 3.1.0
				</div>
			</footer>


			<script type="text/javascript">
				$(document)
					.ready(
						function () {
							var path = window.location.pathname;
							var contextoWeb = path.substring(0, path.indexOf(
								"/", 1));
							var endPointURL = "ws://" + window.location.host
								+ contextoWeb + "/chat";
							var chatClient = null;

							chatClient = new WebSocket(endPointURL);
							chatClient.onmessage = function (event) {
								console.log(event.data);
								//USD 2021-04-20 2021-05-12
								$("#newMessage")
									.append(
										'<div class="direct-chat-msg right">'
										+ '<div class="direct-chat-text">'
										+ event.data + "</div>"
										+ "</div>");
							};

							let code = null;
											let start = null;
											let end = null;

							$("#sendMsg")
								.click(
									function () {
										var inputElement = document
											.getElementById("message");
										var message = inputElement.value
											.trim();
										if (message !== "") {

											var jsonObj = message;
											inputElement.value = "";
											
											$("#newMessage")
												.append(
													'<div class="direct-chat-msg left">'
													+ '<div class="direct-chat-text">'
													+ jsonObj
													+ "</div>"
													+ "");

											var split = jsonObj.split(" ");
											if (split.length == 3) {
												chatClient
													.send(jsonObj);

											} else {

												if (code == null) {
													code = jsonObj;
													jsonObj = null;
												} if (code != null
													&& start == null) {
													start = jsonObj;
													jsonObj = null;
												} if (code != null
													&& start != null
													&& end == null) {
													end = jsonObj;
													jsonObj = null;
												}
												if(code != null && start != null && end != null)
												chatClient
													.send(code + " " + start + " " + end);
											}
										}
										inputElement.focus();
									});
						});
			</script>
		</body>

		</html>
		</Moeda>
		</Moeda>