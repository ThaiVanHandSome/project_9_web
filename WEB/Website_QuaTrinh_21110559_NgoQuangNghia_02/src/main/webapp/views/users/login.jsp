<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Lập trình web</title>
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <link href="template/user/css/styles.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="template/user/js/scripts.js"></script>
    <style>
        .center-table {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .compact-input-group {
            padding: 0.25rem 0.5rem;
        }

        .compact-input {
            font-size: 0.875rem;
        }
    </style>
</head>
<body>
<div id="loader-wrapper">
        <div id="loader"></div>

        <div class="loader-section section-left"></div>
        <div class="loader-section section-right"></div>

    </div>
    <div class="container center-table">
        <table border="1" style="width:500px">
            <tr>
                <td>
                    <div style="display: flex; justify-content: center; align-items: center; margin-top: 20px">
						<h1>LOGIN</h1>
					</div>
                    <form class="div_form" action="/Website_QuaTrinh_21110559_NgoQuangNghia_02/login" method="post">
                        <div class="input-group mb-3 compact-input-group">
                            <span class="input-group-text" id="inputGroup-sizing-default">User Name</span> 
                            <input placeholder="UserName" required name="id" type="text" class="form-control compact-input" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                            <h6 class="text-danger ml-2">${message_username}</h6>
                        </div>  
                        <div class="input-group mb-3 compact-input-group">
                            <span class="input-group-text" id="inputGroup-sizing-default">Password</span> 
                            <input name="passwd" type="password" class="form-control compact-input" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                            <h6 class="text-danger ml-2">${message_pass}</h6>
                        </div>
                        <br>
                        <div style="text-align: center;">
                            <button style="margin-bottom: 50px"formaction="/Website_QuaTrinh_21110559_NgoQuangNghia_02/login" class="btn btn-success">Đăng nhập</button>
                        </div>
                    </form>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>