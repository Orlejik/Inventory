<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
                      xmlns:sec="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style type="text/css">
        <#include "css/mdb.rtl.min.css">
        <#include "css/mdb.min.css">
        <#include "css/main.css">
        <#include "css/mdb.dark.rtl.min.css">
        <#include "css/mdb.dark.min.css">
    </style>
    <title> List of Assets </title>
</head>
<body class="overflow-hidden">
<#assign numberOfItems = 0>
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
                <img src="./images/FujiInv.png" alt="Fuji Logo"/>
            </a>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" active href="/">All Items</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" active href="/additem">Add Item</a>
                </li>
                <li sec:authorize="hasRole('ROLE_ADMIN')" class="nav-item">
                    <a class="nav-link" href="/assets-add">Add Asset</a>
                </li>
                <li sec:authorize="hasRole('ROLE_ADMIN')" class="nav-item">
                    <a class="nav-link" active href="/user-add">Add new User</a>
                </li>
            </ul>
        </div>
        <div class="d-flex align-items-center">
            <div class="d-flex align-items-center">
                <a href="/logout">
                    <button type="button" class="btn btn-outline-dark" data-mdb-ripple-color="dark">Log Out</button>
                </a>
            </div>
        </div>
    </div>
</nav>


<div class="p-5 text-center bg-transparent ">
    <h1 class="mb-3 header_text">Inventoried Items</h1>
</div>


<form action="#" method="post" class="g-3 row" enctype="multipart/form-data">
    <div class="col-md-1"></div>
    <div class="col-md-1">
        <label for="Plant" class="form-label">Find by Plant</label>
        <input type="text" name="Plant" class="form-control" id="sis_number">
    </div>
    <div class="col-md-1">
        <label for="fae_number" class="form-label">Find by FAE Number</label>
        <input type="text" name="fae_number" class="form-control" id="sis_number">
    </div>
    <div class="col-md-1">
        <label for="sis_number" class="form-label">Find by SIS Number</label>
        <input type="text" name="sis_number" class="form-control" id="itemname">
    </div>
    <div class="col-md-1">
        <label for="itemname" class="form-label">Find by Item Type</label>
        <input type="text" name="itemname" class="form-control" id="itemname">
    </div>
    <div class="col-md-1">
        <label for="item_brand" class="form-label">Find by Item Brand</label>
        <input type="text" name="item_brand" class="form-control" id="item_brand">
    </div>
    <div class="col-md-1">
        <label for="item_model" class="form-label">Find by Item Model</label>
        <input type="password" class="form-control" name="item_model" id="item_model">
    </div>
    <div class="col-md-1">
        <label for="serialNamber" class="form-label d-none">Find by Serial Number</label>
        <input disabled type="text" name="serialNamber" class="form-control d-none" id="serialNamber">
    </div>
    <div class="col-md-1">
        <label for="item_brand" class="form-label d-none">Find by ...</label>
        <input disabled type="text" name="item_brand" class="form-control d-none" id="item_brand">
    </div>
    <div class="col-md-1 ">
        <label for="item_model" class="form-label d-none">Find by ...</label>
        <input disabled type="password" class="form-control d-none" name="item_model d-none" id="item_model">
    </div>
    <div class="col-md-1">
        <label for="serialNamber" class="form-label d-none">Find by ...</label>
        <input disabled type="text" name="serialNamber" class="form-control d-none" id="serialNamber">
    </div>
    <div class="col-md-1 ">
    </div>
</form>

<div  class="overflow-x-scroll">
    <table class="table table-dark table-striped table-hover">
        <thead>
        <tr>
            <td scope="col">№</td>
            <td scope="col">Plant</td>
            <td scope="col">FAE Number</td>
            <td scope="col">SIS Number</td>
            <td scope="col">Name</td>
            <td scope="col">Brand</td>
            <td scope="col">Model</td>
            <td scope="col">Serial Number</td>
            <td scope="col">Location</td>
            <td scope="col">Hostname</td>
            <td scope="col">IP Address</td>
            <td scope="col">isDamaged</td>
            <td scope="col">User Name</td>
            <td scope="col">Department</td>
            <td scope="col">Operator Number</td>
        </tr>
        </thead>
        <tbody>
        <#list items as item>
            <tr>
            <td scope="row"><#assign numberOfItems = numberOfItems +1> ${numberOfItems}</td>
            <td>${item.plant}</td>
            <td>${item.fae_number}</td>
            <td>${item.sis_number}</td>
            <td><a href="item/${item.id}" data-mdb-toggle="tooltip" title="View Details">${item.itemname}</a></td>
            <td>${item.item_brand}</td>
            <td>${item.item_model}</td>
            <td>${item.serial_number}</td>
            <td>${item.location}</td>
            <td><#if item.hostname??>
                    ${item.hostname}
                <#else>
                    no hostname
                </#if>
            </td>
            <td><#if item.ip_address??>
                    ${item.ip_address}
                <#else>
                    no ip address
                </#if>
            </td>
            <td><#if item.isDamaged??>
                    working
                <#else>
                    damaged
                </#if>
            </td>
            <td>${item.user_name}</td>
            <td>${item.department}</td>
            <td>${item.operator_number}</td>

        <#else>
            <td colspan="15">
                <h4 class="text-uppercase text-center">Here is nothing to display</h4>
            </td>
            </tr>

        </#list>
        </tbody>
    </table>
</div>

<script>
    <#include "javascript/main.js">
    <#include "javascript/mdb.min.js">
</script>


</body>
</html>