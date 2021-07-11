<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.alura.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Empresas</title>
</head>
<body>

	<c:import url="logout-parcial.jsp"/>

	Usuário Logado: ${ usuarioLogado.login }
	<br>
	<br>
	<br>
   
    <c:if test="${not empty nomeEmpresa}">
            Empresa ${ nomeEmpresa } cadastrada com sucesso!
    </c:if>

	<h1>Lista de Empresas</h1>
   		
   		<a href="/gerenciador/entrada?acao=NovaEmpresaForm">Nova Empresa</a>
   		
    <ul>
        <c:forEach items="${empresas}" var="empresa">
            <li>
            	${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" /> 
            	<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">editar</a>
            	<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remove</a> 
            </li>
        </c:forEach>
    </ul>

</body>
</html>