<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Overview Book</title>
</head>
<body>
    <div class="container">
        <c:forEach var="book" items="${books}">
            <table border="1" style="width: 100%;margin:50px 0px">
                <tbody>
                    <tr>
                        <td style="text-align: center">
                            <b>Book ID: </b>${book.bookid} <br>
                            <b>ISBN: </b>${book.isbn} <br>
                            <b>Title: </b>${book.title}<br>
                            <b>Publisher: </b>${book.publisher}<br>
                            <b>Price: </b>${book.price}<br>
                            <b>Description: </b>${book.description}<br>
                            <b>Publish Date: </b>${book.publish_date}<br>
                            <b>Cover Image: </b>${book.cover_image}<br>
                            <b>Quantity: </b>${book.quantity}<br>
                        </td>
                    </tr>
                </tbody>
            </table>
        </c:forEach>
    </div>
</body>
</html>
