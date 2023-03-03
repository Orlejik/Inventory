<%--
  Created by IntelliJ IDEA.
  User: strigoy
  Date: 3/2/2023
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <title>Main Page</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<div>
    <h3>${pageContext.request.userPrincipal.name}</h3>
    <sec:authorize access="!isAuthenticated()">
        <h4>
            <a href="/login">Login</a>
        </h4>
        <h4>
            <a href="/registration"> Register </a>
        </h4>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h4>
            <a href="/logout">logout</a>
        </h4>
    </sec:authorize>
    <h4>
        <a href="/news"> News(only for users)</a>
    </h4>
    <h4>
        <a href="/admin">Users(only for admins)</a>
    </h4>
</div>

</body>
</html>
