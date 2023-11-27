<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<span> <a href ="<c:url value = '/admin/category/add'/>"> Add Category</a></span>
	<table id ="example1" border="1" style="width:100%">
	<thead>
		<tr> 
			<td>ID</td>
			<td>CategorName</td>
			<td>Icon</td>
			<td>Action</td>
		</tr>
	</thead>
	<tbody>
	<c:forEach var ="i" items = "${list}">
		<tr>
			<td>${i.categoryId}</td>
			<td>${i.categoryName}</td>
			<td>${i.icon}</td>
			<td>
			<a href="/admin/category/edit/${i.categoryId}">Update</a>
			<a href="/admin/category/delete/${i.categoryId}">Delete</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>


</body>
</html>