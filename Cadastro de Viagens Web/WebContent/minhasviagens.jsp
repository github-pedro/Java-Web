<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="css-script/viagem.js"></script>
<link rel="stylesheet" type="text/css"
	href="css-script/minhasviagens.css">
<title>Minhas Viagens</title>
</head>
<body>
	<div id="top" class="row">
		<div class="col-md-3" style="left: 10px">
			<h2>Viagens</h2>
		</div>

		<div class="col-md-6">
			<div class="input-group h2" >
				<form method="GET" action="FiltrarController" style="width: 600px; position: absolute">
					<input name="consulta" class="form-control" id="consulta"
						type="text" placeholder="Pesquisar Viagens">
					<button class="btn btn-primary" type="submit"
							style="background-color: #74b9ff; position: absolute">
							<span class="glyphicon glyphicon-search"></span>
					</button>
				</form>
			</div>
		</div>

		<div class="col-md-3" style="right: 20px">
			<a href="viagem.jsp" class="btn btn-primary pull-right h2"
				style="background-color: #74b9ff;">Nova Viagem</a>
			<a href="index.jsp" class="btn btn-primary pull-right h2" style="background-color: #74b9ff;"  role="button" aria-pressed="true">Voltar</a>
		</div>
	</div>
	<div id="list" class="row">

		<div class="table-responsive col-md-12" style="top: 20px">
			<table class="table table-striped" cellspacing="0" cellpadding="0">
				<thead>
					<tr>
						<th>ID</th>
						<th>Planejamento</th>
						<th>Destino</th>
						<th>Estado</th>
						<th>Cidade</th>
						<th>Data Saida</th>
						<th>Data Volta</th>
						<th>Gasto</th>
						<th>Descrição</th>
						<th class="actions">Ações</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ViagemModel}" var="viagem">
						<tr>
							<td>${viagem.getId()}</td>
							<td>${viagem.getPlanejamento()}</td>
							<td>${viagem.getDestino()}</td>
							<td>${viagem.getEstado()}</td>
							<td>${viagem.getCidade()}</td>
							<td>${viagem.getDataSaida()}</td>
							<td>${viagem.getDataVolta()}</td>
							<td>${viagem.getGasto()}</td>
							<td>${viagem.getDescricao()}</td>
							<td class="actions"><a class="btn btn-warning btn-xs"
								href="ViagemController?acao=alterar&id=${viagem.getId()}">Editar</a>
								<a class="btn btn-danger btn-xs"
								href="ViagemController?acao=ex&id=${viagem.getId()}" onclick="return confirm('Deseja mesmo excluir esta Viagem?');">Excluir</a>
								</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>