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
<g:form action="list">
    <form class="form-inline">
        <label class="sr-only" for="inlineFormInputName2">Name</label>
        <input type="text" name="userSearch" value="${userSearch}" class="form-control mb-2 mr-sm-2" id="inlineFormInputName2" placeholder="Search by name...">

        <button type="submit" class="btn btn-primary mb-2">Submit</button>
    </form>
</g:form>

<!--
#################################
######## ARRAY OF DEALS #########
#################################
-->
<div class="container">
    <table class="table table-striped">
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
                <td>${deal.price + "€"}</td>
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