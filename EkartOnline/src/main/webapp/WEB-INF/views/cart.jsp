<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="span9 margin-bottom center">
	<h3>Items in your cart</h3>
</div>


<div class="span9 margin-left10">

	<c:set var="grandTotal" scope="session" value="${0}" />
	<h4>${successMsg}</h4>

	<div class="row margin-left25">
		<c:if test="${!empty cartList}">
			<table class="table table-bordered table-striped fs13">
				<thead>
					<tr>
						<th>Image</th>
						<th class="width110">Product</th>
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
							<td>${cartItem.quantity}</td>
							<td>${cartItem.totalPrice}</td>
							<td><a
								href="<c:url value="/usercart/cart/removeItem/${cartItem.product.id}/${cartId}"/>"
								class="btn btn-danger btnAction"> <span
									class="glyphicon glyphicon-remove"></span>remove
							</a></td>
							<c:set var="grandTotal"
								value="${cartItem.quantity+cartItem.product.price+grandTotal}" />

						</tr>
					</c:forEach>
					<tr>
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



		<div class="row">
			<div class="span3">
				<a href="<spring:url value="/" />" class="btn btn-primary center">Continue
					Shopping</a>
			</div>
			<div class="span3">
				<a href="<spring:url value="/order/${cartId}"/>"
					class="btn btn-success center"><span
					class="glyphicon-shopping-cart glyphicon"></span> Check out </a>
			</div>
			<div class="span2">
				<a href="<c:url value='/usercart/cart/clearCartItems/${cartId}'/>"
					class="btn btn-danger center"><span
					class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
			</div>
		</div>
	</div>
</div>
<!-- #### JAVASCRIPT FILES ### -->
<%--  <%@include file="/WEB-INF/views/scriptfiles.jsp"%>  --%>