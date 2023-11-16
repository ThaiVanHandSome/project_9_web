<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Category</title>
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
        <h2 class="mb-4">Update Category</h2>
        <form action="update" method="post">
            <div class="form-group">
                <label for="cateID">ID:</label>
                <input type="text" class="form-control" id="cateID" name="cateID" value="${cate.cateID}" readonly>
            </div>
            <div class="form-group">
                <label for="cateName">Category Name:</label>
                <input type="text" class="form-control" id="cateName" name="cateName" value="${cate.cateName}">
            </div>
            <div class="form-group">
                <label for="images">Image File:</label>
                <input type="text" class="form-control" id="images" name="images" value="${cate.images}">
            </div>
            <button type="submit" class="btn btn-primary">Update Category</button>
			<button type="reset" class="btn btn-info">Reset</button>
            <a href="/Website_Tuan8_BanHang_ProductCategory/category/listcate" class="btn btn-danger">HomePage</a>
            
        </form>
    </div>
</body>
</html>
