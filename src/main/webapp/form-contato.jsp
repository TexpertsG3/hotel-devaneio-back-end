<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hotel Devaneio</title>
</head>
<body>
	<head>Cadastro de Contato</head> <br/><br/>

	<form action="/hotel-devaneio/cadastraContato" method="POST">
	
	<b>Email: </b><input type="text" name="email" /> <br/><br/>
	<b>Telefone: </b><input type="text" name="telefone" /><br/><br/>
	<b>Celular: </b><input type="text" name="celular" /><br/><br/>
	<input type="submit" name="Cadastrar" />
	</form>
	<br />
	<br />
	<a href="/hotel-devaneio/form-contato">Voltar</a>
	
</body>
</html>