<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Shoe Store</title>
<style>
	body{
		font-family: sans-serif;
		height: 100%;
		width: 100%;
		display: flex;
		flex-wrap: wrap;
		justify-content: center;
		background-color: #56d5c8;
		align-content: center;
		flex-direction: column;
		align-items: center;
		
	}
	h2{
		color: rgb(182, 0, 0);
		font-weight: 800;
		font-size: 40px;
	}
	#menu-container{
		color: white;
		height: 400px;
		width: 400px;
		display: flex;
		flex-flow: column;
		row-gap: 10px;
	}
	#menu-container > a{
		height: 100%;
		background-color:  #D65076;
        cursor: pointer;
		border-radius: 10px;
		font-size: 30px;
		font-weight: bold;
		display: flex;
		align-items: center;
		justify-content: center;
	}
	#menu-container > a:hover {
	
		background-color: #9B2335;
        cursor: pointer;
	}
	a, a:link, a:visited{
		text-decoration:none;
		color: white;
	}
</style>
</head>
<body>
	<h2>Welcome to Shop Manager</h2>
	
	<div id="menu-container">
		<a href="/sellProduct">Sell</a>
		<a href="/purchaseProduct">Purchase</a>
		<a href="/stockStatus">Stock</a>
		<a href="/sales">Sales</a>
		<a href="/productsPurchased">Products Purchased</a>
	</div>
	<p><a href="/practice"></a></p>
</body>
</html>