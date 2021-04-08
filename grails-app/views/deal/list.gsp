<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/02/2021
  Time: 18:17
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
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
############ TOAST ##############
#################################
-->
<g:if test="${session["DisplayToast"]}">
    <div id="errortip" role="alert" aria-live="assertive" aria-atomic="true"
         class="toast float-right" data-animation="true" data-autohide="true" data-delay="2500">
        <div class="toast-header bg-success text-white">
            <svg class=" rounded mr-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"></svg>
            <strong class="mr-auto">Larpo-Deals</strong>
            <small>0 seconds ago</small>
            <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="toast-body">
            Your deal has been added to the cart!
        </div>
    </div>

    <script>
        setTimeout(() => {
            $(".toast").toast('show')
        }, 0)
    </script>

    <style>
        .fade {
            transition: opacity 0.5s linear !important;
        }
    </style>

    <div style="display: none">
        ${session["DisplayToast"] = false}
    </div>
</g:if>

<!--
#################################
############ SEARCH #############
#################################
-->

<div class="container">
    <div class="p-3 mb-2 bg-light rounded border">
        <g:form action="list" controller="deal">
            <form class="form-inline">
                <div class="input-group">
                    <input name="userSearch" value="${userSearch}" class="form-control mb-2 mr-sm-2 col-12" placeholder="Search by name...">
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
        <div class="p-3 bg-dark rounded text-white col-lg-2" style="margin-left: 915px">
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

</body>
</html>