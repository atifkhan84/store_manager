<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
	<link href="https://fonts.googleapis.com/css?family=Muli&display=swap">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
	body{
		background-color: #56d5c8;
		font-family: sans-serif;
	}
	h2{
		text-align: center;
		font-size: 40px;
		font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
		font-weight: 700;
		color: rgb(0, 0, 0);
	}

	#nostock-message {
		text-align: center;
		color: red;
		font-family: "Muli", sans-serif;
	}
	.table-container{
		height: 100%;
		width: 100%;
		display: flex;
		justify-content: center;
	}
	.table{
		width: 70%;
	}
	a, a:link, a:visited{
		text-decoration:none;
		color: white;
	}
	nav{
		text-align: center;
	}
	nav > *{
		text-align: center;
		font-size: 20px;
		font-weight: 600;
		background-color:  #d22346;
		padding: 7px;
		border-radius: 5px;
	}

	nav > *:hover {
		background-color: #000000;
	}
	.filter{
		display: flex;
		justify-content: center;
	}
	.filter-form{
		margin: 20px;
	}


</style>
<meta charset="ISO-8859-1">
<title>Stock</title>
</head>
<body>
	<c:set var="index" value="1"></c:set>
	<h2 style="text-align:center;">Stock</h2>
	<nav>
		<span><a href="/"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house" viewBox="0 0 16 16">
			<path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5ZM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5 5 5Z"/>
		  </svg>Home</a></span>
		  <a href="/sellProduct">Sell</a>
		  <a href="/purchaseProduct">Purchase</a>
		  <a href="/stockStatus">Stock</a>
		  <a href="/sales">Sales</a>
		  <a href="/productsPurchased">Products Purchased</a>
		
	</nav>
	<div>
		<div class="filter">
			<form class="filter-form" action="/stockBasedOnBrand" method="get">
				<label>Search by brand</label>
				<input type="text" name="brand" placeholder="Campus"/>
				<input type="submit" value="Search">
			</form>
			<form class="filter-form" action="/stockBasedOn" method="get">
				<label>Search by type</label>
				<input type="text" name="type" placeholder="Ex..Sandle"/>
				<input type="submit" value="Search">
			</form>
		</div>
	</div>

	<c:if test="${empty list}">
		<h3 id="nostock-message">No Stock Available</h3>
	</c:if>
	<c:if test="${not empty list}">
		<div class="table-container">
			<table class="table table-hover table-responsive table-dark">
				<tr>
					<th>Sl No</th>
					<th>Sell from Here</th>
					<th>ProductID</th>
					<th>Brand</th>
					<th>Size and Quantity</th>
				</tr>
				<c:forEach var="var" items="${list}">
					<tr>
						<td><c:out value="${i=i+1}"></c:out></td>
						<td><button onclick="location.href='/sellProductPage'" type="button">Sell</button></td>
						<td>${var[0]}</td>
						<td>${var[1]}</td>
						<td>${var[2]}</td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</c:if>
</body>
</html>