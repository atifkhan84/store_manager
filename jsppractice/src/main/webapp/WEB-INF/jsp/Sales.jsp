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

	#noproductsold-message {
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
<title>Products Sold</title>
</head>
<body>
	<h2 style="text-align:center;">Sales Records</h2>
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
			<!-- <form class="filter-form" action="/stockBasedOnBrand" method="get">
				<label>Search by brand</label>
				<input type="text" name="brand" placeholder="Campus"/>
				<input type="submit" value="Search">
			</form> -->
			<!-- <form class="filter-form" action="/stockBasedOn" method="get">
				<label>Search by type</label>
				<input type="text" name="type" placeholder="Ex..Sandle"/>
				<input type="submit" value="Search">
			</form> -->
			<form class="filter-form" action="/salesBasedOnDate" method="get">
				<label>Search by date</label>
				<input type="date" name="date"/>
				<input type="submit" value="Search">
			</form>
		</div>
	</div>
	<c:if test="${empty salesList}">
	
		<h3 id="noproductsold-message">No Products Sold</h3>
	
	</c:if>
	<c:if test="${not empty salesList}">
		<div class="table-container">
			<table class="table table-hover table-responsive table-dark">
				<tr>
					<th>Sl No.</th>
					<th>ProductID</th>
					<th>Brand</th>
					<th>Size</th>
					<th>Quantity</th>
					<th>Price Sold</th>
					<th>Profit/Loss</th>
					<th>Description</th>
					<th>Payment Mode</th>
					<th>Sales DateTime</th>
				</tr>
				
				<c:set var="totalsalesamt" value="0"></c:set>
				<c:set var="totalprofit" value="0"></c:set>
				<c:set var="totalquantitysold" value="0"></c:set>

				<c:forEach var="var" items="${salesList}">
					<tr>
						<td>${i = i + 1}</td>
						<td>${var.productId}</td>
						<td>${var.brand}</td>
						<td>${var.size}</td>
						<td>${var.quantity}</td>
						<td>${var.sellingPrice}</td>
						<td>${var.profitLoss}</td>
						<td>${var.description}</td>
						<td>${var.paymentMode}</td>
						<td>${var.salestimestamp}</td>
						<input type="hidden" value="${totalsalesamt = totalsalesamt + var.sellingPrice}">
						<input type="hidden" value="${totalquantitysold = totalquantitysold + 1}">
						<input type="hidden" value ="${totalprofit = totalprofit + var.profitLoss}">
					</tr>
				</c:forEach>
		

				<!-- <c:forEach items="${salesList}" var="list">
					${totalsalesamt = totalsalesamt + 1}
				</c:forEach> -->
				<tr>
					<th colspan="2">Total</th>
					<td></td>
					<td></td>
					<th>
						<c:out value="${totalquantitysold}"></c:out>
					</th>
					<th>
						<c:out value="Rs. ${totalsalesamt}"></c:out>
					</th>
					<th>
						<c:out value="Rs.${totalprofit}"></c:out>
					</th>
					<td></td>
					<td></td>
					<th></th>
				</tr>
			</table>
		</div>
	</c:if>
</body>
</html>