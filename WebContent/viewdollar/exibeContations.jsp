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

 <link rel="stylesheet" href="style.css">
<title >Insert title here</title>

<style type="text/css">

#tabela {
	
	margin-top: 30px;
	border-collapse: collapse;
}
#tabela th {
	border: 1px solid #ddd;
	padding: 10px;
	text-align: left;
	background-color: #66bbff;
	color: #fff;	
}

#tabela td{

border: 1px solid #ddd;
	padding: 10px;
}



</style>
</head>
<body>
<center>
	<h1>Resultado</h1>
	<table id="tabela">
		<thead>
			<tr>
				<th>CODE</th>
				<th>CODEIN</th>
				<th>NAME</th>
				<th>HIGH</th>
				<th>LOW</th>
				<th>VARBID</th>
				<th>ASK</th>
				<th>PCTCHANGE</th>
				<th>BID</th>
				<th>TIMESTAMP</th>
				<th>CRIATEDATE</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>		
				<td><%=lista.get(i).getCode()%></td>
				<td><%=lista.get(i).getCodein()%></td>
				<td><%=lista.get(i).getName()%></td>
				<td><%=lista.get(i).getHigh()%></td>
				<td><%=lista.get(i).getLow()%></td>
				<td><%=lista.get(i).getVarBid()%></td>
				<td><%=lista.get(i).getAsk()%></td>
				<td><%=lista.get(i).getPctChange()%></td>
				<td><%=lista.get(i).getBid()%></td>
				<td><%=lista.get(i).getTimestamp()%></td>
				<td><%=lista.get(i).getCreate_date()%></td>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>
	<br><br>
	<form action="index.html">
	      <input type="submit" value="voltar">
	</form>
	</center>
</body>
</html>