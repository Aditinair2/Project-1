<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">

<head>
<%@include file="/WEB-INF/views/Header.jsp"%>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	/* border-color: #ccc; */
	width: 100%;
}

.tg tr:hover {
	background-color: #f5f5f5
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	text-align: center;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9;
}

/* section {
	height: 100%;
	min-height: 25cm;
	width: 100%;
} */
</style>


</head>

<body>


	<div id="all">

		<div id="heading-breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col-md-7">
						<h1>My cart</h1>
					</div>
					<div class="col-md-5">
						<ul class="breadcrumb">
							<li><a href="<c:url value="/"/>">Home</a></li>
							<li>My Cart</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<section>

			<!-- <div class="span9 margin-bottom center">
				<h3>Items in your cart</h3>
			</div> -->


			<div class="span9 margin-left10">
				<div class="container">
					<div class="row">
						<c:set var="grandTotal" scope="session" value="${0}" />
						<h3 align="center" style="color: #79be25;">${successMsg}</h3>
						<br>
						<br>

						<div class="row margin-left25">
							<c:if test="${empty cartList}">
								<h3 align="center" style="color: #ff0000;">Your cart is
									empty</h3>
								<br>
								<br>
								<br>
								<br>
								<br>
								<br>
								<br>
								<br>
								<br>
							</c:if>
							<c:if test="${!empty cartList}">
								<table class="table table-bordered table-striped fs13">
									<thead align="center">
										<tr>
											<th>Image</th>
											<th class="width110">Product ID</th>
											<th>Product Name</th>
											<th>Unit Price</th>
											<th>Quantity</th>
											<th>Price(in Rs.)</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${cartList}" var="cartItem">
											<tr>
												<td class="span1"><img
													src="<c:url value='/resources/img/productImages/${cartItem.product.id}.png'/>"
													alt="image" width="140" height="140" /></td>
												<td>${cartItem.product.id}</td>
												<td>${cartItem.product.name}</td>
												<td>${cartItem.product.price}</td>
												<td>${cartItem.quantity}&nbsp;&nbsp;&nbsp; <a
													href="<c:url value="/usercart/cart/addQty/${cartItem.product.id}/${cartId}"/>"
													class="btn btn-primary center">+ </a>&nbsp;&nbsp;&nbsp; <a
													href="<c:url value="/usercart/cart/reduceQty/${cartItem.product.id}/${cartId}"/>"
													class="btn btn-danger btnAction">- </a>
												</td>
												<td>${cartItem.totalPrice}</td>
												<td><a
													href="<c:url value="/usercart/cart/removeItem/${cartItem.product.id}/${cartId}"/>"
													class="btn btn-danger btnAction"> <span
														class="glyphicon glyphicon-remove"></span>remove
												</a></td>
												<c:set var="grandTotal"
													value="${cartItem.totalPrice+grandTotal}" />

											</tr>
										</c:forEach>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>Grand Total(in Rs.)</td>
											<td><c:out value="${grandTotal}" /></td>
											<td>
										</tr>
									</tbody>
								</table>
							</c:if>

							<br>
							<%-- <br> <a
								href="<c:url value="/usercart/cart/update/${cartId}"/>"
								class="btn btn-danger btnAction">Update </a> <br>
							<br> <a
								href="<c:url value="/usercart/cart/refreshCart/${cartId}"/>"
								class="btn btn-primary"> Refresh </a> <br>
							<br> --%>

							<div class="row">
								<div class="span3">
									<a href="<spring:url value="/" />"
										class="btn btn-primary center">Continue Shopping</a>
								</div>
								<br>
								<br>
								<div class="span3">
									<a href="<spring:url value="/user/cart/checkout/${cartId}"/>"
										class="btn btn-success center"><span
										class="glyphicon-shopping-cart glyphicon"></span> Check out </a>
								</div>
								<br>
								<br>
								<div class="span2">
									<a
										href="<c:url value='/user/cart/cart/clearCartItems/${cartId}'/>"
										class="btn btn-danger center"><span
										class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
								</div>
								<br>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- #### JAVASCRIPT FILES ### -->
			<%-- <%@include file="/WEB-INF/views/scriptfiles.jsp"%>
 --%>



		</section>




		<%@include file="/WEB-INF/views/Footer.jsp"%>

	</div>
	<!-- /#all -->




</body>
</html>