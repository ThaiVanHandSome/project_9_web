<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Users Management</title>
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
    		<h1>Users Management</h1>
		</div>


        <div class="alert">
            <c:if test="${not empty message}">
                <div class="alert alert-success">${message}</div>
            </c:if>
            <c:if test="${not empty error}">
                <div class="alert alert-danger">${error}</div>
            </c:if>
        </div>
        <form class="div_form" action="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/list-user" method="post" enctype="multipart/form-data">
<!--             <div> -->
<!--                 <span>User ID</span> -->
<%--                 <input name="id" id="id" type="text" class="form-control" value="${users.id}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" style="margin-bottom: 20px;"> --%>
<!--             </div> -->
            <div>
                <span>Email</span>
                <input name="email" id="email" type="email" class="form-control" value="${users.email}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" style="margin-bottom: 20px;">
            </div>
            <div>
                <span>Full Name</span>
                <input name="fullname" id="fullname" type="text" class="form-control" value="${users.fullname}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" style="margin-bottom: 20px;">
            </div>
            <div>
                <span>Phone</span>
                <input name="phone" id="phone" type="text" class="form-control" value="${users.phone}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" style="margin-bottom: 20px;">
            </div>
            <div>
                <span>Password</span>
                <input name="passwd" id="passwd" type="password" class="form-control" value="${users.passwd}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" style="margin-bottom: 20px;">
            </div>
            <div>
                <span>Signup Date</span>
                <input name="signup_date" id="signup_date" type="date" class="form-control" value="${users.signup_date}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" style="margin-bottom: 20px;">
            </div>
            <div>
                <span>Last Login</span>
                <input name="last_login" id="last_login" type="date" class="form-control" value="${users.last_login}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" style="margin-bottom: 20px;">
            </div>
            <div>
    			<span>Is Admin</span>
    			<br>
    			<input type="radio" name="is_admin" id="is_admin_true" value="true" <c:if test="${users.is_admin eq 'true'}">checked="checked"</c:if>> Yes
    			<input type="radio" name="is_admin" id="is_admin_false" value="false" <c:if test="${users.is_admin eq 'false'}">checked="checked"</c:if>> No
			</div>
            <br>
            <div style="margin: 50px; text-align: center;">
    			<button style="margin-left: 50px" formaction="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/edit-users/insert" class="btn btn-outline-success">Create</button>
    			<button formaction="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/edit-users/update" class="btn btn-outline-warning">Update</button>
    			<button formaction="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/edit-users/delete" class="btn btn-outline-danger">Delete</button>
    			<button formaction="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/edit-users/reset" class="btn btn-outline-info">Reset</button>
			</div>

        </form>
    </div>

    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
