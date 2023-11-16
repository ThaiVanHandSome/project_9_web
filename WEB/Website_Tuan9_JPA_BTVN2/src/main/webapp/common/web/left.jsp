<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Category Management</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<style>
.container{
	width: 500px;
	margin-left: 10px;
}

.alert {
	width: 60%;
	margin-left: auto;
	margin-right: auto;
}
span {
    display: block;
    font-weight: bold;
    margin-top: 10px;
    text-align: left;
}
</style>
</head>
<body>
	<div class="container">
		<div class="title">
			<h1>Category Management</h1>
		</div>
		<div class="alert">
			<c:if test="${not empty message}">
				<div class="alert alert-success">${message}</div>
			</c:if>
			<c:if test="${not empty error}">
				<div class="alert alert-danger">${error}</div>
			</c:if>
		</div>
		<form class="div_form" action="/Website_Tuan9_JPA_BTVN2/Category/listcate" method="post" enctype="multipart/form-data">
			<div>
				<span>Category ID</span>
				<input name="categoryID" id="categoryID" type="text" class="form-control" value="${category.categoryID}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
			</div>
			<div>
				<span>Category Name</span>
				<input name="categoryName" id="categoryName" type="text" class="form-control" value="${category.categoryName}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
			</div>
			<div>
				<span>Image</span>
				<input name="icon" id="icon"type="file" class="form-control" value="${category.icon}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
			</div>
			<br>
			<button style="margin=left:50px"formaction="/Website_Tuan9_JPA_BTVN2/Category/create" class="btn btn-outline-success">Create</button>
			<button formaction="/Website_Tuan9_JPA_BTVN2/Category/update" class="btn btn-outline-warning">Update</button>
			<button formaction="/Website_Tuan9_JPA_BTVN2/Category/delete" class="btn btn-outline-danger">Delete</button>
			<button formaction="/Website_Tuan9_JPA_BTVN2/Category/reset" class="btn btn-outline-info">Reset</button>
		</form>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>