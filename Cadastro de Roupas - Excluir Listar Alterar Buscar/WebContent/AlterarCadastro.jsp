<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Akaya+Telivigala&family=Pacifico&display=swap');
</style>
<title>AlterarCadastro</title>
</head>
<body>
	<h1 style="text-align: center; font-family: 'Pacifico', cursive;
    font-size: 50px;
    color:brown;
    text-shadow: 2px 2px 2px rgba(0,0,0,0.5);">Alterar Cadastro</h1>
	<div class="conteiner" style="width: 20%; margin: auto">
		<form method="POST" action="RoupaController?acao=alt">

			<div class="form-group">
				<label>Id:</label> <input type="text" class="form-control" name="id"
					id="id" value="${roupaAlt.getId()}" readonly="true">
			</div>
			<div class="form-group">
				<label>Tipo</label> <select class="form-control" id="tipo"
					name="tipo" required>
					<option selected disabled value="">${roupaAlt.getTipo()}</option>
					<option>Cueca</option>
					<option>Camiseta</option>
					<option>Bermuda</option>
					<option>Moletom</option>
					<option>Cal?a</option>
				</select>
			</div>
			<div class="form-group">
				<label>Marca</label> <input type="text"
					value="${roupaAlt.getMarca()}" class="form-control" id="marca"
					name="marca" maxlength="40" required>
			</div>
			<div class="form-group">
				<label>Qntd. Estoque</label> <input type="number"
					value="${roupaAlt.getEstoque()}" class="form-control" id="estoque"
					name="estoque" required>
			</div>
			<div class="form-group">
				<label>Unidade de Medida</label> <select class="form-control"
					id="medida" name="medida" required>
					<option selected disabled value="">${roupaAlt.getMedida()}</option>
					<option>P</option>
					<option>M</option>
					<option>G</option>
					<option>GG</option>
				</select>
			</div>
			<div class="form-group">
				<label>Valor Compra</label> <input type="number"
					value="${roupaAlt.getVcompra()}" class="form-control" id="vcompra"
					name="vcompra" required>
			</div>
			<div class="form-group">
				<label>Valor Venda</label> <input type="number"
					value="${roupaAlt.getVvenda()}" class="form-control" id="vvenda"
					name="vvenda" required>
			</div>
			<button type="submit" class="btn btn-primary">Salvar</button>
		</form>
	</div>
</body>
</html>