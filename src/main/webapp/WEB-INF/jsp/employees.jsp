<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Employees</title>
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
                <a class="nav-link" href="/store/${storeId}/products">Products</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/store/${storeId}/employees">Employees<span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>

</nav>

<div class="container">
    <div class="row">
        <div class="col" id="storeNameCol">
            <c:choose>
                <c:when test="${storeId == '100100'}">
                    <b id="nameStoreText">Selected Store: 100100 - Via Torino, Milano</b>
                </c:when>
                <c:when test="${storeId == '100200'}">
                    <b id="nameStoreText">Selected Store: 100200 - Via Giolitti, Bergamo</b>
                </c:when>
                <c:otherwise>
                    <b id="nameStoreText">Selected Store: 100300 - Via Vittorio Emanuele, Roma</b>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <hr>

    <div class="row">
        <div class="col-lg-2">
            <a class="btn btn-outline-primary" href="/add-employee" role="button">Add Employee</a>
        </div>
        <div class="col"></div>
        <div class="col"></div>
        <div class="col"></div>
        <div class="col"></div>
        <div class="col-sm-auto">
            <select id="homeViewSelect" class="form-control form-control-sm">
                <option value="100100"> 100100 - Via Torino, Milano</option>
                <option value="100200"> 100200 - Via Giolitti, Bergamo</option>
                <option value="100300"> 100300 - Via Vittorio Emanuele, Roma</option>
            </select>
        </div>
        <div id="searchButtonHome" class="col-sm-auto">
            <a id="search-store-empl" class="btn btn-outline-primary" href="/store/100100/employees" role="button">Search</a>
        </div>
    </div>
</div>
<div id="employeeData" class="container">
    <table class = "table table-bordered">
        <thead>
        <th scope="col">Employee Code</th>
        <th scope="col">Name</th>
        <th scope="col">Surname</th>
        <th scope="col">Manager ID</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
        </thead>
        <tbody>
        <c:forEach items="${employeesList}" var="employee">
            <tr>
                <td>${employee[0]}</td>
                <td>${employee[1]}</td>
                <td>${employee[2]}</td>
                <td>${employee[3]}</td>
                <td align="center">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" onclick="location.href='/store/${storeId}/update-employee/${employee[0]}'">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5L13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175l-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                        </svg>
                    </button>
                </td>
                <td align="center">
                    <button class="btn btn-outline-danger" type="submit" data-toggle="modal" data-target="#DeleteModal" data-value=${employee[0]} data-store=${storeId}>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                            <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                        </svg>
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Modal -->
<div class="modal fade" id="DeleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Deleting product</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <form id="modalform" method="post" action="" >
                    <input type="Submit" value="Delete" class="btn btn-primary" />
                </form>

            </div>
        </div>
    </div>
</div>




<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="/js/updateHomeEmpl.js"></script>
<script type="text/javascript" src="/js/confirmDeleteEmpl.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
</body>
</html>
