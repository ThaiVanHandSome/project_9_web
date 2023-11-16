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
        <c:forEach var="author" items="${authors}">
            <table border="1" style="width: 100%;margin:50px 0px">
                <tbody>
                    <tr>
                        <td style="text-align: center">
                            <b>Author ID: </b>${author.authorID} <br>
                            <b>Author Name: </b>${author.authorName} <br>
                            <b>Date Of Birth: </b>${author.dateOfBirth}<br>
                        </td>
                    </tr>
                </tbody>
            </table>
        </c:forEach>
        <nav aria-label="Page navigation example">
  			<ul class="pagination">
    			<li class="page-item"><a class="page-link" href="#">Previous</a></li>
    			<li class="page-item"><a class="page-link" href="#">1</a></li>
    			<li class="page-item"><a class="page-link" href="#">2</a></li>
    			<li class="page-item"><a class="page-link" href="#">3</a></li>
    			<li class="page-item"><a class="page-link" href="#">Next</a></li>
  			</ul>
		</nav>
    </div>
</body>
</html>
