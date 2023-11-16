<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<div class="alert">
			<c:if test="${message != null}">
				<div class="alert alert-success">${sessionScope.message}</div>
			</c:if>
			<c:if test="${error != null}">
				<div class="alert alert-danger">${sessionScope.error}</div>
			</c:if>
		</div>

		<a href="/Website_Tuan4_BanHang_3Tier/category/insert"
			class="btn btn-danger">Insert</a>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Images</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="items" items="${listcate}">
					<tr>
						<td>${items.cateID}</td>
						<td>${items.cateName}</td>
						<td>${items.images}</td>
						<td><a class="link-black"
							href="update?cateID=${items.cateID}">Update</a> || <a
							class="link-black" href="delete?cateID=${items.cateID}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
