<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Book Management</title>
</head>
<body>
	<div class="container">
		<div
			style="display: flex; justify-content: center; align-items: center; margin-top: 20px">
			<h1>Book Manager</h1>
		</div>

		<div class="alert">
			<c:if test="${not empty message}">
				<div class="alert alert-success">${message}</div>
			</c:if>
			<c:if test="${not empty error}">
				<div class="alert alert-danger">${error}</div>
			</c:if>
		</div>
		<form class="div_form" action="/admin/list-book" method="post">
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default">ISBN</span>
				<input name="isbn" type="number" class="form-control" value="${book.isbn}"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-default">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default">Title</span>
				<input name="title" type="text" class="form-control" maxlength="200"
					aria-label="Sizing example input" value="${book.title}"
					aria-describedby="inputGroup-sizing-default">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default">Publisher</span>
				<input name="publisher" type="text" class="form-control" value="${book.publisher}"
					maxlength="200" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-default">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default">Price</span>
				<input name="price" type="text" class="form-control"value="${book.price}"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-default">
			</div>
			<div class="mb-3">
				<label for="description">Description</label>
				<textarea name="description" class="form-control" value="${book.description}" rows="4"></textarea>
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default">Publish
					Date</span> <input name="publish_date" type="date" class="form-control"
					aria-label="Sizing example input" value="${book.publish_date}"
					aria-describedby="inputGroup-sizing-default">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default">Cover
					Image URL</span> <input name="cover_image" type="text"
					class="form-control" maxlength="100"
					aria-label="Sizing example input" value="${book.cover_image}"
					aria-describedby="inputGroup-sizing-default">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default">Quantity</span>
				<input name="quantity" type="number" class="form-control"
					aria-label="Sizing example input" value="${book.quantity}"
					aria-describedby="inputGroup-sizing-default">
			</div>
			<br>
			<div style="text-align: center;">
				<button style="margin: 0 10px 50px"
					formaction="/Website_QuaTrinh/admin/edit-book/insert"
					class="btn btn-outline-success">Insert</button>
				<button style="margin: 0 10px 50px"
					formaction="/Website_QuaTrinh/admin/edit-book/update?id=${user.id}"
					class="btn btn-outline-warning">Update</button>
				<button style="margin: 0 10px 50px"
					formaction="/Website_QuaTrinh/admin/edit-book/delete?id=${user.id}"
					class="btn btn-outline-danger">Delete</button>
				<button style="margin: 0 10px 50px"
					formaction="/Website_QuaTrinh/admin/edit-book/reset"
					class="btn btn-outline-info">Reset</button>
			</div>

		</form>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Book ID</th>
					<th scope="col">ISBN</th>
					<th scope="col">Title</th>
					<th scope="col">Publisher</th>
					<th scope="col">Price</th>
					<th scope="col">Description</th>
					<th scope="col">Publish Date</th>
					<th scope="col">Cover Image</th>
					<th scope="col">Quantity</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td>${book.bookid}</td>
						<td>${book.isbn}</td>
						<td>${book.title}</td>
						<td>${book.publisher}</td>
						<td>${book.price}</td>
						<td>${book.description}</td>
						<td>${book.publish_date}</td>
						<td>${book.cover_image}</td>
						<td>${book.quantity}</td>
						<td><a style="text-decoration: none"
							href="/Website_QuaTrinh/admin/edit-book/edit?bookid=${book.bookid}">Edit</a>
							|| <a style="text-decoration: none" class="delete"
							href="/Website_QuaTrinh/admin/edit-book/delete?bookid=${book.bookid}">
								Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>