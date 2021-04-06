<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>

<g:if test="${flash.message}">
    <g:include view="_toast.gsp"/>
</g:if>

<div class="collapse show" id="CurrentCart">
    <%-- <g:include view="_currentCart.gsp"/> --%>
    <g:render template="/currentCart"/>
</div>

<div class="container">
    <h3><span class="badge badge-primary">Cart list</span></h3>
    <table class="table table-striped">
        <thead>
            <tr>
                <th class="uppercase">CREATION</th>
                <th class="uppercase">NAME</th>
                <th class="uppercase">DEAL</th>
                <th class="uppercase">COST</th>
            </tr>
        </thead>
        <tbody>
            <g:each in="${carts}" var="c">
                <tr>
                    <%-- <td>${c.dateCreated.format("dd/MM/yyy HH:mm")}</td> --%>
                    <td><g:dateformat>${c.dateCreated}</g:dateformat></td>
                    <td>${c.name}</td>
                    <td>
                        <ol>
                            <g:each in="${c.deals}" var="cd">
                                <li>${cd.name}</li>
                            </g:each>
                        </ol>
                    </td>
                    <td>${c.cost}€</td>
                </tr>
            </g:each>
        </tbody>
    </table>
</div>

</body>
</html>