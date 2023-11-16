<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
<link href="views/user/home/home.css" rel="stylesheet" />
<link href="common/user/header/header.css" rel="stylesheet" />
<link href="common/user/footer/footer.css" rel="stylesheet" />

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">
<link href='<c:url value="/views/user/product_detail/product_detail.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/views/user/order/order.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/views/user/branches/branches.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/views/user/branches_info/branches_info.css"/>' rel="stylesheet" type="text/css">


<!-- Nghĩa thêm bootstrap bên dưới thực hiện cho security -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
	<%@ include file="/common/user/header/header.jsp"%>
	<decorator:body />
	<%@ include file="/common/user/footer/footer.jsp"%>

	<!-- JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		type="text/javascript"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		type="text/javascript"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		type="text/javascript"></script>
</body>
</html>