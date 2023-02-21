<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
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
	h3{
		margin-top: 40px;
		text-align: center;
		color:red;
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
	.table-container {
		margin-top: 20px;
	}


</style>
<meta charset="ISO-8859-1">
<title>All Products</title>
</head>
<body>
	<c:set var="index" value="0"></c:set>
	<h2 style="text-align:center;">Purchase Records</h2>
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
	<c:if test="${empty productList}">
	
		<h3>No products purchased</h3>
	
	</c:if>
	<c:if test="${not empty productList}">
		<div class="table-container">
			<table class="table table-hover table-responsive table-dark">
				<tr>
					<th>Slno</th>
					<th>ProductID</th>
					<th>Brand</th>
					<th>Discount%</th>
					<th>MRP</th>
					<th>Size</th>
					<th>Quantity</th>
					<th>Description</th>
					<th>SupplierID</th>
					<th>Payment Status</th>
					<th>Payment TimeStamp</th>
				</tr>

				<c:set var="totalPurchaseAmt" value="0"></c:set>
				<c:set var="totalQuantityPurchased" value="0"></c:set>

				<c:forEach var="var" items="${productList}">
					<tr>
						<td><c:out value="${index=index+1}"></c:out></td>
						<td>${var.productId}</td>
						<td>${var.brand}</td>
						<td>${var.discount}</td>
						<td>${var.mrp}</td>
						<td>${var.size}</td>
						<td>${var.quantity}</td>
						<td>${var.description}</td>
						<td>${var.supplierId}</td>
						<td>${var.payment_status}</td>
						<td>${var.purchase_timestamp}</td>
						<input type="hidden" value="${totalPurchaseAmt = totalPurchaseAmt + var.mrp}">
						<input type="hidden" value="${totalQuantityPurchased = totalQuantityPurchased + var.quantity}">
					</tr>
				</c:forEach>
				<tr>
					<th colspan="2">Total</th>
					<td></td>
					<td></td>
					<th>
						<c:out value="Rs.${totalPurchaseAmt}"></c:out>
					</th>
					<th>
					</th>
					<th>
						<c:out value="${totalQuantityPurchased}"></c:out>
					</th>
					<td></td>
					<td></td>
					<td></td>
					<th></th>
				</tr>
			</table>
		</div>
	</c:if>
</body>
</html>