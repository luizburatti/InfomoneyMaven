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

<style type="text/css">
#content-tabble {
	border-collapse: collapse;
	margin: 25px 0;
	font-size: 0.9em;
	min-width: 400px;
	overflow: hidden;
	border-radius: 5px 5px 0 0;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

#content-tabble tbody tr {
	border-bottom: 1px solid #dddddd;
}

#content-tabble tbody tr:nth-of-type(even) {
	background-color: #f3f3f3;
}

#content-tabble tbody tr:last-of-type {
	border-bottom: 2px solid #009879;
}

#content-tabble tbody tr.active-row {
	font-weight: bold;
	color: Grey;
}

#BT {
	height: 50px;
	width: 200px;
	background-clip: content-box;
	color: gray;
	border-radius: 5px;
	border-bottom-left-radius: inherit;
	font-size: 17px;
	font-style: oblique;
	overflow: hidden;
	border-radius: 5px 5px 0 0;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

#content-tabble th {
	background-color: red;
	font-size-adjust: none;
}

body h1 {
	font-style: italic;
	font-size: 30px;
}
</style>

</head>
<body>
	<nav class="main-header navbar navbar-expand navbar-white navbar-light">
		<!-- Left navbar links -->
		<ul class="navbar-nav">
			<li class="nav-item d-none d-sm-inline-block">
				<h1>Cotação</h1>
			</li>
		</ul>
	</nav>
	<aside class="main-sidebar sidebar-dark-primary elevation-4">
		<div class="sidebar">
			<nav class="mt-2">
				<ul class="nav nav-pills nav-sidebar flex-column"
					data-widget="treeview" role="menu" data-accordion="false">
					<li class="nav-item"><a
						href="Dashboard.jsp"
						class="nav-link"> <i class="nav-icon fas fa-home"></i>
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
						<table class="table table-head-fixed text-nowrap"
							id="content-tabble">
							<thead>
								<tr>
									<th>CODE</th>
									<th>NAME</th>
									<th>COMPRA</th>
									<th>Venda</th>
									<th>Maximo</th>
									<th>Minimo</th>
									<th>Diferença</th>
									<th>Variacao</th>
									<th>% Variacao</th>
								</tr>
							</thead>
							<tbody>
								<%
								for (int i = 0; i < lista.size(); i++) {
								%>
								<tr class="active-row">
									<td><%=lista.get(i).getCode()%></td>
									<td><%=lista.get(i).getName()%></td>
									<td><%=lista.get(i).getCompra()%></td>
									<td><%=lista.get(i).getVenda()%></td>
									<td><%=lista.get(i).getMaximo()%></td>
									<td><%=lista.get(i).getMinimo()%></td>
									<td><%=lista.get(i).getDiferenca_maxima_minima()%></td>
									<td><%=lista.get(i).getVariacao()%></td>
									<td><%=lista.get(i).getPorcentagem_de_variacao()%></td>
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
				<button type="button" class="btn btn-default" id="BT"
					data-toggle="modal" data-target="#modal-xl">Franco Suiço</button>
				<button type="button" class="btn btn-default" id="BT"
					data-toggle="modal" data-target="#modal-xl">Peso Argentino</button>
				<button type="button" class="btn btn-default" id="BT"
					data-toggle="modal" data-target="#modal-xl">Euro</button>
				<button type="button" class="btn btn-default" id="BT"
					data-toggle="modal" data-target="#modal-xl">Dolar
					Comercial</button>
				<button type="button" class="btn btn-default" id="BT"
					data-toggle="modal" data-target="#modal-xl">Dolar
					Canadense</button>
				<button type="button" class="btn btn-default" id="BT"
					data-toggle="modal" data-target="#modal-xl">Dolar Turismo</button>
				<button type="button" class="btn btn-default" id="BT"
					data-toggle="modal" data-target="#modal-xl">Bitcoin</button>
				<button type="button" class="btn btn-default" id="BT"
					data-toggle="modal" data-target="#modal-xl">Dolar
					Australiano</button>
				<button type="button" class="btn btn-default" id="BT"
					data-toggle="modal" data-target="#modal-xl">Novo Shekel
					Israelense</button>
				<button type="button" class="btn btn-default" id="BT"
					data-toggle="modal" data-target="#modal-xl">Iene Japonês</button>
				<button type="button" class="btn btn-default" id="BT"
					data-toggle="modal" data-target="#modal-xl">Libra
					Esterlina</button>
				<button type="button" class="btn btn-default" id="BT"
					data-toggle="modal" data-target="#modal-xl">Ripple</button>
				<button type="button" class="btn btn-default" id="BT"
					data-toggle="modal" data-target="#modal-xl">Ethereum</button>
				<button type="button" class="btn btn-default" id="BT"
					data-toggle="modal" data-target="#modal-xl">Litecoin</button>
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
						<table class="table table-head-fixed text-nowrap"
							id="content-tabble">
							<thead>
								<tr class="active-row">
									<th>CODE</th>
									<th>NAME</th>
									<th>COMPRA</th>
									<th>Venda</th>
									<th>Maximo</th>
									<th>Minimo</th>
									<th>Diferenca_maxima_minima</th>
									<th>Variacao</th>
									<th>Porcentagem_de_variacao</th>
								</tr>
							</thead>
							<tbody>
								<%
								for (int i = 0; i < umaMoeda.size(); i++) {
								%>
								<tr>
									<td><%=lista.get(i).getCode()%></td>
									<td><%=lista.get(i).getName()%></td>
									<td><%=lista.get(i).getCompra()%></td>
									<td><%=lista.get(i).getVenda()%></td>
									<td><%=lista.get(i).getMaximo()%></td>
									<td><%=lista.get(i).getMinimo()%></td>
									<td><%=lista.get(i).getDiferenca_maxima_minima()%></td>
									<td><%=lista.get(i).getVariacao()%></td>
									<td><%=lista.get(i).getPorcentagem_de_variacao()%></td>
								</tr>
								<%
								}
								%>

							</tbody>
						</table>
					</div>
					<div class="modal-footer justify-content-between">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	</div>
	

<footer class="main-footer">
    <strong>Copyright © 2021 <a href="https://github.com/GabrielRinaldin/inFomoney"> GitHub</a>.</strong>
    All rights reserved.
    <div class="float-right d-none d-sm-inline-block">
      <b>Version</b> 3.1.0
    </div>
  </footer>
	
</body>
</html>