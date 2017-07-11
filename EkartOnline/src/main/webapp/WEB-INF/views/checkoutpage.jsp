<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="url"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page isELIgnored="false"%>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width,initial-scale=1">

<!-- Latest compiled and minified CSS -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">

<!-- jQuery library -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>




<!-- Latest compiled JavaScript -->

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href='../../../resources/theme1/css/checkoutcss.css'>

<title>Shipping & Payment Info</title>

</head>

<body>

	<h3>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		&nbsp &nbsp &nbsp &nbsp &nbsp Please confirm your Shipping and Payment
		details.</h3>

	<div class="container wrapper">

		<div class="container">

			<c:url value="/page" var="vart12"></c:url>

			<form:form action="${vart12 }" modelAttribute="userDetail"
				method="post">

				<div class="form-group">

					<label for="id"></label>

					<form:hidden path="id"></form:hidden>

					<form:errors path="id" cssStyle="color:red"></form:errors>

				</div>

				<!-- <table class="table table-bordered"> 

<tr>

<td> -->



<
				<div class="form-group">

					<label for="userFullName"></label>

					<form:hidden path="userFullName"></form:hidden>
					<form:errors path="userFullName" cssStyle="color:red"></form:errors>
				</div>




				<!-- </td>

</tr>

<tr>

<td> -->

				<%-- <div class="form-group">

					<label for="username"></label>

					<form:hidden path="username"></form:hidden>

					<form:errors path="username" cssStyle="color:red"></form:errors>

				</div> --%>

				<!-- </tr>

</table> -->

				<table class="table table-bordered">

					<tr>

						<td>
							<!-- <div class="form-group"> --> <label for="email">E-mail</label>

						</td>

						<td><form:input path="userEmail"></form:input> <form:errors
								path="userEmail" cssStyle="color:red"></form:errors> <span
							style="color: red">${duplicateEmail }</span> <!-- </div> --></td>

					</tr>

					<tr>

						<td>
							<!-- <div class="form-group"> --> <label for="userPhone">Phone</label>

						</td>

						<td><form:input path="userPhone"></form:input> <form:errors
								path="userPhone" cssStyle="color:red"></form:errors> <!-- </div> -->

						</td>

					</tr>

				</table>




				<%-- <table class="table table-bordered">

<caption>Billing Address</caption>



<tr>

<td> --%>

				<div class="form-group">

					<label for="billingAddress"></label>

					<form:hidden path="billingAddress.Id"></form:hidden>

					<form:errors path="billingAddress.Id" cssStyle="color:red"></form:errors>

				</div>

				<!-- </td>

</tr>

</table> -->

				<table class="table table-bordered">

					<caption>Billing Address</caption>

					<tr>

						<td>
							<!-- <div class="form-group"> --> <label
							for="billingAddress.houseNo">HouseNo</label>

						</td>

						<td><form:input path="billingAddress.houseNo"></form:input> <form:errors
								path="billingAddress.houseNo" cssStyle="color:red"></form:errors>
							<!-- </div> --></td>

					</tr>




					<tr>

						<td>
							<!-- <div class="form-group"> --> <label
							for="billingAddress.addressLine1">AddressLine1 </label>

						</td>

						<td><form:input path="billingAddress.addressLine1"></form:input>

							<form:errors path="billingAddress.addressLine1"
								cssStyle="color:red"></form:errors> <!-- </div> --></td>

					</tr>
					<tr>

						<td>
							<!-- <div class="form-group"> --> <label
							for="billingAddress.addressLine2">AddressLine2</label>

						</td>

						<td><form:input path="billingAddress.addressLine2"></form:input>

							<form:errors path="billingAddress.addressLine2"
								cssStyle="color:red"></form:errors> <!-- </div> --></td>

					</tr>




					<tr>

						<td>
							<!-- <div class="form-group"> --> <label
							for="billingAddress.city">City</label>

						</td>

						<td><form:input path="billingAddress.city"></form:input> <form:errors
								path="billingAddress.city" cssStyle="color:red"></form:errors> <!-- </div> -->

						</td>

					</tr>




					<tr>

						<td>
							<!-- <div class="form-group"> --> <label
							for="billingAddress.country">Country</label>

						</td>

						<td><form:input path="billingAddress.country"></form:input> <form:errors
								path="billingAddress.country" cssStyle="color:red"></form:errors>

							<!-- </div> --></td>

					</tr>




					<tr>

						<td>
							<!-- <div class="form-group"> --> <label
							for="billingAddress.zipcode">Zipcode</label>

						</td>

						<td><form:input path="billingAddress.zipcode"></form:input> <form:errors
								path="billingAddress.zipcode" cssStyle="color:red"></form:errors>

							<!-- </div> --></td>

					</tr>

				</table>




				<%-- <table class="table table-bordered">

