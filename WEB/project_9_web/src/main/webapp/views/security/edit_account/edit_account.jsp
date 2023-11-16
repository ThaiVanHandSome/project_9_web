<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
    <section class="bg-white">
        <div class="container py-2 h-100">
            <div class="row d-flex justify-content-center align-content-start align-items-center">
                <div class="col-12 col-md-8 col-lg-8 col-xl-6">
                    <div class="card rounded-4 shadow">
                        <div class="card-body p-md-5 p-sm-2">
                        	<div class="alert">
								<c:if test="${not empty message}">
									<div class="alert alert-success">${message}</div>
								</c:if>
								<c:if test="${not empty error}">
									<div class="alert alert-danger">${error}</div>
								</c:if>
							</div>
                            <form action="/security/edit-account" method="post">
                                <h3 class="fw-bold mb-4">Edit Account</h3>
                                <div class="form-floating mb-3">
                                        <input type="text" id="surname" name="surname" class="form-control" placeholder="Họ" />
                                        <label class="form-label">Họ</label>
                                </div>
                                <div class="form-floating mb-3">
                                        <input type="text" id="name" name="name" class="form-control" placeholder="Tên" />
                                        <label class="form-label">Tên</label>
                                </div>
    							<div class="form-floating mb-3">
                                        <input type="password" id="password" name="password" class="form-control" placeholder="Password" />
                                        <label class="form-label">Password</label>
                                </div>
                                <div class="form-floating mb-3">
                                        <input type="password" id="password" name="password_confirm" class="form-control" placeholder="Confirm Password" />
                                        <label class="form-label">Confirm Password</label>
                                </div>
                                <div class="form-floating mb-3">
                                        <input type="text" id="email" name="email" class="form-control" placeholder="Email" />
                                        <label class="form-label">Email</label>
                                </div>
                                <div class="form-floating mb-3">
                                        <input type="date" id="dob" name="dob" class="form-control" placeholder="Date of Birth" />
                                        <label class="form-label">Date of Birth</label>
                                </div>
                                <div class="form-floating mb-3">
                                        <input type="text" id="id_branch" name="id_branch" class="form-control" placeholder="Branch ID" />
                                        <label class="form-label">Branch ID</label>
                                </div>
                                <div class="form-group mb-3">
                                    <label class="form-label">Role</label><br>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="checkbox" id="role_user" name="role" value="user">
                                        <label class="form-check-label" for="role_user">User</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="checkbox" id="role_admin" name="role" value="admin">
                                        <label class="form-check-label" for="role_admin">Admin</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="checkbox" id="role_manager" name="role" value="manager">
                                        <label class="form-check-label" for="role_manager">Manager</label>
                                    </div>
                                </div>
                                <div class="d-grid gap-2 mb-2">
                                    <button formaction="/security/edit-account" type="submit" id="submit" class="btn btn-lg rounded-3 btn-primary">Edit Account</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <img src="edit_account.jpg" alt="Image" class="img-fluid me-3">
                </div>
            </div>
        </div>
    </section>
</body>
</html>