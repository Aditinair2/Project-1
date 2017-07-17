<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<%@include file="/WEB-INF/views/Header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product page</title>
</head>
<body>

	<div id="content">
		<div class="container">
			<div class="flex-container">


				<h2 class="text-uppercase">Product</h2>

				<hr>

				<!-- LOOK HERE -->


				<h3>Add a Product</h3>
				<c:url value="/addproduct" var="url"></c:url>
				<form:form action="${url }" commandName="product" method="POST"  enctype="multipart/form-data">

					<div class="form-group">

						<form:hidden path="id" />
						<form:errors cssClass="" path="id"></form:errors>
					</div>

					<div>
						<form:input path="name" placeholder="Enter Name" />
						<form:errors cssClass="" path="name"></form:errors>
					</div>

					<div>
						<form:input path="price" placeholder="Enter Price" />
						<form:errors cssClass="" path="price"></form:errors>
					</div>


					<div>
						<form:input path="description" placeholder="Enter Description" />
						<form:errors cssClass="" path="description"></form:errors>
					</div>


					<div>
						<label for="supplier">Supplier</label>
						<div class="select-style">
							<%-- <form:select path="category.id" items="${categoryList}"
							itemValue="" itemLabel="name" /> --%>
							<c:forEach items="${supplierList}" var="s">


								<input type="radio" name="supplier" value="${s.id}" />${s.name}
							</c:forEach>
						</div>

					</div>


					<div>
						<label for="category">Category</label>
						<div class="select-style">
							<%-- <form:select path="category.id" items="${categoryList}"
							itemValue="" itemLabel="name" /> --%>
							<c:forEach items="${categoryList}" var="c">




								<input type="radio" name="category" value="${c.id}" />${c.name}
							</c:forEach>
						</div>
					</div>

					<div class="form-group">
						<div class="controls docs-input-sizes">
							
							<c:if test="${empty product.name}">

								
							</c:if>
						</div>
					</div>



					<br>
					<br>
					<div class="form-group">
						<label for="itemImage">Upload Image</label> <input type="file"
							name="itemImage">
					</div>


					<input type="submit" value="Add Product">
				</form:form>

			</div>
			<!-- End of flex-container -->


			<table class="table">
				<h4>PRODUCT LIST</h4>
				<thead>

					<tr>
						<th>Product Name</th>
						<th>Product Price</th>
						<th>Category</th>
						<th>Supplier</th><br><br>
						<th>Action</th>

					</tr>
				</thead>

				<c:forEach items="${productList }" var="p">
					<tr>
						<td>${p.name }</td>

						<td>${p.price }</td>

						<td>${p.category.name }</td>

						<td>${p.supplier.name}</td>
						<td>
						<c:url value="/product/edit/${p.id}" var="edit" />
						<td><a href="${edit }">Edit</a></td>
						<c:url value="/product/remove/${p.id}" var="remove" />
						<td><a href="${remove }">Delete</a></td>
						<c:url value="/all/product/viewproduct/${p.id}" var="view" />
						<td><a href="${view }">View</a>
						</td>
						
					</tr>
				



				</c:forEach>


			</table>


		</div>
		<!-- End of container div -->
	</div>
	<!-- End of content div -->



</body>
</html>