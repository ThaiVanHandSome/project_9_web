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
		<table class="table table-bordered"
			style="width: 100%; margin: 50px 0px">
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td style="text-align: center"><b>Cover Image: </b>${book.cover_image}
							<br></td>
						<td><b>Tiêu đề: </b>${book.title} <br> <b>Mã isbn: </b>${book.isbn}
							<br> <b>Tác giả: </b>${authors[0].authorName} <br> <b>Publisher:
						</b>${book.publisher} <br> <b>Publish_date: </b>${book.publish_date}
							<br> <b>Quantity: </b>${book.quantity} <br> <a
							style="text-decoration: none; color: black;"
							href="<c:url value="/detail-review?bookid=${book.bookid}"/>"><b>Reviews:
							</b></a> ${count}(Ấn vào xem chi tiết)<br></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<table class="table table-bordered"
			style="width: 100%; margin-top: -50px">
			<tr>
				<td><b>Reviews</b></td>
			</tr>
		</table>
		<table class="table table-bordered"
			style="width: 100%; margin-top: -65px">
			<tr>
				<c:forEach var="user" items="${users}">
					<td>[${user.id}]</td>
					<br>
				</c:forEach>
				<c:forEach var="review" items="${reviews}">
					<td>${review}</td>
					<br>
				</c:forEach>

			</tr>
		</table>
		<table class="table table-bordered" style="width: 100%; margin-top: -16px;">
    <tr>
        <td style="text-align: left;">
            <b>Form thêm reviews</b><br>
            <button style="margin-top:100px"formaction="/Website_QuaTrinh_21110559_NgoQuangNghia_01/submit-form" class="btn btn-outline-info">Submit</button>
        </td>
    </tr>
</table>

	</div>
</body>
</html>