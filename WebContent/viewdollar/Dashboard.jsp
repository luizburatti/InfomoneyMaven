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
							'packages' : [ 'corechart' ]
						});
						google.charts.setOnLoadCallback(function() {
							drawChart(result), drawCurveTypes(result),
									drawChartPie(result),
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
						dataArray.push([ obj.name, obj.maximo, obj.maximo+'',
								obj.minimo, obj.minimo +'']);
					});
					data.addRows(dataArray);

					var options = {
						title : 'Diferença  entre cotações',
						width : 1600,
						height : 500,
					};
					var chart = new google.visualization.ColumnChart(document
							.getElementById('chart_div'));
					chart.draw(data, options);
				}

				function drawCurveTypes(result) {
					var dataLine = new google.visualization.DataTable();
					dataLine.addColumn('string', 'Name');
					dataLine.addColumn('number', 'Compra');
					var dataArray = [];
					$.each(result, function(i, obj) {
						dataArray.push([ obj.name, obj.compra, ]);
					});
					dataLine.addRows(dataArray);
					var options = {
						width : 1600,
						height : 500,
						hAxis : {
							title : 'Time'
						},
						vAxis : {
							title : 'Popularity'
						},
						series : {
							00 : {
								curveType : 'function'
							}
						}
					};

					var chart = new google.visualization.LineChart(document
							.getElementById('drawCurve'));
					chart.draw(dataLine, options);
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

					var options = {
						pieSliceText : 'value-and-percentage',
						title : 'Valores Convertidos (1 / Valor da moeda)',
						width : 1600,
						height : 500,
					};

					var chart = new google.visualization.PieChart(document
							.getElementById('drawChartPie'));
					chart.draw(dataLine, options);
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
						width : 1600,
						height : 500,
					};
					var chart = new google.visualization.ColumnChart(document
							.getElementById('drawChartVariacao'));
					chart.draw(data, options);
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
	<h1>Dashboard</h1>
	<div class="col-lg-12">
		<div id="chart_div" style="border: 1px solid #ccc"></div>
		<div id="drawCurve" style="border: 1px solid #ccc"></div>
		<div id="drawChartPie" style="border: 1px solid #ccc"></div>
		<div id="drawChartVariacao" style="border: 1px solid #ccc"></div>
	</div>
	<a href="dollar"><button id="btn" type="button"
			class="btn btn-danger">Voltar</button></a>
</body>
</html>
