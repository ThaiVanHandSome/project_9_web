<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lập trình web</title>
</head>
<body>
<div class="container">			
    <div style="text-align: center;">
        <b style="font-size: 24px; margin-bottom: 20px;">DANH SÁCH TÁC GIẢ</b>
    </div>
    <table class="table table-bordered" style="width: 100%; margin: 50px 0px">
        <tbody>
        <c:forEach var="author" items="${authors}">
            <tr>
                <td style="text-align: center;">
                    <a style="text-decoration: none; color: black;" href="<c:url value="/detail-author?authorID=${author.authorID}"/>">${author.authorName}</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
