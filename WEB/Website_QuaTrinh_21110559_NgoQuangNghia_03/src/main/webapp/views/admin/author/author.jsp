<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Author Management</title>
</head>
<body>
	<div class="container">
		<div
			style="display: flex; justify-content: center; align-items: center; margin-top: 20px">
			<h1>Author Manager</h1>
		</div>

		<div class="alert">
			<c:if test="${not empty message}">
				<div class="alert alert-success">${message}</div>
			</c:if>
			<c:if test="${not empty error}">
				<div class="alert alert-danger">${error}</div>
			</c:if>
		</div>
		<form class="div_form" action="/admin/list-author" method="post">
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default">Author
					Name</span> <input name="authorName" type="text" class="form-control"
					value="${author.authorName}" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-default">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default">Date
					of birth</span> <input name="dateOfBirth" type="date" class="form-control"
					value="${author.dateOfBirth}" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-default">
			</div>
			<br>
			<div style="text-align: center;">
				<button style="margin: 0 10px 50px" formaction="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/edit-author/insert"
					class="btn btn-outline-success">Insert</button>
				<button style="margin: 0 10px 50px" formaction="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/edit-author/update?authorID=${author.authorID}"
					class="btn btn-outline-warning">Update</button>
				<button style="margin: 0 10px 50px" formaction="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/edit-author/delete?authorID=${author.authorID}"
					class="btn btn-outline-danger">Delete</button>
				<button style="margin: 0 10px 50px" formaction="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/edit-author/reset"
					class="btn btn-outline-info">Reset</button>
			</div>

		</form>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Author ID</th>
					<th scope="col">Author Name</th>
					<th scope="col">Date Of Birth</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="author" items="${authors}">
					<tr>
						<td>${author.authorID}</td>
						<td>${author.authorName}</td>
						<td>${author.dateOfBirth}</td>
						<td><a style="text-decoration: none"
							href="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/edit-author/edit?authorID=${author.authorID}">Edit</a> || 
							<a style="text-decoration: none" class="delete"
							href="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/edit-author/delete?authorID=${author.authorID}"> Delete</a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>