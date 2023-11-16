<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Users Management</title>
    <style>
        .container {
            width: 100%;
            max-width: 900px;
            margin: 20px 0;
        </style>
    </head>
    <body>
        <div class="container">
            <table style="width: 100%;margin: 20px 0;" class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">User ID</th>
                        <th scope="col">Email</th>
                        <th scope="col">Fullname</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Password</th>
                        <th scope="col">Signup Date</th>
                        <th scope="col">Last Login</th>
                        <th scope="col">Is Admin</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${USERS}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.email}</td>
                            <td>${user.fullname}</td>
                            <td>${user.phone}</td>
                            <td>${user.passwd}</td>
                            <td>${user.signup_date}</td>
                            <td>${user.last_login}</td>
                            <td>${user.is_admin}</td>
                            <td>
                        		<a style="text-decoration: none" href="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/edit-users/edit?id=${item.id}">Edit</a> ||
                        		<a style="text-decoration: none" class="delete" href="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/edit-users/delete?id=${item.id}">Delete</a>
                    		</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>