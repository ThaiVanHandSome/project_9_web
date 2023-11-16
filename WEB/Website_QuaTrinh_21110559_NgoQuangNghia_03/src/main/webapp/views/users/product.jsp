<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Management</title>
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
                        <th scope="col">Book ID</th>
                        <th scope="col">ISBN</th>
                        <th scope="col">Title</th>
                        <th scope="col">Publisher</th>
                        <th scope="col">Price</th>
                        <th scope="col">Description</th>
                        <th scope="col">Publish Date</th>
                        <th scope="col">Cover Image</th>
                        <th scope="col">Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <td>${book.bookid}</td>
                            <td>${book.isbn}</td>
                            <td>${book.title}</td>
                            <td>${book.publisher}</td>
                            <td>${book.price}</td>
                            <td>${book.description}</td>
                            <td>${book.publish_date}</td>
                            <td>${book.cover_image}</td>
                            <td>${book.quantity}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>