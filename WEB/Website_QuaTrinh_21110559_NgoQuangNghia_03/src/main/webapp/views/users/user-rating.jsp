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
				<tr>
					<td style="width: 50%;">
						<b>User ID: </b>${users[0].id} <br> 
						<b>FullName: </b>${users[0].fullname} <br>
						<b>Email: </b>${users[0].email} <br>
					</td>
					<td>
						<c:forEach var="book" items="${books}">
							<b>Book ID: </b>${book.bookid} <br>
						</c:forEach>
					</td>
				</tr>
		</table>
	</div>
</body>
</html>
