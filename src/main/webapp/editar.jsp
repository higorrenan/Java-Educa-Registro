<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edição-Contato</title>
<link rel="icon"
	href="https://th.bing.com/th/id/R.d1bbedc1e9b75d363860984876b6a527?rik=dXZyt3cnsqWsRg&riu=http%3a%2f%2fpensaraeducacao.com.br%2fpensaraeducacaoempauta%2fwp-content%2fuploads%2fsites%2f8%2f2020%2f08%2fGlobal-compact-on-education.jpg&ehk=gjl4k2fFHyXpnIgS4qhIQDWtyfaCXHtQWZ17hZ3gEeI%3d&risl=&pid=ImgRaw&r=0">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="editar-box">
		<form name="frmContato" action="update">
			<h2>Editar contato</h2>
			
			<div class="caixa-box">

				<input type="text" name="id_contato" style="color: #ff0000" readonly="readonly" value="<%out.print(request.getAttribute("id_contato"));%>">
			</div>
			
			<div class="caixa-box">

				<input type="text" name="nome_contato" value="<%out.print(request.getAttribute("nome_contato"));%>">
			</div>

			<div class="caixa-box">

				<input type="tel" name="fone_contato" value="<%out.print(request.getAttribute("fone_contato"));%>">
				
			</div>

			<div class="caixa-box">

				<input type="email" name="email_contato" value="<%out.print(request.getAttribute("email_contato"));%>">

			</div>

			<div class="neon-botao"> 			
				<button type="button" class=""
				onclick="validar()">Salvar </button>
			</div>
			
	
		</form>
	</div>
	<script type="text/javascript" src="scripts/validador.js"></script>
</body>
</html>