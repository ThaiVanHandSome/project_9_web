<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Category Management</title>
    <style>
        table {
            width: 100%;
            margin-top: 80px; 
            text-align: center;
        }

        a {
            margin-top: 10px;
        }

        .link-black {
            text-decoration: none;
            color: black;
        }

        .body {
            margin-right: 0;
        }

        .left {
            width: 33%; 
        }

        .right {
            width: 67%; 
    </style>
</head>
<body>
<table border="1">
    <tr>
        <td colspan="2"><%@ include file="/common/web/header.jsp" %></td>
    </tr>
    <tr>
        <td class="left"><%@ include file="/common/web/left.jsp" %></td>
        <td class="body right">
            <web:body>
                <%@ include file="/common/web/right.jsp" %>
            </web:body>
        </td>
    </tr>
    <tr>
        <td colspan="2"><%@ include file="/common/web/footer.jsp" %></td>
    </tr>
</table>
</body>
</html>
