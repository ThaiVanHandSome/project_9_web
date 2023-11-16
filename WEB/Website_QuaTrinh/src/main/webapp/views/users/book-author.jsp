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
		<table border="1" style="width: 100%; margin: 50px 0px">
			<tbody>
				<tr>
					<td style="text-align: center">
						<b>Author ID: </b>${authors[0].authorID} <br> 
						<b>Author Name: </b>${authors[0].authorName} <br>
					</td>
					<td>
						<c:forEach var="book" items="${books}">
							<b>Book ID: </b>${book.bookid} <br>
						</c:forEach>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>