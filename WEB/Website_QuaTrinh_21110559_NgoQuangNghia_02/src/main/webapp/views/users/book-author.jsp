<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Author</title>
</head>
<body>
	<div class="container">
		<table class="table table-bordered" style="width: 100%; margin: 50px 0px">
			<tbody>
			<c:forEach var="book" items="${books}">
				<tr>
					<td style="text-align: center">
						<b>Cover Image: </b>${book.cover_image} <br> 
					</td>
					<td>
							<b>Tiêu đề: </b>${book.title} <br>
							<b>Mã isbn: </b>${book.isbn} <br>
							<b>Tác giả: </b>${authors[0].authorName} <br>
							<b>Publisher: </b>${book.publisher} <br>
							<b>Publish_date: </b>${book.publish_date} <br>
							<b>Quantity: </b>${book.quantity} <br>
							<b>Reviews: </b>${count}<br>							
					</td>
				</tr></c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>