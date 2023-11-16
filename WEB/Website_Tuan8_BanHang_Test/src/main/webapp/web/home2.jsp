<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<table border="1">
		<tr>
			<td colspan="2"><%@include file="/common/web/header.jsp"%></td>
		</tr>
		<tr>
			<td><%@include file="/common/web/left.jsp"%></td>
			<td class="body"><web:body>
					<div class="container">
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
								</tr>
							</thead>
							<tbody>
									<tr>
										<td>${product.productID}</td>
										<td>${product.productName}</td>
										<td>${product.description}</td>
										<td>${product.price}</td>
										<td>${product.imageLink}</td>
										<td>${product.categoryID}</td>
										<td>${product.sellerID}</td>
										<td>${product.amount}</td>
										<td>${product.stoke}</td>
									</tr>
						</tbody>
						</table>
					</div>
				</web:body></td>
		</tr>
		<tr>
			<td colspan="2"><%@include file="/common/web/footer.jsp"%></td>
		</tr>
	</table>
</body>
</html>