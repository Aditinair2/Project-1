<%@taglib prefix="url" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<html lang="en">
<head>
<title>EkartPage</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
	$(document).ready(function() {
		$('.dropdown-toggle').dropdown();
	});
</script>


</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">EkartOnline</a>
			</div>
			<ul class="nav navbar-nav">
				<url:url value="/" var="home1"></url:url>
				<li class="active"><a href="${home1 }">Home</a></li>
				<li><a href="aboutus">ABOUT US</a></li>
				<c:forEach items="${categoryList}" var="category">

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href='#'>${category.name}<%-- ${category.name} --%>
							<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<c:forEach items="${category.products}" var="product">

								<li><a
									href="<c:url value='all/product/viewproduct/${product.id}' />">${product.name}</a></li>

							</c:forEach>

						</ul></li>
				</c:forEach>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${pageContext.request.userPrincipal.name==null }">
					<li><a href="register"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<url:url value="/loginPage" var="home56"></url:url>
					<li><a href="${home56 }"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</c:if>

				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<li><i class="fa fa-user-admin"></i> <a>Hello,
							${pageContext.request.userPrincipal.name}</a></li>
					<li><a href="<c:url value="/j_spring_security_logout"/>">
							<i class="fa fa-sign-out"></i>Sign Out
					</a></li>
				</c:if>
				</li>
			</ul>
		</div>

		<li>
			<div>
				<!-- *** MENU BAR***-->
				<hr color="red" size="5">

				<ul id="menu">
					<div class="container">
						<div class="row">
							<%-- <c:forEach items="${categoryList}" var="category">

							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href='#'>${category.name}${category.name}
									<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<c:forEach items="${category.products}" var="product">

										<li><a href="<c:url value='product/get/${product.id}' />">${product.name}</a></li>

									</c:forEach>

								</ul></li>
						</c:forEach> --%>
						</div>
					</div>
				</ul>
		</li>

		<ul class="nav navbar-nav">
			<li><c:choose>
					<c:when test="${pageContext.request.userPrincipal.name != null}">
						<c:if test="${pageContext.request.userPrincipal.name == 'Admin'}">
							<li><a href="<c:url value='/categories'/>">Category</a></li>
							<li><a href="<c:url value="/suppliers"/>">Supplier</a></li>
							<li><a href="<c:url value="/admin/product/productform"/>">Product</a></li>
						</c:if>

						<c:if test="${pageContext.request.userPrincipal.name != 'Admin'}">

							<li><a href="<c:url value="/user/cart/view/${cartId}"/>">Cart</a></li>

						</c:if>
					</c:when>
					<c:otherwise>


					</c:otherwise>
				</c:choose></li>
		</ul>
		</div>
	</nav>

	<%-- <li><c:choose>
			<c:when test="${pageContext.request.userPrincipal.name != null}">
				<c:if test="${pageContext.request.userPrincipal.name == 'Admin'}">

					<li><a href="<c:url value='/categories'/>">Category</a></li>
					<li><a href="<c:url value="/suppliers"/>">Supplier</a></li>
					<li><a href="<c:url value="/admin/product/productform"/>">Product</a></li>
				</c:if>

				<c:if test="${pageContext.request.userPrincipal.name != 'Admin'}">

					<li><a href="<c:url value="/user/cart/view/${cartId}"/>">Cart</a></li>

				</c:if>
			</c:when>

			<c:otherwise>


			</c:otherwise>
		</c:choose></li> --%>
	</ul>
	</div>
	</nav>



</body>
</html>


</head>

