<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        .active {
            background-color: #e65f50;
        }
    </style>
</head>
<body>
<div class="container">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Icon</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item1" items="${listcate}">
            <c:forEach var="CountItem" items="${count}">
                <c:if test="${CountItem.categoryID == item1.cateID && CountItem.total !=0}">
                    <tr class="${setactive == item1.cateID ? 'active' : ''}">
                        <td>${item1.cateID}</td>
                        <td>
                            <a class="link-black" href='<c:url value="/category/listcate/findbycategory?CategoryID=${item1.cateID}" />'>
                                ${item1.cateName}
                                <small>(${CountItem.total})</small>
                            </a>
                        </td>
                        <td>${item1.images}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
