<%--
  Created by IntelliJ IDEA.
  User: Samuel
  Date: 18/02/2021
  Time: 18:15
--%>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<g:include view="_nav.gsp"/>


<%--View of the message after add deal to cart--%>
<g:if test="${session.message != null}">
    <div class="alert alert-primary" role="alert">
        ${session.message}

    </div>
    ${session.message = null}

</g:if>




<div class="container">
<%--Display the price of the session cart if not empty--%>
    <g:if test="${session.cart != null}">
        <br>
        <button type="button" class="btn btn-primary" disabled>session cart price: ${cartPrice} €</button>
        <br>
        <br>
    </g:if>
    <table class="table table-striped">
        <thead>
        <tr>
            <th class="uppercase">caption</th>
            <th class="uppercase">name &emsp; &emsp; &emsp;</th>
            <th class="uppercase">Description</th>
            <th class="uppercase">price &emsp;</th>
            <th class="uppercase">#</th>
        </tr>
        </thead>
        <tbody>
        <%--view of the search input of DealController list--%>
        <g:form action="list">

            <div class="input-group mb-2 mr-sm-2">
                <label class="sr-only" for="inlineFormInputName2">name</label>
                <input type="text" name="search" value="${search}" class="form-control mb-2 mr-sm-2"
                       id="inlineFormInputName2">
                <button type="submit" class="btn btn-primary mb-2">Search by name</button>
            </div>
        </g:form>

        <%--View of the return of DealController list--%>
        <g:each in="${deals}" var="d">
            <tr>
                <td><img src= ${d.caption}></td>
                <td>${d.name}</td>
                <td>${d.description}</td>
                <td>${d.price} €</td>
                <td>
                    <g:form controller="Cart" action="addDealToCart">
                        <label class="sr-only" for="inlineFormInputName2">name</label>
                        <button name="dealToAdd" value="${d.id}" type="submit"
                                class="btn btn-secondary mb-2">ADD</button>
                    </g:form>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>


<g:javascript library="application"/>
</html>