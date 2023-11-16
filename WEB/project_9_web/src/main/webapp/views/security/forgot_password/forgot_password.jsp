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
                            <h2 class="fw-bold mb-4 text-center">Forgot password</h2>
                            <div class="alert">
								<c:if test="${not empty message}">
									<div class="alert alert-success">${message}</div>
								</c:if>
								<c:if test="${not empty error}">
									<div class="alert alert-danger">${error}</div>
								</c:if>
							</div>
                            <form action="/security/forgotpassword" method="post" class="needs-validation">
                                <div class="mb-3">
                                    <div class="form-floating mb-3 d-flex">
    									<input type="email" class="form-control rounded-3 me-2" id="email" placeholder="Enter email" name="email" required="required">
    									<label for="email">Email:</label>
    									<button formaction="/sendOTP" class="btn btn-outline-secondary" id="button-addon2">Gửi OTP</button>
									</div>
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control rounded-3" id="otp" placeholder="Enter OTP" name="otp" required="required">
                                        <label>OTP:</label>
                                    </div>
                                </div>

                                <div class="d-grid gap-2 mb-2">
                                    <button formaction="/security/forgotpassword" type="submit" id="submit" class="btn btn-lg rounded-3 btn-primary">Lấy lại mật khẩu</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <img src="forgot_password.png" alt="Image" class="img-fluid me-3">
                </div>
            </div>
        </div>
    </section>
</body>

</html>