<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("registros");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Registro-contatos</title>
<link rel="icon"
	href="https://th.bing.com/th/id/R.d1bbedc1e9b75d363860984876b6a527?rik=dXZyt3cnsqWsRg&riu=http%3a%2f%2fpensaraeducacao.com.br%2fpensaraeducacaoempauta%2fwp-content%2fuploads%2fsites%2f8%2f2020%2f08%2fGlobal-compact-on-education.jpg&ehk=gjl4k2fFHyXpnIgS4qhIQDWtyfaCXHtQWZ17hZ3gEeI%3d&risl=&pid=ImgRaw&r=0">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="topo">
		<div align="center" style="margin-bottom: 15px">
			<a href="cadastro.html" class="botao" >Novo contado</a> 
			<a href="index.html" class="botao">voltar</a>
		</div>
	</div>
	<table>
		<thead class="cabecelho-tabela">

			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>E-mail</th>
				<th>Opção</th>
			</tr>

		</thead>
		<tbody class="informaçao-tabela">
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td>
					<%=lista.get(i).getId_contato()	%>
				</td>
				<td><%=	lista.get(i).getNome_contato()%>
				</td>
				<td><%=lista.get(i).getFone_contato()%>
				</td>
				<td><%=lista.get(i).getEmail_contato()%>
				</td>
				<td> <a href="select?idcon=<%=lista.get(i).getId_contato()%>" class="botao-registro"> 					
						Editar	
					</a>
					<a href="javascript: confirmar(<%=lista.get(i).getId_contato()%>)" class="botao-registro"> 					
						Excluir	
					</a>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>

	</table>

	<script type="text/javascript" src="scripts/confirmador.js"></script>
</body>
</html>