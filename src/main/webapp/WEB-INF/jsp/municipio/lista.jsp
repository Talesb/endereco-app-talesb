<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AppMIT Endereco</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2>Listagem de Mun�cipios</h2>
	  <hr>
		
	<c:if test="${not empty listamunicipios}">		
		<h2>Total de Munic�pios: ${listamunicipios.size()}</h2>
		  
		<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>ID</th>
		        <th>Nome</th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="m" items="${listamunicipios}">
			      <tr>
			        <td>${m.id}</td>
			        <td>${m.nome}</td>
			      </tr>
		      </c:forEach>		      
		    </tbody>
	  	</table>
    </c:if>	  	  

	<c:if test="${empty listamunicipios}">		
	  <h2>N�o existem Munic�pios!!!</h2>
	</c:if>

	</div>
</body>
</html>