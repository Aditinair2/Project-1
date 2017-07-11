 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/WEB-INF/views/Header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<div id="all">
<div id="heading-breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col-md-7">
						<h1>Home</h1>
					</div>
					<div class="col-md-5">
						<ul class="breadcrumb">
							<li><a href="<c:url value="/"/>">Home</a></li>
							<li>Register</li>
				</ul>
</div>
</div>
</div></div>

<h3 align="center">You are successfully registered</h3>

		<br>
		<br>
<div id="put-center" align="center">

<a href="<c:url value="/"/>"  class="btn btn-template-main" >Continue shopping</a>

</div>
		<br>
		<br>
		<br>


		<%@include file="/WEB-INF/views/Footer.jsp"%>
		<!-- /#footer -->


	</div>
	<!-- /#all -->


	<!-- #### JAVASCRIPT FILES ### -->
	
</body>
</html> 