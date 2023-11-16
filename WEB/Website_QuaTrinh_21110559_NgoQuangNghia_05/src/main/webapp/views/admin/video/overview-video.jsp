<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Overview Author</title>
</head>
<body>
    <div class="container">
        <c:forEach var="video" items="${videos}">
            <table border="1" style="width: 100%;margin:50px 0px">
                <tbody>
                    <tr>
                        <td style="text-align: center">
                            <b>Video ID: </b>${video.videoid} <br>
                            <b>Title: </b>${video.title} <br>
                            <b>Poster: </b>${video.poster}<br>
                            <b>Views: </b>${video.views}<br>
                            <b>Description: </b>${video.description}<br>
                            <b>Active: </b>${video.active}<br>
                            <b>Category ID: </b>${video.category.categoryId}<br>
                        </td>
                    </tr>
                </tbody>
            </table>
        </c:forEach>
        <div style="display: flex; justify-content: center; margin-bottom:50px">
			<div class="d-flex">
				<c:choose>
					<c:when test="${tag == 1}">
						<a href="javascript:void(0);" class="btn btn-primary disabled">Previous</a>
					</c:when>
					<c:otherwise>
						<a
							href="${pageContext.request.contextPath}/admin/overview-video?index=${tag-1}"
							class="btn btn-primary">Previous</a>
					</c:otherwise>
				</c:choose>
				<div>
					<c:forEach var="i" begin="1" end="${endP}">
						<a style="text-decoration: none;"
							href="${pageContext.request.contextPath}/admin/overview-video?index=${i}"
							class="tm-paging-link ${tag == i ? 'active' : ''}"> <span
							style="padding: 5px;">${i}</span>
						</a>
					</c:forEach>
				</div>
				<c:choose>
					<c:when test="${tag == endP}">
						<a href="javascript:void(0);" class="btn btn-primary disabled">Next
							Page</a>
					</c:when>
					<c:otherwise>
						<a
							href="${pageContext.request.contextPath}/admin/overview-video?index=${tag + 1}"
							class="btn btn-primary">Next Page</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>

    </div>
</body>
</html>
