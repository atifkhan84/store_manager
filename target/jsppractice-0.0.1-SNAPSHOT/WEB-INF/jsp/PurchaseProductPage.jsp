<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
<title>Product Purchase</title>
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
		align-content: center;
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
		justify-content: space-between;
	}
	.input-form{
		margin: 10px;
	}
	.form{
		display: flex;
		flex-flow: column;
		row-gap: 15px;
	}
	.search-form{
		display: flex;
		margin: 0px 10px;
		flex-direction: column;
		row-gap: 10px;
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
	}
	#available{
		color: rgb(34, 177, 34);
		text-align: center;
		font-style: italic;
	}
	.addOrRemove > button{
		width: 30px;
		font-weight: bold;
		font-size: 20px;
		background-color: #0d6efd;
		color: white;
		text-align: center;
		cursor: pointer;
		border-radius: 3px;
		border: none;
	}
	.addOrRemove>button:hover{
		background-color: black;
		cursor: pointer;
		color: white;
	}
	.addOrRemove>button:disabled {
		background-color: grey;
		cursor:not-allowed;
	}
	#sizeAndQuantity > tr, td {
		padding: 5px 10px;
	}
	#addOrRemoveContainer{
		display: flex;
		justify-content: center;
		flex-flow: row;
		column-gap: 20px;
	}
	.price-fields> input{
		width: 80px;
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
	<h2>Product Purchase</h2>
	<nav>
		<span><a href="/"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house" viewBox="0 0 16 16">
			<path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5ZM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5 5 5Z"/>
		  </svg>Home</a></span>
		  <a href="/sellProduct">Sell</a>
		  <a href="purchaseProduct">Purchase</a>
		  <a href="/stockStatus">Stock</a>
		  <a href="/sales">Sales</a>
		  <a href="/productsPurchased">Products Purchased</a>
		
	</nav>
	<div class="container">
		<div class="form-container">


			<h4>Serach by productID</h4>	
			<div class="search-form">
				<form:form action="/getDetailsForPurchase" method="post">
					<label for="inp">ProductID</label>
					<input name="productId" list="select" placeholder="Enter productID" required>
					<datalist id="select" class="">
						<c:forEach items="${productList}" var="product">
							<option value="${product.productId}">${product.brand}</option>
						</c:forEach>
					</datalist>
					<input type="submit" value="Get Details">
				</form:form>
				
				<div class="isavailable">
					<c:if test="${productExists == false}">
						<p id="outOfStock">No such product record exist</p>
					</c:if>
					<c:if test="${productExists}">
						<p id="available">Product record available 
							<c:forEach var="product" items="${productInStockBasedOnProductId}">
								<c:out value="${product.size}"></c:out>
							</c:forEach>
							
						</p>
					</c:if>
				</div>	
			</div>



			<h4>Enter details for new product</h4>
			<div class="input-form">
				<form:form class="form" modelAttribute="bulkProductEntity" method="post" action="/purchaseProduct">
					
					<div class="form-item">
						<label for="productId">ProductID</label>
						<form:input id="productId" list="select" path="productId" placeholder="Enter productID" value="${productDetails.productId}" required="required"/>
						<datalist id="select" class="">
							<c:forEach items="${productIdList}" var="product">
								<option value="${product}">${product}</option>
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
					<div class="details">
						<label for="description">Type</label>				
						<form:input list="desciption" path="description" placeholder="type" value="${productDetails.description}" size="7" required="required"/>
						<datalist id="desciption" class="">
							<c:forEach items="${descriptionList}" var="description">
								<option value="${description}"></option>
							</c:forEach>
						</datalist>	
						<label for="category">Category</label>
						<select name="category" id="category">
							<option value="Men">Men</option>
							<option value="Ladies">Ladies</option>
							<option value="Kids">Kids</option>
						</select>
					</div>
					<div class="sizeandquantity">
						<table border="0" id="sizeAndQuantity">
							<tr id="size">
								<td>
									<label for="size">Size</label>				
								</td>
								<c:choose>
									<c:when test="${productDetails.size == null}">

										<td class="size"><form:input type="number" path="size" size="1" placeholder="size" value="6" required="required" min="1"/></td>
										<td class="size"><form:input type="number" path="size" size="1" placeholder="size" value="7" required="required" min="1"/></td>
										<td class="size"><form:input type="number" path="size" size="1" placeholder="size" value="8" required="required" min="1"/></td>
										<td class="size"><form:input type="number" path="size" size="1" placeholder="size" value="9" required="required" min="1"/></td>
									</c:when>
									<c:otherwise>
										<td class="size"><form:input type="number" path="size" size="1" placeholder="size" value="${productDetails.size}" required="required" min="1"/></td>
										<td class="size"><form:input type="number" path="size" size="1" placeholder="size" value="${productDetails.size+1}" required="required" min="1"/></td>
										<td class="size"><form:input type="number" path="size" size="1" placeholder="size" value="${productDetails.size+2}" required="required" min="1"/></td>
										<td class="size"><form:input type="number" path="size" size="1" placeholder="size" value="${productDetails.size+3}" required="required" min="1"/></td>
									</c:otherwise>
								</c:choose>
							</tr>
							<tr id="quantity">
								<td>
									<label for="quantity">Quantity</label>
								</td>
								<td class="quantity">
									<form:input type="number" path="quantity" value="2" required="required" min="1"/>
								</td>
								<td class="quantity"><form:input type="number" path="quantity" value="1" placeholder="qty" required="required" min="1"/></td>
								<td class="quantity"><form:input type="number" path="quantity" value="1" placeholder="qty" required="required" min="1"/></td>
								<td class="quantity"><form:input type="number" path="quantity" value="1" placeholder="qty"  required="required" min="1"/></td>
							</tr>
							<tr>
								<th rowspan="2">Total Quantity</th><th>10</th>
							</tr>
						</table>
						<div id="addOrRemoveContainer">
							<span class="addOrRemove" id="remove"><button id="minus" type="button">-</button></span>
							<span class="addOrRemove" id="add"><button id="plus" type="button">+</button></span>
						</div>
					</div>	
					<div class="price-fields">
						<label for="mrp">MRP:</label>
						<input type="number" name="mrp" oninput="displayActualPrice();" step="0.5" placeholder="MRP" value="${productDetails.mrp}" required="required"/>
						<label for="discount">Discount %</label> 			
						<input id="discount" list="discount-list" oninput="displayActualPrice();" name="discount" size="6" value="${productDetails.discount}" required="required"/>
						<datalist id="discount-list" class="">
							<c:forEach items="${discountList}" var="product">
								<option value="${product}"></option>
							</c:forEach>
						</datalist>
						<label for="mrp">Actual Price</label><input type="number" id="actualPrice" value="${productDetails.mrp*(1-productDetails.discount/100)}" readonly="">
					</div>

					<div class="supplierdetails">	
						<label for="supplierid">SupplierID</label>
						<form:input path="supplierId" size="5" required="required" value="${productDetails.supplierId}"/>
						<label for="payment">Payment Status</label>
						<form:select id="payment-select" path="paymentStatus">
							<option value="Paid">Paid</option>
							<option value="Unpaid">Unpaid</option>
							<option value="Partially Paid">Partially Paid</option>
						</form:select>		
					</div>
					<div class="submit">
						<input type="submit" value="Purchase Product">
					</div>

				</form:form>

			</div> 
			<c:if test="${success==true}"><p class="success">Product Purchase Successful</p></c:if>
		</div>
		
	</div>
	<script>
		
	</script>
	<script src="${pageContext.request.contextPath}/Purchase.js"></script>
</body>
</html>


			
	