<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
  
</head>
<body>
    <section class="bg-white">
        <div class="container py-2">
            <div class="row d-flex justify-content-center align-content-start align-items-center">
                <div class="col-12 col-md-8 col-lg-8 col-xl-6">
                    <div class="card rounded-4 shadow">
                        <div class="card-body p-md-5 p-sm-2">
                            <h2 class="fw-bold mb-4 text-center">Change password</h2>
                            <div class="alert">
								<c:if test="${not empty message}">
									<div class="alert alert-success">${message}</div>
								</c:if>
								<c:if test="${not empty error}">
									<div class="alert alert-danger">${error}</div>
								</c:if>
							</div>
                            <form action="/security/changepassword" method="post" class="needs-validation">
                                <div class="mb-3">
                                    <div class="form-floating mb-3">
                                        <input type="password" class="form-control rounded-3" placeholder="Enter old password" name="old_password" required="required">
                                        <label>Old Password</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="password" class="form-control rounded-3" placeholder="Enter new password" name="password" required="required">
                                        <label>New Password</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="password" class="form-control rounded-3"  placeholder="Enter confirm new password" name="password_confirm" required="required">
                                        <label>Confirm New Password</label>
                                    </div>
                                    
                                </div>

                                <div class="d-grid gap-2 mb-2">
                                    <button formaction="/security/changepassword" type="submit" id="submit" class="btn btn-lg rounded-3 btn-primary">Change Password</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <img src="change_password.jpg" alt="Image" class="img-fluid me-3">
                </div>
            </div>
        </div>
    </section>
</body>

</html>