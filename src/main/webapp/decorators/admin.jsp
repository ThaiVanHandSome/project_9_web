<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	<header class="row">
		<div class="col">
			<%@include file="/common/admin/header.jsp"%>
		</div>
	</header>
	<main class="container-fluid">
		<sitemesh:write property='body'></sitemesh:write>
	</main>
	<footer class="row">
		<div class="col">
			<%@include file="/common/admin/footer.jsp"%>
		</div>
	</footer>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		type="text/javascript"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		type="text/javascript"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="https://code.jquery.com/jquery-3.7.0.js"
		type="text/javascript"></script>
	<script
		src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"
		type="text/javascript"></script>
	<script
		src="https://cdn.datatables.net/1.13.7/js/dataTables.bootstrap4.min.js"
		type="text/javascript"></script>
	<script>
		$(document).ready(function() {

			$('#example1').DataTable({
				"columns" : [ null, null, null, null, ]
			})
		});
	</script>
</body>
</html>