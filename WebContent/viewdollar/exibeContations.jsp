<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="entity.Moeda"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Moeda> lista = (ArrayList<Moeda>) request.getAttribute("listaTodas");
ArrayList<Moeda> umaMoeda = (ArrayList<Moeda>) request.getAttribute("umaMoeda");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">

<script
	src="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/js/adminlte.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/css/adminlte.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
	integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
	integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>

</head>

<style type="text/css">
.BT {
	height: 50px;
	width: 200px;
}
</style>

<body>
	<nav class="main-header navbar navbar-expand navbar-white navbar-light">
		<!-- Left navbar links -->
		<ul class="navbar-nav">
			<li class="nav-item d-none d-sm-inline-block"><a>Cotação</a></li>
		</ul>
	</nav>
	<aside class="main-sidebar sidebar-dark-primary elevation-4">
		<div class="sidebar">
			<nav class="mt-2">
				<ul class="nav nav-pills nav-sidebar flex-column"
					data-widget="treeview" role="menu" data-accordion="false">
					<li class="nav-item"><a href="#" class="nav-link"> <i
							class="nav-icon fas fa-home"></i>
							<p>Dashboard</p>
					</a></li>
				</ul>
			</nav>
		</div>
	</aside>
	<div class="container">
		<div class="row">
			<div class="col-xl-11 ">
				<div class="card">
					<!-- /.card-header -->
					<div class="card-body table-responsive p-0" style="height: 790px;">
						<table class="table table-head-fixed text-nowrap">
							<thead>
								<tr>
									<th>ID</th>
									<th>CODE</th>
									<th>CODEIN</th>
									<th>NAME</th>
									<th>HIGH</th>
									<th>LOW</th>
									<th>VARBID</th>
									<th>ASK</th>
									<th>PCTCHANGE</th>
									<th>BID</th>
								</tr>
							</thead>
							<tbody>
								<%
								for (int i = 0; i < lista.size(); i++) {
								%>
								<tr>
									<td><%=lista.get(i).getId()%></td>
									<td><%=lista.get(i).getCode()%></td>
									<td><%=lista.get(i).getCodein()%></td>
									<td><%=lista.get(i).getName()%></td>
									<td><%=lista.get(i).getHigh()%></td>
									<td><%=lista.get(i).getLow()%></td>
									<td><%=lista.get(i).getVarBid()%></td>
									<td><%=lista.get(i).getAsk()%></td>
									<td><%=lista.get(i).getPctChange()%></td>
									<td><%=lista.get(i).getBid()%></td>
								</tr>
								<%
								}
								%>

							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-lg-1">
				<button type="button" id="CHF" class="btn btn-default BT" data-toggle="modal"
					data-target="#modal-xl">Franco SuÃ­Ã§o</button>
				<button type="button" class="btn btn-default BT" data-toggle="modal"
					data-target="#modal-xl">Peso Argentino</button>
				<button type="button" class="btn btn-default BT" data-toggle="modal"
					data-target="#modal-xl">Euro</button>
				<button type="button" class="btn btn-default BT" data-toggle="modal"
					data-target="#modal-xl">DÃ³lar Comercial</button>
				<button type="button" class="btn btn-default BT" data-toggle="modal"
					data-target="#modal-xl">DÃ³lar Canadense</button>
				<button type="button" class="btn btn-default BT" data-toggle="modal"
					data-target="#modal-xl">DÃ³lar Turismo</button>
				<button type="button" class="btn btn-default BT" data-toggle="modal"
					data-target="#modal-xl">Bitcoin</button>
				<button type="button" class="btn btn-default BT" data-toggle="modal"
					data-target="#modal-xl">DÃ³lar Australiano</button>
				<button type="button" class="btn btn-default BT" data-toggle="modal"
					data-target="#modal-xl">Novo Shekel Israelense</button>
				<button type="button" class="btn btn-default BT" data-toggle="modal"
					data-target="#modal-xl">Iene JaponÃªs</button>
				<button type="button" class="btn btn-default BT" data-toggle="modal"
					data-target="#modal-xl">Libra Esterlina</button>
				<button type="button" class="btn btn-default BT" data-toggle="modal"
					data-target="#modal-xl">Ripple</button>
				<button type="button" class="btn btn-default BT" data-toggle="modal"
					data-target="#modal-xl">Ethereum</button>
				<button type="button" class="btn btn-default BT" data-toggle="modal"
					data-target="#modal-xl">Litecoin</button>
			</div>



		</div>
		<form action="dollar" method="POST">
			<button class="btn btn-danger" type="submit">Atualizar
				valores</button>
		</form>
		<div class="modal fade" id="modal-xl" style="display: none;"
			aria-hidden="true">
			<div class="modal-dialog modal-xl">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Dólar</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="card-body table-responsive p-0" style="height: 790px;">
						<table class="table table-head-fixed text-nowrap">
							<thead>
								<tr>
									<th>ID</th>
									<th>CODE</th>
									<th>CODEIN</th>
									<th>NAME</th>
									<th>HIGH</th>
									<th>LOW</th>
									<th>VARBID</th>
									<th>ASK</th>
									<th>PCTCHANGE</th>
									<th>BID</th>
								</tr>
							</thead>
							<tbody>
								<%
								for (int i = 0; i < umaMoeda.size(); i++) {
								%>
								<tr>
									<td><%=umaMoeda.get(i).getId()%></td>
									<td><%=umaMoeda.get(i).getCode()%></td>
									<td><%=umaMoeda.get(i).getCodein()%></td>
									<td><%=umaMoeda.get(i).getName()%></td>
									<td><%=umaMoeda.get(i).getHigh()%></td>
									<td><%=umaMoeda.get(i).getLow()%></td>
									<td><%=umaMoeda.get(i).getVarBid()%></td>
									<td><%=umaMoeda.get(i).getAsk()%></td>
									<td><%=umaMoeda.get(i).getPctChange()%></td>
									<td><%=umaMoeda.get(i).getBid()%></td>
								</tr>
								<%
								}
								%>

							</tbody>
						</table>
					</div>
					<div class="modal-footer justify-content-between">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	</div>
</body>
</html>