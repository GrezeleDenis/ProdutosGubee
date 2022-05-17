<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="model.JavaBeans"%>
    <%@ page import="java.util.ArrayList" %>
    <%
    	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produtos");
    %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="icon" href="imagens/listav.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Produtos disponíveis</h1>
	<a href="New.html" class="Botao1"> Novo produto </a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Codigo</th>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Mercado-Alvo</th>
				<th>Tecnologias</th>
			</tr>
		</thead>
		<tbody>
			<%for(int i = 0;i<lista.size();i++){ %>
				<tr>
					<td> <%=lista.get(i).getCodpro()%></td>
					<td><%=lista.get(i).getNomepro()%></td>
					<td><%=lista.get(i).getDescripro() %></td>
					<td><%=lista.get(i).getMercapro() %></td>
					<td><%=lista.get(i).getTecnopro() %></td>
				</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>