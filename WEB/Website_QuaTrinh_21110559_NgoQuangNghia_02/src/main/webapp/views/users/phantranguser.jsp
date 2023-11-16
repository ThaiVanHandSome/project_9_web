<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Overview User</title>
</head>
<body>
	<div class="container">
		<c:forEach var="user" items="${users}">
			<table border="1" style="width: 100%; margin: 50px 0px">
				<tbody>
					<tr>
						<td style="text-align: center"><b>User ID: </b>${user.id} <br>
							<b>Full Name: </b>${user.fullname} <br></td>
					</tr>
				</tbody>
			</table>
		</c:forEach>
		<div class="col-md-8 col-sm-8">
			<ul class="pagination pull-right">
				<c:if test="${tag>1}">
					<li><a
						href="${pageContext.request.contextPath}/admin/phantrang?index=${tag-1}">&laquo;</a></li>
				</c:if>
				<c:forEach begin="1" end="${endP}" var="i">
					<li class='${tag==i?"active":"" }'><a
						href="${pageContext.request.contextPath}/admin/phantrang?index=${i}">${i}</a></li>
				</c:forEach>
				<c:if test="${tag<endP}">
					<li><a
						href="${pageContext.request.contextPath}/admin/phantrang?index=${tag+1}">&raquo;</a></li>
				</c:if>
			</ul>
		</div>

	</div>
</body>
</html>
