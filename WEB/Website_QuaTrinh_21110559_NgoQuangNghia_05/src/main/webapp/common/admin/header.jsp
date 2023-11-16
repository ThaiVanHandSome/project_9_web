<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="/Website_QuaTrinh_21110559_NgoQuangNghia_03/admin/home">LapTrinhWeb</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-auto d-flex justify-content-center">
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="/Website_QuaTrinh_21110559_NgoQuangNghia_03/home">Trang chủ user</a></li>
					<li class="nav-item"><a class="nav-link" href="/Website_QuaTrinh_21110559_NgoQuangNghia_03/product">Sản phẩm</a></li>
				</ul>
				
			</div>	
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li style="list-style-position:right"class="ms-lg-4 nav-item ms-auto"><a class="nav-link">Tài khoản: ${account}</a></li>    
			</ul>

		</div>
	</nav>
	<!-- Header-->
	<header class="bg-dark py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
				<h1 class="display-4 fw-bolder">Lập trình web</h1>
			</div>
		</div>
	</header>
</div>