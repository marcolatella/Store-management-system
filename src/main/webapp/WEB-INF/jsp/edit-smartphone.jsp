<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mlepo
  Date: 20/12/20
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/storemanagement.css">



</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light navbar navbar-dark bg-primary">
    <a class="navbar-brand" href="/"><h1>StoreManagement</h1></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/store/${storeId}/products">Products<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/store/${storeId}/employees">Employees</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <nav>
        <div class="nav nav-tabs" id="nav-tab" role="tablist">
            <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Smartphone</a>
        </div>
    </nav>
    <div class="tab-content" id="nav-tabContent">
        <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
            <form:form method="post" action="/store/${storeId}/update-smartphone/${prodDetailId}" modelAttribute="prodToEdit" >
                <div class="form-row">
                    <div class="form-group col-4">
                        <label>Product Code</label>
                        <form:input class="form-control" placeholder="Code" path="code" readonly="true"></form:input>
                    </div>
                    <div class="form-group col-4">
                        <label>Name</label>
                        <form:input class="form-control" placeholder="Name" path="name"></form:input>
                    </div>
                    <div class="form-group col-4">
                        <label>Brand</label>
                        <form:input class="form-control" placeholder="Brand" path="brand"></form:input>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-4">
                        <form:label path="color">Color</form:label>
                        <form:input class="form-control" placeholder="Color" path="color"></form:input>
                        <form:errors path="color" cssClass="error"></form:errors>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Storage (GB)</label>
                        <form:select class="form-control" path="storage">
                            <form:option value="32">32</form:option>
                            <form:option value="64">64</form:option>
                            <form:option value="128">128</form:option>
                            <form:option value="256">256</form:option>
                            <form:option value="512">512</form:option>
                            <form:option value="1024">1024</form:option>
                        </form:select>
                    </div>
                    <div class="form-group col-md-4">
                        <label>5G</label>
                        <form:select class="form-control" path="fiveG">
                            <form:option value="false">No</form:option>
                            <form:option value="true">Yes</form:option>
                        </form:select>
                    </div>
                </div>

                <hr>

                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label>Quantity</label>
                        <input class="form-control" value="${prodDetToEdit.quantity}" name="quantity">
                    </div>
                    <div class="form-group col-md-4">
                        <label>Price</label>
                        <input class="form-control" value="${prodDetToEdit.price}" name="price">
                    </div>
                </div>

                <hr>

                <button type="submit" class="btn btn-primary">Save Product</button>
            </form:form>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
</body>
</html>
