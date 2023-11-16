<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Author Management</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
    crossorigin="anonymous">
<style>
.container {
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
        <div class="title" style="text-align: center;margin-top:20px">
    		<h1>Author Management</h1>
		</div>


        <div class="alert">
            <c:if test="${not empty message}">
                <div class="alert alert-success">${message}</div>
            </c:if>
            <c:if test="${not empty error}">
                <div class="alert alert-danger">${error}</div>
            </c:if>
        </div>
        <form class="div_form" action="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/list-author" method="post" enctype="multipart/form-data">
            <div>
                <span>Author Name</span>
                <input name="authorName" id="authorName" type="text" class="form-control" value="${author.authorName}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" style="margin-bottom: 20px;">
            </div>
            <div>
                <span>Date of birth</span>
                <input name="dateOfBirth" id="dateOfBirth" type="text" class="form-control" value="${author.dateOfBirth}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" style="margin-bottom: 20px;">
            </div>
            <br>
            <div style="margin: 50px; text-align: center;">
    			<button style="margin-left: 50px" formaction="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/edit-author/insert" class="btn btn-outline-success">Create</button>
    			<button formaction="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/edit-author/update" class="btn btn-outline-warning">Update</button>
    			<button formaction="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/edit-author/delete" class="btn btn-outline-danger">Delete</button>
    			<button formaction="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/edit-author/reset" class="btn btn-outline-info">Reset</button>
			</div>

        </form>
  
    </div>

    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
