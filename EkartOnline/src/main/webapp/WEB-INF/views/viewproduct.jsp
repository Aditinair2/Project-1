<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Details</title>
</head>
<%@include file="/WEB-INF/views/Header.jsp"%>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<h2 class="text-uppercase">Product</h2>
				<p>
					<br>${selectedProduct.id} <br>${selectedProduct.name} <br>${selectedProduct.description}
					<br>Rs.${selectedProduct.price} <br>${selectedProduct.category.name}
					<br>${selectedProduct.supplier.name}

					<c:if test="${pageContext.request.userPrincipal.name != 'Admin'}">
						<p>
							
							<c:if
								test="${pageContext.request.userPrincipal.name  != 'Admin'}">
								<a
									href="<c:url value="/user/cart/additem/${selectedProduct.id}"/>"
									class="btn btn-primary"><span
									class="glyphicon glyphicon-shopping-cart"></span>Add to cart </a>
									
									

								
							</c:if>
						</p>
					</c:if>
					<c:if test="${pageContext.request.userPrincipal.name == 'Admin'}">
						<p>
							<a href="<c:url value="/product/edit/${selectedProduct.id}"/>"
								class="btn btn-primary">Edit</a>
						</p>
					</c:if>
					<br> <br> <br>
				</p>
			</div>
			<div class="col-md-8 text-center">
				<img alt=""
					src="<c:url value="../../../resources/images/${selectedProduct.id}.png"/>" />
			</div>
		</div>
	</div>
	</section>


	<%@include file="/WEB-INF/views/Footer.jsp"%>

	</div>
	<!-- /#all -->







</body>
</html>