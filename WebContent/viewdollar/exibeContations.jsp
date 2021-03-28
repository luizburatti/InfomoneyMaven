<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="entity.Moeda"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Moeda> lista = (ArrayList<Moeda>) request.getAttribute("teste");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/js/adminlte.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/css/adminlte.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
<nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="../../index3.html" class="nav-link">Home</a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="#" class="nav-link">Contact</a>
      </li>
    </ul>
  </nav>
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <!-- Sidebar -->
    <div class="sidebar">

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-home"></i>
              <p>
                Dashboard
              </p>
            </a>
          </li>

          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-users"></i>
              <p>
                Moedas
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item has-treeview">
                <a href="#" class="nav-link">
                  <i class="nav-icon fas fa-plus"></i>
                  <p>
                    Dolar
                  </p>
                </a>
              </li>
              <li class="nav-item has-treeview">
                <a href="#" class="nav-link">
                  <i class="nav-icon fas fa-list"></i>
                  <p>
                   Euro
                  </p>
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </nav>
    </div>
  </aside>
  	<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">Cotações</h3>
				</div>
				<!-- /.card-header -->
				<div class="card-body table-responsive p-0" style="height: 672px;">
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
	</div>
	</div>
	<form action="index.html">
		<input class="btn btn-info" type="submit" value="voltar">
	</form>
</body>
</html>