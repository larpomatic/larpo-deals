<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>

<g:if test="${flash.message}">
    <div class="alert alert-error" style="display: block">${flash.message}</div>
</g:if>

<div class="container">
    <h3><span class="badge badge-primary">Current Cart</span></h3>
    <table class="table table-striped">
        <thead>
            <tr>
                <th class="uppercase">DEALS</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>
                    <ol>
                        <g:each in="${CurrentCart.deals}" var="cd">
                            <li>${cd.name}</li>
                        </g:each>
                    </ol>
                </td>
            </tr>
        </tbody>
    </table>
    <g:form class="form-inline" name="SaveCart" action="save" controller="cart">
            <td><label class="sr-only" for="SaveCart">SaveCart</label></td>
            <td><input type="text" class="form-control mb-2 mr-sm-2" id="searchBar" placeholder="Cart name..." name="SaveCart" value="${SaveCart}"></td>
            <td><button type="submit" class="btn btn-primary mb-2">save</button></td>
    </g:form>
</div>

<div class="container">
    <h3><span class="badge badge-primary">Cart list</span></h3>
    <table class="table table-striped">
        <thead>
            <tr>
                <th class="uppercase">CREATION</th>
                <th class="uppercase">NAME</th>
                <th class="uppercase">DEAL</th>
            </tr>
        </thead>
        <tbody>
            <g:each in="${carts}" var="c">
                <tr>
                    <td>${c.dateCreated.format("dd/MM/yyy HH:mm")}</td>
                    <%-- <td>${c.dateCreated}</td> --%>
                    <td>${c.name}</td>
                    <td>
                        <ol>
                            <g:each in="${c.deals}" var="cd">
                                <li>${cd.name}</li>
                            </g:each>
                        </ol>
                    </td>
                </tr>
            </g:each>
        </tbody>
    </table>
</div>

</body>
</html>