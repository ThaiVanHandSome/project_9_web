<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Category Management</title>
    <style>
        .container {
            width: 130%; 
            max-width: 1000px;
            margin: 0 auto; 
        }
    </style>
</head>
<body>
<div class="container">
    <table style="width: 120%"class="table table-bordered">
        <thead>
            <tr>
                <th scope="col">Category ID</th>
                <th scope="col">Category Name</th>
                <th scope="col">Icon</th>
                <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${categories}">
                <tr>
                    <td>${item.categoryID}</td>
                    <td>${item.categoryName}</td>
                    <td>${item.icon}</td>
                    <td>
                        <a style="text-decoration: none"
                           href="/Website_Tuan9_JPA_BTVN2/Category/edit?categoryID=${item.categoryID}">Edit</a> ||
                        <a style="text-decoration: none" class="delete"
                           href="/Website_Tuan9_JPA_BTVN2/Category/delete?categoryID=${item.categoryID}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
