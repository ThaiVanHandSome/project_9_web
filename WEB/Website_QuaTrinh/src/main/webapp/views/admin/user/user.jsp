<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>User Management</title>
</head>
<body>
	<div class="container">
		<div
			style="display: flex; justify-content: center; align-items: center; margin-top: 20px">
			<h1>User Manager</h1>
		</div>

		<div class="alert">
			<c:if test="${not empty message}">
				<div class="alert alert-success">${message}</div>
			</c:if>
			<c:if test="${not empty error}">
				<div class="alert alert-danger">${error}</div>
			</c:if>
		</div>
		<form class="div_form" action="/admin/list-user" method="post">
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default">Email</span>
				<input name="email" type="email" class="form-control"
					value="${user.email}" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-default">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default">Full
					Name</span> <input name="fullname" type="text" class="form-control"
					value="${user.fullname}" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-default">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default">Phone
				</span> <input name="phone" type="text" class="form-control"
					value="${user.phone}" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-default">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default">Password
				</span> <input name="passwd" type="password" class="form-control"
					value="${user.passwd}" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-default">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default">Sign
					up date </span> <input name="signup_date" type="date"
					class="form-control" value="${user.signup_date}"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-default">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default">Last
					Login </span> <input name="last_login" type="date" class="form-control"
					value="${user.last_login}" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-default">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default">Is
					Admin</span> <select name="is_admin" class="form-select"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-default">
					<option value="1">Yes</option>
					<option value="0">No</option>
				</select>
			</div>
			<br>
			<div style="text-align: center;">
				<button style="margin: 0 10px 50px"
					formaction="/Website_QuaTrinh/admin/edit-user/insert"
					class="btn btn-outline-success">Insert</button>
				<button style="margin: 0 10px 50px"
					formaction="/Website_QuaTrinh/admin/edit-user/update?id=${user.id}"
					class="btn btn-outline-warning">Update</button>
				<button style="margin: 0 10px 50px"
					formaction="/Website_QuaTrinh/admin/edit-user/delete?id=${user.id}"
					class="btn btn-outline-danger">Delete</button>
				<button style="margin: 0 10px 50px"
					formaction="/Website_QuaTrinh/admin/edit-user/reset"
					class="btn btn-outline-info">Reset</button>
			</div>

		</form>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">User ID</th>
					<th scope="col">Email</th>
					<th scope="col">Fullname</th>
					<th scope="col">Phone</th>
					<th scope="col">Password</th>
					<th scope="col">Signup Date</th>
					<th scope="col">Last Login</th>
					<th scope="col">Is Admin</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.id}</td>
						<td>${user.email}</td>
						<td>${user.fullname}</td>
						<td>${user.phone}</td>
						<td>${user.passwd}</td>
						<td>${user.signup_date}</td>
						<td>${user.last_login}</td>
						<td>${user.is_admin}</td>
						<td><a style="text-decoration: none"
							href="/Website_QuaTrinh/admin/edit-user/edit?id=${user.id}">Edit</a>
							|| <a style="text-decoration: none" class="delete"
							href="/Website_QuaTrinh/admin/edit-user/delete?id=${user.id}">
								Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>