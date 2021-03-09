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
######### CURRENT CART ##########
#################################
-->
<g:if test="${session['currentCart'] != null && session['currentCart'].getDeals()[0] != null}">
    <div class="container">
        <div class="btn bg-info text-white font-weight-bold">Current cart</div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>NAME</th>
                <th>DEALS</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${session['currentCart'].name}</td>
                    <td>
                        <g:each in="${session['currentCart'].getDeals()}" var="deal">
                            ${deal.id + ". " + deal.name}
                            <br>
                        </g:each>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</g:if>
<br><br>
<!--
#################################
######## ARRAY OF CARTS #########
#################################
-->
<div class="container">
    <div class="btn bg-info text-white font-weight-bold">Cart list</div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>CREATION</th>
            <th>NAME</th>
            <th>DEALS</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${carts}" var="cart">
            <tr>
                <td>${cart.dateCreated.format("dd/mm/yyyy hh:mm")}</td>
                <td>${cart.name}</td>
                <td>
                    <g:each in="${cart.getDeals()}" var="deal">
                        ${deal.id + ". " + deal.name}
                        <br>
                    </g:each>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

<g:include view="_footer.gsp"/>

<g:javascript library="application"/>

</body>
</html>