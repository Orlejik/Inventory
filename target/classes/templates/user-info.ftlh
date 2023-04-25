<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>User Info</title>
    <style type="text/css">
        <#include "css/mdb.rtl.min.css">
        <#include "css/main.css">
        <#include "css/mdb.min.css">
        <#include "css/mdb.dark.rtl.min.css">
        <#include "css/mdb.dark.min.css">
    </style>
</head>
<body class="overflow-hidden">
<nav class="navbar shadow-4 navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <button
                class="navbar-toggler"
                type="button"
                data-mdb-toggle="collapse"
                data-mdb-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <i class="fas fa-bars"></i>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <a class="navbar-brand mt-2 mt-lg-0" href="/">
                <img src="./images/FujiInv.png" alt="Fuji Logo" />
            </a>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/">All Items</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" active href="/additem">Add Item</a>
                </li>
                <li sec:authorize="hasRole('ADMIN')" class="nav-item">
                    <a class="nav-link" href="/assets-add">Add Asset</a>
                </li>
                <li sec:authorize="hasRole('ADMIN')" class="nav-item">
                    <a class="nav-link" active href="/user-add">Add new User</a>
                </li>
            </ul>
        </div>
        <div class="d-flex align-items-center">
            <div class="d-flex align-items-center">
                <a href="/logout">
                    <button type="button" class="btn btn-dark custom_btn_hover" data-mdb-ripple-color="dark"></button>
                </a>
            </div>
        </div>
    </div>
</nav>

<div class="p-5 text-center bg-transparent ">
    <h1 class="mb-3 header_text">${userInfo.username} Info</h1>
</div>

<form action="/users/create" method="post" class="row g-3" enctype="multipart/form-data">
    <div class="col-md-1"></div>
    <div class="col-md-3">
        <label for="username" class="form-label">User Name</label>
        <input type="text" value="${userInfo.username}" name="username" class="form-control" id="username" required>
    </div>
    <div class="col-md-4">
        <label for="email" class="form-label">User E-Mail</label>
        <input type="text" value="${userInfo.email}" name="email" class="form-control" id="email" required>
    </div>
    <div class="col-md-3">
        <label for="password" class="form-label">Password</label>
        <input type="text" class="form-control" value="${userInfo.password}" name="password" id="password" required>
    </div>
    <div class="col-md-1"></div>

    <div class="col-md-3"></div>
    <div class="col-md-2">
        <label for="isActive" class="form-label">Is Active</label>
        <input value="${
                        userInfo.active?then("Active", "Not Active")
                        }" class="form-control" name="isActive" id="isActive" type="text">
    </div>
    <div class="col-md-2">
        <label for="plant" class="form-label">Plant</label>
        <input value="${userInfo.plant}" class="form-control" name="plant" id="plant" type="text">
    </div>
    <div class="col-md-2">
        <label for="roles" class="form-label">Role</label>
        <input value="${userInfo.roles}" class="form-control" name="roles" id="roles" type="text">
    </div>
    <div class="col-md-3"></div>

    <div class="col-md-4"></div>
    <div class="col-md-4">
        <label for="department" class="form-label">Department</label>
        <input type="text" class="form-control" name="department" id="department" value="${userInfo.department}">
    </div>
    <div class="col-md-4"></div>


    <div class="col-2"></div>
    <div class="col-3  text-center">
        <button class="btn btn-primary" id="addItemButton" data-mdb-ripple-color="dark" type="submit">Add New User</button>
    </div>
    <div class="col-2"></div>
    <div class="col-3  text-center">
            <input class="btn btn-danger" id="addItemButton" data-mdb-ripple-color="dark" onclick="history.back()" value="Cancel" type="button">
    </div>
    <div class="col-2"></div>
</form>

<script>
    <#include "javascript/mdb.min.js">
    <#include "javascript/main.js">
</script>

</body>
</html>