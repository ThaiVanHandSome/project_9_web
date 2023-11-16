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
            <table border="1" style="width: 100%;margin:50px 0px">
                <tbody>
                    <tr>
                        <td style="text-align: center">
                            <b>User ID: </b>${user.id} <br>
                            <b>Email: </b>${user.email} <br>
                            <b>Full Name: </b>${user.fullname} <br>
                            <b>Phone: </b>${user.phone}<br>
                            <b>Password: </b>${user.passwd} <br>
                            <b>Sign Up Sate: </b>${user.signup_date} <br>
                            <b>Last Login: </b>${user.last_login} <br>
                            <b>Is Admin: </b>${user.is_admin} <br>
                        </td>
                    </tr>
                </tbody>
            </table>
        </c:forEach>
         <div class="row tm-mb-90">
    	<div style="display: flex; justify-content: center; margin-bottom:50px">
			<div class="d-flex">
				<c:choose>
					<c:when test="${tag == 1}">
						<a href="javascript:void(0);" class="btn btn-primary disabled">Previous</a>
					</c:when>
					<c:otherwise>
						<a
							href="${pageContext.request.contextPath}/admin/overview-user?index=${tag-1}"
							class="btn btn-primary">Previous</a>
					</c:otherwise>
				</c:choose>
				<div>
					<c:forEach var="i" begin="1" end="${endP}">
						<a style="text-decoration: none;"
							href="${pageContext.request.contextPath}/admin/overview-user?index=${i}"
							class="tm-paging-link ${tag == i ? 'active' : ''}"> <span
							style="padding: 5px;">${i}</span>
						</a>
					</c:forEach>
				</div>
				<c:choose>
					<c:when test="${tag == endP}">
						<a href="javascript:void(0);" class="btn btn-primary disabled">Next
							Page</a>
					</c:when>
					<c:otherwise>
						<a
							href="${pageContext.request.contextPath}/admin/overview-user?index=${tag + 1}"
							class="btn btn-primary">Next Page</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		</div>
    </div>
</body>
</html>
