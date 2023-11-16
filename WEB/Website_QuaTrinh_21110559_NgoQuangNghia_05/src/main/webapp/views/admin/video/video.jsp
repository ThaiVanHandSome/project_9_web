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
		<form class="div_form" action="/admin/list-video" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text" id="inputGroup-sizing-default">Title</span>
                <input name="title" type="text" class="form-control" value="${video.title}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="inputGroup-sizing-default">Poster</span>
                <input name="poster" type="text" class="form-control" value="${video.poster}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="inputGroup-sizing-default">Views</span>
                <input name="views" type="text" class="form-control" value="${video.views}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="inputGroup-sizing-default">Description</span>
                <input name="description" type="text" class="form-control" value="${video.description}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="inputGroup-sizing-default">Active</span>
                <input name="active" type="text" class="form-control" value="${video.active}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="inputGroup-sizing-default">Category ID</span>
                <input name="active" type="text" class="form-control" value="${video.category.categoryId}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
            </div>
            
			<br>
			<div style="text-align: center;">
				<button style="margin: 0 10px 50px" formaction="/Website_QuaTrinh_21110559_NgoQuangNghia_05/admin/edit-video/insert"
					class="btn btn-outline-success">Insert</button>
				<button style="margin: 0 10px 50px" formaction="/Website_QuaTrinh_21110559_NgoQuangNghia_05/admin/edit-video/update?videoid=${video.videoid}"
					class="btn btn-outline-warning">Update</button>
				<button style="margin: 0 10px 50px" formaction="/Website_QuaTrinh_21110559_NgoQuangNghia_05/admin/edit-video/delete?videoid=${video.videoid}"
					class="btn btn-outline-danger">Delete</button>
				<button style="margin: 0 10px 50px" formaction="/Website_QuaTrinh_21110559_NgoQuangNghia_05/admin/edit-video/reset"
					class="btn btn-outline-info">Reset</button>
			</div>

		</form>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Video ID</th>
					<th scope="col">Title</th>
					<th scope="col">Poster</th>
					<th scope="col">Views</th>
					<th scope="col">Description</th>
					<th scope="col">Active</th>
					<th scope="col">Category ID</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="video" items="${videos}">
					<tr>
						<td>${video.videoid}</td>
						<td>${video.title}</td>
						<td>${video.poster}</td>
						<td>${video.views}</td>
						<td>${video.description}</td>
						<td>${video.active}</td>
						<td>${video.category.categoryId}</td>
						<td><a style="text-decoration: none"
							href="/Website_QuaTrinh_21110559_NgoQuangNghia_05/admin/edit-video/edit?videoid=${video.videoid}">Edit</a>
							|| <a style="text-decoration: none" class="delete"
							href="/Website_QuaTrinh_21110559_NgoQuangNghia_05/admin/edit-video/delete?videoid=${video.videoid}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>