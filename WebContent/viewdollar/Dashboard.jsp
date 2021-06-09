<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DASHBOARD</title>

<script
	src="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/js/adminlte.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/css/adminlte.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

<!--                                   JAVA SCRIPT                    -->

<script type="text/javascript"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>


<script type="text/javascript">
	$(document).ready(
			function() {
				$.ajax({
					url : "dashboard",
					dataTYPE : "JSON",
					success : function(result) {
						google.charts.load('current', {
							'packages' : [ 'corechart', 'table' ]
						});
						google.charts.setOnLoadCallback(function() {
							drawChart(result), drawChartPie(result),
									drawChartVariacao(result);
						});

					}
				});

				function drawChart(result) {
					var data = new google.visualization.DataTable();
					data.addColumn('string', 'Name');
					data.addColumn('number', 'Maximo');
					data.addColumn({
						role : 'annotation'
					});
					data.addColumn('number', 'Minimo');
					data.addColumn({
						role : 'annotation'
					});
					var dataArray = [];
					$.each(result, function(i, obj) {
						dataArray.push([ obj.name, obj.maximo, obj.maximo + '',
								obj.minimo, obj.minimo + '' ]);
					});
					data.addRows(dataArray);

					var options = {
						title : 'Diferença  entre cotações',
					};
					var chart = new google.visualization.ColumnChart(document
							.getElementById('chart_div'));
					chart.draw(data, options);
				}

				function drawChartPie(result) {

					var dataLine = new google.visualization.DataTable();
					dataLine.addColumn('string', 'Name');
					dataLine.addColumn('number', 'Valor Convertido');
					var dataArray = [];
					$.each(result, function(i, obj) {
						dataArray.push([ obj.name, obj.valor_convertido, ]);
					});
					dataLine.addRows(dataArray);

					var chart = new google.visualization.Table(document
							.getElementById('drawChartPie'));
					chart.draw(dataLine, {
						showRowNumber : true,
						width : '100%',
						height : '100%'
					});
				}

				function drawChartVariacao(result) {
					var data = new google.visualization.DataTable();
					data.addColumn('string', 'Name');
					data.addColumn('number', 'Variacao');
					data.addColumn({
						role : 'style'
					});
					data.addColumn({
						role : 'annotation'
					});
					var dataArray = [];
					$.each(result, function(i, obj) {
						var pct = obj.porcentagem_de_variacao;
						if (pct < 0) {
							dataArray.push([ obj.name, pct, 'color: red',
									pct + '%' ]);
						} else {
							dataArray.push([ obj.name, pct, 'color: green',
									pct + '%' ]);
						}
					});
					data.addRows(dataArray);

					var options = {
						legend : 'none',
						title : 'Variação do Dia em %',
					};
					var chart = new google.visualization.ColumnChart(document
							.getElementById('drawChartVariacao'));
					chart.draw(data, options);
				}

			});
</script>


<script type="text/javascript">
	$(document).ready(
			function() {
				$.ajax({
					url : "request",
					dataTYPE : "JSON",
					success : function(result) {
						google.charts.load('current', {
							'packages' : [ 'table' ]
						});
						google.charts.setOnLoadCallback(function() {
							drawTable(result);
						});
						console.log(result);
					}
				});

				function drawTable(result) {
					console.log(result);
					var dataLine = new google.visualization.DataTable();
					dataLine.addColumn('string', 'Name');
					dataLine.addColumn('number', 'Contagem de Requisições');
					var dataArray = [];
					$.each(result, function(i, obj) {
						dataArray.push([ obj.code, obj.request, ]);
					});
					dataLine.addRows(dataArray);

					var chart = new google.visualization.Table(document
							.getElementById('drawTable'));
					chart.draw(dataLine, {
						showRowNumber : true,
						width : '100%',
						height : '100%'
					});
				}

			});
</script>

<style type="text/css">
body h1 {
	font-style: italic;
	color: white;
	text-align: center;
}
</style>
</head>
<body>
	<nav class="main-header navbar navbar-expand navbar-white navbar-light">
		<!-- Left navbar links -->
		<ul class="navbar-nav">
			<li class="nav-item d-none d-sm-inline-block">
				<h1>Gráficos</h1>
			</li>
		</ul>
	</nav>
	<aside class="main-sidebar sidebar-dark-primary elevation-4">
		<div class="sidebar">
			<nav class="mt-2">
				<ul class="nav nav-pills nav-sidebar flex-column"
					data-widget="treeview" role="menu" data-accordion="false">
					<li class="nav-item"><a href="dollar" class="nav-link"> <i
							class="nav-icon fas fa-home"></i>
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

			<h1>Dashboard</h1>
			<div class="col-12">
					<div class="row">
			
				<div class="col-12" id="chart_div" style="border: 1px solid #ccc"></div>
				<div class="col-6" id="drawChartPie" style="border: 1px solid #ccc"></div>
				<div class="col-6" id="drawTable" style="border: 1px solid #ccc"></div>
				<div class="col-12" id="drawChartVariacao"
					style="border: 1px solid #ccc"></div>
			</div>


		</div>
	</div>
	<br>
	<br>
	<footer class="main-footer" >
		<strong>Copyright © 2021 <a
			href="https://github.com/GabrielRinaldin/inFomoney"> GitHub</a>.
		</strong> All rights reserved.
		<div class="float-right d-none d-sm-inline-block">
			<b>Version</b> 3.1.0
		</div>
	</footer>
</body>
</html>
