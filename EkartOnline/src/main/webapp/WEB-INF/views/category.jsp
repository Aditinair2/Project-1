<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@include file="/WEB-INF/views/Header.jsp"%>
<style type="text/css">

.form-group input{
	width:50%;
}
</style>

	<div id="content">
		<div class="container">



			<h2 class="text-uppercase">Category</h2>


			<hr>

			<!-- LOOK HERE -->

			<h3>Add a Category</h3>

			<c:url var="addAction" value="/category/add"></c:url>
			<form:form action="${addAction}" commandName="category">


				<div class="form-group">
					<c:choose>
						<c:when test="${!empty category.id}">

							<div class="form-group">
								<label for="name">ID</label>
								<div class="controls docs-input-sizes">
									<form:input placeholder="id" path="id" required="true"
										class="form-control" id="id" disabled="true" readonly="true" />
								</div>
							</div>

						</c:when>

						<c:otherwise>

							<div class="form-group">
								<form:input path="id" hidden="true" />
								<label for="id">ID</label>
								<div class="controls docs-input-sizes">
									<form:input placeholder="id" path="id" required="true"
										class="form-control" id="id"
										title="id should contains 6 to 7 characters" patttern=".{6,7}" />
								</div>
							</div>

						</c:otherwise>
					</c:choose>

				</div>

				<div class="form-group">
					<form:input path="id" hidden="true" />
					<label for="name">Name</label>
					<div class="controls docs-input-sizes">
						<form:input placeholder="name" path="name" required="true"
							class="form-control" id="name" />
					</div>
				</div>

				<div class="form-group">
					<label for="description">description</label>
					<div class="controls docs-input-sizes">
						<form:input placeholder="description" path="description"
							class="form-control" id="description" />
					</div>
				</div>



				<div class="form-group">
					<div class="controls docs-input-sizes">
						<c:if test="${!empty category.name}">

							<button type="submit" class="btn btn-template-main pull-left">
								<i class="fa fa-user-md"></i> Edit Category
							</button>
						</c:if>
						<c:if test="${empty category.name}">

							<button type="submit" class="btn btn-template-main pull-left">
								<i class="fa fa-user-md"></i> Add Category
							</button>
						</c:if>
					</div>
				</div>
			</form:form>


			<br><br><br>

			<c:if test="${!empty categoryList}">

				<div class="row">
					<h3>Category List</h3>
					<table class="tg">
						<tr>
							<th width="80">Category ID</th>
							<th width="120">Category Name</th>
							<th width="120">Category Description</th>
							<th width="60">Edit</th>
							<th width="60">Delete</th>
						</tr>
						<c:forEach items="${categoryList}" var="category">
							<tr>
								<td>${category.id}</td>
								<td>${category.name}</td>
								<td>${category.description}</td>
								<td><a
									href="<c:url value='category/edit/${category.id}' />">Edit</a></td>
								<td><a
									href="<c:url value='category/remove/${category.id}' />">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:if>
		<br> <br> <br>


		</div>
	</div>

s