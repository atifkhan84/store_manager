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
		font-size: 40px;
		font-weight: bolder;
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
</style>
<meta charset="ISO-8859-1">
<title>Stock</title>
</head>
<body>
	<h2 style="text-align:center;">Stock</h2>
	<c:if test="${empty stockList}">
	
		<h3 id="nostock-message">No Stock Available</h3>
	
	</c:if>
	<c:if test="${not empty stockList}">
		<div class="table-container">
			<table class="table table-hover table-responsive table-dark">
				<tr>
					<th>Sell from Here</th>
					<th>ProductID</th>
					<th>Brand</th>
					<th>Description</th>
					<th>Size</th>
					<th>Quantity</th>
				</tr>
				<c:forEach var="var" items="${stockList}">
					<tr>
						<td><button onclick="location.href='/sellProductPage'" type="button">Sell</button></td>

						<td>${var.productId}</td>
						<td>${var.brand}</td>
						<td>${var.description}</td>
						<td>${var.size}</td>
						<td>${var.quantity}</td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</c:if>
</body>
</html>


<h4>${message}</h4>
			<p>${"Atif"}</p>
			<p><c:out value="${10*12}"></c:out></p>