<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html lang="en">

<head>
<%@include file="/WEB-INF/views/Header.jsp"%>
<style type="text/css">
.form-group input{
	width:50%;
}
</style>
</head>


<body>

	<div id="all">
<div id="heading-breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col-md-7">
						<h1>Sign in</h1>
					</div>
					<div class="col-md-5">
						<ul class="breadcrumb">
							<li><a href="<c:url value="/"/>">Home</a></li>
							<li>Sign in</li>
						</ul>

					</div>
				</div>
			</div>
		</div>

		<div id="content">
			<div class="container">

						<h2 class="text-uppercase">Login</h2>

						<p class="lead">Already our customer?</p>
						<hr>
						
						<!-- LOOK HERE -->
						<form name="login"
							action="<c:url value='/j_spring_security_check' />" method="post">

							<c:if test="${not empty error}">
								<div class="error" style="color: #ff0000;">${error}</div>
							</c:if>
							
							<div class="span9 center">
								<c:if test="${not empty msg}">
									<div class="msg">${msg} </div>
								</c:if>
							</div>


								<div class="form-group">
									<label for="uname">User name</label>
									
									<input type="text" id="username" name="username" class="form-control" placeholder="user name"/>
								</div>
								<div class="form-group">
									<label for="password">Password</label> 
									
									<input type="password" id="password" name="password" class="form-control" placeholder="password"/>
								</div>
								<div class="text-center form-group">
									<button type="submit" class="btn btn-template-main pull-left">
										<i class="fa fa-sign-in"></i> Log in
									</button>
									<a href="<spring:url value="/" />" class="btn btn-danger margin-left25">Cancel</a>
								</div>
								<!-- LOOK HERE -->

								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
						</form>




						<br>
						<br>
						<br>
				

			</div>

		</div>
		<!-- /#content -->


		<!-- *** GET IT ***
_________________________________________________________ -->



		<!-- *** GET IT END *** -->


		<!-- *** FOOTER ***
_________________________________________________________ -->






		<%@include file="/WEB-INF/views/Footer.jsp"%>





		<!-- /#footer -->

		<!-- *** FOOTER END *** -->

		<!-- *** COPYRIGHT ***
_________________________________________________________ -->


		<!-- /#copyright -->

		<!-- *** COPYRIGHT END *** -->



	</div>
	

	
</body>
</html>