<caption>Shipping Address</caption>



<tr>

<td> --%>

				<div class="form-group">

					<label for="ShippingAddress"></label>

					<form:hidden path="ShippingAddress.Id"></form:hidden>

					<form:errors path="ShippingAddress.Id" cssStyle="color:red"></form:errors>

				</div>

				<!-- </td>

</tr>

</table> -->

				<table class="table table-bordered">

					<caption>Shipping Address</caption>

					<tr>

						<td>
							<!-- <div class="form-group"> --> <label
							for="ShippingAddress.houseNo">HouseNo</label>

						</td>

						<td><form:input path="ShippingAddress.houseNo"></form:input>

							<form:errors path="ShippingAddress.houseNo" cssStyle="color:red"></form:errors>
							<!-- </div> --></td>

					</tr>




					<tr>

						<td>
							<!-- <div class="form-group"> --> <label
							for="ShippingAddress.addressLine1">AddressLine1</label>

						</td>

						<td><form:input path="ShippingAddress.addressLine1"></form:input>

							<form:errors path="ShippingAddress.addressLine1"
								cssStyle="color:red"></form:errors> <!-- </div> --></td>

					</tr>

                   <tr>

						<td>
							<!-- <div class="form-group"> --> <label
							for="ShippingAddress.addressLine2">AddressLine2</label>

						</td>

						<td><form:input path="ShippingAddress.addressLine2"></form:input>

							<form:errors path="ShippingAddress.addressLine2"
								cssStyle="color:red"></form:errors> <!-- </div> --></td>

					</tr>
                   



					<tr>

						<td>
							<!-- <div class="form-group"> --> <label
							for="ShippingAddress.city">City</label>

						</td>

						<td><form:input path="ShippingAddress.city"></form:input> <form:errors
								path="ShippingAddress.city" cssStyle="color:red"></form:errors>

							<!-- </div> --></td>

					</tr>




					<tr>

						<td>
							<!-- <div class="form-group"> --> <label
							for="ShippingAddress.country">Country</label>

						</td>

						<td><form:input path="ShippingAddress.country"></form:input>

							<form:errors path="ShippingAddress.country" cssStyle="color:red"></form:errors>

							<!-- </div> --></td>

					</tr>




					<tr>

						<td>
							<!-- <div class="form-group"> --> <label
							for="ShippingAddress.zipcode">Zipcode</label>

						</td>

						<td><form:input path="ShippingAddress.zipcode"></form:input>

							<form:errors path="ShippingAddress.zipcode" cssStyle="color:red"></form:errors>

							<!-- </div> --></td>

					</tr>

				</table>




				<!-- <tr>

<td> -->

				<div class="form-group">

					<label for="cart"></label>

					<form:hidden path="cart.cartId"></form:hidden>

					<form:errors path="cart.cartId" cssStyle="color:red"></form:errors>

				</div>

				<!-- </td>

</tr> -->




				<!-- <tr>

<td> -->

				<div class="form-group">

					<label for="cart"></label>

					<form:hidden path="cart.usersDetail.id"></form:hidden>

					<form:errors path="cart.usersDetail.id" cssStyle="color:red"></form:errors>

				</div>

				<!-- </td>

</tr> -->




				<!-- <tr>

<td> -->

				<div class="form-group">

					<label for="user"></label>

					<form:hidden path="user.id"></form:hidden>

					<form:errors path="user.id" cssStyle="color:red"></form:errors>

				</div>

				<!-- </td>

</tr> -->




				<!-- <tr>

<td> -->

				<div class="form-group">

					<label for="user"></label>

					<form:hidden path="user.username"></form:hidden>

					<form:errors path="user.username" cssStyle="color:red"></form:errors>

				</div>

				<!-- </td>

</tr> -->




				<!-- <tr>

<td> -->

				<div class="form-group">

					<label for="user"></label>

					<form:hidden path="user.password"></form:hidden>

					<form:errors path="user.password" cssStyle="color:red"></form:errors>

				</div>
				
				<%-- <div class="form-group">

					<label for="password"></label>

					<form:hidden path="password"></form:hidden>

					<form:errors path="password" cssStyle="color:red"></form:errors>

				</div>
 --%>
				<!-- </td>

</tr> -->




				<!-- <tr>

<td> -->

				<div class="form-group">

					<label for="user"></label>

					<form:hidden path="user.enabled"></form:hidden>

					<form:errors path="user.enabled" cssStyle="color:red"></form:errors>

				</div>





				 <input type="submit" name="submit" value="Purchase"/>

               



			</form:form>

		</div>

	</div>

</body>

</html>

<%-- <%@ include file="Footer.jsp"%> --%>
