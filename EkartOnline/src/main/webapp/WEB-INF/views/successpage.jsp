<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="url" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Successful</title>
<link rel="stylesheet" href='resources/theme1/css/finalcss.css'>
</head>
<body>
<%@ include file="Header.jsp"%>
<h3>${userDetail.userFullName }, Your order is successful and will arrive in 3-5 working days.</h3>
<p>Have a nice day!</p>
</body>
</html>
<%@ include file="Footer.jsp"%>