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
	$(document)
			.ready(
					function() {
						$.ajax({
							url : "DASH",
							dataTYPE : "JSON",
							success : function(result) {
								google.charts.load('current', {
									'packages' : [ 'corechart' ]
								});
								google.charts.setOnLoadCallback(function() {
									drawChart(result);
								});
							}
						});

						function drawChart(result) {

							var data = new google.visualization.DataTable();
							data.addColumn('string', 'Name');
							data.addColumn('number', 'High');
							data.addColumn('number', 'Low');
							var dataArray = [];
							$.each(result,
									function(i, obj) {
										dataArray.push([ obj.name, obj.high,
												obj.low ]);
									});

							data.addRows(dataArray);

							var piechart_options = {
								title : 'Maior e menor valores entre cotações atualmente.',
								width : 500,
								height : 500
							};
							var piechart = new google.visualization.PieChart(
									document.getElementById('piechart_div'));
							piechart.draw(data, piechart_options);

							var barchart_options = {
								title : 'Diferença  entre cotações MÁXIMO/MÍNIMO "Do dia" ',
								width : 500,
								height : 500,
								legend : 'none'
							};
							var barchart = new google.visualization.BarChart(
									document.getElementById('barchart_div'));
							barchart.draw(data, barchart_options);
						}

					});
</script>
<style type="text/css">
body {
	background-color: black;
}
body h1 {
	font-style: italic;
	color: white;
	text-align: center;
}
</style>
</head>
<body>

	<h1>Dashboard</h1>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<table class="columns">
					<tr>
						<td><div id="piechart_div" style="border: 1px solid #ccc"></div></td>
						<td><div id="barchart_div" style="border: 1px solid #ccc"></div></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<a href="http://localhost:8081/infomoney/viewdollar/dollar"><button
			id="btn" type="button" class="btn btn-danger">Voltar</button></a>
</body>
</html>
