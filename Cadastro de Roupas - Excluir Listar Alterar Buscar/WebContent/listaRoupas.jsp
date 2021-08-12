<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Lista de Roupas</title>
</head>
<body>
	<div class="form-group input-group">
		<form method="GET" action="FiltrarController">
			<input name="consulta" id="consulta" placeholder="Filtrar"
				type="text" class="form-control" >
			<button type="submit" class="btn btn-primary" >Filtrar</button>
		</form>
	</div>

	<table id="tabela" class="table table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>Tipo</th>
				<th>Marca</th>
				<th>Estoque</th>
				<th>Medida</th>
				<th>Valor Compra</th>
				<th>Valor Venda</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items= "${RoupaModel}" var = "roupa">
				<tr>
					<th>${roupa.getId()}</th>
					<td>${roupa.getTipo()}</td>
					<td>${roupa.getMarca()}</td>
					<td>${roupa.getEstoque()}</td>
					<td>${roupa.getMedida()}</td>
					<td>${roupa.getVcompra()}</td>
					<td>${roupa.getVvenda()}</td>
					<th><a href="RoupaController?acao=ex&id=${roupa.getId()}">Excluir</a>
					<th><a href="RoupaController?acao=alterar&id=${roupa.getId()}">Alterar</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>