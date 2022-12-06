
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <li class="nav-item">
                <a class="nav-link" href="/store/${storeId}/products">Products<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/store/${storeId}/employees">Employees</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <nav>
        <div class="nav nav-tabs" id="nav-tab" role="tablist">
            <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Employee</a>
        </div>
    </nav>
    <div class="tab-content" id="nav-tabContent">
        <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
            <form:form method="post" action="/add-employee/save" modelAttribute="employee" >
                <div class="form-row">
                    <div class="form-group col-3">
                        <label>Employee Id</label>
                        <form:input class="form-control" placeholder="Id" path="id"></form:input>
                    </div>
                    <div class="form-group col-3">
                        <label>Name</label>
                        <form:input class="form-control" placeholder="Name" path="name"></form:input>
                    </div>
                    <div class="form-group col-3">
                        <label>Surname</label>
                        <form:input class="form-control" placeholder="Surname" path="surname"></form:input>
                    </div>
                    <div class="form-group col-3">
                        <label>Manager Id</label>
                        <select class="form-control" name="managerId">
                            <option value=""> - </option>
                            <c:forEach items="${managersList}" var="manager">
                                    <option value="${manager[0]}">${manager[0]} - ${manager[1]}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <hr>

                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label>Store</label>
                        <select class="form-control" name="storeID">
                            <option class="input1" value="100100" > 100100 - Via Torino, Milano</option>
                            <option class="input2" value="100200"> 100200 - Via Giolitti, Bergamo</option>
                            <option class="input3" value="100300"> 100300 - Via Vittorio Emanuele, Roma</option>
                        </select>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Save Employee</button>
            </form:form>
        </div>
    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>

</body>
</html>
