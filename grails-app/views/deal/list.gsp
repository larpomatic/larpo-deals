<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/02/2021
  Time: 18:17
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

<!--
#################################
############ SEARCH #############
#################################
-->
<div class="container">
    <div class="p-3 mb-2 bg-light rounded border">
        <g:form action="list">
            <form class="form-inline">
                <label class="sr-only" for="inlineFormInputName2">Name</label>
                <div class="input-group">
                        <input type="text" name="userSearch"
                               value="${userSearch}" class="form-control mb-2 mr-sm-2 col-12"
                               id="inlineFormInputName2" placeholder="Search by name...">
                        <button type="submit" class="btn btn-primary mb-2 input-group-addon">Search</button>
                </div>
            </form>
        </g:form>
    </div>
</div>

<!--
#################################
########### CART COST ###########
#################################
-->
<br/>
<div class="container">
    <div class="col">
        <div class="p-3 bg-dark rounded text-white col-lg-2 offset-lg-10">
            <div class="d-flex">
                <div class="d-inline-block">
                    Cart Cost:
                </div>
                <div class="d-inline-block bg-info" style="margin-left: 5px">
                    $${cost}
                </div>
            </div>
        </div>
    </div>
</div>
<br/>
<!--
#################################
######## ARRAY OF DEALS #########
#################################
-->
<div class="container">
    <table class="table border table-striped">
        <thead>
        <tr>
            <th>CAPTION</th>
            <th>NAME</th>
            <th>DESCRIPTION</th>
            <th>PRICE</th>
            <th>#</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${deals}" var="deal">
            <tr>
                <td><img class="col-caption" src="${deal.caption}" alt="${deal.name} image"/></td>
                <td>${deal.name}</td>
                <td>${deal.description}</td>
                <td>$${deal.price}</td>
                <td>
                    <g:form controller="cart" action="addDealToCart">
                        <form class="form-inline">
                            <button type="submit"
                                    name="dealId"
                                    value="${deal.id}"
                                    class="btn btn-primary mb-2">ADD</button>
                        </form>
                    </g:form>
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