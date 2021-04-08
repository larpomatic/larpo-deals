<%--
  Created by IntelliJ IDEA.
  User: Anatole
  Date: 09/03/2021
  Time: 14:49
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>

%{--Toast to inform that the current cart has been saved--}%
<g:if test="${session["DisplayCartToast"]}">
    <div  class="toast float-right" data-animation="true" class="toast">
        <div class="toast-header bg-success text-white">
            <strong class="mr-auto">Your cart is now saved ! </strong>
        </div>
    </div>

    <div style="display: none">
        ${session["DisplayCartToast"] = false}
    </div>
</g:if>

%{--show the current cart to the user and its content--}%

<g:if test="${session.cart}">
<div class="container">
    <h3><span class="badge badge-info">Current cart</span></h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th class="uppercase">name</th>
            <th class="uppercase">deals</th>
            <th class="uppercase">price</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>${session.cart.name}</td>
                <td>
                <g:each status="i" in="${session.cart.deals}" var="f">
                    ${i+1}. ${f.name}<br>
                </g:each>
                </td>
                <td>${price}</td>
            </tr>

        </tbody>
    </table>
    <div class="container">
        <table>
    <g:form name="save" action="saveCurrentCart"  controller="Cart">
        <th><input type="text" class="form-control" placeholder="Add a name" name="wish" value="${wish}"></th>
        <th><button class="btn btn-outline-success" type="submit"><h5>Save your cart</h5></button></th>
    </g:form>
        </table>
    </div>
</div>
</g:if>

%{--show cart of the database--}%

<div class="container">
        <h3>
            <span class="badge badge-info">
            Cart list <span class="badge badge-light">${carts.size}</span>
            </span>
        </h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th class="uppercase">creation</th>
            <th class="uppercase">name</th>
            <th class="uppercase">deals</th>
            <th class="uppercase">price</th>

        </tr>
        </thead>
        <tbody>
        <g:each in="${carts}" var="c">
            <tr>
                <td>${c.dateCreated.format("dd/mm/yyyy hh:mm")}</td>
                <td>${c.name}</td>
                <td>
            <g:each status="i" in="${c.deals}" var="f">
                ${i+1}. ${f.name}<br>
            </g:each>
                </td>
                <td>${larpo.deals.CartService.cost(c)}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

</body>
</html>