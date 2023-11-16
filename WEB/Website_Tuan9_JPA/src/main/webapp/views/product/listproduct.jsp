<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category 3Tier</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<style>
.container {
	padding: 20px;
}

.alert {
	text-align: center;
	margin-bottom: -5px;
}

/* Add Bootstrap table classes for styling */
table {
	width: 100%;
	margin-top: 20px; /* Adjust this value as needed */
	text-align: center;
}

th, td {
	text-align: center;
}

a {
	margin-top: 10px;
}
.link-black {
    text-decoration: none; 
    color: black;
}
</style>

</head>
<body>
	<div class="container">
		<a href="/Website_Tuan8_BanHang_Upload_MultiPartConfig_CRUD/product/insert"
			class="btn btn-danger">Insert</a>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Image Link</th>
					<th>Category ID</th>
					<th>Seller ID</th>
					<th>Amount</th>
					<th>Stoke</th>
					<th>Action</th>					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="items" items="${listproduct}">
					<tr>
						<td>${items.productID}</td>
						<td>${items.productName}</td>
						<td>${items.description}</td>
						<td>${items.price}</td>
						<td>${items.imageLink}</td>
						<td>${items.categoryID}</td>
						<td>${items.sellerID}</td>
						<td>${items.amount}</td>
						<td>${items.stoke}</td>
						<td>
							<a class="link-black" href='<c:url value="/product/update?CategoryID=${items.productID}" /> '>Update</a> || 
							<a class="link-black" href='<c:url value="/product/delete?CategoryID=${items.productID}" /> '>Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
