<%--
  Created by IntelliJ IDEA.
  User: Anatole
  Date: 23/02/2021
  Time: 17:14
--%>


<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>

%{--Toast message if the deal has been successfully added to the current cart--}%

<g:if test="${session["DisplayToast"]}">
    <div  class="toast float-right" data-animation="true" class="toast">
        <div class="toast-header bg-success text-white">
            <strong class="mr-auto">This deal is now in your cart! </strong>
        </div>
    </div>

    <div style="display: none">
        ${session["DisplayToast"] = false}
    </div>
</g:if>

%{--Toast message if the deal os already in the current cart--}%
<g:if test="${session["DisplayToasts"]}">
    <div  class="toast float-right" data-animation="true">
        <div class="toast-header bg-warning text-white">
            <strong class="mr-auto">Your deal is already in your cart! </strong>
        </div>
    </div>

    <div style="display: none">
        ${session["DisplayToasts"] = false}
    </div>
</g:if>

%{--search bar --}%
<div class="container">
    <table class="table table-dark">
        <g:form name="search" action="list">
            <tr>
                <th><label>Looking for something ?</label></th>
                <th><input type="text" class="form-control" placeholder="Your wish" name="wish" value="${wish}"></th>
                <th><button type="submit" class="btn btn-primary">Search</button></th>
            </tr>
        </g:form>
    </table>
</div>
%{--display price of the current cart--}%
<div class="container">
    <table class="table table-dark">
        <a class="pull-left" href="http://localhost:8080/cart/list">
        <h3><span class="badge badge-success">Cart cost : ${price}</span></h3>
        </a>
    </table>
</div>

%{--Display the list of deals in the database--}%
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th class="uppercase">caption</th>
            <th class="uppercase">name</th>
            <th class="uppercase">description</th>
            <th class="uppercase">price</th>

        </tr>
        </thead>
        <tbody>
        <g:each in="${deals}" var="d">
            <tr>
                <td><img class="col-caption" src="${d.caption}"/></td>
                <td>${d.name}</td>
                <td>${d.description}</td>
                <td>${d.price}</td>
                <td>
            <g:form name="addAD" action="addDealToCart" controller="Cart">
                <button name="dealToAdd" value="${d.id}" type="submit" class="btn btn-outline-primary">ADD</button>
            </g:form>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

</body>
</html>