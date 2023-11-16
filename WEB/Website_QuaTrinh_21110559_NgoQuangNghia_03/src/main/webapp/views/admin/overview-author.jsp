<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Author Management</title>
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
                        <th scope="col">Author ID</th>
                        <th scope="col">Author Name</th>
                        <th scope="col">Date of birth</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="author" items="${authors}">
                        <tr>
                            <td>${author.authorID}</td>
                            <td>${author.authorName}</td>
                            <td>${author.dateOfBirth}</td>
                            <td>
                        		<a style="text-decoration: none" href="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/edit-author/edit?authorID=${author.authorID}">Edit</a> ||
                        		<a style="text-decoration: none" class="delete" href="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/edit-author/delete?authorID=${author.authorID}">Delete</a>
                    		</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>