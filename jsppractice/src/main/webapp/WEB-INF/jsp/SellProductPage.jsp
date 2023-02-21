<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	 <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" crossorigin="anonymous"> -->

	<meta charset="ISO-8859-1">
	
	
<title>Sell</title>
<style>
	*{
		box-sizing: border-box;
		font-family: sans-serif;
	}
	h2{
		text-align: center;
		font-size: 40px;
		font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
		font-weight: 700;
		color: rgb(0, 0, 0);
	}
	body{
		background-color: #3daa66;
	}
	.container{
		display: flex;
		height: 100%;
		width: 100%;
		justify-content: center;
		color: rgb(0, 0, 0);
	}

	.form-container{
		margin: 20px;	
		display: flex;
		width: 600px;
		background-color: rgb(249, 240, 240);
		flex-flow: column;
		border-radius: 20px;
		padding: 20px 40px;	
	}

	.form-item{
		width: 100%;
		display: flex;
		justify-content: space-between;
		align-items: stretch;
		/* background-color: pink; */
	}
	#select option{
		width:350px;   
	}
	input[type='number']{
    	width: 50px;
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
	h4{
		font-weight: 700;
		font-size: 20px;
	}
	.price-fields{
		display: flex;
		align-items: center;
		align-content: center;
		justify-content: space-between;
	}
	.price-fields>input {
		width: 55px;
	}
	.input-form{
		margin: 10px;
	}
	.form{
		display: flex;
		flex-flow: column;
		row-gap: 25px;
	}
	.search-form{
		margin: 0px 10px;
		display: flex;
		flex-direction: column;
		row-gap: 10px;
	}
	.sizeandquantity>select{
		width: 50px;
	}
	.submit{
		text-align: center;
	}
	input[type="submit"]{
		background-color:#0d6efd;
		border: none;
		padding: 3px 10px;
		border-radius: 5px;
		color: white;
	}
	.submit>input[type="submit"]{
		background-color:#0d6efd;
		font-size: 20px;
		border: none;
		padding: 10px 30px;
		border-radius: 5px;
	}
	.submit>input[type="submit"]:hover{
		background-color: #1155ba;
	}

	#outOfStock{
		color: red;
		text-align: center;
		font-style: italic;
		font-size: 15px;
	}
	#available{
		font-size: 15px;
		color: rgb(34, 177, 34);
		text-align: center;
		font-style: italic;
	}
	#doesNotExit{
		font-size: 15px;
		color: red;
		text-align: center;
		font-style: italic;
	}
	.success {
		text-align: center;
		font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
		background-color: #2d871b;
		font-size: 20px;
		color: white;
	}



</style>
</head>
<body>
	<h2>Sell</h2>
	<nav>
		<a href="/"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house" viewBox="0 0 16 16">
			<path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5ZM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5 5 5Z"/>
		  </svg>Home</a>
		  <a href="/sellProduct">Sell</a>
		  <a href="/purchaseProduct">Purchase</a>
		  <a href="/stockStatus">Stock</a>
		  <a href="/sales">Sales</a>
		  <a href="/productsPurchased">Products Purchased</a>
	</nav>
	<div class="container">
		<div class="form-container">

			<h4>Serach by productID</h4>	
			<div class="search-form">
				<form:form action="/getDetails" method="post">
					<label for="inp">ProductID</label>
					<input name="productId" list="selectAvailable" placeholder="Enter productID" required>
					<datalist id="selectAvailable" class="">
						<c:forEach items="${productIdList}" var="product">
							<option value="${product.key}">${product.value}</option>
						</c:forEach>
					</datalist>
					<input type="submit" value="Get Details">
				</form:form>
				
				<div class="isavailable">
					<c:if test="${productDetailExist == false}">
						<p id="doesNotExit">Product does not exist</p>
					</c:if>
					<c:if test="${empty productInStockBasedOnProductId && not empty productDetails }">
						<p id="outOfStock">Product out of Stock</p>
					</c:if>
					<c:if test="${not empty productInStockBasedOnProductId && not empty productDetails}">
						<p id="available">Available(size:quantity): 
							<c:forEach var="product" items="${productInStockBasedOnProductId}">
								<c:out value="${product.size}:${product.quantity}"></c:out>
							</c:forEach>
							
						</p>
					</c:if>
				</div>	
			</div>
					
			<h4>Product detail</h4>
			
			<div class="input-form">
				<form:form class="form" modelAttribute="salesEntity" method="post" action="/sellProduct">

					<div class="form-item">
						<label for="productId">ProductID</label>
						<form:input id="productId" list="select" path="productId" placeholder="Enter productID" value="${productDetails.productId}" required="required"/>
						<datalist id="select" class="">
							<c:forEach items="${productIdList}" var="product">
								<option value="${product.key}">${product.value}</option>
							</c:forEach>
						</datalist>
						
						<label for="brand">Brand</label>
						<form:input list="brand-list" path="brand" placeholder="Enter brand" value="${productDetails.brand}" required="required"/>
							<datalist id="brand-list">
								<c:forEach items="${brandList}" var="product">
									<option value="${product}"></option>
								</c:forEach>
							</datalist>
					</div>
					<div class="price-fields">
						<label for="sellingprice">Selling Price </label> 			
						<input id="sellingprice" type="number" name="sellingPrice" size="6" oninput="display();" min="${Math.round(productDetails.mrp*(1-productDetails.discount/100))}" required="required"/>
						<label for="productloss">Profit</label><input id="profit" size="1" name="profitLoss" readOnly="true"/>
						<label for="mrp">MRP</label><input id="mrp" type="text" readonly="" size="1" value="${productDetails.mrp}"/>
						<label for="Purchaseprice">Purchase Price</label><input id="purchaseRate" readonly="" type="text" size="1" value="${Math.round(productDetails.mrp*(1-productDetails.discount/100))}"/>
					</div>

					<div class="sizeandquantity">
						<label for="inp">Size</label>				
						<form:select type="number" path="size" min="1" value="${productDetails.size}" required="required">
							<c:forEach items="${productInStockBasedOnProductId}" var="product">
								<option value="${product.size}">${product.size}</option>
							</c:forEach>
						</form:select>	
						
						<label for="inp">Quantity</label>
						<form:input type="number" path="quantity" value="1" min="1" max="${productDetails.quantity}" required="required"/>
					</div>				
				
					<div class="">
						<label for="inp">Type</label>				
						<form:input list="desciption" path="description" size="8" placeholder="Slippers" value="${productDetails.description}" required="required"/>
						<datalist id="desciption" class="">
							<c:forEach items="${descriptionList}" var="description">
								<option value="${description}"></option>
							</c:forEach>
						</datalist>		
						<label for="inp">Payment Mode</label>
						<form:select id="payment-select" path="paymentMode">
							<option value="Cash">Cash</option>
							<option value="UPI">UPI</option>
							<option value="Other">Other</option>
						</form:select>			
					</div>
					<div class="submit">
						<input type="submit" value="Sell Product">
					</div>
				</form:form>
			</div>
			<c:if test="${success==true}"><p class="success">Product Sold</p></c:if>
	</div>
	<script src="${pageContext.request.contextPath}/Sales.js"></script>
</body>
</html>