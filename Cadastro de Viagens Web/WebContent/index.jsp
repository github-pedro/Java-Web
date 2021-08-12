<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<!-- Adicionei o Style no proprio html por bugs por parte do eclipse. -->

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
.btn btn-outline-primary{
  display: block; 
}
</style>

<title>Planejador de Viagens</title>

</head>
<body>
	<div class="container">
  <div class="list-group">
  <a  class="list-group-item list-group-item-action active" style="background-color: #74b9ff; border: #74b9ff">
    PLANEJADOR DE VIAGEM
  </a>
  <a href="viagem.jsp" class="list-group-item list-group-item-action">Planejar Viagem</a>
  <a href="ViagemController?acao=lis" class="list-group-item list-group-item-action">Minhas Viagens</a>
  <a href="conversao.jsp" class="list-group-item list-group-item-action">Conversão de Moeda</a>
  
</div>
</div>
</body>
</html>