<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.13.7/css/dataTables.bootstrap4.min.css" />
<link href='<c:url value = "/templates/users/css/style.css"/>'
	rel="stylesheet" type="text/css">

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
	var contextPath = "${pageContext.request.contextPath}"
</script>
</head>
<body>
	<table class="table table-striped table-responsive">
		<thead class="thead-inverse">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Icon</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" items="${list}">
				<tr>
					<td>${i.categoryId}</td>
					<td>${i.categoryName}</td>
					<td>${i.icon}</td>
					<td><a href="/admin/category/edit/${i.categoryId}">Update</a>
						<a href="/admin/category/delete/${i.categoryId}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>	
	</table>

	<script type="text/javascript">
		/* Get category data */
		$(document)
				.ready(
						function() {
							$
									.getJSON(
											contextPath + '/api/category',
											function(json) {
												var tr = [];
												for (var i = 0; i < json.length; i++) {
													tr.push('<tr>');
													tr
															.push('<td>'
																	+ json[i].categoryId
																	+ '</td>');
													tr
															.push('<td><img src="/admin/categories/images/' + json[i].icon + '" style="width:70px" class="img-fluid" alt=""></td>');
													tr
															.push('<td>'
																	+ json[i].categoryName
																	+ '</td>');
													tr
															.push('<td><a href="#" data-id="' + json[i].categoryId + '" id="editcate" class="btn btn-outline-warning"><i class="fa fa-edit"></i></a>'
																	+ '<a href="#" data-id="' + json[i].categoryId + '" id="categoryId" class="btn btn-outline-danger"><i class="fa fa-trash"></i></a></td>');
													tr.push('</tr>');
												}
												$('table').append(
														$(tr.join('')));
											});
						});
	</script>
	<!-- Modal -->
	<p>
		<button class="btn btn-success ml-auto"
			onclick="showCreateNewCategoryModal()">
			<i class="fas fa-plus mr-2"></i>Thêm Category Ajax
		</button>
	</p>

	<div class="modal" tabindex="-1" role="dialog" id="createCategoryModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form id="addCategory" method="post" onsubmit="return false;"
					enctype="multipart/form-data">
					<div class="modal-header">
						<h5 class="modal-title">Add Category</h5>
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="new_categoryname">Category Name</label> <input
								type="text" class="form-control" id="new_categoryname"
								name="categoryName">
						</div>
						<div class="form-group">
							<label for="new_icon">Icon</label> <input type="file"
								class="form-control" id="new_icon" name="icon">
						</div>
						<div class="form-group row">
							<div class="col text-center">
								<button type="submit" class="btn btn-primary btn-block">Add</button>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Đóng</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			/* Add category */
			$("form#addCategory").submit(function(e) {
				e.preventDefault();
				var formData = new FormData(this);
				$.ajax({
					url : contextPath + '/api/category/addCategory',
					type : 'POST',
					dataType : "json",
					data : formData,
					success : function(data) {
						location.reload();
					},
					cache : false,
					contentType : false,
					processData : false
				});
			});
		});

		function showCreateNewCategoryModal() {
			$('#new_categoryname').val('');
			$('#createCategoryModal').modal('show');
		}
	</script>
	<div class="modal" tabindex="-1" role="dialog"
		id="updateCategoryInfoModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Update Category</h5>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="card">
						<div class="card-header">
							<h5>
								<i class="far fa-address-card mr1"></i>Category
							</h5>
						</div>
						<div class="card-body pb-0">
							<p id="updateCategoryInfoModalId"></p>
							<p id="updateCategoryInfoModalName"></p>
							<p id="updateCategoryInfoModalIcon"></p>
						</div>
					</div>
					<div class="card mt-2">
						<div class="card-header">
							<h5>
								<i class="far fa-address-card mr1"></i>Update Category
							</h5>
						</div>
						<div class="card-body pb-0">
							<form id="updateCategory" method="post" onsubmit="return false;"
								enctype="multipart/form-data">
								<div class="form-group">
									<label for="categoryName">Category Name</label> <input
										type="text" class="form-control" id="categoryName_up"
										name="categoryName">
								</div>
								<div class="form-group">
									<label for="new_icon">Icon</label> <input type="file"
										class="form-control" id="icon_up" name="icon">
								</div>
								<input type="hidden" id="categoryId_up" name="categoryId">
								<div class="form-group row">
									<div class="col text-center">
										<button type="submit" class="btn btn-primary btn-block">Cập
											nhật</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Đóng</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		/* Edit */
		function showEditCategoryModal(categoryId, categoryName, icon, btn) {
			$('#updateCategoryInfoModalId').text("Category ID: " + categoryId);
			$('#updateCategoryInfoModalName').text(
					"Category Name: " + categoryName);
			$('#updateCategoryInfoModalIcon').text('Icon: ' + icon);
			$('#categoryName_up').val(categoryName);
			$('#categoryId_up').val(categoryId);
			$('#updateCategoryInfoModal').modal('show');
		}

		$("form#updateCategory").submit(function(e) {
			e.preventDefault();
			var formData = new FormData(this);
			$.ajax({
				url : contextPath + '/api/category/updateCategory',
				type : 'PUT',
				dataType : "json",
				data : formData,
				success : function(data) {
					location.reload();
				},
				cache : false,
				contentType : false,
				processData : false
			});
		});
	</script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>
