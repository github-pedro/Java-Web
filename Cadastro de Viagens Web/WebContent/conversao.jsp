<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Conversao de Moedas</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="css-script/converter.js"></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<style>
.container {
width: 100vw;
height: 100vh;
background: url(css-script/aviao2.jpg);
background-repeat: no-repeat;
display: flex;
flex-direction: row;
justify-content: center;
align-items: center
}
html, body{
   margin:0px !important;
   padding: 0px !important;
}
</style>

</head>
<body>
	<div class="container">
		<div class="list-group">
			<a class="list-group-item list-group-item-action active"
				style="background-color: #74b9ff; border: #74b9ff"> CONVERSÃO DE
				MOEDA </a> 

				<input class="list-group-item list-group-item-action" placeholder="Digite o Valor" id="entrada"
				type="number"> 
				
				<select class="list-group-item list-group-item-action" id="moedas">
				<option value='NULL'>Selecione a Moeda</option>
				<option value='EUR'>Euro</option>
				<option value='USD'>Dólar</option>
				<option value='USDT'>Dólar turismo</option>
				<option value='CAD'>Dólar canadense</option>
				<option value='AUD'>Dólar australiano</option>
				<option value='GBP'>Libra Esterlina</option>
				<option value='ARS'>Peso argentino</option>
				<option value='JPY'>Iene Japonês</option>
				<option value='CNY'>Yuan Chinês</option>
				<option value='CHF'>Franco Suíço</option>
				<option value='ILS'>Novo Shekel Israelense</option>
				<option value='BTC'>Bitcoin</option>
				<option value='ETH'>Ethereum</option>
				<option value='LTC'>Litecoin</option>
				<option value='DOGE'>Dogecoin</option>
				<option value='XRP'>XRP</option>
			</select>
			<button onclick="converter()" class="list-group-item list-group-item-action" style="background-color: #74b9ff; color:white; text-align: center">Calcular</button>
			<a href="index.jsp" class="list-group-item list-group-item-action" style="background-color: #74b9ff; color:white; text-align: center">Voltar</a>
			<div class="list-group-item list-group-item-action">
			      <h3 id="saida" ></h3> 
			      <span id="atualizacao"></span>
			</div>
			  
			
		</div>
	</div>
</body>
</html>