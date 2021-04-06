<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/03/2021
  Time: 12:45
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>

<!--
#################################
########## NAVIGATION ###########
#################################
-->

<g:include view="_nav.gsp"/>
<br>

<!--
#################################
######## ARRAY OF CARTS #########
#################################
-->
<div class="d-flex">
    <div class="d-inline-block w-100">
        <div class="container">
            <div class="btn bg-info text-white font-weight-bold" style="cursor: default">Cart list</div>
            <table class="table table-striped border">
                <thead>
                <tr>
                    <th>CREATION DATE</th>
                    <th>NAME</th>
                    <th>DEALS</th>
                    <th>PRICE</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${carts}" var="cart">
                    <tr>
                        <td class="w-25">
                            <g:dateFormat format="dd/mm/yyyy HH:mm" value="${cart.dateCreated}"></g:dateFormat>
                        </td>
                        <td class="w-25">${cart.name}</td>
                        <td class="w-25">
                            <g:each in="${larpo.deals.DealService.getDealsSorted(cart)}" var="deal">
                                ${deal.name + " x " + cart.getLutNbDeals()[deal.id as Integer]}
                                <br>
                            </g:each>
                        </td>
                        <td class="w-25">$${larpo.deals.CartService.cost(cart)}</td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
    </div>

<!--
#################################
######### CURRENT CART ##########
#################################
-->
    <div class="d-inline-block">
        <g:if test="${session['currentCart'] != null && session['currentCart'].getDeals()[0] != null}">
            <div class="container" style="width: 200px">
                <div class="btn text-white font-weight-bold rounded border" style="background-color: deepskyblue; cursor: default">
                    <div class="d-flex float-left">
                        <g:form action="changeName">
                            <input name="cartName" value="${cartName}" class="form-control" placeholder="${session['currentCart'].getName()}">
                        </g:form>
                        <div class="d-inline-block" style="margin-left: 5px">
                            (${nbDeals})
                        </div>
                    </div>
                </div>
                <table class="table border">
                    <tbody>
                    <tr>
                        <td>$${cost}</td>
                    </tr>
                    <tr>
                        <td>
                            <g:each in="${larpo.deals.DealService.getDealsSorted(session["currentCart"])}" var="deal">
                                ${deal.name + " x " + session['currentCart'].getLutNbDeals()[deal.id as Integer]}
                                <br>
                            </g:each>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <g:form controller="cart" action="save">
                    <form class="form-inline">
                        <button type="submit" class="btn btn-primary mb-2">SAVE</button>
                    </form>
                </g:form>
            </div>
        </g:if>
    </div>
</div>

<g:include view="_footer.gsp"/>

</body>
</html>