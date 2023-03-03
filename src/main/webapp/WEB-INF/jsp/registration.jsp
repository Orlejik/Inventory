<%--
  Created by IntelliJ IDEA.
  User: strigoy
  Date: 3/2/2023
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>

<div>
    <form:form action="POST" modelAttribute="userForm">
        <h2> Registration </h2>
        <div>
            <form:input type="text" path="username" placeholder="Username" autofocus="true"></form:input>
            <form:errors path="username"></form:errors>
            ${usernameError}
        </div>
        <div>
            <form:input type="password" path="password" placeholder="Password"></form:input>
        </div>
        <div>
            <form:input type="password" path="passwordConfirm" placeholder="Confirm your password"></form:input>
            <form:errors path="password"></form:errors>
            ${passwordError}
        </div>
        <button type="submit"> Registration </button>
    </form:form>
</div>
<a href="/"> Main </a>
</body>
</html>
