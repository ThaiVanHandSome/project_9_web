<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Category</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
    crossorigin="anonymous">
<style>
    .container {
        margin-top:10%;
        width: 400px;
        padding: 20px;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.2);
    }

    .form-group {
        margin-bottom: 20px;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Insert Product</h2>
        <form action="admin-insert" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="productName">Product Name:</label>
                <input type="text" class="form-control" id="productName" name="productName" required>
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <textarea cols="5" class="form-control" id="description" name="description" required></textarea>
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="text" class="form-control" id="price" name="price" required>
            </div>
             <div class="form-group">
                <label for="imageLink">Image Link:</label>
                <input type="file" class="form-control" id="imageLink" name="imageLink" required>
            </div>
            <div class="form-group">
                <label for="category">Category:</label>
                <select name="categoryID">
                	<c:forEach items="${listcate}" var=item>
						<option value="${item.categoryID}">${item.categoryName}</option>                	
                	</c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="sellerID">Seller:</label>
                <input type="text" class="form-control" id="sellerID" name="sellerID" required>
            </div>
             <div class="form-group">
                <label for="amout">Amount:</label>
                <input type="text" class="form-control" id="amount" name="amount" required>
            </div>
             <div class="form-group">
                <label for="stoke">Stoke:</label>
                <input type="text" class="form-control" id="stoke" name="stoke" required>
            </div>
            <button type="submit" class="btn btn-primary">Insert Product</button>
            <button type="reset" class="btn btn-info">Reset</button>
            <a href="/Website_Tuan8_BanHang_Upload_MultiPartConfig_CRUD/category/listcate" class="btn btn-danger">HomePage</a>
            
        </form>
    </div>
</body>
</html>
