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
    </div>
</body>
</html>
