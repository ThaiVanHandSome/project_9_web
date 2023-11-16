<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Giỏ hàng</title>
<link rel="stylesheet" type="text/css" href=".cart.css">
</head>
<body>
	<!-- Content -->
	<div class="content">
		<!--  Title-->
		<div class="title">
			<h1>Giỏ hàng của tôi</h1>
		</div>

		<!-- List Cart -->
		<ul class="list-cart">
			<li class="cart-item">
				<div class="product-container">
					<input class="check-box-cart-item" type="checkbox"> <img
						class="image-cart" src="path-to-image.jpg" alt="">
                    <div class="product-cart">
                        <span class="name-cart">Product Name</span> <span
						class="price-cart">35.000</span>
                    </div>					
				</div>

				<div class="quantity-container">
					<button class="plus-minus">-</button>
					<span class="quantity">1</span>
					<button class="plus-minus">+</button>
				</div>
			</li>
			<li class="cart-item">
				<div class="product-container">
					<input class="check-box-cart-item" type="checkbox"> <img
						class="image-cart" src="path-to-image.jpg" alt="">
                    <div class="product-cart">
                        <span class="name-cart">Product Name</span> <span
                        class="price-cart">35.000</span>
                    </div>
				</div>

				<div class="quantity-container">
					<button class="plus-minus">-</button>
					<span class="quantity">1</span>
					<button class="plus-minus">+</button>
				</div>
			</li>
			<!-- Add more list items as needed -->
		</ul>

		<!-- Total price -->
		<div class="order-container">
				<!-- Check box -->
			<div class="check-container">
				<input class="check-box-cart" type="checkbox"> 
				<span class="all-order">Tất cả</span> 
			</div>
			
			<!-- Total Price -->
			<div class="total-price">
				<span class="total-price-title">Tổng giá:</span> 
				<span class="price-cart">35.000</span>
			</div>
			
			<button class="order-btn">Đặt hàng</button>
		</div>
	</div>
</body>
</html>