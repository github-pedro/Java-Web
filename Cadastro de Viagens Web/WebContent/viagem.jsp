<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="css-script/paises.js"></script>
<link rel="stylesheet" type="text/css" href="css-script/viagem.css">
<title>Cadastro de Viagem</title>
</head>
<body>

	<h1 class="titulo">Cadastrar Viagem</h1>
	<div class="conteiner" style="width: 20%; margin: auto">
		<form method="POST" action="ViagemController?acao=add">

			<div class="form-group">
				<label>O que planeja fazer?</label> <input type="text"
					class="form-control" id="planejamento" name="planejamento"
					placeholder="Ex: Viagem a Trabalho" maxlength="300" required>
			</div>

			<div class="form-group">

				<label>País Destino</label> <select class="form-control" id="pais"
					name="pais">
				</select> 
				<label id="campo_estado"> Estado <select id="estado" name="estado" ></select>
				</label> <label id="campo_cidade"> Cidade <select id="cidade" name="cidade" >
				</select>
				</label>
			</div>



			<div class="form-group">
				<label>Quanto pretende levar?</label> <input type="number"
					class="form-control" id="gasto" name="gasto" placeholder="Ex: 1500"
					required>
			</div>

			<div class="form-group">
				<label>Data de Saida</label> <input type="date" class="form-control"
					id="dataSaida" name="dataSaida" required>
			</div>
			<div class="form-group">
				<label>Data de Volta</label> <input type="date" class="form-control"
					id="dataVolta" name="dataVolta">
			</div>
			<div class="form-group">
				<label>Descreva o que pretende levar</label>
				<textarea class="form-control" rows="6" style="width: 26em"
					id="descricao" maxlength="300" name="descricao"></textarea>
			</div>
			<button type="submit" class="btn btn-primary" style="background-color: #74b9ff; border: #74b9ff">Cadastrar</button>
			<a href="index.jsp" class="btn btn-primary" role="button" aria-pressed="true" style="background-color: #74b9ff; border: #74b9ff">Voltar</a>
			
		</form>
	</div>
</body>
</html>